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
	
	private boolean estDepotFeuVertAutorise() {
		if(pileBataille.isEmpty()) {
			Bataille top=pileBataille.remove(pileBataille.size()-1);
				if (top.equals(CartesI.FEU_ROUGE) || (!top.equals(CartesI.FEU_VERT) && top instanceof Parade)) {
					return true;
				}
			}
		return false;
	}
		
	private boolean estDepotBorneAutorise(Borne borne) {
		Bataille batTop=pileBataille.remove(pileBataille.size()-1);
		Limite batLim=pileLimite.remove(pileLimite.size()-1);
		
		if( !(batTop instanceof Attaque))  {
			if( ((batLim instanceof DebutLimite ) && borne.getKm() <= 50) || (batLim instanceof FinLimite)) {
				
				int kmParcourus = donnerKmParcourus();
				if((kmParcourus + borne.getKm()) <=1000 ) {
					return true;
					
				}
			}
		}
		return false;
	}
	
	private boolean estDepotLimiteAutorise(Limite limite) {
		
		if(pileLimite.size()!=0) {
			Limite batLim=pileLimite.remove(pileLimite.size()-1);
			if((limite instanceof DebutLimite) && (batLim instanceof FinLimite) ) {
				return true;
			}
//			if(limite instanceof FinLimite )
		}
		
		return false;
		
	}
	
	private boolean estDepotBatailleAutorise(Bataille bataille) {
		Bataille batTop=pileBataille.remove(pileBataille.size()-1);
		
		if((bataille instanceof Attaque) && !(batTop instanceof Attaque )) {
			return true;
		}
		if(bataille instanceof Parade) {
			if(bataille.equals(CartesI.FEU_VERT)) {
				if( (pileBataille.size()==0) ||  (batTop.equals(CartesI.FEU_ROUGE) || ( (!batTop.equals(CartesI.FEU_VERT) && batTop instanceof Parade)))){
					return true;
				}
			}
		}
		else {
			if( (pileBataille.size()!=0) && (batTop.getType().equals(bataille.getType()))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean estDepotAutorise(Cartes carte) {
		if(carte.equals(CartesI.FEU_VERT)) {
			return estDepotFeuVertAutorise();
		}
		if(carte instanceof Borne borne) {
			return estDepotBorneAutorise(borne);
		}
		if(carte instanceof Limite limite) {
			return estDepotLimiteAutorise(limite);
		}
		if(carte instanceof Bataille bataille) {
			return estDepotBatailleAutorise(bataille);
		}
		return false;
	}
	
	
	
	
}
