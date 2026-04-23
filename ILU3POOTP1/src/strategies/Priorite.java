package strategies;

import carte.Borne;
import carte.Botte;
import carte.Cartes;
import carte.FinLimite;
import carte.Parade;
import carte.Type;

public interface Priorite {

	public default Integer donnerPrioriteBornes(Cartes carte1, Cartes carte2) {
		if (carte1 instanceof Borne borne1 && carte2 instanceof Borne borne2) {
			return borne1.compareTo(borne2);
		}
		if (carte1 instanceof Borne) {
			return 1;
		}
		if (carte2 instanceof Borne) {
			return -1;
		}
		return null;
	}

	public default Integer donnerPrioriteParades(Cartes carte1, Cartes carte2) {
		if (carte1 instanceof Parade parade1 && carte2 instanceof Parade parade2) {
			return parade1.compareTo(parade2);
		}
		if (carte1 instanceof Parade) {
			return 1;
		}
		if (carte2 instanceof Parade) {
			return -1;
		}
		return null;
	}

	public default Integer donnerPrioriteBottes(Type typeProbleme, Cartes carte1, Cartes carte2) {
		if (carte1 instanceof Botte botte && botte.getType() == typeProbleme) {
			return 1;
		}
		if (carte2 instanceof Botte botte && botte.getType() == typeProbleme) {
			return -1;
		}
		return null;
	}

	public default Integer donnerPrioriteLimites(Cartes carte1, Cartes carte2) {
		if (carte1 instanceof FinLimite) {
			return 1;
		}
		if (carte2 instanceof FinLimite) {
			return -1;
		}
		return null;
	}
}
