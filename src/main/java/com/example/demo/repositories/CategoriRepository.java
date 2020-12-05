package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Categorie;

@CrossOrigin("*")
@RepositoryRestResource
public interface CategoriRepository extends JpaRepository<Categorie, Long> {

}
