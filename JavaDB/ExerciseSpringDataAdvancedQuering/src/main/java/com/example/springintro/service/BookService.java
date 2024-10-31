package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllBookTitlesWithAgeRestriction(AgeRestriction ageRestriction);

    List<String> findAllGoldenBooksWithLessThan5000Copies();

    List<String> findAllBooksWithPriceBetween();

    List<String> findAllBooksNotReleasedInAGiverYear(int year);

    List<String> findAllBooksBeforeDate(LocalDate localDate);

    List<String> findAllBooksContainingString(String string);

    List<String> findAllBooksWithAuthorsNameStartsWith(String string);

    Integer findCountOfBooksWithTitleLongerThan(int number);

    List<String> findAllBooksByTitle(String title);
}
