package com;

import java.util.Random;
import java.util.Scanner;

public class PlusOuMoinsJoueur extends Game {

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
		String resultat = "";
		for (int i = 0; i < tableauJoueur.length; i++) {

			if (tableauJoueur[i] == tableauJeu[i]) {
				resultat += "=";
			} else if (tableauJoueur[i] < tableauJeu[i]) {
				resultat += "-";
			} else if (tableauJoueur[i] > tableauJeu[i]) {
				resultat += "+";
			} else {
				break;
			}
		}
		return resultat;
	}

	public void jouer() {
		// A remplacer ensuite par une liste
		int[] tableauJeu = createTab();
		int[] tableauJoueur;
		dev(tableauJeu);
		boolean win = false;

		while (!win) {
			tableauJoueur = askTab();
			dev(tableauJoueur);
			String compareResult = compare(tableauJoueur, tableauJeu);
			System.out.println(compareResult);
			win = compareResult.equals("====");
		}
	}
}
