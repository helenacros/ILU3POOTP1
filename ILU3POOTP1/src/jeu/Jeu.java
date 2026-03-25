package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import carte.Cartes;
import carte.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	
	private Sabot sabot;
	
	public Jeu(Sabot sabot) {
		JeuDeCartes jeuDeCarte= new JeuDeCartes();
		Cartes[] tabCartes= jeuDeCarte.donnerCartes();
		
		List<Cartes> listeCartes= new ArrayList<>();
		Collections.addAll(listeCartes,tabCartes);
		
		listeCartes=GestionCartes.melanger(listeCartes);
		
		sabot=new Sabot((Cartes[]) listeCartes.toArray());
		
	}

	
}
