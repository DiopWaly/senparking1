package com.example.demo.restservice;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Client;
import com.example.demo.repositories.ClientRepository;

@CrossOrigin("*")
@RestController
public class ClientRestService {
	@Autowired
	private ClientRepository rep;
	
	@GetMapping(value="/client/all")
	private List<Client> listModel(){
		return rep.findAll();
	}
	@GetMapping(value="/client/{id}")
	private Client listModel(@PathVariable(name="id") Long id){
		return rep.findById(id).get();
	}
	@PutMapping(value="/client/update/{id}")
	private Client update(@PathVariable(name="id") Long id,@RequestBody Client c) {
		c.setId(id);
		return rep.save(c);
	}
	@PostMapping(value="/client/add")
	private Client save(@RequestBody Client c) {
		hashagepw(c);
		return rep.save(c);
	}
	@DeleteMapping(value="/client/delete/{id}")
	private void delete(@PathVariable(name="id") Long id) {
		rep.deleteById(id);
	}
	@PatchMapping(value="/client/login")
	private Client login(@RequestBody Client c) {
		hashagepw(c);
		if(rep.findByEmailAndPassword(c.getEmail(),c.getPassword()) != null)
			return rep.findByEmailAndPassword(c.getEmail(),c.getPassword());
		else if(rep.findByTelAndPassword(c.getEmail(),c.getPassword()) != null)
			return rep.findByTelAndPassword(c.getEmail(),c.getPassword());
		else
			return rep.findByUserNameAndPassword(c.getEmail(),c.getPassword());
	}
	public void sauverImage(BufferedImage image, String nomImage) throws IOException {
		 File nomfichier = new File("profile/"+nomImage+".jpg");
		 ImageIO.write(image, "JPG", nomfichier);
	 }
	private void hashagepw(Client c){
		String password = c.getPassword();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(password.getBytes());
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff)+0x100, 16).substring(1));
			}
			c.setPassword(sb.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
