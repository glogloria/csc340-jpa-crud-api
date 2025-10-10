package com.example.demo;

import java.io.IOException;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;

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
        hamsterRepository.deleteById(hamsterId);
    }

    /**
   * Method to write a hamster object to a JSON file
   *
   * @param hamster The hamster object to write
   */
    public String writeJson(Hamster hamster) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
        objectMapper.writeValue(new File("students.json"), hamster);
        return "Student written to JSON file successfully";
        } catch (IOException e) {
        e.printStackTrace();
        return "Error writing student to JSON file";
        }

    }

    /**
     * Method to read a hamster object from a JSON file
     *
     * @return The hamster object read from the JSON file
     */
    public Object readJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
        return objectMapper.readValue(new File("students.json"), Hamster.class);
        } catch (IOException e) {
        e.printStackTrace();
        return null;
        }
    }
}