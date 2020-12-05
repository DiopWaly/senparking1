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

import com.example.demo.entities.Modele;
import com.example.demo.repositories.AnneeRepository;
import com.example.demo.repositories.CategoriRepository;
import com.example.demo.repositories.MarqueRepository;
import com.example.demo.repositories.ModelRepository;

@CrossOrigin("*")
@RestController
public class ModeleRestService {
	@Autowired
	private ModelRepository rep;
	@Autowired
	private AnneeRepository repA;
	@Autowired
	private MarqueRepository repM;
	@Autowired
	private CategoriRepository repC;
	
	@GetMapping(value="/modele/all")
	private List<Modele>listModel(){
		return rep.findAll();
	}
	@GetMapping(value="/modele/{id}")
	private Modele listModel(@PathVariable(name="id") Long id){
		return rep.findById(id).get();
	}
	@PutMapping(value="/modele/update/{id}")
	private Modele update(@PathVariable(name="id") Long id,@RequestBody Modele m) {
		//m.setId(id);
		return rep.save(m);
	}
	@PostMapping(value="modele/add")
	private Modele save(@RequestBody Modele m) {
		return rep.save(m);
	}
	@DeleteMapping(value="/modele/delete/{id}")
	private void delete(@PathVariable(name="id") Long id) {
		rep.deleteById(id);
	}
	
}
