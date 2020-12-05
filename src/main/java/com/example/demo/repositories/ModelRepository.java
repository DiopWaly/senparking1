package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Modele;

@CrossOrigin("*")
@RepositoryRestResource
public interface ModelRepository extends JpaRepository<Modele, Long> {
	//modeles/search/byLibelle?mc=a
	
	@RestResource(path = "/byLibelle")
	public List<Modele> findByLibelleContains(@Param("mc") String lib);
	//modeles/search/byLibellePage?mc=i&pange=0&size=2 pagination
	@RestResource(path = "/byLibellePage ")
	public List<Modele> findByLibelleContains(@Param	("mc") String lib, Pageable page);

}
