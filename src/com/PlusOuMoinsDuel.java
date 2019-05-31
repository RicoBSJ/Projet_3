package com;

import java.util.Arrays;

public class PlusOuMoinsDuel extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		logger.info("\rNombre d'essais maximum : " + Constante.nombreEssai);
		int[] tabComputer = createTab();
		logger.info("\rL'ordinateur a choisi : ");
		dev(tabComputer);
		int[] tabPlayer = askTab();
		logger.info("\rLe joueur a entré la combinaison : ");
		dev(tabPlayer);
		String premierEssaiJoueur = compare(tabPlayer, tabComputer);
		logger.info(premierEssaiJoueur);
		boolean winC = false;
		boolean winJ = false;
		int nbrEssaiJoueur = 1;
		int nbrEssaiComputer = 0;

		int[] premierEssai = new int[Constante.longueurCombinaison];
		for (int i = 0; i < premierEssai.length; i++) {
			premierEssai[i] = 4;
		}

		logger.info("\rL'ordinateur essaie avec : " + Arrays.toString(premierEssai));
		nbrEssaiComputer++;
		String resultat = compare(premierEssai, tabComputer);
		logger.info(resultat);

		while (!winJ && nbrEssaiJoueur < Constante.nombreEssai && !winC && nbrEssaiComputer < Constante.nombreEssai) {
			nbrEssaiJoueur++;
			nbrEssaiComputer++;
			int[] tentativesJoueur = askTab();
			logger.info("\rLe joueur essaie avec : ");
			dev(tentativesJoueur);
			String compareResult = compare(tentativesJoueur, tabComputer);
			logger.info(compareResult);
			winJ = compareResult.equals(resultatGagnant());
			premierEssai = createTabComputer(premierEssai, resultat);
			logger.info("\rL'ordinateur essaie avec : ");
			dev(premierEssai);
			resultat = compare(premierEssai, tabComputer);
			logger.info(resultat);
			winC = resultat.equals(resultatGagnant());
		}
		if (winJ == true) {
			logger.info("\rLe joueur gagne en " + nbrEssaiJoueur + " essai(s)");
		} else {
			logger.info("\rVous avez perdu !");
		}

		if (winC == true) {
			logger.info("\rL'ordinateur gagne en " + nbrEssaiComputer + " essai(s)");
		} else {
			logger.info("\rL'ordinateur a perdu !");
		}
		optionsJeux();
	}
}