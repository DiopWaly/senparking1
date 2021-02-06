package com.example.demo.restservice;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Voiture;
import com.example.demo.repositories.VoitureRepository;

@CrossOrigin("*")
@RestController
public class VoitureRestService {
	@Autowired
	private VoitureRepository rep;
	
	@GetMapping(value="/voiture/all")
	private List<Voiture> listModel(){
		return rep.findAll();
	}
//	@GetMapping(value="/voiture/trie")
//	private List<Voiture> trieModel(){
//		
//	}
	@GetMapping(value="/voiture/{id}")
	private Voiture listModel(@PathVariable(name="id") Long id){
		return rep.findById(id).get();
	}
	@PutMapping(value="/voiture/update/{id}")
	private Voiture update(@PathVariable(name="id") Long id,@RequestBody Voiture v) {
		v.setId(id);
		return rep.save(v);
	}
	@PostMapping(value="/voiture/add")
	private Voiture save(@RequestBody Voiture v) {
		return rep.save(v);
	}
	@DeleteMapping(value="/voiture/delete/{id}")
	private void delete(@PathVariable(name="id") Long id) {
		rep.deleteById(id);
	}

}
