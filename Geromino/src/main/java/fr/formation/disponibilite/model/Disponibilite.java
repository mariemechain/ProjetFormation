package fr.formation.disponibilite.model;

import java.time.LocalDate;

public class Disponibilite {
	
	private int id;
	private LocalDate date;
	private Double etatSalle;
	private Double etatOrdi;
	private Double etatVideoProj;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Double getEtatSalle() {
		return etatSalle;
	}
	public void setEtatSalle(Double etatSalle) {
		this.etatSalle = etatSalle;
	}
	public Double getEtatOrdi() {
		return etatOrdi;
	}
	public void setEtatOrdi(Double etatOrdi) {
		this.etatOrdi = etatOrdi;
	}
	public Double getEtatVideoProj() {
		return etatVideoProj;
	}
	public void setEtatVideoProj(Double etatVideoProj) {
		this.etatVideoProj = etatVideoProj;
	}
	
}
