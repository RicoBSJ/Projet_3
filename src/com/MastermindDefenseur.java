package com;

public class MastermindDefenseur extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		System.out.println("\rL'ordinateur a droit à " + Constante.nombreEssai + " essais");
		String[] tableauDefenseur = askTabColor();
		System.out.print("\rLe défenseur a entré la combinaison : ");
		dev(tableauDefenseur);
		boolean win = false;
		int nbrEssaiDef = 0;

		while (!win && nbrEssaiDef < Constante.nombreEssai) {
			nbrEssaiDef++;
			String[]essaiComputer = createTabColor(Constante.tabColor);
			System.out.print("\rL'ordinateur essaie avec : ");
			dev(essaiComputer);
			win = compare(essaiComputer, tableauDefenseur);
		}
		if (win == true) {
			System.out.println("\rL'ordinateur gagne en " + nbrEssaiDef + " essai(s)");
		} else {
			System.out.println("\rL'ordinateur a perdu !");
		}
		optionsJeux();
	}

}
