package com.assignment.genp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.stereotype.Service;

import com.assignment.genp.models.Book;

@Service(value="dummyBook")
public class DummyBookService extends GenericService{


	static Supplier<Book> bookSupplier=Book::new;
	static List<Book> bookList=new ArrayList<>();

	static Book getSampleBook() {
		Book book=bookSupplier.get();
		book.setAuthor("Diwakara");
		book.setAvailabilityStatus(true);
		book.setDescription("this is a great book");
		book.setName("Hello World");
		book.setBookId(123456l);

		return book;
	}
	public Book getBook(long id) {
		Book book=getSampleBook();
		return book;
	}

	public List<Book> getBooks() {
		Book b1=getSampleBook();
		Book b2=getSampleBook();
		Book b3=getSampleBook();

		b2.setName("MahaBarath");
		b2.setAuthor("siva");

		b3.setName("Ramayan");
		b3.setAuthor("sreekant");

		bookList.add(b1);
		bookList.add(b2);
		bookList.add(b3);
		return bookList;
	}

	public Book updateBook(long id, Book bookeDetails) {
		return bookeDetails;	
	}

	public Book addBook(Book bookToBeAdded) {

		bookList.add(bookToBeAdded);
		return bookToBeAdded;


	}

}
