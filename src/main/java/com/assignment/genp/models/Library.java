package com.assignment.genp.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Library{
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lib_id")
	private Long id;
	private String name;
	private String description;
	

	@OneToMany(targetEntity = Book.class,cascade = CascadeType.ALL ,mappedBy = "bookId")
	@Transient
	private List<Book> books;
	
	public Library() {
		
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}
	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
}
