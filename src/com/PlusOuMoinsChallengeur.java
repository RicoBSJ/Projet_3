package com;

public class PlusOuMoinsChallengeur extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		System.out.println("\rVous avez droit à " +Constante.nombreEssai+ " essais");
		int[] tableauJeu = createTab();
		System.out.print("\rL'ordinateur a choisi : ");
		int[] tableauJoueur;
		dev(tableauJeu);
		boolean win = false;
		// Cr�ation d'une variable pour les essais
		int nbrEssaiCh = 0;

		while (!win) {
			// Incr�mentation de la variable � chaque essai
			nbrEssaiCh++;
			// Incr�mentation de la variable que l'on compare au nbr d'essai
			Constante.nbrEssai++;
			// 1er essai
			tableauJoueur = askTab();
			System.out.print("\rVous essayez avec : ");
			dev(tableauJoueur);
			String compareResult = compare(tableauJoueur, tableauJeu);
			System.out.println(compareResult);
			win = compareResult.equals("====");
			// Si le joueur gagne, on affiche le nbr d'essai
			if (win == true) {
				System.out.println("\rVous avez trouvé la combinaison en " + nbrEssaiCh + " essai(s)");
				// On relance le jeu avec la m�thode de la classe Game
				optionsJeux();
			}
			// Si le nbr d'essai atteint le maximum alors le joueur perd
			if (Constante.nbrEssai == Constante.nombreEssai) {
				System.out.println("\rVous avez perdu !");
				// On relance le jeu avec la m�thode de la classe Game
				optionsJeux();
			}
		}
	}
}
