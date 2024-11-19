package exercisespringdataautomappingobjects.xmlexercise.service.impl;

import exercisespringdataautomappingobjects.xmlexercise.model.dto.CategorySeedDto;
import exercisespringdataautomappingobjects.xmlexercise.model.dto.CategorySeedRootDto;
import exercisespringdataautomappingobjects.xmlexercise.model.entity.Category;
import exercisespringdataautomappingobjects.xmlexercise.repository.CategoryRepository;
import exercisespringdataautomappingobjects.xmlexercise.service.CategoryService;
import exercisespringdataautomappingobjects.xmlexercise.service.UserService;
import exercisespringdataautomappingobjects.xmlexercise.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserService userService;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserService userService) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
    }

    @Override
    public void seedCategories(List<CategorySeedDto> categories) {
        categories.stream()
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                .forEach(categoryRepository::save);
    }

    @Override
    public long getCount() {
        return categoryRepository.count();
    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();

        long randomCount = ThreadLocalRandom.current().nextLong(1, 3);
        long categoriesCount = categoryRepository.count();

        for (int i = 0; i < randomCount; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, categoriesCount);
            Category category = categoryRepository.findById(randomId).orElse(null);
            categories.add(category);
        }
        return categories;
    }
}
