package com.smartdubai.controller;

import com.smartdubai.entity.Book;
import com.smartdubai.model.request.AddBookRequest;
import com.smartdubai.model.request.CheckOutBookRequest;
import com.smartdubai.model.request.UpdateBookRequest;
import com.smartdubai.model.response.GenericResponse;
import com.smartdubai.service.BookService;
import com.smartdubai.service.CheckOutService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class BooksControllerTest {

    private static Book book1;
    private static Book book2;
    private static AddBookRequest addBookRequest;
    private static UpdateBookRequest updateBookRequest;
    private static List<CheckOutBookRequest> checkOutBookRequestList;

    @InjectMocks
    private BooksController booksController;

    @Mock
    private BookService bookService;

    @Mock
    private CheckOutService checkOutService;

    @Test
    void getAllBooks() {
        Mockito.when(bookService.getAllBooks()).thenReturn(Arrays.asList(book1,book2));
        ResponseEntity<GenericResponse> responseEntity = booksController.getAllBooks();
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        Mockito.verify(bookService.getAllBooks());
        assertEquals(bookService.getAllBooks().size(), 2);
    }

    @Test
    void getBookById() {
        Mockito.when(bookService.getBookById(1)).thenReturn(book1);
        ResponseEntity<GenericResponse> responseEntity = booksController.getBookById(1);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        Mockito.verify(bookService.getBookById(1));
    }

    @Test
    void add() throws Exception {
        booksController.add(addBookRequest);
        Mockito.verify(bookService, Mockito.times(1)).saveBook(addBookRequest);
    }

    @Test
    void update() {
        booksController.update(updateBookRequest);
        Mockito.verify(bookService, Mockito.times(1)).updateBook(updateBookRequest);
    }

    @Test
    void deleteBookById() {
        booksController.deleteBookById(1);
        Mockito.verify(bookService, Mockito.times(1)).delete(1);
    }

    @Test
    void checkOut() {
        booksController.checkOut(checkOutBookRequestList);
        Mockito.verify(checkOutService).checkOutBooks(checkOutBookRequestList);
    }

    @BeforeAll
    void setUp() {
        MockitoAnnotations.initMocks(this);
        book1 = new Book();
        book1.setName("test1");
        book1.setTypeId(1);
        book1.setIsbn("123-456-789");
        book1.setAuthor("Hassan test1");
        book1.setDescription("testing 1");
        book1.setPrice(100L);

        book2 = new Book();
        book2.setName("test2");
        book2.setTypeId(2);
        book2.setIsbn("123-456-789-2");
        book2.setAuthor("Hassan test2");
        book2.setDescription("testing 2");
        book2.setPrice(130L);

        addBookRequest = new AddBookRequest();
        addBookRequest.setName("test1");
        addBookRequest.setTypeId(1);
        addBookRequest.setIsbn("123-456-789");
        addBookRequest.setAuthor("Hassan test1");
        addBookRequest.setDescription("testing 1");
        addBookRequest.setPrice(100L);

        updateBookRequest = new UpdateBookRequest();
        updateBookRequest.setName("test2");
        updateBookRequest.setTypeId(2);
        updateBookRequest.setIsbn("123-456-789-2");
        updateBookRequest.setAuthor("Hassan test2");
        updateBookRequest.setDescription("testing 2");
        updateBookRequest.setPrice(130L);

        checkOutBookRequestList = new ArrayList<>();
        CheckOutBookRequest checkOutBookRequest = new CheckOutBookRequest();
        checkOutBookRequest.setName("test2");
        checkOutBookRequest.setTypeId(2);
        checkOutBookRequest.setIsbn("123-456-789-2");
        checkOutBookRequest.setAuthor("Hassan test2");
        checkOutBookRequest.setDescription("testing 2");
        checkOutBookRequest.setPrice(130L);

        checkOutBookRequestList.add(checkOutBookRequest);
    }
}