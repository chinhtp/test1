package com.example.todo_app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                  // Lombok: tự sinh getter, setter, toString, equals, hashCode

public class User {
    private Long id;
    private String ten;
    private String email;
}