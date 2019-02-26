package com;

public class PlusOuMoinsDefenseur extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		int[] tableauDefenseur = askTab();
		dev(tableauDefenseur);
		boolean win = false;
		
		int[] premierEssai = {4, 4, 4, 4};
		String resultat = compare(premierEssai, tableauDefenseur);
		System.out.println(resultat);
		win = resultat.equals("====");

		while (!win) {
			premierEssai = createTabComputer(premierEssai, resultat);
			dev(premierEssai);
			resultat = compare(premierEssai, tableauDefenseur);
			System.out.println(resultat);
			win = resultat.equals("====");
		}
	}
}
/*
 * 1234 ++=+ 2335 ++=+ 3436 ++=+ 4537 =+=+ 4638 =+== 4738 =+== 4838 =+== 4938
 * ====
 */
