package com;

import java.util.Arrays;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;

public class MastermindChallengeur extends Game {

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
			logger.info("\rVous avez trouvé la combinaison en " + nbrEssaiCh + " essai(s)");
		} else {
			logger.info("\rVous avez perdu !");
			logger.info("La combinaison était la suivante :" + Arrays.toString(tableauJeu));
		}
		optionsJeux();
	}
}
