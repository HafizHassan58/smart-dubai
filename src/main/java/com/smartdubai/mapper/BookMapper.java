package com.smartdubai.mapper;

import com.smartdubai.entity.Book;
import com.smartdubai.model.request.AddBookRequest;
import com.smartdubai.model.request.UpdateBookRequest;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book mapBookRequest(AddBookRequest addBookRequest){
        Book book = new Book();
        book.setName(addBookRequest.getName());
        book.setAuthor(addBookRequest.getAuthor());
        book.setDescription(addBookRequest.getDescription());
        book.setPrice(addBookRequest.getPrice());
        book.setTypeId(addBookRequest.getTypeId());
        book.setIsbn(addBookRequest.getIsbn());
        return book;
    }

    public Book mapBookRequest(UpdateBookRequest updateBookRequest){
        Book book = new Book();
        book.setId(updateBookRequest.getId());
        book.setName(updateBookRequest.getName());
        book.setAuthor(updateBookRequest.getAuthor());
        book.setDescription(updateBookRequest.getDescription());
        book.setPrice(updateBookRequest.getPrice());
        book.setTypeId(updateBookRequest.getTypeId());
        book.setIsbn(updateBookRequest.getIsbn());
        return book;
    }
}
