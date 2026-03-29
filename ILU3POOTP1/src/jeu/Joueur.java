package jeu;

import java.util.Iterator;

import carte.Bataille;
import carte.Borne;
import carte.Cartes;
import carte.Limite;

public class Joueur {

	private String nom;
	private ZoneDeJeu zoneDeJeu;
	private MainJoueur mainJoueur;
	
	
	public Joueur(String nom, ZoneDeJeu zoneDeJeu, MainJoueur mainJoueur) {
		this.nom = nom;
		this.zoneDeJeu = zoneDeJeu;
		this.mainJoueur = mainJoueur;
	}

	public String getNom() {
		return nom;
	}


	@Override 
	public boolean equals(Object obj) {
		if( obj instanceof Joueur joueur) {
			return (obj != null) && (nom == joueur.getNom());
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Nom du joueur :" + nom + "";
	}

	public MainJoueur getMain() {
		return mainJoueur;
	}
	
	private void donner(Cartes carte){
		mainJoueur.prendre(carte);
	}
	
	private Cartes prendreCarte(Sabot sabot) {
		Cartes carte=sabot.piocher();
		donner(carte);
		return carte;
	}
	
	public int donnerKmParcourus() {
		return zoneDeJeu.donnerKmParcourus();
	}
	
	public void deposer(Cartes c) {
		 zoneDeJeu.deposer(c);
	}
	
	public boolean estDepotAutorise(Cartes carte){
		return zoneDeJeu.estDepotAutorise(carte);
	}
	
}
