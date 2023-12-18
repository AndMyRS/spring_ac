package com.andrusevich.spring_ac.service;

import com.andrusevich.spring_ac.model.Pet;
import com.andrusevich.spring_ac.storage.PetStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PetDAO {

    private final PetStorage petStorage;

    public List<Pet> getAllPets() { // index
        return petStorage.getPets();
    }

    public Pet getPetById(int id) { // show
        Optional<Pet> pet = petStorage.getPets().stream()
                .filter(p -> p.getId() == id)
                .findFirst();

        if (pet.isPresent()) {
            return pet.get();
        } else throw new IllegalArgumentException("Pet not found");
    }

    public void save(Pet pet) {
        petStorage.addPet(pet);
    }

    public void updatePet(Pet pet, int id) {
        Pet petToUpdate = getPetById(id);
        petToUpdate.setName(pet.getName());
    }
}
