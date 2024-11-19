package exercisespringdataautomappingobjects.xmlexercise;

import exercisespringdataautomappingobjects.xmlexercise.model.dto.*;
import exercisespringdataautomappingobjects.xmlexercise.service.CategoryService;
import exercisespringdataautomappingobjects.xmlexercise.service.ProductService;
import exercisespringdataautomappingobjects.xmlexercise.service.UserService;
import exercisespringdataautomappingobjects.xmlexercise.util.XmlParser;
import jakarta.xml.bind.JAXBException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    public static final String FILE_PATH = "src/main/resources/files/";
    public static final String CATEGORY_FILE_NAME = "categories.xml";
    public static final String USER_FILE_NAME = "users.xml";
    public static final String PRODUCT_FILE_NAME = "products.xml";
    public static final String PRODUCT_IN_RANGE = "products-in-range.xml";
    public static final String USERS_WITH_SOLD_PRODUCTS = "users-with-sold-products.xml";
    private final XmlParser xmlParser;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final Scanner scanner;

    public Main(XmlParser xmlParser, CategoryService categoryService, UserService userService, ProductService productService) {
        this.xmlParser = xmlParser;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("Select exercise:");

        int exercise = Integer.parseInt(scanner.nextLine());

        switch (exercise) {
            case 1 -> productsInRange();
            case 2 -> usersWithSoldProducts();
        }
    }

    private void usersWithSoldProducts() throws JAXBException, FileNotFoundException {
        UserViewRootDto userViewRootDto = userService.findUsersWithMoreThanOneSoldProduct();
        xmlParser.toFile(FILE_PATH + USERS_WITH_SOLD_PRODUCTS, userViewRootDto);
    }

    private void productsInRange() throws JAXBException, FileNotFoundException {
        ProductViewRootDto productViewRootDto = productService.findAllInPriceRangeWithoutBuyer();

        xmlParser.toFile(FILE_PATH + PRODUCT_IN_RANGE, productViewRootDto);
    }

    private void seedData() throws JAXBException, FileNotFoundException {
        if (categoryService.getCount() == 0) {
            CategorySeedRootDto categorySeedRootDto = xmlParser.fromFile(FILE_PATH + CATEGORY_FILE_NAME, CategorySeedRootDto.class);
            categoryService.seedCategories(categorySeedRootDto.getCategories());
        }

        if (userService.getCount() == 0) {
            UserSeedRootDto userSeedRootDto = xmlParser.fromFile(FILE_PATH + USER_FILE_NAME, UserSeedRootDto.class);
            userService.seedUsers(userSeedRootDto.getUsers());
        }

        if (productService.getCount() == 0) {
            ProductSeedRootDto productSeedRootDto = xmlParser.fromFile(FILE_PATH + PRODUCT_FILE_NAME, ProductSeedRootDto.class);
            productService.seedProducts(productSeedRootDto.getProducts());
        }
    }
}
