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
		boolean resultat = compare(premierEssai, tableauDefenseur);

		while (!win && nbrEssaiDef < Constante.nombreEssai) {
			nbrEssaiDef++;
			String[] essaiComputer = compareDefenseur(premierEssai, resultat);
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

	protected String[] compareDefenseur(String tableauJoueur[], boolean resultat) {
		String str = String.valueOf(resultat);
		String[] strArray = str.split(" ");
		int nbrPresent = 0;
		int nbrBienPlace = 0;
		String temp;
		for (int i = 0; i < tableauJoueur.length; i++) {
			for (int j = 0; j < strArray.length; j++) {
				if (tableauJoueur[i].equals(strArray[j])) {
					nbrPresent++;
			        temp = presenteEtMalPlace[i];
			        presenteEtMalPlace[i] = strArray[j];
			        strArray[j] = temp;
					if (i == j) {
						nbrBienPlace++;
						presenteEtBienPlace[i] = strArray[j];
					}
				}
			}
		}
		System.out.println(nbrPresent + " couleurs sont pr�sentes et " + nbrBienPlace + " sont bien plac�es");
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
