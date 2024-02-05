package edu.app.service.impl;

import edu.app.domains.Books;
import edu.app.respo.BooksRepository;
import edu.app.service.BookService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
public class BookServiceIMPL implements BookService {
    @Autowired
    BooksRepository booksRepository;
    @Override
    public void addBook(Books book) throws Exception {
        try {
            booksRepository.save(book);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }
}
