package Exams.IteratorsAndComparatorsLab._3_ComparableBook;

import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book>{

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors = Arrays.asList(authors);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public int compareTo(Book book) {
        int result;
        if (this.title.compareTo(book.title) == 0) {
            result = Integer.compare(this.year, book.year);
        } else if (this.title.compareTo(book.title) > 0) {
            result = -1;
        } else {
            result = 1;
        }
        return result;
    }
    @Override
    public String toString() {
        return getTitle();
    }
}





