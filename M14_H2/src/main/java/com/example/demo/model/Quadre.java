package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the quadres database table.
 * 
 */
@Entity
@Table(name="quadres")
@NamedQuery(name="Quadre.findAll", query="SELECT q FROM Quadre q")
public class Quadre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_entrada")
	private Date dataEntrada;

	private String nom;

	private double preu;

	//bi-directional many-to-one association to Botiga
	@ManyToOne
	@JoinColumn(name="id_botiga")
	private Botiga botiga;

	public Quadre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataEntrada() {
		return this.dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPreu() {
		return this.preu;
	}

	public void setPreu(double preu) {
		this.preu = preu;
	}

	public Botiga getBotiga() {
		return this.botiga;
	}

	public void setBotiga(Botiga botiga) {
		this.botiga = botiga;
	}

}