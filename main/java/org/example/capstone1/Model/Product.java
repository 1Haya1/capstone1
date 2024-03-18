package org.example.capstone1.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Product {



    @NotEmpty(message = "must be not empty")
    private Integer id;

    @NotEmpty(message = "must be not empty")
    @Size(min = 4,message = "have to be more than 3 length long")
    private String name;

    @NotEmpty(message = "must be not empty")
    @Positive(message = "must be positive number")
    private Integer price;

    @NotEmpty(message = "must be not empty")
    private Integer categoryId;

    @NotNull(message = "must be not empty")
    private List<Integer>ratings;

}
