package com;

import java.util.Arrays;

public class MastermindDefenseur extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		System.out.println("\rL'ordinateur a droit à " + Constante.nombreEssai + " essais");
		String[] tableauDefenseur = askTabColor();
		System.out.print("\rLe défenseur a entré la combinaison : ");
		dev(tableauDefenseur);
		boolean win = false;
		int nbrEssaiDef = 0;
		
		String[] premierEssai = new String[Constante.longueurCombinaison];
		for (int i = 0; i < premierEssai.length; i++) {
			premierEssai[i] = "bleu";
		}
		System.out.print("\rL'ordinateur essaie avec : "+Arrays.toString(premierEssai));
		boolean resultat = compare(premierEssai, tableauDefenseur);
		System.out.println(resultat);

		while (!win && nbrEssaiDef < Constante.nombreEssai) {
			nbrEssaiDef++;
			String[]essaiComputer = createTabCompColor(premierEssai, resultat);
			System.out.print("\rL'ordinateur essaie avec : ");
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

}
