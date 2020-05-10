package com.assignment.genp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Book  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long bookId;
	private String author;
	private String name;
	private String description;
	private boolean availabilityStatus;

	@ManyToOne
	private Library library;


	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}


	public Long getBookId() {
		return bookId;
	}

	public void setBookId(long id) {
		this.bookId= id;
	}


	public Book() {
		
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
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
	/**
	 * @return the availabilityStatus
	 */
	public boolean isAvailabilityStatus() {
		return availabilityStatus;
	}
	/**
	 * @param availabilityStatus the availabilityStatus to set
	 */
	public void setAvailabilityStatus(boolean availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}


}
