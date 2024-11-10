package json.service;

import json.model.dto.CategoryByProductsDto;
import json.model.entity.Category;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> findRandomCategories();

    List<CategoryByProductsDto> getAllCategoriesByProducts();
}
