package com;

public class MastermindChallengeur extends Game {
	
	public void jouer() {
		// A remplacer ensuite par une liste
		String[] tabColorJeu = createTabColor();
		String[] tabColorJoueur;
		dev(tabColorJeu);
		boolean win = false;

		while (!win) {
			tabColorJoueur = askTabColor();
			dev(tabColorJoueur);
			String compareResult = compareString(tabColorJeu, tabColorJoueur);
			System.out.println(compareResult);
			win = compareResult.equals("====");
		}
	}
}
