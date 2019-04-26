package com;

import java.util.Arrays;

public class MastermindDefenseur extends Game {

	private String[] presenteEtBienPlace;
	private String[] presenteEtMalPlace;

	public void jouer() {
		// A remplacer ensuite par une liste
		initializeTab();
		System.out.println("\rL'ordinateur a droit à " + Constante.nombreEssai + " essais");
		String[] tableauDefenseur = askTabColor();
		System.out.print("\rLe défenseur a entré la combinaison : ");
		dev(tableauDefenseur);
		boolean win = false;
		int nbrEssaiDef = 0;

		String[] premierEssai = createTabColor(Constante.tabColor);
		System.out.println("\rL'ordinateur essaie avec : " + Arrays.toString(premierEssai));

		while (!win && nbrEssaiDef < Constante.nombreEssai) {
			nbrEssaiDef++;
			String[] essaiComputer = compareDefenseur(premierEssai, tableauDefenseur);
			System.out.println("\rL'ordinateur essaie avec : ");
			dev(essaiComputer);
			win = compare(tableauDefenseur, essaiComputer);
		}
		if (win == true) {
			System.out.println("\rL'ordinateur gagne en " + nbrEssaiDef + " essai(s)");
		} else {
			System.out.println("\rL'ordinateur a perdu !");
		}
		optionsJeux();
	}

	protected String[] compareDefenseur(String tableauJoueur[], String tableauJeu[]) {
		presenteEtMalPlace = tableauJoueur;
		presenteEtBienPlace = tableauJeu;
		int nbrPresent = 0;
		int nbrBienPlace = 0;
		String tmp;
		for (int i = 0; i < presenteEtMalPlace.length; i++) {
			for (int j = 0; j < presenteEtBienPlace.length; j++) {
				if (presenteEtMalPlace[i].equals(presenteEtBienPlace[j])) {
					nbrPresent++;
					tmp = presenteEtBienPlace[j];
					presenteEtBienPlace[j] = presenteEtMalPlace[i];
					presenteEtMalPlace[i] = tmp;
					if (i == j) {
						nbrBienPlace++;
						presenteEtBienPlace[j] = presenteEtMalPlace[i];
					}
				}
			}
		}
		System.out.println(nbrPresent + " couleurs sont présentes et " + nbrBienPlace + " sont bien placées");
		return presenteEtBienPlace;
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
