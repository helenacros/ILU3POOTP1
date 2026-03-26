package testsFonctionnels;

import carte.Attaque;
import carte.Borne;
import carte.Cartes;
import carte.Parade;
import carte.Type;

public class TestMethodeEquals {
	public static void main(String[] args) {
		Cartes carte25Bornes1 = new Borne(25);
		Cartes carte25Bornes2 = new Borne(25);
		System.out.println("Deux cartes de 25km sont identiques ? " + carte25Bornes1.equals(carte25Bornes2));
	
		Cartes carteFeuxRouge1 = new Attaque(Type.FEU);
		Cartes carteFeuxRouge2 = new Attaque(Type.FEU);
		System.out.println("Deux cartes de feux rouge sont identiques ? " + carteFeuxRouge1.equals(carteFeuxRouge2));
		
		Cartes carteFeuxVert = new Parade(Type.FEU);
		System.out.println("La carte feu rouge et la carte feu vert sont identiques ? " + carteFeuxRouge1.equals(carteFeuxVert));
	}
}
