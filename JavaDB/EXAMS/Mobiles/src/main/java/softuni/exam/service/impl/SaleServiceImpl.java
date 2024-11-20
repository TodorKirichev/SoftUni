package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.SaleImportDto;
import softuni.exam.models.entity.Sale;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SaleRepository;
import softuni.exam.service.SaleService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class SaleServiceImpl implements SaleService {

    public static final String SALES_PATH = "src/main/resources/files/json/sales.json";
    private final SaleRepository saleRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final SellerService sellerService;

    public SaleServiceImpl(SaleRepository saleRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, SellerService sellerService) {
        this.saleRepository = saleRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.sellerService = sellerService;
    }

    @Override
    public boolean areImported() {
        return saleRepository.count() > 0;
    }

    @Override
    public String readSalesFileContent() throws IOException {
        return Files.readString(Path.of(SALES_PATH));
    }

    @Override
    public String importSales() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readSalesFileContent(), SaleImportDto[].class))
                .filter(saleImportDto -> {
                    boolean isValid = validationUtil.isValid(saleImportDto);

                    Sale sale = saleRepository.findByNumber(saleImportDto.getNumber());

                    if (sale != null) {
                        isValid = false;
                    }

                    if (isValid) {
                        sb.append(String.format("Successfully imported sale with number %s",
                                saleImportDto.getNumber()));
                    } else {
                        sb.append("Invalid sale");
                    }
                    sb.append(System.lineSeparator());

                    return isValid;
                }).map(saleImportDto -> {
                    Sale sale = modelMapper.map(saleImportDto, Sale.class);

                    Seller seller = sellerService.findSellerById(saleImportDto.getSeller());

                    sale.setSeller(seller);
                    seller.getSales().add(sale);

                    return sale;
                }).forEach(saleRepository::save);

        return sb.toString().trim();
    }

    @Override
    public Sale findSaleById(long id) {
        return saleRepository.findById(id);
    }
}
