package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class HamsterService {

    @Autowired
    private HamsterRepository hamsterRepository;

    private static final String UPLOAD_DIR = "src/main/resources/static/hamster-images/";

    /**
    * Method to get all hamsters
    * @return list of all hamsters
    */
    public List<Hamster> getAllHamsters() {
        return hamsterRepository.findAll();
    }

    /**
    * Method to get a hamster by ID
    * @param hamsterID: the ID of the hamster to retrieve
    * @return The hamster with the matching ID
    */
    public Hamster getHamsterById(@PathVariable long hamsterID) {
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
    public Hamster addHamster(Hamster hamster, MultipartFile hamsterImage) {
        Hamster newHamster = hamsterRepository.save(hamster);
        String originalFileName = hamsterImage.getOriginalFilename();

        try {
            if (originalFileName != null & originalFileName.contains(".")) {
                String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
                String fileName = String.valueOf(newHamster.getHamsterId()) + "." + fileExtension;
                Path filePath = Paths.get(UPLOAD_DIR + fileName);

                InputStream inputStream = hamsterImage.getInputStream();

                Files.createDirectories(Paths.get(UPLOAD_DIR));
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                newHamster.setHamsterImagePath(fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hamsterRepository.save(newHamster);
    }

    /**
    *Method to update a hamster
    *param hamsterID: The ID of the hamster to update
    *param hamster: The hamster to update
    */
    public Hamster updateHamster(Long hamsterId, Hamster hamster, MultipartFile hamsterImage) {
        String originalFileName = hamsterImage.getOriginalFilename();

        try {
            if (originalFileName != null && originalFileName.contains(".")) {
                String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
                String fileName = String.valueOf(hamsterId) + "." + fileExtension;
                Path filePath = Paths.get(UPLOAD_DIR + fileName);

                InputStream inputStream = hamsterImage.getInputStream();

                Files.createDirectories(Paths.get(UPLOAD_DIR));
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                hamster.setHamsterImagePath(fileName);
            }
        }
    }

    /**
    * Method to delete a hamster
    * @param hamsterID The ID of the hamster to delete
    */
    public void deleteHamster (Long hamsterId) {
        hamsterRepository.deleteById(hamsterId);
    }
}