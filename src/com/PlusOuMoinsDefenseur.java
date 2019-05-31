package com;

import java.util.Arrays;

public class PlusOuMoinsDefenseur extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		logger.info("\rL'ordinateur a droit à " + Constante.nombreEssai + " essais");
		int[] tableauDefenseur = askTab();
		logger.info("Le défenseur a entré la combinaison : ");
		dev(tableauDefenseur);
		boolean win = false;
		int nbrEssaiDef = 0;

		int[] premierEssai = new int[Constante.longueurCombinaison];
		for (int i = 0; i < premierEssai.length; i++) {
			premierEssai[i] = 4;
		}
		logger.info("\rL'ordinateur essaie avec : " + Arrays.toString(premierEssai));
		String resultat = compare(premierEssai, tableauDefenseur);
		logger.info(resultat);
		win = resultat.equals(resultatGagnant());

		while (!win && nbrEssaiDef < Constante.nombreEssai) {
			nbrEssaiDef++;
			premierEssai = createTabComputer(premierEssai, resultat);
			logger.info("\rL'ordinateur essaie avec : ");
			dev(premierEssai);
			resultat = compare(premierEssai, tableauDefenseur);
			logger.info(resultat);
			win = resultat.equals(resultatGagnant());
		}
		if (win == true) {
			logger.info("\rL'ordinateur gagne en " + nbrEssaiDef + " essai(s)");
		} else {
			logger.info("\rL'ordinateur a perdu !");
		}
		optionsJeux();
	}
}