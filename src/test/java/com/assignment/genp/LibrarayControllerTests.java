package com.assignment.genp;

import com.assignment.genp.controllers.LibraryController;
import com.assignment.genp.models.Book;
import com.assignment.genp.models.Library;
import com.assignment.genp.services.BooksServices;
import com.assignment.genp.services.LibraryServices;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON;

import org.springframework.http.ResponseEntity;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

/***

 Created by 
 @author dkammara on Sunday - 5/10/2020

 */

@RunWith(SpringRunner.class)
@WebMvcTest(LibraryController.class)
public class LibrarayControllerTests {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private LibraryController libraryController;
    @MockBean
    private LibraryServices libraryServices;

    @MockBean
    private BooksServices booksServices;


    @Ignore
    public void getLibraries() throws Exception {

        Library library = new Library();
        library.setId(123l);
        library.setName("name");
        library.setDescription("desc");

        List<Library> ll=new ArrayList<>();
        ll.add(library);

        given(libraryServices.getLibraries()).willReturn(ll);

        mockMvc.perform(get("/api/libs/123").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)));



    }


    @Ignore
    public void getLibrary() throws Exception {
        Library library = new Library();
        library.setId(1l);
        library.setName("name");
        library.setDescription("desc");

        List<Library> ll=new ArrayList<>();
        ll.add(library);

        //given(libraryServices.getLibrary(1)).willReturn(library);

        mockMvc.perform( MockMvcRequestBuilders
                .get("/api/libs/{id}", 1L)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));


    }



    @Ignore
    public void getBook() throws Exception {
        Book book = new Book();
       book.setAuthor("author");
       // given(booksServices.getBook(123)).willReturn(book);

        mockMvc.perform( MockMvcRequestBuilders
                .get("/api/libs/1/books/{id}", 123)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));


    }


}
