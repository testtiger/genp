package com.assignment.genp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.assignment.genp.models.Book;

import java.util.List;

public interface BooksRepository extends CrudRepository<Book, Long> {

    public List<Book> findByLibraryId(long id);

}