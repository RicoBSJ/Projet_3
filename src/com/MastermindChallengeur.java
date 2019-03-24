package com;

import java.util.Arrays;

public class MastermindChallengeur extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		System.out.println("\rVous avez droit à " + Constante.nombreEssai + " essais");
		String[] tableauJeu = createTabColor(Constante.tabColor);
		System.out.print("\rL'ordinateur a choisi : ");
		String[] tableauJoueur;
		dev(tableauJeu);
		boolean win = false;
		int nbrEssaiCh = 0;

		while (!win && nbrEssaiCh < Constante.nombreEssai) {
			nbrEssaiCh++;
			tableauJoueur = askTabColor();
			System.out.println("\rVous essayez avec : "+Arrays.toString(tableauJoueur));
			String compareResult = compare(tableauJoueur, tableauJeu);
			System.out.println(compareResult);
			win = compareResult.equals(resultatGagnantColor());
		}
		if (win == true) {
			System.out.println("\rVous avez trouvé la combinaison en " + nbrEssaiCh + " essai(s)");
		} else {
			System.out.println("\rVous avez perdu !");
		}
		optionsJeux();
	}
}
