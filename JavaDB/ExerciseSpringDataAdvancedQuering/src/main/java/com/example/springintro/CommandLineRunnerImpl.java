package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final Scanner scanner;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, Scanner scanner) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.scanner = scanner;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

//        printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//        printAllAuthorsAndNumberOfTheirBooks();
//        pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

        System.out.println("Enter exercise number:");
        int ex = Integer.parseInt(scanner.nextLine());

        switch (ex) {
            case 1: booksTitlesByAge();
            case 2: goldenBook();
            case 3: booksByPrice();
            case 4: notReleasedBooks();
            case 5: booksReleasedBefore();
            case 6: authorsNamesEndsWith();
            case 7: booksContainsString();
            case 8: booksTitleSearch();
            case 9: numOfBooksLonger();
            case 11: reducedBook();
        }

    }

    private void reducedBook() {
        String title = scanner.nextLine();
        bookService.findAllBooksByTitle(title).forEach(System.out::println);
    }

    private void numOfBooksLonger() {
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(bookService.findCountOfBooksWithTitleLongerThan(number));
    }

    private void booksTitleSearch() {
        String string = scanner.nextLine();
        bookService.findAllBooksWithAuthorsNameStartsWith(string).forEach(System.out::println);
    }

    private void booksContainsString() {
        String string = scanner.nextLine();
        bookService.findAllBooksContainingString(string).forEach(System.out::println);
    }

    private void authorsNamesEndsWith() {
        String string = scanner.nextLine();
        authorService.findAllAuthorsWhereNamesEndsWith(string).forEach(System.out::println);
    }

    private void booksReleasedBefore() {
        LocalDate localDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        bookService.findAllBooksBeforeDate(localDate).forEach(System.out::println);
    }

    private void notReleasedBooks() {
        int year = Integer.parseInt(scanner.nextLine());
        bookService.findAllBooksNotReleasedInAGiverYear(year).forEach(System.out::println);
    }

    private void booksByPrice() {
        bookService.findAllBooksWithPriceBetween().forEach(System.out::println);
    }

    private void goldenBook() {
        bookService.findAllGoldenBooksWithLessThan5000Copies().forEach(System.out::println);
    }

    private void booksTitlesByAge() {
        AgeRestriction ageRestriction = AgeRestriction.valueOf(scanner.nextLine().toUpperCase());

        bookService.findAllBookTitlesWithAgeRestriction(ageRestriction).forEach(System.out::println);
    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
