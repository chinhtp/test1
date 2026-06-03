package com.example.todo_app;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                  // Lombok: tự sinh getter, setter, toString, equals, hashCode

public class User {
    private Long id;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters")
    private String name;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Email format is invalid")
    private String email;
}