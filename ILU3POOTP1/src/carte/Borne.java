package carte;

public class Borne extends Cartes implements Comparable<Borne>{
	
	private int km;
	
	public Borne(int km) {
		this.km = km;
	}
	
	public int getKm() {
		return km;
	}

	@Override
	public String toString() {
		return "Borne km=" + km + "";
	}

	@Override 
	public boolean equals(Object obj) {
		if( obj instanceof Borne borne) {
			return (km!=0) && (km == borne.getKm());
		}
		return false;
	}
	
	@Override
	public int compareTo(Borne borne) {
		return Integer.compare(this.km, borne.km);
	}
	
}
