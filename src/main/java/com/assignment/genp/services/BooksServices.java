package com.assignment.genp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.genp.models.Book;
import com.assignment.genp.repository.BooksRepository;

@Service
public class BooksServices extends GenericService{
	@Autowired
	BooksRepository booksRepository;

	public Book getBook(long id) {
		
		Optional<Book> book =booksRepository.findById(id);
		book.orElseThrow(BookNotFoundException::new);
		return book.get();
	}

	public List<Book> getBooks() {
		
		return (List<Book>)booksRepository.findAll();
		
	}

	public Book updateBook(long id, Book bookDetails) {
		return booksRepository.save(bookDetails);
	}

	public Book addBook(Book bookToBeAdded) {
		return booksRepository.save(bookToBeAdded);
		
	}
	
	

}
