package com;

import java.util.Arrays;

public class MastermindDefenseur extends Game {

	private String[] presenteEtBienPlace;
	private String[] presenteEtMalPlace;

	public void jouer() {
		// A remplacer ensuite par une liste
		initializeTab();
		System.out.println("\rL'ordinateur a droit � " + Constante.nombreEssai + " essais");
		String[] tableauDefenseur = askTabColor();
		System.out.print("\rLe d�fenseur a entr� la combinaison : ");
		dev(tableauDefenseur);
		boolean win = false;
		int nbrEssaiDef = 0;

		String[] premierEssai = createTabColor(Constante.tabColor);
		System.out.println("\rL'ordinateur essaie avec : " + Arrays.toString(premierEssai));

		while (!win && nbrEssaiDef < Constante.nombreEssai) {
			++nbrEssaiDef;
			win = compareDefenseur(premierEssai, tableauDefenseur);
//			String str = String.valueOf(resultat);
//			String[] strArray = str.split(" ");
//			System.out.println("\rL'ordinateur essaie avec : ");
//			dev(strArray);
//			win = compare(tableauDefenseur, presenteEtBienPlace);
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
					presenteEtMalPlace[i] = tableauJoueur[i];
					decaler(presenteEtMalPlace, 2);
				}
				if (i == j) {
					nbrBienPlace++;
					presenteEtBienPlace[i] = tableauJoueur[j];
				}
			}
		}
		System.out.println(nbrPresent + " couleurs sont pr�sentes et " + nbrBienPlace + " sont bien plac�es");
		return nbrBienPlace == tableauJeu.length;
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
