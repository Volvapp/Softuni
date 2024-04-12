package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.repository.BookInfo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);


    List<String> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<String> findALlByEditionTypeAndCopies(EditionType editionType, int copies);

    List<Book> findAllBooksWithPriceOutsideOf(int lowerBound, int upperBound);

    List<String> findTitlesForBooksNotPublishedIn(int year);

    List<Book> findAllReleasedBefore(LocalDate parsedDate);

    List<String> findTitlesContaining(String needle);

    List<String> findTitlesForAuthorLastNameStartingWith(String lastNameStart);

    int findTitleCountLongerThan(int minLength);

    BookInfo findInfoByTitle(String title);

    void sellCopies(int bookId, int copiesSold);
}
