package com;

public class PlusOuMoins extends Game {

	public void jouer() {
		
		int tab[] = new int[4];
		
for (int i = 0; i < tab.length; i++) {
	System.out.println("A l'emplacement " + i + " du tableau, nous avons = " + tab[i]);
}
	}
}
		
		/*
		do {
			Scanner nombre = new Scanner(System.in);
			System.out.println("Veuillez entrer un nombre...");
			Nombre = nombre.nextInt();

			if (Nombre < NombreMystere) {
				System.out.println("C'est plus ! ");
				essais++;
			} else if (Nombre > NombreMystere) {
				System.out.println("C'est moins !");
				essais++;
			} else {
				System.out.println("Trouver en " + essais + " essais ! Bien Joué !");
			}
		} while (Nombre != NombreMystere);
		*/
