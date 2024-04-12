package org.bookshopsystemspring.service.impl;

import org.bookshopsystemspring.data.entities.Author;
import org.bookshopsystemspring.data.entities.Book;
import org.bookshopsystemspring.data.entities.Category;
import org.bookshopsystemspring.data.entities.enums.AgeRestriction;
import org.bookshopsystemspring.data.entities.enums.EditionType;
import org.bookshopsystemspring.data.repositories.BookRepository;
import org.bookshopsystemspring.service.AuthorService;
import org.bookshopsystemspring.service.BookService;
import org.bookshopsystemspring.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class BookServiceImpl implements BookService {
    private static final String FILE_PATH = "src/main/resources/files/books.txt";
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookRepository bookRepository;

    public BookServiceImpl(CategoryService categoryService, AuthorService authorService, BookRepository bookRepository) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookRepository = bookRepository;
    }

    @Override
    public void seedBooks() throws IOException {
        Files.readAllLines(Path.of(FILE_PATH))
                .stream()
                .filter(row -> !row.isEmpty())
                .forEach(row -> {
                    String[] data = row.split("\\s+");

                    Author author = this.authorService.getRandomAuthor();

                    EditionType editionType =

                            EditionType.values()[Integer.parseInt(data[0])];

                    LocalDate releaseDate = LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
                    int copies = Integer.parseInt(data[2]);
                    BigDecimal price = new BigDecimal(data[3]);
                    AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
                    String title = Arrays.stream(data).skip(5).collect(Collectors.joining(" "));
                    Set<Category> categories = this.categoryService.getRandomCategories();
                    Book book = new Book(title, editionType, price, copies, releaseDate, ageRestriction, author, categories);

                    this.bookRepository.saveAndFlush(book);

                });
    }
}