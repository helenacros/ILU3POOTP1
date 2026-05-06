package testsFonctionnels;

import carte.Cartes;
import jeu.Jeu;
import jeu.Joueur;
import jeu.MainJoueur;
import jeu.Sabot;
import jeu.ZoneDeJeu;
import strategies.Presse;

public class TestJeu {
    public static void main(String[] args) {
    	//test tp4
//        Jeu milleBornes = new Jeu(null);
//
//        Joueur luffy = new Joueur("Luffy", new ZoneDeJeu(), new MainJoueur());
//        Joueur jack = new Joueur("Jack", new ZoneDeJeu(), new MainJoueur());
//        Joueur bill = new Joueur("Bill", new ZoneDeJeu(), new MainJoueur());
//
//        milleBornes.inscrire(luffy, jack, bill);
//
//        milleBornes.distribuerCartes();
//
//        System.out.println("debut de la partie\n");
//        
//        String resultatPartie = milleBornes.lancer();
//        System.out.println(resultatPartie);
//        
//        System.out.println("fin de la partie \n");
        
    	//test tp5
    	
    	Sabot sabot = new Sabot(new Cartes[0]);
        Jeu jeu = new Jeu(sabot);
      
        Joueur j1 = new Joueur("Alice (Pressée)", new ZoneDeJeu(), new MainJoueur());
        Joueur j2 = new Joueur("Bob (Classique)", new ZoneDeJeu(), new MainJoueur());
        Joueur j3 = new Joueur("Charlie (Classique)", new ZoneDeJeu(), new MainJoueur());
        
        // {} permet d'instancier direct l'interface 
        j1.setStrategie(new Presse() {});
        
        //les deux autres joueurs gardent donc la strategies par defaut 
          
        jeu.inscrire(j1, j2, j3);
        
        System.out.println("--- DÉBUT DE LA PARTIE ---");
        jeu.distribuerCartes();
        String resultat = jeu.lancer();
       
        System.out.println(resultat);	
    }
}