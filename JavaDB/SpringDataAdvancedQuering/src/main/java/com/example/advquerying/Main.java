package com.example.advquerying;

import com.example.advquerying.entities.Size;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class Main implements CommandLineRunner {

    private final ShampooService shampooService;

    private final IngredientService ingredientService;

    public Main(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scan = new Scanner(System.in);

//        Size size = Size.valueOf(scan.nextLine());
//        this.shampooService.findAllBySizeOrderById(size).forEach(System.out::println);

//        long labelId = scan.nextLong();
//        this.shampooService.findAllBySizeOrLabel_IdOrderByPrice(size, labelId).forEach(System.out::println);

//        BigDecimal price = new BigDecimal(scan.nextLine());
//        this.shampooService.findAllByPriceGreaterThanOrderByPriceDesc(price).forEach(System.out::println);

//        String letter = scan.nextLine();
//        this.ingredientService.findAllByNameStartingWith(letter).forEach(System.out::println);

//        List<String> names = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
//        this.ingredientService.findAllByNameInOrderByPrice(names).forEach(System.out::println);

//        BigDecimal price = new BigDecimal(scan.nextLine());
//        System.out.println(this.shampooService.countAllByPriceLessThan(price));

//        List<String> names = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
//        this.shampooService.findAllByIngredientsNames(names).forEach(System.out::println);

//        int number = Integer.parseInt(scan.nextLine());
//        this.shampooService.findAllByIngredientsLessThanNumber(number).forEach(System.out::println);

//        String name = scan.nextLine();
//        this.ingredientService.deleteAllByName(name);

        this.ingredientService.updateIngredientsPrice();
        System.out.println("Done");
    }
}
