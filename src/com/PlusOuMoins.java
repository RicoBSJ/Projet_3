package com;

import java.util.Scanner;

public class PlusOuMoins extends Game {

	public void jouer() {
		int tableauJeu[] = {0, 0, 0, 0};
		int i = 0;
		char reponse = ' ';
		int nbr = ' ';
		Scanner sc = new Scanner(System.in);

		do {// Boucle principale
			do {// On répète cette boucle tant que l'utilisateur n'a pas rentré une lettre
				// figurant dans le tableau
				i = 0;
				System.out.println("Rentrez un chiffre, SVP ");
				
				nbr = sc.nextInt();
				sc.nextLine();
				// Boucle de recherche dans le tableau
				while (i < tableauJeu.length && nbr != tableauJeu[i])
					i++;

				// Si i < 7 c'est que la boucle n'a pas dépassé le nombre de cases du tableau
				if (i < tableauJeu.length)
					System.out.println("Le chiffre " + nbr + " se trouve bien dans le tableau !");
				else // Sinon
					System.out.println("Le chiffre " + nbr + " ne se trouve pas dans le tableau !");

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