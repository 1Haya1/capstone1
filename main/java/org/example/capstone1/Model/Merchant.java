package org.example.capstone1.Model;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Merchant {

    @NotNull(message = "must be not null")
    private Integer id;

    @NotNull(message = "must be not empty")
    @Size(min = 4,message = "have to be more than 3 length long")
    private String name;
}
