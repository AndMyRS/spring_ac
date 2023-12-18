package com.andrusevich.spring_ac.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Pet {

    public Pet() {
    }

    public Pet(int id, String name, int age, String colour) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.colour = colour;
    }

    private int id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    // @Positive(message = "Age cannot be negative")
    private int age;

    private String colour;
}
