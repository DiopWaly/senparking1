package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Chauffeur;

@CrossOrigin("*")
@RepositoryRestResource
public interface ChauffeurRepository extends JpaRepository<Chauffeur, Long> {

}
