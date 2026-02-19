package carte;

public class JeuDeCartes {
	private Configuration[] typeDeCartes= new Configuration[19];
	
	public String affichageJeuDeCartes() {
		String aff="JEU :";
		for (int i = 0; i < typeDeCartes.length; i++) {
			aff  += "\n" + typeDeCartes[i].getNbExmplaires()+" "+typeDeCartes[i].getCarte().toString();
			
		}
		return aff;
		
	}
	
	private class Configuration {
		private int nbExmplaires;
		private Cartes carte;
		
		public int getNbExmplaires() {
			return nbExmplaires;
		}

		public Cartes getCarte() {
			return carte;
		}

		public Configuration( Cartes carte,int nbExmplaires) {
			this.nbExmplaires = nbExmplaires;
			this.carte = carte;
		}
		
	}
	
	public Cartes[] donnerCartes() {
		int nbCartes=0;
		for (int i = 0; i < typeDeCartes.length; i++) {
			nbCartes+=typeDeCartes[i].getNbExmplaires();
		}
		Cartes[] cartes;
		int nbExemplaires=0;
		for (int i = 0; i < nbCartes; i++) {
			nbExemplaires=t
			
		}
		return cartes;
	}
	
}
