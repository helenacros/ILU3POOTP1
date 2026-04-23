package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import carte.Bataille;
import carte.Borne;
import carte.Cartes;
import carte.Limite;
import strategies.Strategie;

public class Joueur {

	private String nom;
	private ZoneDeJeu zoneDeJeu;
	private MainJoueur mainJoueur;
	private Strategie strategie= new Strategie() {
		
			};
	
	
	public Joueur(String nom, ZoneDeJeu zoneDeJeu, MainJoueur mainJoueur) {
		this.nom = nom;
		this.zoneDeJeu = zoneDeJeu;
		this.mainJoueur = mainJoueur;
	}

	public String getNom() {
		return nom;
	}
	
	public void setStrategie(Strategie strategie) {
        this.strategie = strategie;
    }


	@Override 
	public boolean equals(Object obj) {
	    if (obj instanceof Joueur joueur) {
	        return nom.equals(joueur.getNom()); 
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
	
	public Cartes prendreCarte(Sabot sabot) {
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
	
	
	public Set<Coup> coupsPossibles(Set<Joueur> participants){
		Set<Coup> coupValides= new HashSet<>();
		Iterator<Joueur> itJ = participants.iterator();
		
		while (itJ.hasNext()) {
			Joueur cible = itJ.next();
	
			for (int i=0 ; i<mainJoueur.getNbCartes() ; i++) {
				Cartes carte = mainJoueur.getCarte(i);
				Coup couptest = new Coup (this, carte, cible);
				if(couptest.estValide()) {
					coupValides.add(couptest);
				}
			}
		}
		
		return coupValides;
	}
	
	
	public Set<Coup> coupsDefausse() {
		Set<Coup> defausse = new HashSet<>();
		for(int i=0 ; i <mainJoueur.getNbCartes() ; i++) {
			defausse.add(new Coup (this, mainJoueur.getCarte(i), null));
		}
		return defausse;
	}
	
	public void retirerDeLaMain ( Cartes carte) {
		mainJoueur.jouer(carte);
	}
	
	private Coup choisirCoupRandom(Set<Coup> coups) {
	    List<Coup> liste = new ArrayList<>(coups);
	    Random random = new Random();
	    int indexAleatoire = random.nextInt(liste.size());
	    return liste.get(indexAleatoire);
	}
	
	
	public Coup choisirCoup (Set <Joueur> participants) {
		Set<Coup> possibles = coupsPossibles(participants);
		if(!possibles.isEmpty()) {
			return strategie.selectionnerCoup(possibles);
		}
		else return strategie.selectionnerDefausse(coupsDefausse());
	}
	
	public String afficherEtatJoueur() {
		StringBuilder chaine= new StringBuilder();
		chaine.append("Etat de ").append(nom).append(":\n");
		chaine.append("- Bottes : ").append(zoneDeJeu.getBottes()).append("\n");
		chaine.append("- Limitation : ").append(zoneDeJeu.presenceLimitation()).append("\n");;
		chaine.append("- Somme bataille : ").append(zoneDeJeu.getSommeBataille()).append("\n");
		chaine.append("- Main : ").append(mainJoueur.toString()).append("\n");
		return chaine.toString();
	
	}
	
}
