package com.example.demo.entities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.springframework.lang.NonNull;

import lombok.Data;

@Entity
public class Client implements Serializable {

	public Client() {
		
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false, length = 50)
	private String nom;
	@Column(nullable = false, length = 50)
	private String prenom;
	@Column(nullable = false, length = 5)
	private String civilite;
	private Date dateNaissance;
	@Column(length = 50)
	private String lieuNaissance;
	@Column(unique = true, nullable = true, length = 50)
	private String email;
	@Column(unique = true, nullable = false, length = 50)
	private String tel;
	private String userName;
	@Column(nullable = false)
	private String password;
	@Column(unique = true, nullable = true, length = 50)
	private String numPermis;
	private String adresse;
	private String profil;
	
//	@OneToMany(mappedBy = "client",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
////	@JoinColumn
//	private Collection<Reservation> reservation = new ArrayList<>();
	
//	public Collection<Reservation> getReservation() {
//		return reservation;
//	}
//
//	public void setReservation(Collection<Reservation> reservation) {
//		this.reservation = reservation;
//	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public Long getId() {
		return id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNumPermis() {
		return numPermis;
	}

	public void setNumPermis(String numpermis) {
		this.numPermis = numpermis;
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
