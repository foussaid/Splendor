package fr.uge.splendor.Jetons;
import java.util.*;
public class ClassJetons {
	/*
	 -L'ensemble des jetons du jeu sera représenté par un ArrayList
	 -Dans une liste de jetons : On peut enlever un jeton, on peut aussi ajouter un jeton
	 -On a ajouté à cela une fonction calculant le nombre de jetons restant dans la banque, 
	  fonction pratique dans plusieurs autres fonctions. 
	 -Une fonction d'affichage de la liste principale des jetons, avec le nombre de jetons restant*/
	
	private final List<Jetons>jetons;
	
	public ClassJetons(){
		jetons = new ArrayList<Jetons>();
	}
	
	public void addJeton(Jetons jeton) {
		Objects.requireNonNull(jeton);
		jetons.add(jeton);
		System.out.println("Vous avez ajouté le jeton");
	}
	
	public List<Jetons> removeJeton(String color) {
		Objects.requireNonNull(color);
		var it = jetons.iterator();
		List<Jetons>removedJetons = new ArrayList<Jetons>();
		while(it.hasNext()) {
			var jeton = it.next();
			if(jeton.color().equals(color)) {
				removedJetons.add(jeton);
				it.remove();
				return removedJetons;
				/*je dois le renvoyer à la fin, sinon sans le return
				 *  j'enlèverais tous les jeton de color*/
			}
		}
		return null;
	}
    
	public int jetonsRestants(String color) {
		/*Prend en paramètre une couleur, et renvoie le nombre de jetons de cette restant dans la liste principale des jetons*/
		Objects.requireNonNull(color);
		int cmpt;
		cmpt = 0;
		for(var jeton : jetons) {
			if(jeton.color().equals(color)) {
				cmpt += 1;
			}
		}
		return cmpt;
	}
	public void AfficheBanque() {
    	Map<Integer, String> lst = new HashMap<Integer, String>();
    	int cmpt;
    	cmpt = 1;
    	for(var jeton : jetons) {
    		cmpt = jetonsRestants(jeton.color());
    		lst.putIfAbsent(cmpt, jeton.color());
    	}
    	for(Map.Entry entry : lst.entrySet()) {
    		System.out.print("(" + entry.getKey() +"," + entry.getValue() + "); ");
    	}
    }
}



