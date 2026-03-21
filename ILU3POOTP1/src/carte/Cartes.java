package carte;

public abstract class Cartes {
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Cartes carte) {
			return (obj != null) && (getClass() == carte.getClass());
		}
		return false;
	}
	
}
