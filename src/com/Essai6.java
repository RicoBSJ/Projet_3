package com;

public class Essai6 {

	public static void main(String[] args) {

		String tableauJeu[] = { "vert", "noir", "orange", "bleu", "jaune" };
		String tableauJoueur[] = { "gris", "marron", "bleu foncé", "violet", "mauve" };

		@SuppressWarnings("unused")
		String resultat = " ";
		for (int i = 0; i < tableauJoueur.length; i++) {
			boolean present = false;
			System.out.println(tableauJoueur[i]);
			for (int j = 0; j < tableauJeu.length; j++) {
				System.out.println(tableauJeu[j]);
				if (tableauJeu[i].equals(tableauJoueur[j])) {
					present = true;
					break;
				}
			}
			if (present) {
				resultat += "\rLa couleur à l'emplacement " + (i + 1) + " est identique ";
			} else {
				resultat += "\rLa couleur à l'emplacement " + (i + 1) + " est différente ";
			}
		}
	}
}
