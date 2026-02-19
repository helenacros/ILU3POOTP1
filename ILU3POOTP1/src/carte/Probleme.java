package carte;

public abstract class Probleme extends Cartes {
	protected Type type;
	
	public Probleme(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Probleme [type=" + type + "]";
	}

}
