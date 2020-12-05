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

import com.example.demo.entities.Chauffeur;
import com.example.demo.repositories.ChauffeurRepository;

@CrossOrigin("*")
@RestController
public class ChauffeurRestService {
	@Autowired
	private ChauffeurRepository rep;
	
	@GetMapping(value="/chauffeur/all")
	private List<Chauffeur> listModel(){
		return rep.findAll();
	}
	@GetMapping(value="/chauffeur/{id}")
	private Chauffeur listModel(@PathVariable(name="id") Long id){
		return rep.findById(id).get();
	}
	@PutMapping(value="/chauffeur/update/{id}")
	private Chauffeur update(@PathVariable(name="id") Long id,@RequestBody Chauffeur c) {
		c.setId(id);
		return rep.save(c);
	}
	@PostMapping(value="/marqu/add")
	private Chauffeur save(@RequestBody Chauffeur c) {
		return rep.save(c);
	}
	@DeleteMapping(value="/chauffeur/delete/{id}")
	private void delete(@PathVariable(name="id") Long id) {
		rep.deleteById(id);
	}
}
