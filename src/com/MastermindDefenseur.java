package com;

import java.util.*;

public class MastermindDefenseur extends Game {

	private String[] presenteEtBienPlace;
	private String[] presenteEtMalPlace;
	private int nbrEssaiDef = 0;

	public void jouer() {
		// A remplacer ensuite par une liste
		initializeTab();
		System.out.println("\rL'ordinateur a droit à " + Constante.nombreEssai + " essais");
		String[] tableauDefenseur = askTabColor();
		System.out.print("\rLe défenseur a entré la combinaison : ");
		dev(tableauDefenseur);
		boolean win = false;

		while (!win && nbrEssaiDef < Constante.nombreEssai) {
			String[] essaiComp = creerCombinaison();
			System.out.println("\rL'ordinateur essaie avec : " + Arrays.toString(essaiComp));
			nbrEssaiDef++;
			win = compareDefenseur(essaiComp, tableauDefenseur);
		}
		if (win == true) {
			System.out.println("\rL'ordinateur gagne en " + nbrEssaiDef + " essai(s)");
		} else {
			System.out.println("\rL'ordinateur a perdu !");
		}
		optionsJeux();
	}

	private boolean compareDefenseur(String tableauJoueur[], String tableauJeu[]) {
		int nbrPresent = 0;
		int nbrBienPlace = 0;
		for (int i = 0; i < tableauJoueur.length; i++) {
			for (int j = 0; j < tableauJeu.length; j++) {
				if (tableauJoueur[i].equals(tableauJeu[j])) {
					nbrPresent++;
					if (i == j) {
						nbrPresent--;
						nbrBienPlace++;
						presenteEtBienPlace[i] = tableauJoueur[i];
					} else {
						presenteEtMalPlace[i] = tableauJoueur[i];
					}
				}
			}
		}
		dev(presenteEtMalPlace);
		System.out.println(nbrPresent + " couleurs sont mal placées et " + nbrBienPlace + " sont bien placées");
		return nbrBienPlace == tableauJeu.length;
	}

	private String cherchePresent() {
		ArrayList<String> pool = new ArrayList<String>();
		for (int i = 0; i < presenteEtMalPlace.length; i++) {
			if (presenteEtMalPlace[i] != null) {
				if (pool.contains(presenteEtMalPlace[i])) {
					pool.add(presenteEtMalPlace[i]);
				}
			}
		}
		Random rand = new Random();
		if (pool.isEmpty()) {
			return null;
		} else {
			return pool.get(rand.nextInt(pool.size()));
		}
	}

	private String[] creerCombinaison() {
		String[] tabComp;
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
		return tabComp;
	}

	private void initializeTab() {
		this.presenteEtBienPlace = new String[Constante.longueurCombinaison];
		this.presenteEtMalPlace = new String[Constante.longueurCombinaison];
		for (int i = 0; i < Constante.longueurCombinaison; i++) {
			presenteEtBienPlace[i] = null;
			presenteEtMalPlace[i] = null;
		}
	}
}
