package com.assignment.genp.models;

import javax.persistence.*;
import java.util.List;

/***

 Created by 
 @author dkammara on Wednesday - 6/10/2020

 */
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String name;


  //  @OneToMany(targetEntity = BookRequest.class,cascade = CascadeType.ALL)
   // List<BookRequest> requests;

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


}
