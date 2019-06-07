package com;

public class PlusOuMoinsChallengeur extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		logger.info("\rVous avez droit à " + Constante.nombreEssai + " essais");
		int[] tableauJeu = createTab();
		logger.info("\rL'ordinateur a choisi : ");
		int[] tableauJoueur;
		dev(tableauJeu);
		boolean win = false;
		int nbrEssaiCh = 0;

		while (!win && nbrEssaiCh < Constante.nombreEssai) {
			nbrEssaiCh++;
			tableauJoueur = askTab();
			System.out.println("\rVous essayez avec : ");
			dev(tableauJoueur);
			String compareResult = compare(tableauJoueur, tableauJeu);
			logger.info(compareResult);
			win = compareResult.equals(resultatGagnant());
		}
		if (win == true) {
			logger.info("\rVous avez trouvé la combinaison en " + nbrEssaiCh + " essai(s)");
		} else {
			logger.info("\rVous avez perdu !");
		}
		optionsJeux();
	}
}
