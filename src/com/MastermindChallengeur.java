package com;

public class MastermindChallengeur extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		System.out.println("\rVous avez droit à " + Constante.nombreEssai + " essais");
		int[] tableauJeu = createTab();
		System.out.print("\rL'ordinateur a choisi : ");
		int[] tableauJoueur;
		dev(tableauJeu);
		boolean win = false;
		int nbrEssaiCh = 0;

		while (!win && nbrEssaiCh < Constante.nombreEssai) {
			nbrEssaiCh++;
			tableauJoueur = askTab();
			System.out.print("\rVous essayez avec : ");
			dev(tableauJoueur);
			String compareResult = compare(tableauJoueur, tableauJeu);
			System.out.println(compareResult);
			win = compareResult.equals(resultatGagnant());
		}
		if (win == true) {
			System.out.println("\rVous avez trouvé la combinaison en " + nbrEssaiCh + " essai(s)");
		} else {
			System.out.println("\rVous avez perdu !");
		}
		optionsJeux();
	}
}
/*
 * (Combinaison secrète : 1234)

Proposition : 4278 -> Réponse : 1 présent, 1 bien placé
Proposition : 6274 -> Réponse : 2 bien placés
...
*/
