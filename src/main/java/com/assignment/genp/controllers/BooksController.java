package com.assignment.genp.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.assignment.genp.models.Book;
import com.assignment.genp.services.BooksServices;
import com.assignment.genp.services.DummyBookService;
import com.assignment.genp.services.GenericService;


@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api/books")
public class BooksController {

	@Autowired
	
	BooksServices booksServices;


	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> getBook(@PathVariable long id){
		Book book=booksServices.getBook(id);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Book>> getBooks(){
		List<Book> books=booksServices.getBooks();
		return  new ResponseEntity<List<Book>>(books,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Book> addBook(@Valid @RequestBody Book bookToBeAdded){
		Book addedBook=booksServices.addBook(bookToBeAdded);
		return  new ResponseEntity<Book>(addedBook,HttpStatus.OK);
	}
	
	@PutMapping(value="{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, Book bookDetails){
		Book updatedBook=booksServices.updateBook(id,bookDetails);
		return  new ResponseEntity<Book>(updatedBook,HttpStatus.OK);		
	}


}
