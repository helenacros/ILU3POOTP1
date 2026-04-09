package jeu;

import carte.Attaque;
import carte.Cartes;
import carte.DebutLimite;
import carte.FinLimite;

public class Coup {
	private Joueur joueurCourant;
	private Cartes carteJouee;
	private Joueur joueurCible;
	
	public Coup(Joueur joueurCourant, Cartes carteJouee, Joueur joueurCible) {
		super();
		this.joueurCourant = joueurCourant;
		this.carteJouee = carteJouee;
		this.joueurCible = joueurCible;
	}

	public Joueur getJoueurCourant() {
		return joueurCourant;
	}

	public Cartes getCarteJouee() {
		return carteJouee;
	}

	public Joueur getJoueurCible() {
		return joueurCible;
	}
	
	public boolean estValide() {
		if( joueurCible!=null && joueurCible.estDepotAutorise(carteJouee)) {
			if((carteJouee instanceof DebutLimite) ||(carteJouee instanceof Attaque) ) {
				return !(joueurCourant.equals(joueurCible));
			}
			else {
				return joueurCourant.equals(joueurCible);
			}
		}
		return joueurCible==null;
	}
	
	
	
}
