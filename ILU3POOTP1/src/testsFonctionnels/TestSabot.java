package testsFonctionnels;

import java.util.Iterator;

import carte.Botte;
import carte.Cartes;
import carte.JeuDeCartes;
import carte.Type;
import jeu.Sabot;

public class TestSabot {
	JeuDeCartes jeu = new JeuDeCartes();
	Sabot sabot = new Sabot(jeu.donnerCartes());

	// 4.2.a
	public void questionA() {

		while (!sabot.estVide()) {
			Cartes carte = sabot.piocher();
			System.out.println("Je pioche " + carte);
		}
//		Console :
//		Je pioche Accident
//		Je pioche Accident
//		Je pioche Accident
//		Je pioche R�paration
//		Je pioche R�paration
//		Je pioche R�paration
//		Je pioche As du volant
	}

	// 4.2.b
	public void questionB() {
		for (Iterator<Cartes> iterator = sabot.iterator(); iterator.hasNext();) {
			System.out.println("Je pioche B" + iterator.next());
			iterator.remove();
		}
	}

	// 4.2.c
	public void questionC() {
		Cartes cartePiochee = sabot.piocher();
		System.out.println("Je pioche " + cartePiochee);
		for (Iterator<Cartes> iterator = sabot.iterator(); iterator.hasNext();) {
			Cartes carte = iterator.next();
			System.out.println("Je pioche " + carte);
			iterator.remove();
			Cartes cartePiochee1 = sabot.piocher();
			sabot.ajouterCarte(new Botte(Type.ACCIDENT));
		}
		Iterator<Cartes> iterator = sabot.iterator();
		System.out.println("\nLa pioche contient encore des cartes ? " + iterator.hasNext());
	}

	public static void main(String[] args) {
		TestSabot testPioche = new TestSabot();
		//testPioche.questionA();
		//testPioche.questionB();
		testPioche.questionC();
	}

}