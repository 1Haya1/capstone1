package org.example.capstone1.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {

    @NotEmpty(message = "must be not empty")
    private Integer id;

    @NotEmpty(message = "must be not empty")
    @Size(min = 4,message = "have to be more than 3 length long")
    private String name;
}
