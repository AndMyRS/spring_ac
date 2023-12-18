package com.andrusevich.spring_ac.controller;

import com.andrusevich.spring_ac.model.Pet;
import com.andrusevich.spring_ac.service.PetDAO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pets")
public class PetsController {

    private final PetDAO petDAO;

    @GetMapping()
    public String getAllPets(Model model) {
        model.addAttribute("pets", petDAO.getAllPets());
        return "allpets";
    }

    @GetMapping("/{id}")
    public String getPetById(@PathVariable("id") int id,
                          Model model) {
        model.addAttribute("pet", petDAO.getPetById(id));
        return "pet";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("pet", new Pet());
        return "new";
    }

    @PostMapping()
    public String addPet(@ModelAttribute("pet") @Valid Pet pet) {
        petDAO.save(pet);
        return "redirect:/pets";
    }

    @GetMapping("/{id}/edit")
    public String editPet(Model model, @PathVariable("id") int id) {
        model.addAttribute("pet", petDAO.getPetById(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String updatePet(@ModelAttribute("pet") @Valid Pet pet, @PathVariable("id") int id) {
        petDAO.updatePet(pet, id);
        return "redirect:/pets";
    }

}
