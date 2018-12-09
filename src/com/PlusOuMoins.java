package com;

import java.util.Random;
import java.util.Scanner;

public class PlusOuMoins extends Game {

	public void jouer() {

		int[] myTab = new int[4];
		int Nombre, essais = 0;
		Random rand = new Random();
		int NombreMystere = rand.nextInt(101);

		System.out.println("Je joue à Plus ou Moins");
		System.out.println("Trouvez le nombre mystere entre 0 et 100 !");

		Scanner nombre = new Scanner(System.in);
		System.out.println("Veuillez entrer un nombre...");
		Nombre = nombre.nextInt();

		if (Nombre < NombreMystere || Nombre != NombreMystere) {
			System.out.println("C'est plus ! ");
			essais++;
		} else if (Nombre > NombreMystere) {
			System.out.println("C'est moins !");
			essais++;
		} else {
			System.out.println("Trouver en " + essais + " essais ! Bien Joué !");
		}
	}
}