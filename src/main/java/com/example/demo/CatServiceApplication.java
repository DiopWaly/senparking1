package com.example.demo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.imageio.ImageIO;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.entities.Annee;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Client;
import com.example.demo.entities.Marque;
import com.example.demo.entities.Modele;
import com.example.demo.entities.Voiture;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.ModelRepository;

@SpringBootApplication
public class CatServiceApplication implements CommandLineRunner {
	@Autowired
	private RepositoryRestConfiguration restconfiguration;
	@Autowired
	private ModelRepository rep;
	public static void main(String[] args) {
		
		SpringApplication.run(CatServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restconfiguration.exposeIdsFor(Modele.class,Marque.class,Categorie.class,
					Client.class,Annee.class);
		for(Modele m : rep.findAll()) {
			System.out.println(m.toString());
		}
	}

}
