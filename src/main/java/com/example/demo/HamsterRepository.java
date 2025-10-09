package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface  HamsterRepository extends JpaRepository<Hamster, Long> {

    List<Hamster> getHamstersByAge(double age);

    @Query(value= "select * from hamsters h where h.age >= 1", nativeQuery = true)
    List<Hamster> getOlderHamsters(double age);


}