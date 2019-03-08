package com;

public class PlusOuMoinsChallengeur extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		System.out.println("\rVous avez droit à " + Constante.nombreEssai + " essais");
		int[] tableauJeu = createTab();
		System.out.print("\rL'ordinateur a choisi : ");
		int[] tableauJoueur;
		dev(tableauJeu);
		boolean win = false;
		// Création d'une variable pour les essais
		int nbrEssaiCh = 0;

		while (!win && nbrEssaiCh < Constante.nombreEssai) {
			// Incrémentation de la variable é chaque essai
			nbrEssaiCh++;
			// 1er essai
			tableauJoueur = askTab();
			System.out.print("\rVous essayez avec : ");
			dev(tableauJoueur);
			String compareResult = compare(tableauJoueur, tableauJeu);
			System.out.println(compareResult);
			win = compareResult.equals("====");
		}
		// Si le joueur gagne, on affiche le nbr d'essai
		if (win == true) {
			System.out.println("\rVous avez trouvé la combinaison en " + nbrEssaiCh + " essai(s)");
			// On relance le jeu avec la méthode de la classe Game
		} else {
			System.out.println("\rVous avez perdu !");
		}
		optionsJeux();
	}
}
