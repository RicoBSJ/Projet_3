package com;

public class PlusOuMoinsDuel extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		// Application de la méthode createTab() sur le tableau de int tableauJeu :
		// Le programme choisit aléatoirement 4 chiffres
		// que l'ordinateur et le joueur vont devoir deviner
		int[] tableauJeu = createTab();
		int[] tableauJoueur;
		dev(tableauJeu);
		boolean win = false;

		int[] premierEssai = { 4, 4, 4, 4 };
		String resultat = compare(premierEssai, tableauJeu);
		System.out.println(resultat);
		win = resultat.equals("====");

		while (!win) {
			tableauJoueur = askTab();
			premierEssai = createTabComputer(premierEssai, resultat);
			dev(tableauJoueur);
			String resultatJoueur = compare(tableauJoueur, tableauJeu);
			System.out.println(resultatJoueur);
			win = resultatJoueur.equals("====");
			dev(premierEssai);
			resultat = compare(premierEssai, tableauJeu);
			win = resultat.equals("====");
		}
	}
}
