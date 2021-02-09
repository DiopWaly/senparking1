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

import com.example.demo.entities.Client;
import com.example.demo.entities.Reservation;
import com.example.demo.repositories.ChauffeurRepository;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.ReservationRepository;
import com.example.demo.repositories.VoitureRepository;

@CrossOrigin("*")
@RestController
public class ReservationRestService {
	@Autowired
	private ReservationRepository rep;
	@Autowired
	private ClientRepository repC;
	@Autowired
	private VoitureRepository repV;
	@Autowired
	private ChauffeurRepository repCh;
	
	@GetMapping(value="/reservation/all")
	private List<Reservation> listModel(){
		return rep.findAll();
	}
	@GetMapping(value="/reservation/{id}")
	private Reservation listModel(@PathVariable(name="id") Long id){
		return rep.findById(id).get();
	}
	@PutMapping(value="/reservation/update/{id}")
	private Reservation update(@PathVariable(name="id") Long id,@RequestBody Reservation r) {
		r.setId(id);
		return rep.save(r);
	}
	@PostMapping(value="/reservation/add")
	private Reservation save(@RequestBody Reservation r) {
		r.setClient(repC.findById((Long)r.getCli()).get());
		r.setChauffeur(repCh.findById((Long)r.getV()).get());
		r.setVoiture(repV.findById((Long)r.getV()).get());
		System.out.println(r.toString());
		return rep.save(r);
	}
	@DeleteMapping(value="/reservation/delete/{id}")
	private void delete(@PathVariable(name="id") Long id) {
		rep.deleteById(id);
	}

}
