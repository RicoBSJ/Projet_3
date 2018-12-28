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

	/*
	 * tableJeu = 1234 et tableJoueur = 3456 i = 0 ; j = 0 tableauJoueur[i] = 3 ;
	 * tableauJeu[j] = 1 ; tableauJoueur[i] = 3 ; tableauJeu[j] = 2 tableauJoueur[i]
	 * = 3 ; tableauJeu[j] = 3 ; tableauJoueur[i] = 3 ; tableauJeu[j] = 4
	 * tableauJoueur[i] = 4 ; tableauJeu[j] = 1 ; tableauJoueur[i] = 4 ;
	 * tableauJeu[j] = 2 tableauJoueur[i] = 4 ; tableauJeu[j] = 3 ; tableauJoueur[i]
	 * = 4 ; tableauJeu[j] = 4
	 * 
	 * tableauJoueur[i] = 3 ; tableauJeu[i] = 1 ; tableauJoueur[i] = 4 ;
	 * tableauJeu[i] = 2 tableauJoueur[i] = 5 ; tableauJeu[i] = 3 ; tableauJoueur[i]
	 * = 6 ; tableauJeu[i] = 4
	 */
	private static String compare(int tableauJeu[], int tableauJoueur[]) {

		for (int i = 0; i < tableauJoueur.length; i++) {

			if (tableauJoueur[i] == tableauJeu[i]) {
				System.out.println("=");
			} else if (tableauJoueur[i] > tableauJeu[i]) {
				System.out.println("-");
			} else if (tableauJoueur[i] < tableauJeu[i]) {
				System.out.println("+");
			} 
				for (int tabComp : tableauJoueur) {
					System.out.println(tabComp);
				}
			}
		return null;
		}

	public void jouer() {
		// A remplacer ensuite par une liste
		int[] tableauJeu = createTab();
		int[] tableauJoueur;
		dev(tableauJeu);

		while (true) {
			tableauJoueur = askTab();
			dev(tableauJoueur);
			compare(tableauJoueur, tableauJeu);
		}
	}
}