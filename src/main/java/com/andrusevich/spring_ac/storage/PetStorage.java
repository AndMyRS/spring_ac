package com.andrusevich.spring_ac.storage;

import com.andrusevich.spring_ac.model.Pet;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class PetStorage {

    private static int ID_COUNTER;

    private List<Pet> pets;

    {
        pets = new ArrayList<>();

        pets.add(new Pet(++ID_COUNTER, "Marsik", 3, "Brown"));

        pets.add(new Pet(++ID_COUNTER, "Bublik", 5, "White"));
    }

    public void addPet(Pet pet) {
        if (pet.getId() == 0) {
            pet.setId(++ID_COUNTER);
        }
        pets.add(pet);
    }

}
