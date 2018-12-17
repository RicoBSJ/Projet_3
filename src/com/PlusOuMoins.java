package com;

import java.util.Random;
import java.util.Scanner;

public class PlusOuMoins extends Game {
	private int[] createTab() {
		int[] resultat = {0,0,0,0};
		Random rand = new Random();
		for (int i = 0; i < resultat.length; i++)
		{
			resultat[i] = rand.nextInt(9);
		}
		return resultat;
	}
	private int[] askTab() {
		int[] resultat = {0,0,0,0};
		System.out.println("Veuillez taper 4 chiffres :");
		Scanner sc = new Scanner(System.in);
		String result = sc.nextLine();
		for (int i = 0; i < resultat.length; i++) {
			String carac = Character.toString(result.charAt(i));
			resultat [i] = Integer.parseInt(carac);
		}
		return resultat;
	}
	private void dev(int[] tab) {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i]);
		}
		System.out.println();
	}
//	private String compare(int tableauJeu[],int tableauJoueur[]) {
//		for (int i = 0; )
//	}

	public void jouer() {
		// A remplacer ensuite par une liste
		int[] tableauJeu = createTab();
		int[] tableauJoueur;
		int i = 0;
		dev(tableauJeu);
		
		while (true) {
			tableauJoueur = askTab();
			dev(tableauJoueur);
		}

//		if (i >= tableauJeu.length) {
//			if (nbr1 != tableauJeu[i])
//				System.out.println("Le chiffre 1 ne se trouve pas dans le tableau !");
//			else if (nbr1 == tableauJeu[i])
//				System.out.println("Le chiffre 1 se trouve pas dans le tableau !");
//			if (nbr2 != tableauJeu[i])
//				System.out.println("Le chiffre 2 ne se trouve pas dans le tableau !");
//			else if (nbr2 == tableauJeu[i])
//				System.out.println("Le chiffre 2 se trouve pas dans le tableau !");
//			if (nbr3 != tableauJeu[i])
//				System.out.println("Le chiffre 3 ne se trouve pas dans le tableau !");
//			else if (nbr3 == tableauJeu[i])
//				System.out.println("Le chiffre 3 se trouve pas dans le tableau !");
//			if (nbr4 != tableauJeu[i])
//				System.out.println("Le chiffre 4 ne se trouve pas dans le tableau !");
//			else if (nbr4 == tableauJeu[i])
//				System.out.println("Le chiffre 4 se trouve pas dans le tableau !");
//		}
	}
}

// do {
// System.out.println("Voulez-vous essayer � nouveau ? (O/N)");
// reponse = sc.nextLine().charAt(0);
// } while (reponse != 'N' && reponse != 'O');
// }while(reponse=='O');
//
// System.out.println("Au revoir !");
// }}