package com.smartdubai.controller;

import com.smartdubai.entity.Book;
import com.smartdubai.model.request.AddBookRequest;
import com.smartdubai.model.request.UpdateBookRequest;
import com.smartdubai.model.response.GenericResponse;
import com.smartdubai.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public ResponseEntity<?> getAllBooks() {
        try {
            List<Book> books = bookService.getAllBooks();
            GenericResponse response = new GenericResponse("Success", true, books);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            GenericResponse response = new GenericResponse("Internal Server Error!", false, null);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable("bookId") int bookId) {
        try {
            Book book = bookService.getBookById(bookId);
            GenericResponse response = new GenericResponse("Success", true, book);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            GenericResponse response = new GenericResponse("Internal Server Error!", false, null);
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("/book/add")
    public ResponseEntity<?> add(@Valid @RequestBody AddBookRequest addBookRequest) {
        try {
            Book book = bookService.saveBook(addBookRequest);
            GenericResponse response = new GenericResponse("Book Added Successfully!", true, book);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            GenericResponse response = new GenericResponse("Internal Server Error!", false, null);
            return ResponseEntity.ok(response);
        }
    }

    @PutMapping("/book/update")
    public ResponseEntity<?> update(@Valid @RequestBody UpdateBookRequest updateBookRequest) {
        try {
            Book book = bookService.updateBook(updateBookRequest);
            GenericResponse response = new GenericResponse("Book Updated Successfully!", true, book);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            GenericResponse response = new GenericResponse("Internal Server Error!", false, null);
            return ResponseEntity.ok(response);
        }
    }

    @DeleteMapping("/book/{bookid}")
    public ResponseEntity<?> deleteBookById(@PathVariable("bookId") int bookId) {
        try {
            bookService.delete(bookId);
            GenericResponse response = new GenericResponse("Book Deleted Successfully!", true, null);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            GenericResponse response = new GenericResponse("Internal Server Error!", false, null);
            return ResponseEntity.ok(response);
        }
    }
}
