package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import carte.Attaque;
import carte.Bataille;
import carte.Borne;
import carte.Cartes;
import carte.CartesI;
import carte.DebutLimite;
import carte.FinLimite;
import carte.Limite;
import carte.Parade;
import carte.Type;

public class ZoneDeJeu {
	private List<Limite> pileLimite= new ArrayList<>();
	private List<Bataille> pileBataille= new ArrayList<>();
	private Collection<Borne> collectionBorne=new ArrayList<>();
	
	public int donnerLimitationVitesse() {
		if(!pileLimite.isEmpty() && (pileLimite.getLast() instanceof DebutLimite)) {
			return 50;
		}
		return 200;
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
		if(!pileBataille.isEmpty() && pileBataille.getLast().equals(CartesI.FEU_VERT)) {
			return true;
		}
		return false;
	}
	
	private boolean estDepotFeuVertAutorise() {
		if(!pileBataille.isEmpty()) {
			Bataille sommet = pileBataille.getLast();
			if(!sommet.equals(CartesI.FEU_ROUGE) &&  (!(sommet instanceof Parade) || sommet.equals(CartesI.FEU_VERT))) {
				return false;
			}
		}
		return true;
	}
		
	private boolean estDepotBorneAutorise(Borne borne) {
		if (peutAvancer() && donnerLimitationVitesse() >= borne.getKm() 
				&& donnerKmParcourus() < 1000) {
			return true;
		}
		return false;
	}
	
	private boolean estDepotLimiteAutorise(Limite limite) {
		if(limite instanceof DebutLimite) {
			return donnerLimitationVitesse() == 200;
		}
		return donnerLimitationVitesse() == 50;
	}
	
	private boolean estDepotBatailleAutorise(Bataille bataille) {
		if(bataille instanceof Attaque) {
			return peutAvancer();
		} if(bataille.getType() == Type.FEU ) {
			return estDepotFeuVertAutorise() ;	
		} if(! pileBataille.isEmpty()){
			Bataille sommet = pileBataille.getLast();
			return sommet instanceof Attaque && sommet.getType() == bataille.getType();
		}
		return false;
	}
	
	
	public boolean estDepotAutorise(Cartes carte) {
		if(carte instanceof Borne borne) {
			return estDepotBorneAutorise(borne);
		}
		if(carte instanceof Limite limite) {
			return estDepotLimiteAutorise(limite);
		}
		if(carte instanceof Bataille bataille) {
			return estDepotBatailleAutorise(bataille);
		}
		return true;
	}
	
	
	
	
}
