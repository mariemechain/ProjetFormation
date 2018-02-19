package fr.formation.disponibilite.model;

import java.util.Date;

public class Disponibilite {

	private Date date;
	private Double etatSalle;
	private Double etatOrdi;
	private Double etatVideoProj;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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
