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

import com.example.demo.entities.Annee;
import com.example.demo.repositories.AnneeRepository;

@CrossOrigin("*")
@RestController
public class AnneeRestService {
	@Autowired
	private AnneeRepository rep;
	
	@GetMapping(value="/annee/all")
	private List<Annee> listModel(){
		return rep.findAll();
	}
	@GetMapping(value="/annee/{id}")
	private Annee listModel(@PathVariable(name="id") Long id){
		return rep.findById(id).get();
	}
	@PutMapping(value="/annee/update/{id}")
	private Annee update(@PathVariable(name="id") Long id,@RequestBody Annee a) {
		a.setId(id);
		return rep.save(a);
	}
	@PostMapping(value="/marqu/adde")
	private Annee save(@RequestBody Annee a) {
		return rep.save(a);
	}
	@DeleteMapping(value="/annee/delete/{id}")
	private void delete(@PathVariable(name="id") Long id) {
		rep.deleteById(id);
	}
}
