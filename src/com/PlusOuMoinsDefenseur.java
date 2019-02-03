package com;

import java.util.Random;
import java.util.Scanner;

public class PlusOuMoinsDefenseur extends Game {

	private int[] createTab() {
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

	private int[] askTab() {
		int[] resultat = { 0, 0, 0, 0 };
		Random rand = new Random();
		for (int i = 0; i < resultat.length; i++) {
			resultat[i] = rand.nextInt(9);
		}
		return resultat;
	}

	private void dev(int[] tab) {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i]);
		}
		System.out.println();
	}

	private String compare(int tableauDefenseur[], int tableauOrdinateur[]) {
		String resultat = "";
		for (int i = 0; i < tableauOrdinateur.length; i++) {

			if (tableauOrdinateur[i] == tableauDefenseur[i]) {
				resultat += "=";
			} else if (tableauOrdinateur[i] < tableauDefenseur[i]) {
				resultat += "-";
			} else if (tableauOrdinateur[i] > tableauDefenseur[i]) {
				resultat += "+";
			} else {
				break;
			}
		}
		return resultat;
	}

	public void jouer() {
		// A remplacer ensuite par une liste
		int[] tableauDefenseur = createTab();
		int[] tableauOrdinateur;
//		dev(tableauDefenseur);
		boolean win = false;

		while (!win) {
			tableauOrdinateur = askTab();
			dev(tableauOrdinateur);
			String compareResult = compare(tableauOrdinateur, tableauDefenseur);
			System.out.println(compareResult);
			win = compareResult.equals("====");
		}
	}
}
