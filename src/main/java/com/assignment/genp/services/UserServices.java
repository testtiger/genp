package com.assignment.genp.services;

import com.assignment.genp.models.Book;
import com.assignment.genp.models.User;
import com.assignment.genp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/***

 Created by 
 @author dkammara on Wednesday - 6/10/2020

 */
@Service
public class UserServices {

    UserRepository repository;

    public User addUser(User user){
        return repository.save(user);
    }


    public User requestBook(Book book) {
        User user = new User();
        List<Book> books = new ArrayList<>();
        books.add(book);
        user.setBook(books);
        return repository.save(user);
    }


}
