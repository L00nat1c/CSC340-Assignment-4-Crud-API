package com.example.demo.animal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    /**
     * Get a list of all Animals in the database
     * http://localhost:8080/animals/all
     *
     * @return a list of all Animal object
     */
    @GetMapping("/all")
    public List<Animal> getAllAnimals() {
        return service.getAllAnimals();
    }

    /**
     * Get a specific Animal by ID
     * http://localhost:8080/animals/8888
     *
     * @param animalID is the unique ID for the Animal
     * @return the Animal object with the correponding animalID
     */
    @GetMapping("/{animalID}")
    public Animal getOneAnimal(@PathVariable int animalID) {
        return service.getAnimalByID(animalID);
    }

    /**
     * Get a list of Animals that live in the specified habitat
     * http://localhost:8080/animals?habitat=savanna
     *
     * @param habitat is the animals' habitat
     * @return a list of Animals that live in the specified habitat
     */
    @GetMapping("")
    public List<Animal> getAnimalByHabitat(@RequestParam(name = "habitat", defaultValue = "desert") String habitat){
        return service.getAnimalByHabitat(habitat);
    }

    /**
     * Get a list of Animals of a certain species
     *http://localhost:8080/animals/species?species=Frog
     *
     * @param species is the species that the Animal is a part of
     * @return a list of Animals of a certain species
     */
    @GetMapping("/species")
    public List<Animal> getAnimalsBySpecies(@RequestParam(name = "species", defaultValue = "Lion") String species) {
        return service.getAnimalBySpecies(species);
    }

    /**
     * Get a list of Animals with a certain name
     * http://localhost:8080/animals/name?name=blue
     * http://localhost:8080/animals/name?name=l
     *
     * @param name is the name of the Animal
     * @return a list of Animals with a certain name
     */
    @GetMapping("/name")
    public List<Animal> getAnimalsByName(@RequestParam(name = "name", defaultValue = "Blue") String name) {
        return service.getAnimalByName(name);
    }

    /**
     * Creates a new Animal object
     * http://localhost:8080/animals/new --data
     * {
     *     "name": "TestName",
     *     "scientificName": "TestScienceName",
     *     "species": "TestSpecies",
     *     "habitat": "TestHabitat",
     *     "description": "TestDescription"
     * }
     *
     *
     * @param animal is the new Animal object
     * @return a list of all Animals
     */
    @PostMapping("/new")
    public List<Animal> addNewAnimal(@RequestBody Animal animal) {
        service.addNewAnimal(animal);
        return service.getAllAnimals();
    }

    /**
     * Updates an existing Animal object
     * http://localhost:8080/animals/update/8888 --data
     * {
     *     "name": "Asiatic Lion",
     *     "scientificName": "Panthera Leo",
     *     "species": "Lion",
     *     "habitat": "Savanna",
     *     "description": "Large, powerfully built cat. The second largest cat species."
     * }
     *
     * @param animalID is the Animal's unique ID
     * @param animal is the Animal object
     * @return the update Animal object
     */
    @PutMapping("/update/{animalID}")
    public Animal updateAnimal(@PathVariable int animalID, @RequestBody Animal animal) {
        service.updateAnimal(animalID, animal);
        return service.getAnimalByID(animalID);
    }

    /**
     * Deletes an Animal object
     * http://localhost:8080/animals/delete/8888
     *
     * @param animalID is the Animal's unique ID
     * @return the updated list of Animals
     */
    @DeleteMapping("/delete/{animalID}")
    public List<Animal> deleteAnimalByID(@PathVariable int animalID){
        service.deleteAnimalByID(animalID);
        return service.getAllAnimals();
    }


}
