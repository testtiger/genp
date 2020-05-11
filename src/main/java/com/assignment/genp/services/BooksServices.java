package com.assignment.genp.services;

import java.util.List;

import com.assignment.genp.exceptions.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.genp.models.Book;
import com.assignment.genp.repository.BooksRepository;

@Service
public class BooksServices extends GenericService{
	@Autowired
	BooksRepository booksRepository;

	public Book getBook(long id) {
		
		return  booksRepository.findById(id).orElseThrow(BookNotFoundException::new);
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

	public List<Book> findByLibraryId(long id){
		return booksRepository.findByLibraryId(id);
	}

	public Book findById(long id){
		return booksRepository.findById(id).get();
	}
	

}
