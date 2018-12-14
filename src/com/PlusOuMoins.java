package com;

import java.util.Random;
import java.util.Scanner;

public class PlusOuMoins extends Game {

	public void jouer() {
		int nbr1 = 0, nbr2 = 0, nbr3 = 0, nbr4 = 0;
		int[] tableauJeu = { nbr1, nbr2, nbr3, nbr4 };
		Random rand = new Random();
		int i = 0;
		char reponse = ' ';
		Scanner sc = new Scanner(System.in);

		do {// Boucle principale

			do {// On répète cette boucle tant que l'utilisateur n'a pas rentré une lettre
				// figurant dans le tableau
				i = 0;
				System.out.println("Rentrez un chiffre, SVP ");
				j1 = sc.toString();
				sc.nextLine();
				System.out.println("Rentrez un chiffre, SVP ");
				j2 = sc.toString();
				sc.nextLine();
				System.out.println("Rentrez un chiffre, SVP ");
				j3 = sc.toString();
				sc.nextLine();
				System.out.println("Rentrez un chiffre, SVP ");
				j4 = sc.toString();
				sc.nextLine();
				// Boucle de recherche dans le tableau
				while (i < tableauJeu.length && "j1" != tableauJeu[i])
					i++;

				// Si i < 7 c'est que la boucle n'a pas dépassé le nombre de cases du tableau
				if (i < tableauJeu.length) {
					System.out.println("Le chiffre 1 se trouve bien dans le tableau !");
					System.out.println("Le chiffre 2 se trouve bien dans le tableau !");
					System.out.println("Le chiffre 3 se trouve bien dans le tableau !");
					System.out.println("Le chiffre 4 se trouve bien dans le tableau !");
				} else { // Sinon
					System.out.println("Le chiffre 1 ne se trouve pas dans le tableau !");
					System.out.println("Le chiffre 2 ne se trouve pas dans le tableau !");
					System.out.println("Le chiffre 3 ne se trouve pas dans le tableau !");
					System.out.println("Le chiffre 4 ne se trouve pas dans le tableau !");
				}
			} while (i >= tableauJeu.length);

			// Tant que la lettre de l'utilisateur ne correspond pas à une lettre du tableau
			do {
				System.out.println("Voulez-vous essayer à nouveau ? (O/N)");
				reponse = sc.nextLine().charAt(0);
			} while (reponse != 'N' && reponse != 'O');
		} while (reponse == 'O');

		System.out.println("Au revoir !");
	}
}