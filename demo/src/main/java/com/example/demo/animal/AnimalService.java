package com.example.demo.animal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;


    public List<Animal> getAllAnimals() {return animalRepository.findAll();}

    public Animal getAnimalByID(int animalID) {return animalRepository.findById(animalID).orElse(null);}

    public List<Animal> getAnimalByHabitat(String habitat) {return animalRepository.getAnimalByHabitat(habitat);}

    public List<Animal> getAnimalBySpecies(String species){return animalRepository.getAnimalBySpecies(species);}

    public List<Animal> getAnimalByName(String name) {return animalRepository.getAnimalByName(name);}

    public void addNewAnimal(Animal animal) {animalRepository.save(animal);}

    public void updateAnimal(int animalID, Animal animal) {
        Animal existing = getAnimalByID(animalID);
        existing.setName(animal.getName());
        existing.setScientificName(animal.getScientificName());
        existing.setSpecies(animal.getSpecies());
        existing.setHabitat(animal.getHabitat());
        existing.setDescription(animal.getDescription());

        animalRepository.save(existing);
    }

    public void deleteAnimalByID(int animalID) {
        animalRepository.deleteById(animalID);
    }
}
