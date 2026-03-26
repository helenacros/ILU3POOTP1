package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import carte.Bataille;
import carte.Borne;
import carte.Cartes;
import carte.CartesI;
import carte.FinLimite;
import carte.Limite;
import carte.Parade;

public class ZoneDeJeu {
	private List<Limite> pileLimite= new ArrayList<>();
	private List<Bataille> pileBataille= new ArrayList<>();
	private Collection<Borne> collectionBorne=new ArrayList<>();
	
	public int donnerLimitationVitesse() {
		if((pileLimite.isEmpty()) || (pileLimite.remove(pileLimite.size()-1) instanceof FinLimite)) 
			return 200;
		else 
			return 50;
	}
	
	public int donnerKmParcourus() {
		int accBorne=0;
		for (Iterator<Borne> itCollection = collectionBorne.iterator(); itCollection.hasNext();) {
			accBorne += itCollection.next().getKm();
		}
		return accBorne;
	}
	
	public void deposer(Cartes c) {
		if(c instanceof Borne borne) {
			collectionBorne.add(borne);
		}
		if(c instanceof Limite limite) {
			pileLimite.add(limite);
		}
		if(c instanceof Bataille bataille) {
			pileBataille.add(bataille);
		}
	}
	
	public boolean peutAvancer() {
		if(!pileBataille.isEmpty()&& pileBataille.remove(pileLimite.size()-1).equals(CartesI.FEU_VERT)){
			return true;
		}
		return false;
	}
	
	public boolean estDepotFeuVertAutorise() {
		if(pileBataille.isEmpty()) {
			Bataille top=pileBataille.remove(pileLimite.size()-1);
				if (top.equals(CartesI.FEU_ROUGE) || (top.equals(CartesI.FEU_VERT) && top instanceof Parade)) {
					return true;
				}
				
			return false;
		}
	
	}
		
		
	
	
	
	
	
	
}
