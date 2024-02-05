package edu.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;

import edu.app.domains.Subcategory;
import edu.app.dto.CommonRequest;
import edu.app.respo.BooksRepository;
import edu.app.respo.CategoryRepository;
import edu.app.respo.SubcategoryRepository;

@RestController
@RequestMapping(value = "/api")
public class APIController {
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	SubcategoryRepository subcategory;
	@Autowired
	BooksRepository booksRepository;
@GetMapping("/getallCats")
public ResponseEntity<?>findallCats(){
	 ResponseEntity<?>output=null;
	 try {
		 
		output=new ResponseEntity(categoryRepository.findAll(),HttpStatus.OK);
	} catch (Exception e) {
		output=new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	 return output;
}
@GetMapping("/getsubsbycats")
public ResponseEntity<?>getsubsbycats(@RequestBody CommonRequest request){
	 ResponseEntity<?>output=null;
	 try {
		 
	output=new ResponseEntity(subcategory.findByCats_Catid(request.getId()),HttpStatus.OK);
	} catch (Exception e) {
		output=new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	 return output;
}

@GetMapping("/getbookbysubid")
public ResponseEntity<?>getbookbysubid(@RequestBody CommonRequest request){
	 ResponseEntity<?>output=null;
	 try {
		 
	output=new ResponseEntity(booksRepository.findBySubcategory_Sutid(request.getId()),HttpStatus.OK);
	} catch (Exception e) {
		output=new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	 return output;
}
}
