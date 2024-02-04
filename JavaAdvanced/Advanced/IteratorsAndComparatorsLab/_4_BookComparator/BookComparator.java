package Exams.IteratorsAndComparatorsLab._4_BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book one, Book two) {
        int result;
        if (one.getTitle().compareTo(two.getTitle()) == 0) {
            result = Integer.compare(one.getYear(),two.getYear());
        } else if (one.getTitle().compareTo(two.getTitle()) < 0) {
            result = -1;
        } else {
            result = 1;
        }
        return result;
    }
}
