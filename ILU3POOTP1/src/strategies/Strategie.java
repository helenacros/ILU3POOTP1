package strategies;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import jeu.Coup;
import jeu.Joueur;

public interface Strategie {

	Random random= new Random();	
	
	default TreeSet<Coup> trierCoups(Set<Coup> coups) {
		Comparator<Coup> comparateurAleatoire = new Comparator<Coup>() {
			@Override
			public int compare(Coup c1, Coup c2) {
				
				if (c1.equals(c2)) {
					return 0;
				}
				if (random.nextBoolean()) {
			        return 1;  
			    } else {
			        return -1;
			    }
			}
			
			
		};
		TreeSet<Coup> ensembleTrie = new TreeSet<>(comparateurAleatoire);
		ensembleTrie.addAll(coups);
		return ensembleTrie;
		
	
	}
	
	
	default Coup selectionnerCoup(Set<Coup> coups ) {
		return trierCoups(coups).first();
	}
	
	default Coup selectionnerDefausse(Set<Coup> coups) {
		return trierCoups(coups).last();
	}
	
	
	
	
	
}
