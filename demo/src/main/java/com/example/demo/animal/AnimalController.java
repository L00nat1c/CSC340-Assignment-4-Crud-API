package com.example.demo.animal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    /**
     * Get a list of all Animals in the database
     *
     * @return a list of all Animal object
     */
    @GetMapping("/all")
    public String getAllAnimals(Model model) {
        model.addAttribute("animalList", service.getAllAnimals());
        return "animal-list";
    }

    /**
     * Get a specific Animal by ID
     *
     * @param animalID is the unique ID for the Animal
     * @return the Animal object with the corresponding animalID
     */
    @GetMapping("/{animalID}")
    public String getOneAnimal(@PathVariable int animalID, Model model) {
        model.addAttribute("animal", service.getAnimalByID(animalID));
        return "animal-details";
    }

    /**
     * Get a list of Animals that live in a specified habitat
     *
     * @param habitat is the animals' habitat
     * @return a list of Animals that live in the specified habitat
     */
    @GetMapping("")
    public String getAnimalByHabitat(@RequestParam(name = "habitat", defaultValue = "desert") String habitat, Model model){
        model.addAttribute("animalList", service.getAnimalByHabitat(habitat));
        return "animal-list";
    }

    /**
     * Get a list of Animals of a certain species
     *
     * @param species is the species that the Animal is a part of
     * @return a list of Animals of a certain species
     */
    @GetMapping("/species")
    public String getAnimalsBySpecies(@RequestParam(name = "species", defaultValue = "Lion") String species, Model model) {
        model.addAttribute("animalList", service.getAnimalBySpecies(species));
        return "animal-list";
    }

    /**
     * Get a list of Animals with a certain name
     *
     * @param name is the name of the Animal
     * @return a list of Animals with a certain name
     */
    @GetMapping("/name")
    public String getAnimalsByName(@RequestParam(name = "name", defaultValue = "Blue") String name, Model model) {
        model.addAttribute("animalList", service.getAnimalByName(name));
        return "animal-list";
    }

    /**
     * Gets the create animal form
     *
     * @return the create animal form
     */
    @GetMapping("/createForm")
    public String showCreateForm() {
        return "animal-create";
    }

    /**
     * Creates a new Animal object
     *
     * @param animal is the new Animal object
     * @return a list of all Animals
     */
    @PostMapping("/new")
    public String addNewAnimal(Animal animal) {
        service.addNewAnimal(animal);
        return "redirect:/animals/all";
    }

    /**
     * Gets the update form for an animal
     *
     * @return the update form
     */
    @GetMapping("/update/{animalID}")
    public String showUpdateForm(@PathVariable int animalID, Model model) {
        model.addAttribute("animal", service.getAnimalByID(animalID));
        return "animal-update";
    }

    /**
     * Updates an existing Animal object
     *
     * @param animal is the Animal object
     * @return the updated Animal object
     */
    @PostMapping("/update")
    public String updateAnimal(Animal animal) {
        service.addNewAnimal(animal);
        return "redirect:/animals/" + animal.getAnimalID();
    }

    /**
     * Deletes an Animal object
     *
     * @param animalID is the Animal's unique ID
     * @return the updated list of Animals
     */
    @GetMapping("/delete/{animalID}")
    public String deleteAnimalByID(@PathVariable int animalID){
        service.deleteAnimalByID(animalID);
        return "redirect:/animals/all";
    }

}
