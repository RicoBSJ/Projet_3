package com;

public class PlusOuMoinsDefenseur extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		System.out.println("\rL'ordinateur a droit � " +Constante.nombreEssai+ " essais");
		int[] tableauDefenseur = askTab();
		System.out.print("Le défenseur a entré la combinaison : ");
		dev(tableauDefenseur);
		boolean win = false;
		int nbrEssaiDef = 0;
		
		System.out.println("\rL'ordinateur essaie avec : 4444");
		int[] premierEssai = new int[Constante.longueurCombinaison];
		for (int i = 0; i < premierEssai.length; i++) {
			premierEssai[i] = 4;
		}
		nbrEssaiDef++;
		String resultat = compare(premierEssai, tableauDefenseur);
		System.out.println(resultat);
		win = resultat.equals("====");

		while (!win) {
			nbrEssaiDef++;
			Constante.nbrEssai++;
			premierEssai = createTabComputer(premierEssai, resultat);
			System.out.print("\rL'ordinateur essaie avec : ");
			dev(premierEssai);
			resultat = compare(premierEssai, tableauDefenseur);
			System.out.println(resultat);
			win = resultat.equals("====");
			if (Constante.nbrEssai == Constante.nombreEssai) {
				System.out.println("\rL'ordinateur a perdu !");
				optionsJeux();
			}
			if (win == true) {
				System.out.println("\rL'ordinateur gagne en " +nbrEssaiDef+ " essai(s)");
				optionsJeux();
			}
		}
	}
}
/*
 * 1234 ++=+ 2335 ++=+ 3436 ++=+ 4537 =+=+ 4638 =+== 4738 =+== 4838 =+== 4938
 * ====
 */
