package com.smartdubai.service;

import com.smartdubai.model.request.CheckOutBookRequest;
import com.smartdubai.repository.BookRepository;
import com.smartdubai.repository.BookTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CheckOutService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookTypeRepository bookTypeRepository;

    public Long checkOutBooks(List<CheckOutBookRequest> books){
        Long totalAmount = 0L;
        Map<Integer, Integer> booksTypeDiscountMap = getBookTypeDiscount();

        for (CheckOutBookRequest book: books){
            totalAmount = totalAmount + calculateAmountAfterDiscount(book.getPrice(), booksTypeDiscountMap.get(book.getTypeId()));
        }

        return totalAmount;
    }

    private Long calculateAmountAfterDiscount(Long originalPrice, Integer discountPercentage){
        System.out.println("originalPrice:: "+originalPrice);
        Long discountedPrice = originalPrice * discountPercentage / 100;
        System.out.println("discountedPrice:: "+discountedPrice);
        return originalPrice - discountedPrice;
    }

    private Map<Integer, Integer> getBookTypeDiscount(){
        Map<Integer, Integer> booksTypeDiscountMap = new HashMap<>();
        bookTypeRepository.findAll().forEach(book -> booksTypeDiscountMap.put(book.getId(), book.getDiscountPercent()));
        return booksTypeDiscountMap;
    }
}
