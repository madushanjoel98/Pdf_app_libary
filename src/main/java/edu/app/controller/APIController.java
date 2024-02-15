package edu.app.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.util.JSONPObject;

import edu.app.domains.Category;
import edu.app.domains.Subcategory;
import edu.app.dto.BookResponse;
import edu.app.dto.CommonListResponse;
import edu.app.dto.CommonRequest;
import edu.app.dto.SubCates;
import edu.app.dto.SubjectResponse;
import edu.app.respo.BooksRepository;
import edu.app.respo.CategoryRepository;
import edu.app.respo.SubcategoryRepository;

@RestController(value = "/api")
@RequestMapping(value = "/api")
public class APIController {
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	SubcategoryRepository subcategory;
	@Autowired
	BooksRepository booksRepository;

	@GetMapping(value = "/getallCats", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findallCats() {
		ResponseEntity<?> output = null;
		try {
			JSONPObject array = new JSONPObject("data", new  SubjectResponse(categoryRepository.findAll()));
			output = new ResponseEntity(array.getValue(), HttpStatus.OK);
		//	output = new ResponseEntity(categoryRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			output = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return output;
	}

	@PostMapping(value = "/getsubsbycats", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getsubsbycats(@RequestBody CommonRequest request) {
		ResponseEntity<?> output = null;
		try {
			JSONPObject array = new JSONPObject("data", new SubCates(subcategory.findByCats_Catid(request.getId())));
			output = new ResponseEntity(array.getValue(), HttpStatus.OK);
		} catch (Exception e) {
			output = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return output;
	}

	@GetMapping(value = "/getbookbysubid", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getbookbysubid(@RequestBody CommonRequest request) {
		ResponseEntity<?> output = null;
		try {
			JSONPObject array = new JSONPObject("data", new CommonListResponse(booksRepository.findBySubcategory_Sutid(request.getId())));
			output = new ResponseEntity(array.getValue(), HttpStatus.OK);
			//output = new ResponseEntity(booksRepository.findBySubcategory_Sutid(request.getId()), HttpStatus.OK);
		} catch (Exception e) {
			output = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return output;
	}

	@PostMapping(value = "/getbookKeyword", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getbookKeyword(@RequestBody CommonRequest request) {
		ResponseEntity<?> output = null;
		try {
			JSONPObject array = new JSONPObject("data", new CommonListResponse(booksRepository.findByBook_nameLike(request.getKeyword())));
			output = new ResponseEntity(array.getValue(), HttpStatus.OK);
			
			
		} catch (Exception e) {
			output = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return output;
	}

	@PostMapping("/getbookbyid")
	public ResponseEntity<?> getbookbyid(@RequestBody CommonRequest request) {
		ResponseEntity<?> output = null;
		try {
			JSONPObject array = new JSONPObject("data", new BookResponse(booksRepository.findById(Long.valueOf(request.getId())
					).get()));
			output = new ResponseEntity(array.getValue(), HttpStatus.OK);
		} catch (Exception e) {
			output = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return output;
	}

	@GetMapping("/getAllbook")
	public ResponseEntity<?> getAllbook() {
		ResponseEntity<?> output = null;
		try {
			JSONPObject array = new JSONPObject("data", new CommonListResponse(booksRepository.findAll()));
			output = new ResponseEntity(array.getValue(), HttpStatus.OK);
		} catch (Exception e) {
			output = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return output;
	}

	@GetMapping(value = "/getallsubscat", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getallsubscat() {
		ResponseEntity<?> output = null;
		try {
			JSONPObject array = new JSONPObject("data", new SubCates(subcategory.findAll()));
			output = new ResponseEntity(array.getValue(), HttpStatus.OK);
			
		} catch (Exception e) {
			output = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return output;
	}
}
