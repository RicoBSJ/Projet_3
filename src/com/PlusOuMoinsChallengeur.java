package com;

import java.util.Scanner;

public class PlusOuMoinsChallengeur extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		int[] tableauJeu = createTab();
		System.out.print("\rL'ordinateur a choisi : ");
		int[] tableauJoueur;
		dev(tableauJeu);
		boolean win = false;
		int nbrEssaiCh = 0;

		while (!win) {
			nbrEssaiCh++;
			tableauJoueur = askTab();
			System.out.print("\rVous essayez avec : ");
			dev(tableauJoueur);
			String compareResult = compare(tableauJoueur, tableauJeu);
			System.out.println(compareResult);
			win = compareResult.equals("====");
			if (win == true) {
				System.out.println("\rVous avez trouvé la combinaison en " + nbrEssaiCh + " essais");
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
