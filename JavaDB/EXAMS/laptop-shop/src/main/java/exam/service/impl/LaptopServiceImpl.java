package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.LaptopImportDto;
import exam.model.entity.Laptop;
import exam.model.entity.Shop;
import exam.model.enums.WarrantyType;
import exam.repository.LaptopRepository;
import exam.service.LaptopService;
import exam.service.ShopService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Set;

@Service
public class LaptopServiceImpl implements LaptopService {

    private static final String LAPTOPS_PATH = "src/main/resources/files/json/laptops.json";
    private final LaptopRepository laptopRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final ShopService shopService;

    public LaptopServiceImpl(LaptopRepository laptopRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, ShopService shopService) {
        this.laptopRepository = laptopRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.shopService = shopService;
    }

    @Override
    public boolean areImported() {
        return laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(LAPTOPS_PATH));
    }

    @Override
    public String importLaptops() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readLaptopsFileContent(), LaptopImportDto[].class))
                .filter(laptopImportDto -> {
                    boolean isValid = validationUtil.isValid(laptopImportDto);

                    Laptop laptop = laptopRepository.findByMacAddress(laptopImportDto.getMacAddress());

                    try {
                        WarrantyType warrantyType = WarrantyType.valueOf(laptopImportDto.getWarrantyType());
                    } catch (Exception e) {
                        isValid = false;
                    }

                    if (laptop != null) {
                        isValid = false;
                    }

                    if (isValid) {
                        sb.append(String.format("Successfully imported Laptop %s - %.2f - %d - %d",
                                laptopImportDto.getMacAddress(),
                                laptopImportDto.getCpuSpeed(),
                                laptopImportDto.getRam(),
                                laptopImportDto.getStorage()));
                    } else {
                        sb.append("Invalid Laptop");
                    }
                    sb.append(System.lineSeparator());

                    return isValid;
                }).map(laptopImportDto -> {
                    Laptop laptop = modelMapper.map(laptopImportDto, Laptop.class);

                    Shop shop = shopService.findShopByName(laptopImportDto.getShop().getName());


                    laptop.setShop(shop);


                    return laptop;
                }).forEach(laptopRepository::save);

        return sb.toString().trim();
    }

    @Override
    public String exportBestLaptops() {
        StringBuilder sb = new StringBuilder();

        Set<Laptop> laptops = laptopRepository.findAllLaptops();

        laptops.forEach(laptop -> {
            sb.append(String.format("Laptop - %s\n" +
                    "*Cpu speed - %.2f\n" +
                    "**Ram - {ram}\n" +
                    "***Storage - %s\n" +
                    "****Price - %.2f\n" +
                    "#Shop name - %s\n" +
                    "##Town - %s",
                    laptop.getMacAddress(),
                    laptop.getCpuSpeed(),
                    laptop.getStorage(),
                    laptop.getPrice(),
                    laptop.getShop().getName(),
                    laptop.getShop().getTown().getName()))
                    .append(System.lineSeparator());
        });

        return sb.toString().trim();
    }
}
