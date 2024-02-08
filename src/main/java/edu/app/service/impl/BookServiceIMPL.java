package edu.app.service.impl;

import edu.app.domains.Books;
import edu.app.domains.Category;
import edu.app.domains.Subcategory;
import edu.app.respo.BooksRepository;
import edu.app.respo.CategoryRepository;
import edu.app.respo.SubcategoryRepository;
import edu.app.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
public class BookServiceIMPL implements BookService {
    @Autowired
    BooksRepository booksRepository;
    @Autowired
	CategoryRepository categoryRepository;
	@Autowired
	SubcategoryRepository subcategoryrespo;
    @Override
    public void addBook(Books book) throws Exception {
        try {
            booksRepository.save(book);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }
	@Override
	public void addCategory(Category category) throws Exception {
		 try {
			 categoryRepository.save(category);
	        }catch (Exception e){
	            throw  new Exception(e.getMessage());
	        }
		
	}
	@Override
	public void addSubCategory(Subcategory subcategory) throws Exception {
		try {
			subcategoryrespo.save(subcategory);
	        }catch (Exception e){
	            throw  new Exception(e.getMessage());
	        }
		
	}
	@Override
	public void deleteBook(long id) throws Exception {
		
		try {
			booksRepository.deleteById(id);
	        }catch (Exception e){
	            throw  new Exception(e.getMessage());
	        }
		
	}
	@Override
	public void deletecat(int id) throws Exception {
		try {
			categoryRepository.deleteById(id);
	        }catch (Exception e){
	            throw  new Exception(e.getMessage());
	        }
		
	}
	@Override
	public void deletesubcat(int id) throws Exception {
		try {
			subcategoryrespo.deleteById(id);
	        }catch (Exception e){
	            throw  new Exception(e.getMessage());
	        }
		
	}
}
