package edu.app.service;

import java.awt.print.Book;

import edu.app.domains.Books;
import edu.app.domains.Category;
import edu.app.domains.Subcategory;

public interface BookService {

   void addBook(Books book) throws  Exception;
   void addCategory(Category category)throws  Exception;
   void addSubCategory(Subcategory subcategory)throws  Exception;
   void deleteBook(long id)throws  Exception;
   void deletecat(int id)throws  Exception;
   void deletesubcat(int id)throws  Exception;
   
}
