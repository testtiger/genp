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

/***


 program which exposes read/write/update API for creating a book object in a
 Use case details for full-stack and backend developer*:
(A) Develop the following use case before coming for the discussion:
1. Create a Library Object and a Book object in JPA
2. Write a program which exposes read/write/update API for creating a book object in a
in memory database like .h2. use JAP for writing to DB
3. One API to get all the books for a Library
4. API to update one Book details into DB
5. Write test cases Unit + integration
6. Should be Maven based running project
7. One simple React or angular JS page which displays list libraries
8. Click on libraries and show the books
9. Write test case to test the components
10. Use best possible design principles
11. Should be able to modify the use case to showcase generally used design patterns
during the discussion
12. Document code to appropriately describe the design choices
(B) During the discussion, the above use case will be reviewed and discussed. An
enhancement would be asked to be made and unit testing would have to be done for the
enhancement. In addition to this, regular technical questions would be asked.

 Created by 
 @author dkammara on Monday - 5/4/2020

 */
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
