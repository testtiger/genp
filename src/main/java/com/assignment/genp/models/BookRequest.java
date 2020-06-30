package com.assignment.genp.models;

import javax.persistence.*;
import java.util.List;

/***

 Created by 
 @author dkammara on Thursday - 6/11/2020

 */
//https://www.baeldung.com/jpa-join-column

public class BookRequest {

    // request is about requesting a book by a user:
    // request can contain mutiple books
    // request can conation user info

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long requestId;

    @OneToOne(targetEntity = User.class,cascade = CascadeType.ALL ,mappedBy = "bookId")
    @Transient
    private  User user;

    @OneToMany(targetEntity = Book.class,cascade = CascadeType.ALL)
    @Transient
    List<Book> book;

    public long getId() {
        return requestId;
    }

    public void setId(long id) {
        this.requestId = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }


}
