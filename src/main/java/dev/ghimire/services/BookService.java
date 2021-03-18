package dev.ghimire.services;

import dev.ghimire.entities.Book;

import java.util.Set;

public interface BookService {

    Book registerBook(Book book);

    //read
    Book getBookById(int id);
    Set<Book> getAllBooks();

    Book updateBook(Book book);

    boolean deleteBookById(int id);


}
