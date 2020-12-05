package com.example.demo.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Client;
import com.example.demo.repositories.CategoriRepository;

@CrossOrigin("*")
@RestController
public class CategorieRestService {
	@Autowired
	private CategoriRepository rep;
	
	@GetMapping(value="/categorie/all")
	private List<Categorie> listModel(){
		return rep.findAll();
	}
	@GetMapping(value="/categorie/{id}")
	private Categorie listModel(@PathVariable(name="id") Long id){
		return rep.findById(id).get();
	}
	@PutMapping(value="/categorie/update/{id}")
	private Categorie update(@PathVariable(name="id") Long id,@RequestBody Categorie c) {
		c.setId(id);
		return rep.save(c);
	}
	@PostMapping(value="/categorie/add")
	private Categorie save(@RequestBody Categorie c) {
		return rep.save(c);
	}
	@DeleteMapping(value="/categorie/delete/{id}")
	private void delete(@PathVariable(name="id") Long id) {
		rep.deleteById(id);
	}

}
