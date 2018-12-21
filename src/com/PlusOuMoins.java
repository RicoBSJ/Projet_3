package com;

import java.util.Random;
import java.util.Scanner;

public class PlusOuMoins extends Game {
	private int[] createTab() {
		int[] resultat = { 0, 0, 0, 0 };
		Random rand = new Random();
		for (int i = 0; i < resultat.length; i++) {
			resultat[i] = rand.nextInt(9);
		}
		return resultat;
	}

	private int[] askTab() {
		int[] resultat = { 0, 0, 0, 0 };
		System.out.println("Veuillez taper 4 chiffres :");
		Scanner sc = new Scanner(System.in);
		String result = sc.nextLine();
		for (int i = 0; i < resultat.length; i++) {
			String carac = Character.toString(result.charAt(i));
			resultat[i] = Integer.parseInt(carac);
		}
		return resultat;
	}

	private void dev(int[] tab) {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i]);
		}
		System.out.println();
	}

	private String compare(int tableauJeu[], int tableauJoueur[]) {
		String str = new String();
		for (int i = 0; i < tableauJeu.length; i++) {
			for (int j = 0; j < tableauJoueur.length; j++) {

				if (tableauJeu[i] == tableauJoueur[j]) {
					System.out.println("OK");
					return int ;

				} else {
					System.out.println("Tableaux différents !");
				}

			}
		}
	}

	public void jouer() {
		// A remplacer ensuite par une liste
		int[] tableauJeu = createTab();
		int[] tableauJoueur;
		int i = 0;
		dev(tableauJeu);

		while (true) {
			tableauJoueur = askTab();
			dev(tableauJoueur);
		}
	}
}