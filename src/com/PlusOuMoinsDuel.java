package com;

public class PlusOuMoinsDuel extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		/* Application de la méthode createTab() sur le tableau de int
		 * tableauJeu : Le programme choisit aléatoirement 4 chiffres
		 * que l'ordinateur et le joueur vont devoir deviner */
		int[] tableauJeu = createTab();
		/* Instanciation du tableau de int tableauJoueur
		 * sans attribution de valeur */
		int[] tableauJoueur;
		/* Application de la méthode dev sur tableauJeu
		 * c'est-à-dire affichage */
		dev(tableauJeu);
		// Instanciation de la variable booléenne win, intialisée à false
		boolean win = false;

		/* Affectation au tableau de int premierEssai
		 * (l'ordinateur), de 4 int de valeur 4 chacun */
		int[] premierEssai = { 4, 4, 4, 4 };
		/* Affectation de la méthode compare, premierEssai
		 * et tableauJeu en paramètres, sur le string resultat */
		String resultat = compare(premierEssai, tableauJeu);
		// Affichage de resultat
		System.out.println(resultat);
		// Si les 4 int sont bons, l'ordinateur gagne
		win = resultat.equals("====");

		while (!win) {
			/* Si les 4 int ne sont pas 4, 4, 4, 4 alors le programme entre
			 * dans la boucle while. Application de la méthode askTab sur
			 * tableauJoueur */
			tableauJoueur = askTab();
			/* Application de la méthode createTabComputer,
			 * premierEssai et resultat en paramètres, sur premierEssai */
			premierEssai = createTabComputer(premierEssai, resultat);
			/* Application de la méthode dev sur tableauJoueur
			 * c'est-à-dire affichage */
			dev(tableauJoueur);
			/* Application de la méthode compare, tableauJoueur et
			 * tableauJeu en paramètres, sur resultatJoueur */
			String resultatJoueur = compare(tableauJoueur, tableauJeu);
			// Affichage de resultat
			System.out.println(resultatJoueur);
			// Si les 4 int sont bons, le joueur gagne
			win = resultatJoueur.equals("====");
			/* Application de la méthode dev sur tableauJoueur
			 * c'est-à-dire affichage */
			dev(premierEssai);
			/* Application de la méthode compare, premierEssai et
			 * tableauJeu en paramètres, sur resultat */
			resultat = compare(premierEssai, tableauJeu);
			// Si les 4 int sont bons, l'ordinateur gagne
			win = resultat.equals("====");
		}
	}
}
