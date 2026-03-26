package jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import carte.Cartes;

public class MainJoueur {
	private List<Cartes> main= new ArrayList<>();
	
	public void prendre(Cartes carte) {
		main.add(carte);
	}
	
	public void joueur(Cartes carte) {
		assert(main.contains(carte));
		main.remove(carte);
	}
	
	@Override
	public String toString() {
		StringBuilder stringMain= new StringBuilder();
		
		for (ListIterator<Cartes> itMain = main.listIterator(); itMain.hasNext();) {
			Cartes carte= itMain.next();
			stringMain.append(carte);
		}
		return stringMain.toString();
	}
	
}
