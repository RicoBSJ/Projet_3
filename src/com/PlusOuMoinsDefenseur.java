package com;

public class PlusOuMoinsDefenseur extends Game {

	public void jouer() {
		// A remplacer ensuite par une liste
		// Application de la méthode askTab() sur le tableau de int tableauDefenseur :
		// Le défenseur choisit 4 chiffres que l'ordinateur va devoir deviner
		int[] tableauDefenseur = askTab();
		// Application de la méthode dev sur tableauDefenseur
		dev(tableauDefenseur);
		// Intsanciation de la variable booléenne win, intialisée à false
		boolean win = false;
		
		// Instanciation du tableau de int premierEssai (l'ordinateur),
		// initialisé avec 4 int de valeur 4 chacun
		int[] premierEssai = {4, 4, 4, 4};
		// Application de la méthode compare, premierEssai et tableauDefenseur
		// en paramètres, sur le string resultat
		String resultat = compare(premierEssai, tableauDefenseur);
		// Affichage de resultat
		System.out.println(resultat);
		// Si les 4 int sont bons, l'ordinateur gagne
		win = resultat.equals("====");

		while (!win) {
			// Si les 4 int ne sont pas 4, 4, 4, 4 alors le programme entre dans la boucle while
			// Application de la méthode createTabComputer, premierEssai et resultat en paramètres,
			// sur premierEssai
			premierEssai = createTabComputer(premierEssai, resultat);
			// Application de la méthode dev sur premierEssai
			dev(premierEssai);
			// Application de la méthode compare, premierEssai et tableauDefenseur en paramètres,
			// sur resultat
			resultat = compare(premierEssai, tableauDefenseur);
			// Affichage de resultat
			System.out.println(resultat);
			// Si les 4 int sont bons, l'ordinateur gagne			
			win = resultat.equals("====");
		}
	}
}
/*
 * 1234 ++=+ 2335 ++=+ 3436 ++=+ 4537 =+=+ 4638 =+== 4738 =+== 4838 =+== 4938
 * ====
 */
