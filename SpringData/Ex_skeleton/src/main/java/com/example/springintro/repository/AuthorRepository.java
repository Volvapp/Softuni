package com.example.springintro.repository;

import com.example.springintro.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a ORDER BY a.books.size DESC")
    List<Author> findAllByBooksSizeDESC();
@Query()
    List<Author> findAllByFirstNameEndingWith(String symbol);
@Query("SELECT SUM(b.copies) FROM " +
        "Author a " +
        "JOIN a.books b " +
        "WHERE a.firstName = :firstName " +
        "AND a.lastName = :lastName")
    int countBookCopiesByAuthorName(String firstName, String lastName);
}
