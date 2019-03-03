package com;

public class PlusOuMoinsDuel extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		int[] tabComputer = createTab();
		System.out.print("\rL'ordinateur a choisi : ");
		dev(tabComputer);
		int[] tabPlayer = askTab();
		System.out.print("\rLe joueur a entré la combinaison : ");
		dev(tabPlayer);
		boolean win = false;
		int nbrEssaiJoueur = 0;
		int nbrEssaiComputer = 0;

		System.out.println("\rL'ordinateur essaie avec : 4444");
		int[] premierEssai = new int[Constante.longueurCombinaison];
		for (int i = 0; i < premierEssai.length; i++) {
			premierEssai[i] = 4;
		}
		nbrEssaiComputer++;
		String resultat = compare(premierEssai, tabPlayer);
		System.out.println(resultat);

		while (!win) {
			nbrEssaiJoueur++;
			nbrEssaiComputer++;
			boolean winJ = false;
			boolean winC = false;
			int[] tentativesJoueur = askTab();
			System.out.print("\rLe joueur essaie avec : ");
			dev(tentativesJoueur);
			String compareResult = compare(tentativesJoueur, tabComputer);
			System.out.println(compareResult);
			winJ = compareResult.equals("====");
			premierEssai = createTabComputer(premierEssai, resultat);
			System.out.print("\rL'ordinateur essaie avec : ");
			dev(premierEssai);
			resultat = compare(premierEssai, tabPlayer);
			System.out.println(resultat);
			winC = resultat.equals("====");
			if (winJ == true) {
				System.out.println("\rLe joueur gagne en " +nbrEssaiJoueur+ " essai(s)");
				optionsJeux();
			} else if (winC == true) {
				System.out.println("\rL'ordinateur gagne en " +nbrEssaiComputer+ " essai(s)");
				optionsJeux();
			}
		}
	}
}
