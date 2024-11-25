package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BorrowingRecordImportDto;
import softuni.exam.models.dto.BorrowingRecordRootImportDto;
import softuni.exam.models.entity.Book;
import softuni.exam.models.entity.BorrowingRecord;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.models.enums.Genre;
import softuni.exam.repository.BorrowingRecordRepository;
import softuni.exam.service.BookService;
import softuni.exam.service.BorrowingRecordsService;
import softuni.exam.service.LibraryMemberService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class BorrowingRecordsServiceImpl implements BorrowingRecordsService {

    public static final String RECORDS_PATH = "src/main/resources/files/xml/borrowing-records.xml";
    private final BorrowingRecordRepository borrowingRecordRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final BookService bookService;
    private final LibraryMemberService libraryMemberService;

    public BorrowingRecordsServiceImpl(BorrowingRecordRepository borrowingRecordRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil, BookService bookService, LibraryMemberService libraryMemberService) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.bookService = bookService;
        this.libraryMemberService = libraryMemberService;
    }

    @Override
    public boolean areImported() {
        return borrowingRecordRepository.count() > 0;
    }

    @Override
    public String readBorrowingRecordsFromFile() throws IOException {
        return Files.readString(Path.of(RECORDS_PATH));
    }

    @Override
    public String importBorrowingRecords() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        List<BorrowingRecordImportDto> borrowingRecordImportDtos = xmlParser
                .fromFile(RECORDS_PATH, BorrowingRecordRootImportDto.class).getBorrowingRecordImportDtos();

        borrowingRecordImportDtos
                .stream().filter(borrowingRecordImportDto -> {
                    boolean isValid = validationUtil.isValid(borrowingRecordImportDto);

                    Book book = bookService
                            .findBookByTitle(borrowingRecordImportDto.getBook().getTitle());

                    if (book == null) {
                        isValid = false;
                    }

                    LibraryMember libraryMember = libraryMemberService
                            .findLibraryMemberById(borrowingRecordImportDto.getMember().getId());

                    if (libraryMember == null) {
                        isValid = false;
                    }

                    if (isValid) {
                        sb.append(String.format("Successfully imported borrowing record %s - %s",
                                borrowingRecordImportDto.getBook().getTitle(),
                                borrowingRecordImportDto.getBorrowDate()));
                    } else {
                        sb.append("Invalid borrowing record");
                    }
                    sb.append(System.lineSeparator());

                    return isValid;
                }).map(borrowingRecordImportDto -> {
                    BorrowingRecord borrowingRecord = modelMapper.map(borrowingRecordImportDto, BorrowingRecord.class);

                    Book book = bookService
                            .findBookByTitle(borrowingRecordImportDto.getBook().getTitle());

                    LibraryMember libraryMember = libraryMemberService
                            .findLibraryMemberById(borrowingRecordImportDto.getMember().getId());

                    borrowingRecord.setBook(book);
                    borrowingRecord.setLibraryMember(libraryMember);

                    return borrowingRecord;
                }).forEach(borrowingRecordRepository::save);

        return sb.toString().trim();
    }

    @Override
    public String exportBorrowingRecords() {
        StringBuilder sb = new StringBuilder();

        List<BorrowingRecord> records = borrowingRecordRepository.findAllByBook_GenreOrderByBorrowDateDesc(Genre.SCIENCE_FICTION);

        records.forEach(record -> {
            sb.append(String.format("Book title: %s\n" +
                    "*Book author: %s\n" +
                    "**Date borrowed: %s\n" +
                    "***Borrowed by: %s %s",
                    record.getBook().getTitle(),
                    record.getBook().getAuthor(),
                    record.getBorrowDate(),
                    record.getLibraryMember().getFirstName(),
                    record.getLibraryMember().getLastName()))
                    .append(System.lineSeparator());
        });

        return sb.toString().trim();
    }
}
