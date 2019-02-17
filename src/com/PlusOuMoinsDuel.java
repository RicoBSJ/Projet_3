package com;

public class PlusOuMoinsDuel extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		int[] tableauJeu = createTab();
		int[] tableauJoueur = askTab();
		int[] tableauOrdinateur;
		dev(tableauJoueur);
		boolean win = false;

		int[] premierEssai = { 4, 4, 4, 4 };
		String resultat = compare(premierEssai, tableauJeu);
		System.out.println(resultat);
		win = resultat.equals("====");

		while (!win) {
			tableauOrdinateur = askTab();
			premierEssai = createTabComputer(premierEssai, resultat);
			dev(premierEssai);
			resultat = compareDuel(tableauJeu, tableauOrdinateur, tableauJoueur);
			System.out.println(resultat);
			win = resultat.equals("====");
		}
	}
}
