package org.bookshopsystemspring.service.impl;

import org.bookshopsystemspring.data.entities.Author;
import org.bookshopsystemspring.data.repositories.AuthorRepository;
import org.bookshopsystemspring.service.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ThreadLocalRandom;
@Service
public class AuthorServiceImpl implements AuthorService {
    private static final String FILE_PATH = "src/main/resources/files/authors.txt";
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        Files.readAllLines(Path.of(FILE_PATH))
                .stream()
                .filter(row -> !row.isEmpty())
                .forEach(row -> {
                    String[] tokens = row.split("\\s+");
                    Author author = new Author(tokens[0], tokens[1]);
                    this.authorRepository.saveAndFlush(author);
                });
    }

    @Override
    public Author getRandomAuthor() {
        int randomId = ThreadLocalRandom
                .current()
                .nextInt(1, (int) this.authorRepository.count() + 1);
        return this.authorRepository.findById(randomId).get();

    }
}
