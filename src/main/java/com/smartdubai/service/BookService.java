package com.smartdubai.service;

import com.smartdubai.entity.Book;
import com.smartdubai.mapper.BookMapper;
import com.smartdubai.model.request.AddBookRequest;
import com.smartdubai.model.request.UpdateBookRequest;
import com.smartdubai.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(book -> books.add(book));
        return books;
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).get();
    }

    public Book saveBook(AddBookRequest addBookRequest) throws Exception{
        return bookRepository.save(bookMapper.mapBookRequest(addBookRequest));
    }

    public Book updateBook(UpdateBookRequest updateBookRequest) {
        return bookRepository.save(bookMapper.mapBookRequest(updateBookRequest));
    }

    public void delete(int id) {
        bookRepository.deleteById(id);
    }

}
