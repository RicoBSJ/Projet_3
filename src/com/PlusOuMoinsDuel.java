package com;

import java.util.Scanner;

public class PlusOuMoinsDuel extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		int[] tableauJeu = createTab();
		int[] tableauJoueur;
		int[] tableauOrdinateur;
		dev(tableauJeu);
		boolean win = false;

		while (!win) {
			tableauJoueur = askTab();
			tableauOrdinateur = createTabComputer();
			dev(tableauJoueur);
			dev(tableauOrdinateur);
			String compareResult = compare(tableauJeu, tableauJoueur, tableauOrdinateur);
			System.out.println(compareResult);
			win = compareResult.equals("====");
		}
	}
}
