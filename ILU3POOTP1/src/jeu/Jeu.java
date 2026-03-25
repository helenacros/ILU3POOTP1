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
		JeuDeCartes modeleJeu= new JeuDeCartes();
		Cartes[] tabCartes= modeleJeu.donnerCartes();
		
		List<Cartes> listeCartes= new ArrayList<>();
		Collections.addAll(listeCartes,tabCartes);
		
		listeCartes=GestionCartes.melanger(listeCartes);
		
		//manque la fin 
		
	}

	
}
