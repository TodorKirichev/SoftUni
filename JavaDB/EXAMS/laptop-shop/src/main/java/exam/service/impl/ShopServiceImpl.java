package exam.service.impl;

import exam.model.dto.ShopRootImportDto;
import exam.model.entity.Shop;
import exam.model.entity.Town;
import exam.repository.ShopRepository;
import exam.service.ShopService;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ShopServiceImpl implements ShopService {

    private static final String SHOPS_PATH = "src/main/resources/files/xml/shops.xml";
    private final ShopRepository shopRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final TownService townService;

    public ShopServiceImpl(ShopRepository shopRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, TownService townService) {
        this.shopRepository = shopRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(SHOPS_PATH));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(SHOPS_PATH, ShopRootImportDto.class)
                .getShopImportDtos()
                .stream().filter(shopImportDto -> {
                    boolean isValid = validationUtil.isValid(shopImportDto);

                    Shop shop = shopRepository.findByName(shopImportDto.getName());

                    if (shop != null) {
                        isValid = false;
                    }

                    if (isValid) {
                        sb.append(String.format("Successfully imported Shop %s - %f",
                                shopImportDto.getName(),
                                shopImportDto.getIncome()));
                    } else {
                        sb.append("Invalid shop");
                    }
                    sb.append(System.lineSeparator());

                    return isValid;
                }).map(shopImportDto -> {
                    Shop shop = modelMapper.map(shopImportDto, Shop.class);

                    Town town = townService.findTownByName(shopImportDto.getTown().getName());

                    shop.setTown(town);

                    return shop;
                }).forEach(shopRepository::save);

        return sb.toString().trim();
    }

    @Override
    public Shop findShopByName(String name) {
        return shopRepository.findByName(name);
    }
}
