package testsFonctionnels;

import carte.Attaque;
import carte.Borne;
import carte.Parade;
import carte.Type;

public class TestMethodeEquals {
	public static void main(String[] args) {
		Borne b1 = new Borne(25);
		Borne b2= new Borne(25);
		System.out.println("Deux cartes de 25km sont identiques ?" + b1.equals(b2));
		
		Attaque feuR1= new Attaque(Type.FEU);
		Attaque feuR2= new Attaque(Type.FEU);
		System.out.println("Deux cartes feux rouges sont identiques ?"+ feuR1.equals(feuR2));
		
		Parade feuVert= new Parade (Type.FEU);
		System.out.println("La cartes feu rouge et la carte feu vert sont identiques ?"+feuR1.equals(feuVert));
	}
	
	
	
}
