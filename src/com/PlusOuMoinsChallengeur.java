package com;

public class PlusOuMoinsChallengeur extends Game {
	
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
