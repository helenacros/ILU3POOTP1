package carte;

public class Parade extends Bataille {

	public Parade(Type type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		String renvoi= "Parade ";
		switch(getType()) {
			case FEU:
				renvoi = renvoi+"Feu Vert";
				break;
			case ESSENCE:
				renvoi= renvoi+"Essence";
				break;
			case CREVAISON:
				renvoi=renvoi+"Roue de secours";
				break;
			case ACCIDENT:
				renvoi=renvoi+"Réparation";
				break;
				
		}
		return renvoi;
	}


}
