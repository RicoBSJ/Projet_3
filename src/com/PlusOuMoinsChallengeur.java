package com;

public class PlusOuMoinsChallengeur extends Game {
	
	public void jouer() {
		// A remplacer ensuite par une liste
		int[] tableauJeu = createTab();
		System.out.print("\rL'ordinateur a choisi : ");
		int[] tableauJoueur;
		dev(tableauJeu);
		boolean win = false;
		int eCh = 0;

		while (!win) {
			eCh++;
			tableauJoueur = askTab();
			System.out.print("\rLe joueur essaie avec : ");
			dev(tableauJoueur);
			String compareResult = compare(tableauJoueur, tableauJeu);
			System.out.println(compareResult);
			win = compareResult.equals("====");
			if (win == true) {
				System.out.print("\rLe joueur a trouvé la combinaison en ");
				System.out.print(eCh);
				System.out.print(" essais");
				break;
			}
		}
	}
}
