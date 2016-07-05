package com.adaming.gestiondescomptes.entitis;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jdk.nashorn.internal.objects.annotations.Setter;
@Entity
@Table(name="tbGroupe")
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGroupe;
	private String nomGroupe;
	@ManyToMany(mappedBy="groupes")
	private Collection<Employe> employes;

	@JsonIgnore
	public Collection<Employe> getEmployes() {
		return employes;
	}

	@Setter
	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}

	public Long getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(Long idGroupe) {
		this.idGroupe = idGroupe;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public Groupe() {
	}

	public Groupe(String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
	}
	
}
