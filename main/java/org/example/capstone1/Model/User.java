package org.example.capstone1.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {


    @NotEmpty(message = "must be not empty")
    private Integer id;

    @NotEmpty(message = "must be not empty")
    @Size(min = 6,message = "have to be more than 5 length long")
    private String username;

    @NotEmpty(message = "must be not empty")
    @Size(min = 7,message = "have to be more than 6 length long and contain both characters and digits")
    private String password;

    @NotEmpty(message = "Email must not be empty")
    @Email
    private String email;

    @NotEmpty(message = "Role must not be empty")
    @Pattern(regexp = "^(Admin|Customer)$", message = "Role must be 'Admin' or 'Customer'")
    private String role;

    @NotEmpty(message = "must be not empty")
    @Positive(message = "Balance must be a positive number")
    private double balance;

}
