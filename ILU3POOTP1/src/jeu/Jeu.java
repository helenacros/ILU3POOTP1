package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import carte.Cartes;
import carte.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	
	private Sabot sabot;
	private List<Joueur> joueurs= new ArrayList<>();
	private static final int NBCARTES = 6;
	private Iterator<Joueur> itJoueur;
	
	public Jeu(Sabot sabot) {
		JeuDeCartes jeuDeCarte= new JeuDeCartes();
		Cartes[] tabCartes= jeuDeCarte.donnerCartes();
		
		List<Cartes> listeCartes= new ArrayList<>();
		Collections.addAll(listeCartes,tabCartes);
		
		listeCartes=GestionCartes.melanger(listeCartes);
		
		this.sabot = new Sabot(listeCartes.toArray(new Cartes[0]));
		
	}

	public void inscrire(Joueur... nouveauxJoueurs) {
		for(int i=0 ; i<nouveauxJoueurs.length; i++) {
			joueurs.add(nouveauxJoueurs[i]);
		}
	}
	
	public void distribuerCartes() {
		for (int i=0 ; i<NBCARTES ; i++) {
			for (int j=0 ; j< joueurs.size(); j++) {
				Joueur joueurCourant = joueurs.get(j);
				Cartes carte= sabot.piocher();
				joueurCourant.getMain().prendre(carte);
			}
		}
	}
	
	public String jouerTour(Joueur joueur) {
		Cartes cartePiochee=joueur.prendreCarte(this.sabot);
		
		Set<Joueur> participants = new HashSet<>(this.joueurs);
		Coup coupChoisi= joueur.choisirCoup(participants);
		
		joueur.retirerDeLaMain(coupChoisi.getCarteJouee());
		
		if(coupChoisi.getJoueurCible() == null) {
			sabot.ajouterCarte(coupChoisi.getCarteJouee());
		}
		else {
			coupChoisi.getJoueurCible().deposer(coupChoisi.getCarteJouee());
		}
		
		StringBuilder chaine = new StringBuilder();
		chaine.append("Le joueur ").append(joueur.getNom()).append(" a pioché ").append(cartePiochee).append("\n");
		chaine.append("\n");
		chaine.append(joueur.getNom()).append(" ").append(coupChoisi.toString());
		chaine.append("\n");
		return chaine.toString();
	}
	
	public Joueur donnerJoueurSuivant() {
		if(itJoueur== null || !itJoueur.hasNext()) {
			itJoueur=joueurs.iterator();
		}
		return itJoueur.next();
	}
	
	public String lancer() {
		StringBuilder chaine= new StringBuilder();
		boolean gagne=false;
		
		while(!sabot.estVide() && !gagne) {
			Joueur courant= donnerJoueurSuivant();
			chaine.append(jouerTour(courant));
			
			if(courant.donnerKmParcourus() >=1000) {
				gagne=true;
				chaine.append("Victoire de ").append(courant.getNom()).append("\n");
						
			}
			chaine.append(courant.afficherEtatJoueur());
			chaine.append(courant.donnerKmParcourus());
			
		}
		
		if(!gagne && sabot.estVide()) {
			chaine.append("Fin de la partie, le sabot est vide, personne n'a atteint les 1000 km");
			
		}
		chaine.append("Voici le classement final ").append(classement()).append("\n");
		
		
		
		return chaine.toString();
	}
	

		
	
	public List<Joueur> classement(){
		Comparator<Joueur> comparateur = new Comparator<Joueur>() {
			@Override
			public int compare(Joueur j1, Joueur j2) {
				int km1=j1.donnerKmParcourus();
				int km2=j2.donnerKmParcourus();
				
				if (km1!=km2) {
					return Integer.compare(km2, km1);
				}
				return j2.getNom().compareTo(j1.getNom());
			}
			
			
		};
		TreeSet<Joueur> classement = new TreeSet<>(comparateur);
		classement.addAll(joueurs);
		return new ArrayList<>(classement);
		
	
	}
	
	
	
	
}
