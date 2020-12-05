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

import com.example.demo.entities.Marque;
import com.example.demo.entities.Modele;
import com.example.demo.repositories.MarqueRepository;

@CrossOrigin("*")
@RestController
public class MarqueRestService {
	@Autowired
	private MarqueRepository rep;
	
	@GetMapping(value="/marque/all")
	private List<Marque> listModel(){
		return rep.findAll();
	}
	@GetMapping(value="/marque/{id}")
	private Marque listModel(@PathVariable(name="id") Long id){
		return rep.findById(id).get();
	}
	@PutMapping(value="/marque/update/{id}")
	private Marque update(@PathVariable(name="id") Long id,@RequestBody Marque m) {
		m.setId(id);
		return rep.save(m);
	}
	@PostMapping(value="/marque/add")
	private Marque save(@RequestBody Marque m) {
		return rep.save(m);
	}
	@DeleteMapping(value="/marque/delete/{id}")
	private void delete(@PathVariable(name="id") Long id) {
		rep.deleteById(id);
	}

}
