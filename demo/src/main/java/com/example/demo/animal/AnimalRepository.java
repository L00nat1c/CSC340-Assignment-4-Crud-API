package com.example.demo.animal;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> getAnimalByHabitat(String habitat);

    List<Animal> getAnimalBySpecies(String species);

    @Query(value = "select * from animals where name like %?%", nativeQuery = true)
    List<Animal> getAnimalByName(String name);

}
