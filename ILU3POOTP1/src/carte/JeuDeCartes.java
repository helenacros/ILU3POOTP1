package carte;

public class JeuDeCartes {
	private Configuration[] typeDeCartes= new Configuration[19];
	
	public JeuDeCartes() {
		typeDeCartes[0]=new Configuration(new Borne(25),10);
		typeDeCartes[1]=new Configuration(new Borne(50),10);
		typeDeCartes[2]=new Configuration(new Borne(75),10);
		typeDeCartes[3]=new Configuration(new Borne(100),12);
		typeDeCartes[4]=new Configuration(new Borne(200),4);
		
		typeDeCartes[5]=new Configuration(new Parade(Type.FEU),14);
		typeDeCartes[6]=new Configuration(new FinLimite(),6);
		
		typeDeCartes[7]=new Configuration(new Parade(Type.ESSENCE),6);
		typeDeCartes[8]=new Configuration(new Parade(Type.CREVAISON),6);
		typeDeCartes[9]=new Configuration(new Parade(Type.ACCIDENT),6);
		
		typeDeCartes[10]=new Configuration(new Attaque(Type.FEU),5);
		typeDeCartes[11]=new Configuration(new DebutLimite(),4);
		
		typeDeCartes[12]=new Configuration(new Attaque(Type.ESSENCE),3);
		typeDeCartes[13]=new Configuration(new Attaque(Type.CREVAISON),3);
		typeDeCartes[14]=new Configuration(new Attaque(Type.ACCIDENT),3);
		
		typeDeCartes[15]=new Configuration(new Botte(Type.FEU),1);
		typeDeCartes[16]=new Configuration(new Botte(Type.ESSENCE),1);
		typeDeCartes[17]=new Configuration(new Botte(Type.CREVAISON),1);
		typeDeCartes[18]=new Configuration(new Botte(Type.ACCIDENT),1);
			
	}
	
	
	
	public String affichageJeuDeCartes() {
		StringBuilder aff=new StringBuilder (" ");
		for (int i = 0; i < typeDeCartes.length; i++) {
			aff .append("\n" + typeDeCartes[i].getNbExmplaires()+" "+typeDeCartes[i].getCarte().toString());
			
		}
		return aff.toString();
		
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

		private Configuration( Cartes carte,int nbExmplaires) {
			this.nbExmplaires = nbExmplaires;
			this.carte = carte;
		}
		
	}
	
	public Cartes[] donnerCartes() {
		int nbCartes=0;
		for (int i = 0; i < typeDeCartes.length; i++) {
			nbCartes+=typeDeCartes[i].getNbExmplaires();
		}
		Cartes[] cartes=new Cartes[nbCartes];
		int indCartes=0;
		for (int i = 0; i < typeDeCartes.length; i++) {
			for (int j=0; j<typeDeCartes[i].getNbExmplaires();j++) {
				cartes[indCartes]=typeDeCartes[i].getCarte();
				indCartes++;
			}
		}
		return cartes;
	}


	
}
