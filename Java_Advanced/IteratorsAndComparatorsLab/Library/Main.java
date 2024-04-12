package IteratorsAndComparatorsLab.Library;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        Library lib = new Library(bookOne, bookTwo, bookThree);

        for (Book book : lib) {
            System.out.println(book.getTitle());
        }

        lib.forEach(book -> System.out.println(book.getTitle()));

        Iterator<Book> iterator = lib.iterator();

        while (iterator.hasNext()) {
            Book currentBook = iterator.next();

            System.out.println(currentBook.getTitle());
        }
    }
}