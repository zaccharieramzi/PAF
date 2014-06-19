package Requeteetresultat;

public class Tableau extends FichePedagoquique {

		private String auteur;
		private String lieudeconservation;
		private String dimenssion;
		private String courantartistique;
		
	public Tableau (String auteur, String lieudeconservation, String dimenssion, String courantartistique){
		this.auteur=auteur;
		this.lieudeconservation=lieudeconservation;
		this.dimenssion=dimenssion;
		this.courantartistique=courantartistique;
	}
}
