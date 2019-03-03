package com;

public class PlusOuMoinsChallengeur extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		int[] tableauJeu = createTab();
		System.out.print("\rL'ordinateur a choisi : ");
		int[] tableauJoueur;
		dev(tableauJeu);
		boolean win = false;
		int nbrEssaiCh = 0;

		while (!win) {
			nbrEssaiCh++;
			tableauJoueur = askTab();
			System.out.print("\rVous essayez avec : ");
			dev(tableauJoueur);
			String compareResult = compare(tableauJoueur, tableauJeu);
			System.out.println(compareResult);
			win = compareResult.equals("====");
			if (win == true) {
				System.out.println("\rVous avez trouvé la combinaison en " + nbrEssaiCh + " essai(s)");
				optionsJeux();
			}
		}
	}
}
