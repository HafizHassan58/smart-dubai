package com.smartdubai.model.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AddBookRequest {

    @NotNull
    @NotEmpty
    private String name;

    private String description;

    @NotNull
    @NotEmpty
    private String author;

    @NotNull
    @NotEmpty
    private Integer typeId;

    @NotNull
    @NotEmpty
    private Double price;

    @NotNull
    @NotEmpty
    private String isbn;
}
