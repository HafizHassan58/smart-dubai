package com.smartdubai.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="book")
@Data
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String author;
    @Column(name = "type_id")
    private Integer typeId;
    private Double price;
    private String isbn;
}
