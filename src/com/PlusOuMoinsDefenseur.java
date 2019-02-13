package com;

public class PlusOuMoinsDefenseur extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		int[] tableauDefenseur = askTab();
		int[] tableauOrdinateur;
		dev(tableauDefenseur);
		boolean win = false;

		while (!win) {
			tableauOrdinateur = createTabComputer();
			dev(tableauOrdinateur);
			String compareResult = compare(tableauOrdinateur, tableauDefenseur);
			System.out.println(compareResult);
			win = compareResult.equals("====");
		}
	}
}
/*
 * 1234 ++=+ 2335 ++=+ 3436 ++=+ 4537 =+=+ 4638 =+== 4738 =+== 4838 =+== 4938
 * ====
 */
