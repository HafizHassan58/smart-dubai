package com.smartdubai.repository;

import com.smartdubai.entity.BookType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookTypeRepository extends JpaRepository<BookType, Integer> {
}
