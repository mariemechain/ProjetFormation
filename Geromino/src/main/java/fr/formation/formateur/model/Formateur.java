package fr.formation.formateur.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Formateur {
	private String titre;
	private double patience;
	private List<Date> disponibilite;
	private HashMap<String, Niveau> expertise;
}
