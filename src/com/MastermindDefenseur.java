package com;

import java.util.Arrays;

public class MastermindDefenseur extends Game {

	private String[] presenteEtBienPlace;
	private String[] presenteEtMalPlace;
	private String[] copy;
	private String[] tabComp;
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
			String[] premierEssai = creerCombinaison();
			System.out.println("\rL'ordinateur essaie avec : " + Arrays.toString(premierEssai));
			nbrEssaiDef++;
			win = compareDefenseur(premierEssai, tableauDefenseur);
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
						nbrBienPlace++;
						presenteEtBienPlace[i] = tableauJoueur[i];
					} else {
						presenteEtMalPlace[i] = tableauJoueur[i];
					}
				}
			}
		}
		System.out.println(nbrPresent + " couleurs sont présentes et " + nbrBienPlace + " sont bien placées");
		return nbrBienPlace == tableauJeu.length;
	}

	@SuppressWarnings("unused")
	private String[] creerCombinaison() {
		if (nbrEssaiDef == 0) {
			tabComp = createTabColor(Constante.tabColor);
			if (nbrEssaiDef != 0) {
				tabComp = presenteEtBienPlace;
			}
		}
		for (int i = 0; i < Constante.longueurCombinaison; i++) {
			boolean colorInTab;
			copy = tabComp;
			if (tabComp[i] == null) {
				colorInTab = presenteEtMalPlace[i] != null;
				if (colorInTab = true) {
					//Ligne remplissant le tableau de null
					tabComp[i] = presenteEtMalPlace[i];
				} else {
					tabComp[i] = Constante.tabColor[i];
				}
			}
			presenteEtBienPlace[i] = tabComp[i];
			presenteEtMalPlace[i] = null;
		}
		return copy;
	}

	/*
	 * Créer une méthode private creerCombinaison
	 * {
	 * Si nbrEssaiDef = 0 alors on utilise la méthode createTabColor
	 * Si nbrEssaiDef != 0 alors on récupère presenteEtBienPlace
	 * for ()
	 * {
	 * On crée une copie de presenteEtBienPlace
	 * 
	 * Si l'index sur lequel on se trouve = null, on vérifie s'il y a des couleurs disponibles dans presenteEtMalPlace
	 * 		S'il y en a on prend une couleur qui remlacera null
	 * 		S'il n'y en a pas, on prend une nouvelle couleur alétoire dans Constante.tabColor
	 * On remplace null par cette couleur dans presenteEtBienPlace
	 * Et cette couleur par null dans presenteEtMalPlace
	 * 
	 * return copie
	 * }
	 */

	private void initializeTab() {
		this.presenteEtBienPlace = new String[Constante.longueurCombinaison];
		this.presenteEtMalPlace = new String[Constante.longueurCombinaison];
		this.tabComp = new String[Constante.longueurCombinaison];
		this.copy = new String[Constante.longueurCombinaison];
		for (int i = 0; i < Constante.longueurCombinaison; i++) {
			presenteEtBienPlace[i] = null;
			presenteEtMalPlace[i] = null;
			tabComp[i] = null;
			copy[i] = null;
		}
	}
}
