package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Modele;
import com.example.demo.entities.Voiture;

@CrossOrigin("*")
@RepositoryRestResource
public interface VoitureRepository extends JpaRepository<Voiture, Long> {

}
