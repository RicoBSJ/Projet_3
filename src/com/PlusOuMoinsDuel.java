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

		System.out.println("L'ordinateur essaie avec : 4444");
//		int[] premierEssai = { 4, 4, 4, 4 };
		int[] premierEssai = new int[Constante.longueurCombinaison];
		for (int i = 0; i < premierEssai.length; i++) {
			premierEssai[i] = 4;
		}
		String resultat = compare(premierEssai, tabPlayer);
		System.out.println(resultat);

		while (!win) {
			int[] tentativesJoueur = askTab();
			System.out.print("\rLe joueur essaie avec : ");
			dev(tentativesJoueur);
			String compareResult = compare(tentativesJoueur, tabComputer);
			System.out.println(compareResult);
			win = compareResult.equals("====");
			if (win == true) {
				System.out.println("Le joueur gagne !");
				break;
			}
			premierEssai = createTabComputer(premierEssai, resultat);
			System.out.print("\rL'ordinateur essaie avec : ");
			dev(premierEssai);
			resultat = compare(premierEssai, tabPlayer);
			System.out.println(resultat);
			win = resultat.equals("====");
			if (win == true) {
				System.out.println("\rL'ordinateur gagne !");
				break;
			}
		}
	}
}
