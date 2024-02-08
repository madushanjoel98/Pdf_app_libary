package edu.app.controller;

import java.awt.print.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.app.domains.Books;
import edu.app.domains.Category;
import edu.app.domains.Subcategory;
import edu.app.dto.CommonRequest;
import edu.app.service.BookService;

@Controller
public class UserController {
	@Autowired
	BookService bookService;
@GetMapping("/login")
public String loadlogin() {
	return "login.html";
}
@GetMapping("/")
public String mainPage(Model model) {
	
	model.addAttribute("cat", new Category());
	model.addAttribute("subcat", new Subcategory());
	model.addAttribute("bookmod", new Books());
	
	return "/view/mainpage.html";
}
@GetMapping("/logout")
public String logout() {
	return "redirect:/login";
}
@PostMapping("/addcat")
public String addcat(@ModelAttribute Category category,RedirectAttributes attributes) {
	try {
		bookService.addCategory(category);
		attributes.addFlashAttribute("success", "category added");
	} catch (Exception e) {
		attributes.addFlashAttribute("error", e.getMessage());
	}
	return "redirect:/";
}

@PostMapping("/addsucat")
public String addsucat(@ModelAttribute Subcategory category,RedirectAttributes attributes) {
	try {
		bookService.addSubCategory(category);
		attributes.addFlashAttribute("success", "sub-category added");
	} catch (Exception e) {
		attributes.addFlashAttribute("error", e.getMessage());
	}
	return "redirect:/";
}

@PostMapping("/addbook")
public String addbook(@ModelAttribute Books category,RedirectAttributes attributes) {
	try {
		
		bookService.addBook(category);
		attributes.addFlashAttribute("success", "Book added");
	} catch (Exception e) {
		attributes.addFlashAttribute("error", e.getMessage());
	}
	return "redirect:/";
}

@PostMapping("/deletebook")
public ResponseEntity<?> getbookbyid(@RequestBody CommonRequest request) {
	ResponseEntity<?> output = null;
	try {
		bookService.deleteBook(request.getId());
		output = new ResponseEntity("Deleted", HttpStatus.OK);
	} catch (Exception e) {
		output = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	return output;
}
@PostMapping("/deletemaincat")
public ResponseEntity<?> deletemaincat(@RequestBody CommonRequest request) {
	ResponseEntity<?> output = null;
	try {
		bookService.deletecat(request.getId());
		output = new ResponseEntity("Deleted", HttpStatus.OK);
	} catch (Exception e) {
		output = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	return output;
}
@PostMapping("/deletesubcat")
public ResponseEntity<?> deletesubcat(@RequestBody CommonRequest request) {
	ResponseEntity<?> output = null;
	try {
		bookService.deletesubcat(request.getId());
		output = new ResponseEntity("Deleted", HttpStatus.OK);
	} catch (Exception e) {
		output = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	return output;
}

}
