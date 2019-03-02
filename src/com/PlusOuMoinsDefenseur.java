package com;

public class PlusOuMoinsDefenseur extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		int[] tableauDefenseur = askTab();
		System.out.print("Le défenseur a entré la combinaison : ");
		dev(tableauDefenseur);
		boolean win = false;
		int eD = 0;
		
		System.out.println("\rL'ordinateur essaie avec : 4444");
		int[] premierEssai = new int[Constante.longueurCombinaison];
		for (int i = 0; i < premierEssai.length; i++) {
			premierEssai[i] = 4;
		}
		String resultat = compare(premierEssai, tableauDefenseur);
		System.out.println(resultat);
		win = resultat.equals("====");

		while (!win) {
			eD++;
			premierEssai = createTabComputer(premierEssai, resultat);
			dev(premierEssai);
			resultat = compare(premierEssai, tableauDefenseur);
			System.out.println(resultat);
			win = resultat.equals("====");
			if (win == true) {
				System.out.print("\rL'ordinateur gagne en ");
				System.out.print(eD+1);
				System.out.print(" essais");
				break;
			}
		}
	}
}
/*
 * 1234 ++=+ 2335 ++=+ 3436 ++=+ 4537 =+=+ 4638 =+== 4738 =+== 4838 =+== 4938
 * ====
 */
