package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BookImportDto;
import softuni.exam.models.entity.Book;
import softuni.exam.repository.BookRepository;
import softuni.exam.service.BookService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class BookServiceImpl implements BookService {

    public static final String BOOKS_PATH = "src/main/resources/files/json/books.json";
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return bookRepository.count() > 0;
    }

    @Override
    public String readBooksFromFile() throws IOException {
        return Files.readString(Path.of(BOOKS_PATH));
    }

    @Override
    public String importBooks() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readBooksFromFile(), BookImportDto[].class))
                .filter(bookImportDto -> {
                    boolean isValid = validationUtil.isValid(bookImportDto);

                    Book book = bookRepository.findByTitle(bookImportDto.getTitle());

                    if (book != null) {
                        isValid = false;
                    }

                    if (isValid) {
                        sb.append(String.format("Successfully imported book %s - %s",
                                bookImportDto.getAuthor(),
                                bookImportDto.getTitle()));
                    } else {
                        sb.append("Invalid book");
                    }
                    sb.append(System.lineSeparator());

                    return isValid;
                }).map(bookImportDto -> modelMapper.map(bookImportDto, Book.class))
                .forEach(bookRepository::save);

        return sb.toString().trim();
    }

    @Override
    public Book findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}
