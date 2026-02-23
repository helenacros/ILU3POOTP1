package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import carte.Cartes;

public class Sabot implements Iterable<Cartes> {
	private Cartes[] cartes;
	private int nbCartes=0;
	
	int nbOpe=0;
	
	public Iterator<Cartes> iterator(){
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<Cartes>{
		private int indiceIterateur=0;
		private boolean nextEffectuer=false;
		private int nbOpeRef=nbOpe;
		
		@Override
		public boolean hasNext() {
			return indiceIterateur<nbCartes;
		}
		
		private void verifConcu() {
			if (nbOpe != nbOpeRef) {
				throw new ConcurrentModificationException();
			}
		}
		
		@Override
		public Cartes next() {
			verifConcu();
			if(hasNext()) {
				Cartes carte= cartes[indiceIterateur];
				indiceIterateur++;
				nextEffectuer=true;
				return carte;
			}else {
				throw new NoSuchElementException();
			}
		}
		
		@Override
		public void remove() {
			verifConcu();
			if(nbCartes < 1 || !nextEffectuer) {
				throw new IllegalStateException();
			}
			for(int i =indiceIterateur-1; i<nbCartes-1; i++) {
				cartes[i]=cartes[i+1];
		
			}
			nextEffectuer=false;
			indiceIterateur++;
			nbCartes--;
			nbOpe++;
			nbOpeRef++;
		}
		
	}
	
	
	public Sabot(Cartes[] cartes) {
		super();
		this.cartes = cartes;
		this.nbCartes = cartes.length;
	}

	public Boolean estVide() {
		return nbCartes==0;
	}
	
	public void ajouterCarte(Cartes carte) {
		if(nbCartes<cartes.length) {
			cartes[nbCartes]=carte;
			nbCartes++;
		}else {
			throw new ArrayIndexOutOfBoundsException("out of place in the sabot !!");
		}
	}
	
	public Cartes piocher() {
		Iterator<Cartes> iterator=iterator();
		Cartes suivant=iterator.next();
		iterator.remove();
		return suivant;	
	}
	
}
