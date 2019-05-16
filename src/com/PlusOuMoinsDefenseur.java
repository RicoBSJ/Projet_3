package com;

import java.util.Arrays;

public class PlusOuMoinsDefenseur extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		System.out.println("\rL'ordinateur a droit à " + Constante.nombreEssai + " essais");
		int[] tableauDefenseur = askTab();
		System.out.print("Le défenseur a entré la combinaison : ");
		dev(tableauDefenseur);
		boolean win = false;
		int nbrEssaiDef = 0;

		int[] premierEssai = new int[Constante.longueurCombinaison];
		for (int i = 0; i < premierEssai.length; i++) {
			premierEssai[i] = 4;
		}
		System.out.print("\rL'ordinateur essaie avec : "+Arrays.toString(premierEssai));
		String resultat = compare(premierEssai, tableauDefenseur);
		System.out.println(resultat);
		win = resultat.equals(resultatGagnant());

		while (!win && nbrEssaiDef < Constante.nombreEssai) {
			nbrEssaiDef++;
			premierEssai = createTabComputer(premierEssai, resultat);
			System.out.print("\rL'ordinateur essaie avec : ");
			dev(premierEssai);
			resultat = compare(premierEssai, tableauDefenseur);
			System.out.println(resultat);
			win = resultat.equals(resultatGagnant());
		}
		if (win == true) {
			System.out.println("\rL'ordinateur gagne en " + nbrEssaiDef + " essai(s)");
		} else {
			System.out.println("\rL'ordinateur a perdu !");
		}
		optionsJeux();
	}
}
/*
 * 1234 ++=+ 2335 ++=+ 3436 ++=+ 4537 =+=+ 4638 =+== 4738 =+== 4838 =+== 4938
 * ====
 */
