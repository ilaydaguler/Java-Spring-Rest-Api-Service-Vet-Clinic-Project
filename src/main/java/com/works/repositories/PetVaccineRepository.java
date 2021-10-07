package com.works.repositories;


import com.works.entities.PetVaccine;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PetVaccineRepository extends JpaRepository<PetVaccine,Integer> {

}
