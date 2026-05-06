package strategies;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import carte.Attaque;
import carte.Cartes;

import jeu.Coup;
import jeu.Joueur;
import carte.Botte; 
import carte.Type;

public interface Presse extends Strategie, Priorite {
	@Override
	default TreeSet<Coup> trierCoups(Set<Coup> coups){
		Comparator<Coup> compPresse=new Comparator<Coup>(){
			@Override
			public int compare(Coup c1, Coup c2) {
				int ordreNat=c1.compareTo(c2);
				if(ordreNat != 0) {// sont pas egaux
					return ordreNat;
				}
				return comparerCartes(c1.getJoueurCourant(),c1.getCarteJouee(),c2.getCarteJouee());
			}
		};
		
		TreeSet<Coup> coupsTries=new TreeSet <>(compPresse);
		coupsTries.addAll(coups);
		return coupsTries;
	}
	
	

	private int comparerCartes(Joueur joueur, Cartes carte1, Cartes carte2) {
		Integer comparaison = null;
		comparaison = donnerPrioriteLimites(carte1, carte2);
		if(comparaison != null) {
			return comparaison;
		}
		comparaison = donnerPrioriteBornes(carte1, carte2);
	
		if(comparaison != null) {
			return comparaison;
		}
		Cartes carteSommet = joueur.donnerSommetPile();
		if(carteSommet instanceof Attaque attaque) {
			Type typeProbleme = attaque.getType();
			if(joueur.donnerBottes().contains(new Botte(typeProbleme))) {
				typeProbleme = Type.FEU;
			}
			comparaison = donnerPrioriteBottes(typeProbleme, carte1, carte2);
			if(comparaison != null) {
				return comparaison;
			}
		}
		comparaison = donnerPrioriteParades(carte1, carte2);
		if(comparaison != null) {
			return comparaison;
		}
		if (random.nextBoolean()) {
			return 1;
		} else {
			return -1;
		}
	}
		

	
	
	
	
	
	
	
	
	
	
}
