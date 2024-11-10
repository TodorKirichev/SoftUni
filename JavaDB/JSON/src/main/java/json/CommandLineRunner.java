package json;


import com.google.gson.Gson;
import json.model.dto.CategoryByProductsDto;
import json.model.dto.ProductNameAndPriceDto;
import json.model.dto.UserSoldDto;
import json.service.CategoryService;
import json.service.ProductService;
import json.service.UserService;
import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    public static final String OUTPUT_PATH = "src/main/resources/files/out/";
    public static final String PRODUCTS_IN_RANGE_PATH = "products-in-range.json";
    public static final String USERS_AND_SOLD_PRODUCTS = "users-and-sold-products.json";
    public static final String CATEGORIES_BY_PRODUCTS = "categories-by-products.json";

    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final Scanner scanner;
    private final Gson gson;

    public CommandLineRunner(CategoryService categoryService, UserService userService, ProductService productService, Gson gson) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.gson = gson;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        userService.seedUsers();
        productService.seedProducts();

        System.out.println("Enter exercise:");

        int exNum = Integer.parseInt(scanner.nextLine());

        switch (exNum) {
            case 1 -> productsInRange();
            case 2 -> soldProducts();
            case 3 -> categoriesByProductsCount();
        }
    }

    private void categoriesByProductsCount() throws IOException {
        List<CategoryByProductsDto> categoryByProductsDtos = categoryService.getAllCategoriesByProducts();

        String content = gson.toJson(categoryByProductsDtos);

        writeToFile(OUTPUT_PATH + CATEGORIES_BY_PRODUCTS, content);
    }

    private void soldProducts() throws IOException {
        List<UserSoldDto> userSoldDtos = userService.findAllUsersWithMoreThenOneSoldProduct();

        String content = gson.toJson(userSoldDtos);

        writeToFile(OUTPUT_PATH + USERS_AND_SOLD_PRODUCTS, content);
    }

    private void productsInRange() throws IOException {
        List<ProductNameAndPriceDto> productDtos = productService
                .findAllProductsInRange(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));

        String content = gson.toJson(productDtos);

        writeToFile(OUTPUT_PATH + PRODUCTS_IN_RANGE_PATH, content);
    }

    private void writeToFile(String filePath, String content) throws IOException {
        Files.write(Path.of(filePath), Collections.singleton(content));
    }
}
