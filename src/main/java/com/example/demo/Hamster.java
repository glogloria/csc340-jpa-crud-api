package com.example.demo;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "hamsters")
public class Hamster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hamsterId;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String description;

    private String breed;

    private double age;

    public Hamster(){
    }

    public Hamster(Long hamsterId, String name, String description, String breed, double age) {
        this.hamsterId = hamsterId;
        this.name = name;
        this.description = description;
        this.breed = breed;
        this.age = age;
    }

    public void setHamsterId(Long hamsterId) {
        this.hamsterId = hamsterId;
    }

    public Long getHamsterId() {
        return hamsterId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getAge() {
        return age;
    }

}