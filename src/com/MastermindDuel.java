package com;

import java.util.*;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;

public class MastermindDuel extends Game {

	private String[] presenteEtBienPlace;
	private int nbrEssaiDuel = 0;
	ArrayList<String[]> essaiPrecedent = new ArrayList<String[]>();

	public void jouer() {
		// A remplacer ensuite par une liste
		if (Constante.dev == true) {
			PropertyConfigurator.configure("log4j.properties");
			logger.setLevel(Level.DEBUG);
		} else {
			PropertyConfigurator.configure("log4j.properties");
			logger.setLevel(Level.INFO);
		}
		initializeTab();
		logger.info("\rNombre d'essais maximum : " + Constante.nombreEssai);
		String[] tabComputer = createTabColor(Constante.tabColor);
		logger.debug("\rL'ordinateur a choisi : " + Arrays.toString(tabComputer));
		String[] tabPlayer = askTabColor();
		logger.debug("\rLe joueur a choisi : " + Arrays.toString(tabPlayer));
		boolean winC = false;
		boolean winJ = false;
		int nbrEssaiJoueur = 0;
		int nbrEssaiComputer = 0;

		while (!winJ && nbrEssaiJoueur < Constante.nombreEssai && !winC && nbrEssaiComputer < Constante.nombreEssai) {
			nbrEssaiJoueur++;
			nbrEssaiComputer++;
			String[] essaiComp = creerCombinaison();
			logger.info("\rL'ordinateur essaie avec : " + Arrays.toString(essaiComp));
			winC = compareDuel(essaiComp, tabPlayer);
			logger.info("\rL'ordinateur est à son " + nbrEssaiComputer + "ème essai(s)");
			String[] tentativesJoueur = askTabColor();
			logger.info("\rLe joueur essaie avec : " + Arrays.toString(tentativesJoueur));
			winJ = compare(tentativesJoueur, tabComputer);
			logger.info("\rLe joueur est à son " + nbrEssaiJoueur + "ème essai(s)");
			nbrEssaiDuel++;
		}
		if (winJ == true) {
			logger.info("\rLe joueur gagne en " + nbrEssaiJoueur + " essai(s)");
		} else {
			logger.info("\rVous avez perdu !");
			logger.info("La combinaison était la suivante :" + Arrays.toString(tabComputer));
		}

		if (winC == true) {
			logger.info("\rL'ordinateur gagne en " + nbrEssaiComputer + " essai(s)");
		} else {
			logger.info("\rL'ordinateur a perdu !");
			logger.info("La combinaison était la suivante :" + Arrays.toString(tabPlayer));
		}
		optionsJeux();
	}

	private boolean dejaUtilise(String[] essai) {
		boolean present = false;
		for (String[] x : essaiPrecedent) {
			if (tableauEgal(x, essai)) {
				present = true;
			}
		}
		return present;
	}

	private boolean tableauEgal(String[] tab1, String[] tab2) {
		boolean egal = true;
		for (int i = 0; i < tab1.length; i++) {
			if (!tab1[i].equals(tab2[i])) {
				egal = false;
			}
		}
		return egal;
	}

	private boolean compareDuel(String tableauJoueur[], String tableauJeu[]) {
		int nbrPresent = 0;
		int nbrBienPlace = 0;
		for (int i = 0; i < tableauJoueur.length; i++) {
			for (int j = 0; j < tableauJeu.length; j++) {
				if (tableauJoueur[i].equals(tableauJeu[j])) {
					if (i == j) {
						nbrBienPlace++;
						presenteEtBienPlace[i] = tableauJoueur[i];
					} else {
						nbrPresent++;
						addToPool(tableauJoueur[i]);
					}
				}
			}
		}
		logger.debug(pool.toString());
		logger.info("\r" + nbrPresent + " couleurs sont présentes et " + nbrBienPlace + " sont bien placées");
		return nbrBienPlace == tableauJeu.length;
	}

	private String cherchePresent() {
		Random rand = new Random();
		if (pool.isEmpty()) {
			return null;
		} else {
			int i = rand.nextInt(pool.size());
			String resultat = pool.get(i);
			pool.remove(i);
			return resultat;
		}
	}

	private String[] creerCombinaison() {
		boolean ok = false;
		String[] tabComp = null;
		while (ok == false) {
			if (nbrEssaiDuel == 0) {
				tabComp = createTabColor(Constante.tabColor);
			} else {
				tabComp = presenteEtBienPlace.clone();
			}
			for (int i = 0; i < tabComp.length; i++) {
				if (tabComp[i] == null) {
					String result = cherchePresent();
					if (result != null) {
						tabComp[i] = result;
					} else {
						Random rand = new Random();
						String newColor = Constante.tabColor[rand.nextInt(Constante.tabColor.length)];
						tabComp[i] = newColor;
					}
				}
			}
			if (!dejaUtilise(tabComp)) {
				ok = true;
			}
		}

		essaiPrecedent.add(tabComp);
		return tabComp;
	}

	private void initializeTab() {
		this.presenteEtBienPlace = new String[Constante.longueurCombinaison];
		for (int i = 0; i < Constante.longueurCombinaison; i++) {
			presenteEtBienPlace[i] = null;
		}
	}
}
