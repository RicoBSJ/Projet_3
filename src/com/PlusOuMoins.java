package com;

import java.util.Random;
import java.util.Scanner;

public class PlusOuMoins extends Game {

	public void jouer() {
		int nbr1 = 0, nbr2 = 0, nbr3 = 0, nbr4 = 0;
		int[] tableauJeu = { nbr1, nbr2, nbr3, nbr4 };
		Random rand = new Random();
		int tableauRand = rand.nextInt();
		int i = 0;
		char reponse = ' ';
		Scanner sc = new Scanner(System.in);

		for (i = 0; i < tableauJeu.length; i++) {
			System.out.println("Rentrez 4 chiffres, SVP ");
			tableauJeu = sc.nextInt();
			sc.nextLine();
		}

		// Boucle de recherche dans le tableau

		// Si i < 7 c'est que la boucle n'a pas dépassé le nombre de cases du tableau

		if (i >= tableauJeu.length) {
			if (nbr1 != tableauJeu[i])
				System.out.println("Le chiffre 1 ne se trouve pas dans le tableau !");
			else if (nbr1 == tableauJeu[i])
				System.out.println("Le chiffre 1 se trouve pas dans le tableau !");
			if (nbr2 != tableauJeu[i])
				System.out.println("Le chiffre 2 ne se trouve pas dans le tableau !");
			else if (nbr2 == tableauJeu[i])
				System.out.println("Le chiffre 2 se trouve pas dans le tableau !");
			if (nbr3 != tableauJeu[i])
				System.out.println("Le chiffre 3 ne se trouve pas dans le tableau !");
			else if (nbr3 == tableauJeu[i])
				System.out.println("Le chiffre 3 se trouve pas dans le tableau !");
			if (nbr4 != tableauJeu[i])
				System.out.println("Le chiffre 4 ne se trouve pas dans le tableau !");
			else if (nbr4 == tableauJeu[i])
				System.out.println("Le chiffre 4 se trouve pas dans le tableau !");
		}
	}
}

//			do {
//				System.out.println("Voulez-vous essayer à nouveau ? (O/N)");
//				reponse = sc.nextLine().charAt(0);
//			} while (reponse != 'N' && reponse != 'O');
//		}while(reponse=='O');
//
//	System.out.println("Au revoir !");
//}}