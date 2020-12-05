package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public class Chauffeur implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public void setId(Long id) {
		this.id = id;
	}
	@Column(unique = true, nullable = false, length = 50)
	private String numpermis;
	
	public Chauffeur(String numpermis) {
		super();
		this.numpermis = numpermis;
	}
	@Column(nullable = false, length = 50)
	private String nom;
	@Column(nullable = false, length = 50)
	private String prenom;
	@Column(nullable = false, length = 5)
	private String civilite;
	private Date dateNais;
	@Column(length = 50)
	private String lieuNais;
	@Column(unique = true, nullable = true, length = 50)
	private String mail;
	@Column(unique = true, nullable = false, length = 50)
	private String tel;
	@Column(nullable = false)
	private boolean dispo;
	

	public Long getId() {
		return id;
	}

	public boolean isDispo() {
		return dispo;
	}

	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public Date getDateNais() {
		return dateNais;
	}

	public void setDateNais(Date dateNais) {
		this.dateNais = dateNais;
	}

	public String getLieuNais() {
		return lieuNais;
	}

	public void setLieuNais(String lieuNais) {
		this.lieuNais = lieuNais;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getNumpermis() {
		return numpermis;
	}

	public void setNumpermis(String numpermis) {
		this.numpermis = numpermis;
	}

	public Chauffeur() {
		// TODO Auto-generated constructor stub
	}

}
