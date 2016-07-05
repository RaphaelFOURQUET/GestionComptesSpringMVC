package com.adaming.gestiondescomptes.entitis;

import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jdk.nashorn.internal.objects.annotations.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@Table(name = "tbBanque")
public class Banque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBanque;
	private String nomAgence;
	private String adrrAgence;
	private String codePostale;
	
	@ManyToMany
	@JoinTable(name="BANQUE_COMPTES",
	joinColumns =
			@JoinColumn(name="IDBAQ"),
			inverseJoinColumns = @JoinColumn(name="IDCPT")
	)
	private Collection<Compte>  tabComptes  ;

	
	@JsonIgnore
	public Collection<Compte> getTabComptes() {
		return tabComptes;
	}
	@Setter
	public void setTabComptes(Collection<Compte> tabComptes) {
		this.tabComptes = tabComptes;
	}
	public Long getIdBanque() {
		return idBanque;
	}
	public void setIdBanque(Long idBanque) {
		this.idBanque = idBanque;
	}
	public String getNomAgence() {
		return nomAgence;
	}
	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}
	public String getAdrrAgence() {
		return adrrAgence;
	}
	public void setAdrrAgence(String adrrAgence) {
		this.adrrAgence = adrrAgence;
	}
	public String getCodePostale() {
		return codePostale;
	}
	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}
	public Banque() {
	}
	public Banque(String nomAgence, String adrrAgence, String codePostale) {
		super();
		this.nomAgence = nomAgence;
		this.adrrAgence = adrrAgence;
		this.codePostale = codePostale;
	}
	
}
