package com;

import java.util.Random;
import java.util.Scanner;

public class PlusOuMoins extends Game {
	private int[] createTab() {
		int[] resultat = { 0, 0, 0, 0 };
		Random rand = new Random();
		for (int i = 0; i < resultat.length; i++) {
			resultat[i] = rand.nextInt(9);
		}
		return resultat;
	}

	private int[] askTab() {
		int[] resultat = { 0, 0, 0, 0 };
		System.out.println("Veuillez taper 4 chiffres :");
		Scanner sc = new Scanner(System.in);
		String result = sc.nextLine();
		for (int i = 0; i < resultat.length; i++) {
			String carac = Character.toString(result.charAt(i));
			resultat[i] = Integer.parseInt(carac);
		}
		return resultat;
	}

	private void dev(int[] tab) {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i]);
		}
		System.out.println();
	}

	private String compare(int tableauJeu[], int tableauJoueur[]) {
		for (int i = 0; i < tableauJeu.length; i++) {
			for (int j = 0; j < tableauJoueur.length; j++) {
<<<<<<< HEAD
				if (tableauJeu[i] == tableauJoueur[j]) {
					System.out.println("OK");
				} else {
					System.out.println("Tableaux différents !");
				}
=======
			if (tableauJeu[i] == tableauJoueur[j]) {
				System.out.println("OK");
			}
			else {
				System.out.println("Tableaux diffï¿½rents !");
>>>>>>> branch 'master' of https://github.com/RicoBSJ/Projet_3.git
			}
		}
<<<<<<< HEAD
		return compare();
=======
			result compare();
		}
>>>>>>> branch 'master' of https://github.com/RicoBSJ/Projet_3.git
	}

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
<<<<<<< HEAD

	// ************* ACCESSEURS *************

	// Retourne le nom de la ville
	public int getCreate {
		return createTab;
	}

	// Retourne le nom du pays
	public String getCompare() {
		return nomPays;
	}

	// Retourne le nombre d'habitants
	public int getNombreHabitants() {
		return nbreHabitants;
	}

	// ************* MUTATEURS *************

	// Définit le nom de la ville
	public void setNom(String pNom) {
		nomVille = pNom;
	}

	// Définit le nom du pays
	public void setNomPays(String pPays) {
		nomPays = pPays;
	}

	// Définit le nombre d'habitants
	public void setNombreHabitants(int nbre)
		  {
		    nbreHabitants = nbre;
		  }
=======
>>>>>>> branch 'master' of https://github.com/RicoBSJ/Projet_3.git
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> branch 'master' of https://github.com/RicoBSJ/Projet_3.git
