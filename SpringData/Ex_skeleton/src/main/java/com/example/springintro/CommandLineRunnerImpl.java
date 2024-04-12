package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.repository.BookInfo;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        // printBooksByAgeRestriction();
        // todo printGoldBookWithLessThan5000copies();
        // printBooksWithPriceOutOfRange();
        // printBooksNotIssuedAt();
        // printBookInfoForBooksReleasedBefore();
        // printAuthorsEndingIn();
        // printBookTitlesContaining();
        // findAllBooksByLastNameStarting();
        // findStatsForTitleLength();
        // printTotalBookCopiesForAuthor();
        // printBookProjection();
            updateBookCopies();
    }

    private void updateBookCopies() {
        bookService.sellCopies(1,1200);
    }

    private void printBookProjection() {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        BookInfo info = this.bookService.findInfoByTitle(title);

        System.out.println(info.getTitle() + " " + info.getEditionType() + " " + info.getAgeRestriction() + " " + info.getPrice());
    }

    private void printTotalBookCopiesForAuthor() {
        Scanner scanner = new Scanner(System.in);
        String[] authorName = scanner.nextLine().split("\\s+");

        int count = this.authorService.getTotalCopiesCountFor(authorName[0], authorName[1]);

        System.out.printf("%s %s %d \n", authorName[0], authorName[1], count);
    }

    private void findStatsForTitleLength() {
        Scanner scanner = new Scanner(System.in);
        int minLength = Integer.parseInt(scanner.nextLine());

        int count = this.bookService.findTitleCountLongerThan(minLength);

        System.out.printf("There are %d books with longer titles than %d symbols.", count, minLength);
    }

    private void findAllBooksByLastNameStarting() {
        Scanner scanner = new Scanner(System.in);
        String lastNameStart = scanner.nextLine();

        List<String> titlesForAuthorLastNameStartingWith = this.bookService.findTitlesForAuthorLastNameStartingWith(lastNameStart);

        titlesForAuthorLastNameStartingWith.forEach(System.out::println);
    }

    private void printBookTitlesContaining() {
        Scanner scanner = new Scanner(System.in);
        String needle = scanner.nextLine();

        List<String> titlesContaining = this.bookService.findTitlesContaining(needle);

        titlesContaining.forEach(System.out::println);
    }

    private void printAuthorsEndingIn() {
        Scanner scanner = new Scanner(System.in);
        String ending = scanner.nextLine();

        List<String> allNamesEndingIn = this.authorService.findAllNamesEndingIn(ending);

        allNamesEndingIn.forEach(System.out::println);
    }

    private void printBookInfoForBooksReleasedBefore() {
        Scanner scanner = new Scanner(System.in);

        String beforeDate = scanner.nextLine();

        LocalDate parsedDate =
                LocalDate.parse(beforeDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        List<Book> allReleasedBefore = this.bookService.findAllReleasedBefore(parsedDate);

        allReleasedBefore.forEach(book -> System.out.printf("%s %s $%.2f\n", book.getTitle(), book.getEditionType(), book.getPrice()));
    }

    private void printBooksNotIssuedAt() {
        List<String> titles = this.bookService.findTitlesForBooksNotPublishedIn(2000);

        titles.forEach(System.out::println);
    }

    private void printBooksWithPriceOutOfRange() {
        List<Book> books = bookService.findAllBooksWithPriceOutsideOf(5, 40);

        books.forEach(b -> System.out.printf("%s $%.2f\n", b.getTitle(), b.getPrice()));
    }

    private void printGoldBookWithLessThan5000copies() {
        List<String> titles = this.bookService.findALlByEditionTypeAndCopies(EditionType.GOLD, 5000);
    }

    private void printBooksByAgeRestriction() {
        Scanner scanner = new Scanner(System.in);

        String restriction = scanner.nextLine();
        try {
            AgeRestriction ageRestriction = AgeRestriction.valueOf(restriction.toUpperCase());

            List<String> titles = this.bookService.findAllByAgeRestriction(ageRestriction);

            titles.forEach(t -> System.out.println(t));


        } catch (IllegalArgumentException ex) {
            System.out.println("Wrong age category!");
            return;
        }
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
