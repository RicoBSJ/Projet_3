package com;

public class Essai4 {

	public static void main(String[] args) {

		String[] tableau = { "toto", "dodo", "fofo", "gogo", "koko", "lolo", "roro" };
		String[] tab = { "dodo", "soso", "koko", "momo", "fofo" };
		for (int i = 0; i < tableau.length; i++) {
			boolean present = false;
			for (int j = 0; j < tab.length; j++) {
				if (tableau[i].equals(tab[j])) {
					present = true;
					break;
				}
			}
			if (present) {
				System.out.println("oui");
			} else {
				System.out.println("non");
			}
		}
	}
}