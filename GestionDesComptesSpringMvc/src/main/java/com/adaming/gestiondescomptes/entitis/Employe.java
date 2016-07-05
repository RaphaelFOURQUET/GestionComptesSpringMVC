package com.adaming.gestiondescomptes.entitis;


import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jdk.nashorn.internal.objects.annotations.Setter;

@Entity
@Table(name="tbEmploye")
public class Employe {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeEmploye;
    @NotEmpty(message = "Merci de renseigner le nom de l'employe")
	private String nomEmploye;
	@ManyToMany
	@JoinTable(name="Empl_Groupe",
	joinColumns = @JoinColumn(name="IDEMP"),
	inverseJoinColumns = @JoinColumn(name="IDGRP"))
	private Collection<Groupe> groupes ;
	
	@JsonIgnore
	public Collection<Groupe> getGroupes() {
		return groupes;
	}
	@Setter
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
	public Long getCodeEmploye() {
		return codeEmploye;
	}
	public void setCodeEmploye(Long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}
	
	public String getNomEmploye() {
		return nomEmploye;
	}
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	public Employe() {
	}
	public Employe(String nomEmploye) {
		super();
		this.nomEmploye = nomEmploye;
	}

	
}
