package com;

import java.util.Arrays;

public class PlusOuMoinsDuel extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		System.out.println("\rNombre d'essais maximum : " + Constante.nombreEssai);
		int[] tabComputer = createTab();
		System.out.print("\rL'ordinateur a choisi : ");
		dev(tabComputer);
		int[] tabPlayer = askTab();
		System.out.print("\rLe joueur a entré la combinaison : ");
		dev(tabPlayer);
		boolean winC = false;
		boolean winJ = false;
		int nbrEssaiJoueur = 0;
		int nbrEssaiComputer = 0;

		int[] premierEssai = new int[Constante.longueurCombinaison];
		for (int i = 0; i < premierEssai.length; i++) {
			premierEssai[i] = 4;
		}

		System.out.println("\rL'ordinateur essaie avec : "+Arrays.toString(premierEssai));
//		System.out.print("\rL'ordinateur essaie avec : ");
//		dev(premierEssai);
		nbrEssaiComputer++;
		String resultat = compare(premierEssai, tabPlayer);
		System.out.println(resultat);

		while (!winJ && nbrEssaiJoueur < Constante.nombreEssai && !winC && nbrEssaiComputer < Constante.nombreEssai) {
			nbrEssaiJoueur++;
			nbrEssaiComputer++;
			int[] tentativesJoueur = askTab();
			System.out.print("\rLe joueur essaie avec : ");
			dev(tentativesJoueur);
			String compareResult = compare(tentativesJoueur, tabComputer);
			System.out.println(compareResult);
			winJ = compareResult.equals(resultatGagnant());
			premierEssai = createTabComputer(premierEssai, resultat);
			System.out.print("\rL'ordinateur essaie avec : ");
			dev(premierEssai);
			resultat = compare(premierEssai, tabPlayer);
			System.out.println(resultat);
			winC = resultat.equals(resultatGagnant());
		}
		if (winJ == true) {
			System.out.println("\rLe joueur gagne en " + nbrEssaiJoueur + " essai(s)");
		} else {
			System.out.println("\rVous avez perdu !");
		}

		if (winC == true) {
			System.out.println("\rL'ordinateur gagne en " + nbrEssaiComputer + " essai(s)");
		} else {
			System.out.println("\rL'ordinateur a perdu !");
		}
		optionsJeux();
	}
}
