package carte;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JeuDeCartes {
	private Map<Cartes, Integer> configuration= new HashMap<>();
	
	public JeuDeCartes() {
		
		
		configuration.put(new Borne(25),10);
		configuration.put(new Borne(50),10);
		configuration.put(new Borne(75),10);
		configuration.put(new Borne(100),12);
		configuration.put(new Borne(200),4);
		
		configuration.put(new Parade(Type.FEU),14);
		configuration.put(new FinLimite(),6);
		
		configuration.put(new Parade(Type.ESSENCE),6);
		configuration.put(new Parade(Type.CREVAISON),6);
		configuration.put(new Parade(Type.ACCIDENT),6);
		
		configuration.put(new Attaque(Type.FEU),5);
		configuration.put(new DebutLimite(),4);
		
		configuration.put(new Attaque(Type.ESSENCE),3);
		configuration.put(new Attaque(Type.CREVAISON),3);
		configuration.put(new Attaque(Type.ACCIDENT),3);
		
		configuration.put(new Botte(Type.FEU),1);
		configuration.put(new Botte(Type.ESSENCE),1);
		configuration.put(new Botte(Type.CREVAISON),1);
		configuration.put(new Botte(Type.ACCIDENT),1);
			
	}
	
	
	
	public String affichageJeuDeCartes() {
		StringBuilder aff=new StringBuilder (" ");
		for (Map.Entry<Cartes, Integer> entry : configuration.entrySet()) {
			aff.append("\n").append(entry.getValue()).append(" ").append(entry.getKey().toString());
		}
		return aff.toString();
		
	}
	
//	private class Configuration {
//		private int nbExmplaires;
//		private Cartes carte;
//		
//		public int getNbExmplaires() {
//			return nbExmplaires;
//		}
//
//		public Cartes getCarte() {
//			return carte;
//		}
//
//		private Configuration( Cartes carte,int nbExmplaires) {
//			this.nbExmplaires = nbExmplaires;
//			this.carte = carte;
//		}
//		
//	}
	
	
	public Cartes[] donnerCartes() {
		int index=0;
		Cartes[] tabCartes=new Cartes[106];
		
		for (Map.Entry<Cartes, Integer> entry : configuration.entrySet()) {
			
			Cartes carte= entry.getKey();
			int nbExemplaires= entry.getValue(); //comme un dico
			
			for (int i=0; i<nbExemplaires ; i++) {
				tabCartes[index]= carte;
				index ++;
			}
		}
//		Cartes[] cartes=new Cartes[nbCartes];
//		int indCartes=0;
//		for (int i = 0; i < typeDeCartes.length; i++) {
//			for (int j=0; j<typeDeCartes[i].getNbExmplaires();j++) {
//				cartes[indCartes]=typeDeCartes[i].getCarte();
//				indCartes++;
//			}
//		}
		return tabCartes;
	}
	
	public boolean checkCount() {
		Cartes[] cartes = donnerCartes();
		int nbCartes=0;
		for (Map.Entry<Cartes, Integer> entry : configuration.entrySet()) {
			Cartes carteAttendue= entry.getKey();
			int nbExemplaires= entry.getValue();
			
			for (int i=0; i<nbExemplaires ; i++) {
				
				if(!cartes[nbCartes].equals(carteAttendue)) {
					return false;
				}
				nbCartes ++;
			}
		}
		return true;
	}
	
	


	
}
