package com.assignment.genp;

import com.assignment.genp.models.Book;
import com.assignment.genp.models.Library;
import com.assignment.genp.repository.BooksRepository;
import com.assignment.genp.repository.LibraryRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

/***

 Created by 
 @author dkammara on Sunday - 5/10/2020

 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private LibraryRepository repository;

    @Autowired
    private BooksRepository booksRepository;
    @Test
    public void testSaveLibrary() {
        Library lb=new Library();
        String name="lib1";
        String desc="lib desc";
        lb.setName(name);
        lb.setDescription(desc);

        entityManager.persist(lb);
        List<Library> savedOne=(List<Library>) repository.findAll();
        assertEquals(savedOne.get(0).getName(),name);
        assertEquals(savedOne.get(0).getDescription(),desc);

    }

    @Test
    public void tetSaveBook() {
        Book lb=new Book();
        String name="lib1";
        String desc="lib desc";
        String auth="Author";
        lb.setName(name);
        lb.setDescription(desc);
        lb.setAuthor(auth);

        entityManager.persist(lb);
        List<Book> savedOne=(List<Book>) booksRepository.findAll();
        assertEquals(savedOne.get(0).getName(),name);
        assertEquals(savedOne.get(0).getDescription(),desc);
        assertEquals(savedOne.get(0).getAuthor(),auth);

    }
}
