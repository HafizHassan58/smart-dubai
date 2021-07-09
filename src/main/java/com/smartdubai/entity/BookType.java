package com.smartdubai.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="book_type")
@Data
public class BookType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    @Column(name = "discount_percent")
    private Integer discountPercent;
}
