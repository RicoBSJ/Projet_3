package com;

import java.util.*;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;

public class MastermindDefenseur extends Game {

	private String[] presenteEtBienPlace;
	private int nbrEssaiDef = 0;
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
		logger.info("\rL'ordinateur a droit à " + Constante.nombreEssai + " essais");
		String[] tableauDefenseur = askTabColor();
		logger.debug("\rLe défenseur a entré la combinaison : " + Arrays.toString(tableauDefenseur));
		boolean win = false;

		while (!win && nbrEssaiDef < Constante.nombreEssai) {
			String[] essaiComp = creerCombinaison();
			logger.info("\rL'ordinateur essaie avec : " + Arrays.toString(essaiComp));
			nbrEssaiDef++;
			logger.info("Il s'agit du " + nbrEssaiDef + "ème essai(s)");
			win = compareDefenseur(essaiComp, tableauDefenseur);
		}
		if (win == true) {
			logger.info("\rL'ordinateur gagne en " + nbrEssaiDef + " essai(s)");
		} else {
			logger.info("\rL'ordinateur a perdu !");
			logger.info("La combinaison était la suivante :" + Arrays.toString(tableauDefenseur));
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

	private boolean compareDefenseur(String tableauJoueur[], String tableauJeu[]) {
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
		logger.info(nbrPresent + " couleurs sont présentes et " + nbrBienPlace + " sont bien placées");
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
			if (nbrEssaiDef == 0) {
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