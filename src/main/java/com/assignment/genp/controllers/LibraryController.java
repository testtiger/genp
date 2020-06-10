package com.assignment.genp.controllers;

import java.util.List;

import com.assignment.genp.models.Book;
import com.assignment.genp.repository.BooksRepository;
import com.assignment.genp.services.BooksServices;
import com.assignment.genp.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.assignment.genp.models.Library;
import com.assignment.genp.services.LibraryServices;

/***

 Created by
 @author dkammara on Monday - 5/4/2020

 */
@RestController
@RequestMapping("/api/libs")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)


public class LibraryController {
	

	@Autowired
	LibraryServices libraryServices;
	@Autowired
	BooksServices booksServices;

	@Autowired
	BooksRepository booksRepository;

	@Autowired
	UserServices userServices;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Library> getLibrary(@PathVariable long id){
		Library library=libraryServices.getLibrary(id);
		return new ResponseEntity<Library>(library,HttpStatus.OK);
	}
//@RequestParam(defaultValue = "0")
	@GetMapping
	public ResponseEntity<List<Library>> getLibraries(){
		List<Library> libraries=libraryServices.getLibraries();
		return  new ResponseEntity<List<Library>>(libraries,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Library> addLibrary(@RequestBody Library libraryToBeAdded){
		Library addedLibrary=libraryServices.addLibrary(libraryToBeAdded);
		return  new ResponseEntity<Library>(addedLibrary,HttpStatus.CREATED);
	}
	@PutMapping(value="{id}")
	public ResponseEntity<Library> updateLibrary(@PathVariable long id,@RequestBody Library libraryDetails){
		Library updatedLibrary=libraryServices.updateLibrary(id,libraryDetails);
		return  new ResponseEntity<Library>(updatedLibrary,HttpStatus.OK);		
	}

	@PostMapping(value = "/{id}/books")
	public ResponseEntity<Book> addBook( @PathVariable long id, @RequestBody Book bookToBeAdded){
		Library l= new Library();
		l.setId(id);
		bookToBeAdded.setLibrary(l);

		Book addedBook=booksServices.addBook(bookToBeAdded);
		return  new ResponseEntity<Book>(addedBook,HttpStatus.OK);
	}


	@GetMapping(value = "/{id}/books")
	public ResponseEntity<List<Book>> getBooks( @PathVariable long id){
		List<Book> booksList=booksServices.findByLibraryId(id);
		return  new ResponseEntity<List<Book>>(booksList,HttpStatus.OK);
	}

	@GetMapping(value = "/{lib_id}/books/{id}")
	public ResponseEntity<Book> getABook( @PathVariable long id){
		Book book=booksServices.findById(id);
		return  new ResponseEntity<Book>(book,HttpStatus.OK);
	}

	@PutMapping(value = "/{lib_id}/books/{id}")
	public ResponseEntity<Book> updateABook( @PathVariable long id, @RequestBody Book book){
		Book updatedBook=booksServices.updateBook(id,book);
		return  new ResponseEntity<Book>(updatedBook,HttpStatus.OK);
	}

	@PostMapping(value = "/{lib_id}/books/{id}/{user_id}")
	public ResponseEntity<Book> requestBook(@PathVariable long user_id){
		userServices.a
	}

}


