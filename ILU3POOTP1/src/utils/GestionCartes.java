package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import carte.Cartes;
import carte.JeuDeCartes;

import java.util.ListIterator;

public class GestionCartes {
	private static Random rand = new Random();
	
	public static <T> T extraire(List <T> liste) {
		int index=rand.nextInt(liste.size()); //on prend le dernier elt
		return liste.remove(index); //l'enleve et le retourne
	}
	
	public static <T> T extraireIterator(List <T> liste) {
		int index=rand.nextInt(liste.size());
		ListIterator<T> it = liste.listIterator();
		T elt=null;
		
		for (int i = 0; i < index ; i++) {
			elt = it.next(); //On avance jsuqu'a la fin
		}
		it.remove();
		return elt;
	}
	
	public static <T> List<T> melanger(List <T> liste) {
		List<T> listeMelangee= new ArrayList<>();
		
		while(!liste.isEmpty()) {
			T element= extraire(liste);
			listeMelangee.add(element);
		}
		return listeMelangee;	
	}
	
	public static <T> boolean verifierMelange(List<T> l1, List<T> l2) {
		if(l1.size()!= l2.size())
			return false;
		
		for(int i=0; i<l1.size();i++) {
			T elt = l1.get(i);
			if(Collections.frequency(l1, elt) != Collections.frequency(l2,elt))
				return false;
		}
		return true;
	}
	
	public static <T> List<T> rassembler(List<T> liste){
		List<T> listeRassemblee= new ArrayList<>();
		
		while(!liste.isEmpty()) {
			T elt=liste.remove(0);
			listeRassemblee.add(elt);
			
			ListIterator<T> it=liste.listIterator();
			while(it.hasNext()) {
				T next= it.next();
				
				if(elt.equals(next)) {
					listeRassemblee.add(next);
					it.remove();
				}
			}
		}
		return listeRassemblee;
	}
	
	public static <T> boolean verifierRassemblement(List<T> liste) {
		ListIterator<T> it=liste.listIterator();
		
		T courant=it.next();
		while(it.hasNext()) {
			T next=it.next();
			
			if(!(courant.equals(next))) { //changement de groupe d'obj
				ListIterator<T> dup_finder= liste.listIterator(it.nextIndex()); // on le fait partie de la ou on est
				
				while(dup_finder.hasNext()) {
					if(courant.equals(dup_finder.next())){
						return false; //un autre elt du meme type est ailleurs
					}
				}
			}
		}
		return true;
	}
	
	public static <T> void testerRassemblement(List<T> liste) {
		System.out.println("Verification de la liste :"+liste);
		boolean res=GestionCartes.verifierRassemblement(liste);
		System.out.println(" Liste bien rassemblee ?"+res);
	}
	
	public static void main(String[] args) {

	    testerRassemblement(new ArrayList<>(List.of()));                 // true
	    testerRassemblement(new ArrayList<>(List.of(1, 1, 2, 1, 3)));   // false
	    testerRassemblement(new ArrayList<>(List.of(1, 4, 3, 2)));      // true
	    testerRassemblement(new ArrayList<>(List.of(1, 1, 2, 3, 1)));   // false

	    JeuDeCartes jeu = new JeuDeCartes();

	    List<Cartes> listeCarteNonMelangee = new LinkedList<>();
	    for (Cartes carte : jeu.donnerCartes()) {
	        listeCarteNonMelangee.add(carte);
	    }
	    
	    List<Cartes> listeCartes = new ArrayList<>(listeCarteNonMelangee);
	    System.out.println(listeCartes);
	    
	    listeCartes = GestionCartes.melanger(listeCartes);
	    System.out.println(listeCartes);
	    
	    System.out.println("liste mélangée sans erreur ? "
	        + GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));
	    
	    listeCartes = GestionCartes.rassembler(listeCartes); 
	    System.out.println(listeCartes);
	    
	    System.out.println("liste rassemblée sans erreur ? "
	        + GestionCartes.verifierRassemblement(listeCartes));
	}


	
	
}


