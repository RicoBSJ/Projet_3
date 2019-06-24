package com;

import java.util.Arrays;

public class MastermindChallengeur extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		logger.info("\rVous avez droit � " + Constante.nombreEssai + " essais");
		String[] tableauJeu = createTabColor(Constante.tabColor);
		logger.debug("\rL'ordinateur a choisi : " + Arrays.toString(tableauJeu));
		String[] tableauJoueur;
		boolean win = false;
		int nbrEssaiCh = 0;

		while (!win && nbrEssaiCh < Constante.nombreEssai) {
			nbrEssaiCh++;
			tableauJoueur = askTabColor();
			logger.info("\rVous essayez avec : " + Arrays.toString(tableauJoueur));
			win = compare(tableauJoueur, tableauJeu);
			logger.info("\rCeci est votre " + nbrEssaiCh + " essai(s)");
			logger.info("\rIl vous reste " + (Constante.nombreEssai - nbrEssaiCh) + " essai(s)");
		}
		if (win == true) {
			logger.info("\rVous avez trouv� la combinaison en " + nbrEssaiCh + " essai(s)");
		} else {
			logger.info("\rVous avez perdu !");
		}
		optionsJeux();
	}
}
