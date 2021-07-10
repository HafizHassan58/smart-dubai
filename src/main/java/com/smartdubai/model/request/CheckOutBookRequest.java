package com.smartdubai.model.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CheckOutBookRequest implements Serializable {

    @NotNull(message = "id cannot be null")
    private Integer id;

    @NotNull(message = "name cannot be null")
    @NotEmpty
    private String name;

    private String description;

    @NotNull(message = "author cannot be null")
    @NotEmpty
    private String author;

    @NotNull(message = "typeId cannot be null")
    private Integer typeId;

    @NotNull(message = "price cannot be null")
    private Long price;

    @NotNull(message = "isbn cannot be null")
    @NotEmpty
    private String isbn;
}
