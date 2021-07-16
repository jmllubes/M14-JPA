package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the botiga database table.
 * 
 */
@Entity
@NamedQuery(name="Botiga.findAll", query="SELECT b FROM Botiga b")
public class Botiga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int capacitat;

	private String nom;

	//bi-directional many-to-one association to Quadre
	@OneToMany(mappedBy="botiga")
	private List<Quadre> quadres;

	public Botiga() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacitat() {
		return this.capacitat;
	}

	public void setCapacitat(int capacitat) {
		this.capacitat = capacitat;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Quadre> getQuadres() {
		return this.quadres;
	}

	public void setQuadres(List<Quadre> quadres) {
		this.quadres = quadres;
	}

	public Quadre addQuadre(Quadre quadre) {
		getQuadres().add(quadre);
		quadre.setBotiga(this);

		return quadre;
	}

	public Quadre removeQuadre(Quadre quadre) {
		getQuadres().remove(quadre);
		quadre.setBotiga(null);

		return quadre;
	}

}