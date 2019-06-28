package com;

import java.util.Arrays;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;

public class PlusOuMoinsChallengeur extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		if (Constante.dev == true) {
			PropertyConfigurator.configure("log4j.properties");
			logger.setLevel(Level.DEBUG);
		} else {
			PropertyConfigurator.configure("log4j.properties");
			logger.setLevel(Level.INFO);
		}
		logger.info("\rVous avez droit à " + Constante.nombreEssai + " essais");
		int[] tableauJeu = createTab();
		logger.debug("\rL'ordinateur a choisi : " + Arrays.toString(tableauJeu));
		int[] tableauJoueur;
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
