package json.service;

import com.google.gson.Gson;
import json.constants.Constants;
import json.model.dto.CategoryByProductsDto;
import json.model.dto.CategorySeedDto;
import json.model.entity.Category;
import json.model.entity.Product;
import json.repository.CategoryRepository;
import json.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static json.constants.Constants.RESOURCE_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {

    public static final String CATEGORIES_PATH = "categories.json";

    private final Gson gson;
    private CategoryRepository categoryRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(Gson gson, CategoryRepository categoryRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.gson = gson;
        this.categoryRepository = categoryRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() > 0) {
            return;
        }

        String fileContent = Files.readString(Path.of(RESOURCE_FILE_PATH + CATEGORIES_PATH));

        CategorySeedDto[] categorySeedDtos = gson.fromJson(fileContent, CategorySeedDto[].class);

        Arrays.stream(categorySeedDtos).filter(validationUtil::isValid)
                .map(category -> modelMapper.map(category, Category.class))
                .forEach(categoryRepository::save);
                
    }

    @Override
    public Set<Category> findRandomCategories() {
        int catCount = ThreadLocalRandom.current().nextInt(1, 4);
        Set<Category> categories = new HashSet<>();
        long categoriesCount = categoryRepository.count();

        for (int i = 0; i < catCount; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, categoriesCount + 1);

            categories.add(categoryRepository.findById(randomId).orElse(null));
        }
        return categories;
    }

    @Override
    public List<CategoryByProductsDto> getAllCategoriesByProducts() {
        return this.categoryRepository.findAllCategoriesByProducts().stream()
                .map(category -> {
                    CategoryByProductsDto dto = this.modelMapper.map(category, CategoryByProductsDto.class);
                    dto.setProductsCount(category.getProducts().size());
                    BigDecimal sum = category.getProducts().stream().map(Product::getPrice).reduce(BigDecimal::add).get();
                    dto.setTotalRevenue(sum);
                    dto.setAveragePrice(sum.divide(BigDecimal.valueOf(category.getProducts().size()), MathContext.DECIMAL64));
                    return dto;
                }).collect(Collectors.toList());
    }
}
