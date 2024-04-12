package org.bookshopsystemspring;

import org.bookshopsystemspring.service.AuthorService;
import org.bookshopsystemspring.service.BookService;
import org.bookshopsystemspring.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    public CommandLineRunnerImpl(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() throws IOException {
        this.categoryService.getRandomCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();
    }
}
