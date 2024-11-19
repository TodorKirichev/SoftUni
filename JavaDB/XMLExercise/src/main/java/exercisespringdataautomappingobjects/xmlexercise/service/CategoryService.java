package exercisespringdataautomappingobjects.xmlexercise.service;

import exercisespringdataautomappingobjects.xmlexercise.model.dto.CategorySeedDto;
import exercisespringdataautomappingobjects.xmlexercise.model.entity.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedCategories(List<CategorySeedDto> categories);

    long getCount();

    Set<Category> getRandomCategories();
}
