package carte;

public class FinLimite extends Limite {


	@Override
	public String toString() {
		return "Fin Limite 50 ";
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof FinLimite;
	}

}
