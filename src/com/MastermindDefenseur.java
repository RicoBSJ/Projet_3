package com;

import java.util.Arrays;

public class MastermindDefenseur extends Game {

	private String[] presenteEtBienPlace;
	private String[] presenteEtMalPlace;
	private String[] copy;
	private int nbrEssaiDef = 0;

	public void jouer() {
		// A remplacer ensuite par une liste
		initializeTab();
		System.out.println("\rL'ordinateur a droit � " + Constante.nombreEssai + " essais");
		String[] tableauDefenseur = askTabColor();
		System.out.print("\rLe d�fenseur a entr� la combinaison : ");
		dev(tableauDefenseur);
		boolean win = false;

		String[] premierEssai = creerCombinaison();
		System.out.println("\rL'ordinateur essaie avec : " + Arrays.toString(premierEssai));

		while (!win && nbrEssaiDef < Constante.nombreEssai) {
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
		nbrEssaiDef++;
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
		System.out.print("presenteEtMalPlace :");
		System.out.println(Arrays.toString(presenteEtMalPlace));
		System.out.print("presenteEtBienPlace :");
		System.out.println(Arrays.toString(presenteEtBienPlace));
		System.out.println(nbrPresent + " couleurs sont pr�sentes et " + nbrBienPlace + " sont bien plac�es");
		return nbrBienPlace == tableauJeu.length;
	}

	private String[] creerCombinaison() {

		if (nbrEssaiDef == 0) {
			String tabComp[] = createTabColor(Constante.tabColor);
			if (nbrEssaiDef != 0) {
				tabComp = presenteEtBienPlace;
			}
			for (int i = 0; i < tabComp.length; i++) {
				copy = presenteEtBienPlace;
				if (presenteEtBienPlace[i] == null && presenteEtMalPlace[i] != null) {
					presenteEtBienPlace[i] = presenteEtMalPlace[i];
					if (presenteEtBienPlace[i] == null && presenteEtMalPlace[i] == null) {
						presenteEtMalPlace[i] = Constante.tabColor[i];
					}
					presenteEtBienPlace[i] = presenteEtMalPlace[i];
					presenteEtMalPlace[i] = null;
				}
			}
		}
		return copy;
	}

	/*
	 * private creerCombinaison { Si nbrEssaiDef = 0 > createTabColor Si nbrEssaiDef
	 * != 0 > récupérer presenteEtBienPlace for () { Créer une copie de
	 * presenteEtBienPlace Si l'index sur lequel on se trouve = null, on vérifie
	 * qu'il y des couleurs disponibles dans presenteEtMalPlace S'il y en a on prend
	 * une couleur qui remlacera null S'il n'y en a pas, on prend unr nouvelle
	 * couleur aléatoire dans presenteEtMalPlace On remplace null par cette couleur
	 * dans presenteEtBienPlace et cette couleur par null dans presenteEtMalPlace
	 * return copie }
	 */

	private void initializeTab() {
		this.presenteEtBienPlace = new String[Constante.longueurCombinaison];
		this.presenteEtMalPlace = new String[Constante.longueurCombinaison];
		this.copy = new String[Constante.longueurCombinaison];
		for (int i = 0; i < Constante.longueurCombinaison; i++) {
			presenteEtBienPlace[i] = null;
			presenteEtMalPlace[i] = null;
			copy[i] = null;
		}
	}
}
