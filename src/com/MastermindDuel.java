package com;

import java.util.Arrays;

public class MastermindDuel extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		System.out.println("\rNombre d'essais maximum : " + Constante.nombreEssai);
		String[] tabComputer = createTabColor(Constante.tabColor);
		System.out.print("\rL'ordinateur a choisi : ");
		dev(tabComputer);
		String[] tabPlayer = askTabColor();
		System.out.print("\rLe joueur a entré la combinaison : ");
		dev(tabPlayer);
		boolean winC = false;
		boolean winJ = false;
		int nbrEssaiJoueur = 0;
		int nbrEssaiComputer = 0;
		
		String[] premierEssai = new String[Constante.longueurCombinaison];
		for (int i = 0; i < premierEssai.length; i++) {
			premierEssai[i] = "jaune";
		}

		System.out.println("\rL'ordinateur essaie avec : "+Arrays.toString(premierEssai));
		nbrEssaiComputer++;
		boolean resultat = compare(premierEssai, tabPlayer);
		System.out.println(resultat);

		while (!winJ && nbrEssaiJoueur < Constante.nombreEssai && !winC && nbrEssaiComputer < Constante.nombreEssai) {
			nbrEssaiJoueur++;
			nbrEssaiComputer++;
			String[] tentativesJoueur = askTabColor();
			System.out.print("\rLe joueur essaie avec : ");
			dev(tentativesJoueur);
			winJ = compare(tentativesJoueur, tabComputer);
			String[] essaiComputer = createTabCompColor(premierEssai, resultat);
			System.out.print("\rL'ordinateur essaie avec : ");
			dev(essaiComputer);
			winC = compare(essaiComputer, tabPlayer);
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
