package carte;

public abstract class Probleme extends Cartes implements Comparable<Probleme> {
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
	
	@Override
    public int compareTo(Probleme autre) {
        return this.type.compareTo(autre.getType());
    }

}
