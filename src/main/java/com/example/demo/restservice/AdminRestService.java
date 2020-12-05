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

import com.example.demo.entities.Admin;
import com.example.demo.repositories.AdminRepository;

@CrossOrigin("*")
@RestController
public class AdminRestService {
	@Autowired
	private AdminRepository rep;
	
	@GetMapping(value="/admin/all")
	private List<Admin> listModel(){
		return rep.findAll();
	}
	@GetMapping(value="/admin/{id}")
	private Admin listModel(@PathVariable(name="id") Long id){
		return rep.findById(id).get();
	}
	@PutMapping(value="/admin/update/{id}")
	private Admin update(@PathVariable(name="id") Long id,@RequestBody Admin a) {
		a.setId(id);
		return rep.save(a);
	}
	@PostMapping(value="/admin/add")
	private Admin save(@RequestBody Admin a) {
		return rep.save(a);
	}
	@DeleteMapping(value="/admin/delete/{id}")
	private void delete(@PathVariable(name="id") Long id) {
		rep.deleteById(id);
	}

}
