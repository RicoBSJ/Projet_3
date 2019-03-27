package com;

//import java.util.Arrays;
//import java.util.List;

public class Essai1 {

	public static void main(String[] args) {

		String tableauJeu[] = { "vert", "noir", "orange", "bleu", "jaune" };
		String tableauJoueur[] = { "gris", "marron", "bleu foncé", "violet", "mauve" };
		
//		List<String> list1 = Arrays.asList(tableauJeu);
//		List<String> list2 = Arrays.asList(tableauJoueur);
//		for (String str : list1) {
//		    if(list2.contains(str)){ System.out.println("oui");}
//		else{System.out.println("non");}
//		}
		
		String resultat = " ";
		for (int i = 0; i < tableauJeu.length; i++) {
			boolean present = false;
			for (int j = 0; j < tableauJoueur.length; j++) {
				if (tableauJeu[i].equals(tableauJoueur[j])) {
					present = true;
					break;
				}
			}
			if (present) {
				resultat += "\rLa couleur " + tableauJeu[i] + " à l'emplacement " + (i + 1) + " est identique ";
			} else {
				resultat += "\rLa couleur " + tableauJeu[i] + " à l'emplacement " + (i + 1) + " est différente ";
			}
		}
		System.out.println(resultat);
	}
}
