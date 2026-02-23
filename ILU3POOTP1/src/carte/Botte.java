package carte;

public class Botte extends Probleme {

	public Botte(Type type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String renvoi= "Botte ";
		switch(getType()) {
			case FEU:
				renvoi = renvoi+"Prioritaire";
				break;
			case ESSENCE:
				renvoi= renvoi+"Citerne";
				break;
			case CREVAISON:
				renvoi=renvoi+"Increvable";
				break;
			case ACCIDENT:
				renvoi=renvoi+"As du volant";
			break;
				
		}
		return renvoi;
	}

}
