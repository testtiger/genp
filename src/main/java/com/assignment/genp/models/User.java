package com.assignment.genp.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/***

 Created by 
 @author dkammara on Wednesday - 6/10/2020

 */
public class User {

    String name;

    public List<Book> getBook() {
        return booklist;
    }

    public void setBook(List<Book> booklist) {
        this.booklist = booklist;
    }

    @OneToMany

    Library library;
    @OneToMany
    List<Book> booklist;

    public String getName() {
        return name;
    }

    public User(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public User() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    public void setLibrary(Library library){
        this.library=library;
    }

}
