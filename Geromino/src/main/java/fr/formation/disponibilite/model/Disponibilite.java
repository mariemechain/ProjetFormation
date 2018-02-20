package fr.formation.disponibilite.model;

import java.util.Date;

public class Disponibilite {
	
	private int id;
	private String date;
	private Double etatSalle;
	private Double etatOrdi;
	private Double etatVideoProj;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
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
