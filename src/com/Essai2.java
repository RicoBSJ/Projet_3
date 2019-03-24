package com;

public class Essai2 {

	public static void main(String[] args) {

		String[] tableau = { "gris", "noir", "vert", "jaune", "rouge" };
		String[] tab = { "rouge", "gris", "noir", "vert", "jaune" };
		for (int i = 0; i < tableau.length; i++) {
			boolean present = false;
			for (int j = 0; j < tab.length; j++) {
				if (tableau[i].equals(tab[j])) {
					present = true;
					break;
				} else {
					break;
				}
			}
			if (present) {
				System.out.println("La couleur à l'emplacement " + i + " est identique");
			} else {
				System.out.println("La couleur à l'emplacement " + i + " diffère");
			}
		}
	}
}