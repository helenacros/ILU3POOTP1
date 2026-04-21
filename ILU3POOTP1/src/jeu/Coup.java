package jeu;

import carte.Attaque;
import carte.Cartes;
import carte.DebutLimite;
import carte.FinLimite;
import carte.Limite;

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
	    if (joueurCible == null) return true;

	    if (!joueurCible.estDepotAutorise(carteJouee)) return false;

	    if (carteJouee instanceof Attaque || carteJouee instanceof Limite) {
	        return !joueurCourant.equals(joueurCible);
	    } else {
	        return joueurCourant.equals(joueurCible);
	    }
	}

	@Override
	public boolean equals(Object obj) {
	    if (obj instanceof Coup coup) {
	        return joueurCourant.equals(coup.joueurCourant) &&
	               carteJouee.equals(coup.carteJouee) &&
	               (this.joueurCible == coup.joueurCible 
	               			|| (this.joueurCible != null && this.joueurCible.equals(coup.joueurCible)));
	    }
	    return false;
	}

	@Override
	public int hashCode() {
	    int resultat = 31; 
	    
	    //multiplie et on ajoute le hashCode de chaque champ
	   // va creer un code unique 
	    resultat = 31 * resultat + joueurCourant.hashCode();
	    resultat = 31 * resultat + carteJouee.hashCode();
	    if (joueurCible != null) {
	        resultat = 31 * resultat + joueurCible.hashCode();
	    } else {
	        resultat = 31 * resultat + 0;
	    }
	    
	    return resultat;
	}

	@Override
	public String toString() {
		if(joueurCible == null) {
			return "defausse de la carte" +carteJouee.toString();
		}
		else {
			return "depose de la carte " + carteJouee.toString() +
					"dans la zone de jeu "+ joueurCible.getNom();
		}
	}
	
	
	
}
