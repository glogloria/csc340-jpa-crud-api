
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HamsterController {

    @Autowired
    private HamsterService hamsterService;

    /**
    * Endpoint to get all hamsters
    * 
    * @return List of all hamsters
    */
    @GetMapping("/hamsters")
    public Object getAllHamsters() {
        return hamsterService.getAllHamsters();
    }

    /**
    *Endpoint to get a hamster by ID
    *
    * @param id The ID of the hamster to retrieve
    * @return The hamster with the specified ID
    */
    @GetMapping("/hamsters/{id}")
    public Hamster getHamsterByID(@PathVariable long id) {
        return hamsterService.getHamsterByID(id);
    }

    /**
    * Endpoint to get hamsters by name
    *
    * @param name The name of the hamster to search for
    * @return List of hamsters with the specified name
    */
    @GetMapping("/hamsters/name")
    public Object getHamstersByName(@RequestParam String key) {
        if (key != null) {
            return hamsterService.getHamstersByName(key);
        } else {
            return hamsterService.getAllHamsters();
        }
    }

    /**
     * Endpoint to get hamsters with age above one
     *
     * @param age The age threshold for hamsters
     * @return List of hamsters of the specified age
     */
    @GetMapping("/hamsters/older")
    public Object getHamstersByAge(@RequestParam(name = "age", defaultValue = "1.0") double age) {
        return new ResponseEntity<>(hamsterService.getHamstersByAge(age), HttpStatus.OK);

    }
    /**
     * Endpoint to add a new hamster
     *
     * @param hamster The hamster to add
     * @return List of all hamsters
     */
    @PostMapping("/hamsters")
    public Object addStudent(@RequestBody Hamster hamster) {
        return hamsterService.addHamster(hamster);
    }

    /**
     * Endpoint to update a hamster
     *
     * @param id      The ID of the hamster to update
     * @param hamster The updated hamster information
     * @return The updated hamster
     */
    @PutMapping("/hamsters/{id}")
    public Hamster updateHamster(@PathVariable Long id, @RequestBody Hamster hamster) {
        hamsterService.updateHamster(id, hamster);
        return hamsterService.getHamsterByID(id);
    }

    /**
     * Endpoint to delete a hamster
     *
     * @param id The ID of the hamster to delete
     * @return List of all hamsters
     */
    @DeleteMapping("/hamsters/{id}")
    public Object deleteHamster(@PathVariable Long id) {
        hamsterService.deleteHamster(id);
        List<Hamster> remainingHamsters = hamsterService.getAllHamsters();
        return ResponseEntity.ok(remainingHamsters);
    }

    /**
     * Endpoint to write a hamster to a JSON file
     *
     * @param hamster The hamster to write
     * @return An empty string indicating success
     */
    @PostMapping("/hamsters/writeFile")
    public Object writeJson(@RequestBody Hamster hamster) {
        return hamsterService.writeJson(hamster);
    }

    /**
     * Endpoint to read a JSON file and return its contents
     *
     * @return The contents of the JSON file
     */
    @GetMapping("/hamsters/readFile")
    public Object readJson() {
        return hamsterService.readJson();

    }

}