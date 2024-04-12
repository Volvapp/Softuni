package org.bookshopsystemspring.service;

import org.bookshopsystemspring.data.entities.Author;

import java.io.IOException;

public interface AuthorService {

    void seedAuthors() throws IOException;

    Author getRandomAuthor();
}
