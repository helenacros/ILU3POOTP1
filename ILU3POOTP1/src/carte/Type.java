package carte;

public enum Type {
	ACCIDENT("Accident", "Réparation", "As du volant"),
	CREVAISON("Crevaison", "Roue de secours", "Increvable"),
	ESSENCE("Panne d'essence", "Bidon d'essence", "Citerne"),
	FEU("Feu rouge", "Feu vert", "Prioritaire");
	
	private String attaque;
	private String parade;
	private String botte;
	
	private Type(String attaque, String parade, String botte) {
		this.attaque = attaque;
		this.parade = parade;
		this.botte = botte;
	}

	public String getAttaque() {
		return attaque;
	}

	public String getParade() {
		return parade;
	}

	public String getBotte() {
		return botte;
	}
}