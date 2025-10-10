package com.example.demo;

import java.io.IOException;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class HamsterService {

    @Autowired
    private HamsterRepository hamsterRepository;

    /**
    * Method to get all hamsters
    * @return list of all hamsters
    */
    public Object getAllHamsters() {
        return hamsterRepository;
    }

    /**
    * Method to get a hamster by ID
    * @param hamsterID: the ID of the hamster to retrieve
    * @return The hamster with the matching ID
    */
    public Hamster getHamsterByID(@PathVariable long hamsterID) {
        return hamsterRepository.findById(hamsterID).orElse(null);
    }

    /**
    * Method to get hamsters by name
    * @param name: the name of the hamster
    * @return The list of hamsters with the matching name
    */
    public Object getHamstersByName(String name) {
        return hamsterRepository.getHamstersByName(name);
    }

    /**
    * Method to get older hamsters (above the age of one)
    * param age
    * @return the list of af hamsters matching the age criteria
    */
    public Object getHamstersByAge(double age) {
        return hamsterRepository.getHamstersByAge(age);
    }

    /**
    * Method to add a new hamster
    * @param hamster: the hamster to add
    */
    public Hamster addHamster(Hamster hamster) {
        return hamsterRepository.save(hamster);
    }

    /**
    *Method to update a hamster
    *param hamsterID: The ID of the hamster to update
    *param hamster: The hamster to update
    */
    public Hamster updateHamster(Long hamsterId, Hamster hamster) {
        return hamsterRepository.save(hamster);
    }

    /**
    * Method to delete a hamster
    * @param hamsterID The ID of the hamster to delete
    */
    public void deleteHamster (Long hamsterId) {
        return hamsterRepository.deleteById(hamsterId);
    }

}