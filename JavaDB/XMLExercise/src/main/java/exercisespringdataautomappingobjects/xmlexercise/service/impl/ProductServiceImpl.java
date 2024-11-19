package exercisespringdataautomappingobjects.xmlexercise.service.impl;

import exercisespringdataautomappingobjects.xmlexercise.model.dto.ProductSeedDto;
import exercisespringdataautomappingobjects.xmlexercise.model.dto.ProductViewRootDto;
import exercisespringdataautomappingobjects.xmlexercise.model.dto.ProductWithSellerDto;
import exercisespringdataautomappingobjects.xmlexercise.model.entity.Product;
import exercisespringdataautomappingobjects.xmlexercise.repository.ProductRepository;
import exercisespringdataautomappingobjects.xmlexercise.service.CategoryService;
import exercisespringdataautomappingobjects.xmlexercise.service.ProductService;
import exercisespringdataautomappingobjects.xmlexercise.service.UserService;
import exercisespringdataautomappingobjects.xmlexercise.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final CategoryService categoryService;
    private final UserService userService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil, CategoryService categoryService, UserService userService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    public long getCount() {
        return productRepository.count();
    }

    @Override
    public void seedProducts(List<ProductSeedDto> products) {
        products.stream()
                .filter(validationUtil::isValid)
                .map(this::mapProduct)
                .forEach(productRepository::save);

    }

    @Override
    public ProductViewRootDto findAllInPriceRangeWithoutBuyer() {
        ProductViewRootDto productViewRootDto = new ProductViewRootDto();
        productViewRootDto.setProducts(productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPriceAsc(BigDecimal.valueOf(500), BigDecimal.valueOf(1000))
                .stream()
                .map(product -> {
                    ProductWithSellerDto productWithSellerDto = modelMapper.map(product, ProductWithSellerDto.class);
                    productWithSellerDto.setSeller(String.format("%s %s",
                            product.getSeller().getFirstName(), product.getSeller().getLastName()));
                    return productWithSellerDto;
                })
                .collect(Collectors.toList()));
        return productViewRootDto;
    }

    private Product mapProduct(ProductSeedDto productSeedDto) {
        {
            Product product = modelMapper.map(productSeedDto, Product.class);
            product.setSeller(userService.getRandomUser());
            if (product.getPrice().compareTo(BigDecimal.valueOf(700)) > 0) {
                product.setBuyer(userService.getRandomUser());
            }
            product.setCategories(categoryService.getRandomCategories());
            return product;
        }
    }
}
