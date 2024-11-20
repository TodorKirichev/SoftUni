package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.SellerImportDto;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class SellerServiceImpl implements SellerService {

    public static final String SELLERS_PATH = "src/main/resources/files/json/sellers.json";
    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public SellerServiceImpl(SellerRepository sellerRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(SELLERS_PATH));
    }

    @Override
    public String importSellers() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readSellersFromFile(), SellerImportDto[].class))
                .filter(sellerImportDto -> {
                    boolean isValid = validationUtil.isValid(sellerImportDto);

                    Seller seller = sellerRepository.findByLastName(sellerImportDto.getLastName());

                    if (seller != null) {
                        isValid = false;
                    }

                    if (isValid) {
                        sb.append(String.format("Successfully imported seller %s %s",
                                sellerImportDto.getFirstName(),
                                sellerImportDto.getLastName()));
                    } else {
                        sb.append("Invalid seller");
                    }
                    sb.append(System.lineSeparator());

                    return isValid;
                }).map(sellerImportDto -> modelMapper.map(sellerImportDto, Seller.class))
                .forEach(sellerRepository::save);

        return sb.toString().trim();
    }

    @Override
    public Seller findSellerById(long id) {
        return sellerRepository.findById(id);
    }
}
