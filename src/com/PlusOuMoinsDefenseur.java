package com;

import java.util.Scanner;

public class PlusOuMoinsDefenseur extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
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
		nbrEssaiDef = 1;
		String resultat = compare(premierEssai, tableauDefenseur);
		System.out.println(resultat);
		win = resultat.equals("====");

		while (!win) {
			nbrEssaiDef++;
			premierEssai = createTabComputer(premierEssai, resultat);
			System.out.print("\rL'ordinateur essaie avec : ");
			dev(premierEssai);
			resultat = compare(premierEssai, tableauDefenseur);
			System.out.println(resultat);
			win = resultat.equals("====");
			if (win == true) {
				System.out.println("\rL'ordinateur gagne en " +nbrEssaiDef+ " essai(s)");
				System.out.println("\rVoulez-vous : ");
				System.out.println("4 - Rejouer");
				System.out.println("5 - Changer de jeu");
				System.out.println("6 - Quitter");
				Scanner sc = new Scanner(System.in);
				int choix = sc.nextInt();
				if (choix == 4) {
					jouer();
				} else if (choix == 5) {
					GameFactory.createGame(new Menu().runMenu()).jouer();
				} else if (choix == 6) {
					break;
				}
			}
		}
	}
}
/*
 * 1234 ++=+ 2335 ++=+ 3436 ++=+ 4537 =+=+ 4638 =+== 4738 =+== 4838 =+== 4938
 * ====
 */
