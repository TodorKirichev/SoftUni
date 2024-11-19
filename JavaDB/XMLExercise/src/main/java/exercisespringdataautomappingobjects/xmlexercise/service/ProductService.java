package exercisespringdataautomappingobjects.xmlexercise.service;

import exercisespringdataautomappingobjects.xmlexercise.model.dto.ProductSeedDto;
import exercisespringdataautomappingobjects.xmlexercise.model.dto.ProductViewRootDto;

import java.util.List;

public interface ProductService {
    long getCount();

    void seedProducts(List<ProductSeedDto> products);

    ProductViewRootDto findAllInPriceRangeWithoutBuyer();
}
