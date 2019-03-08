package com;

import java.util.*;

public abstract class Game {

	protected int[] createTab() {
		int[] resultat = new int[Constante.longueurCombinaison];
		Random rand = new Random();
		for (int i = 0; i < resultat.length; i++) {
			resultat[i] = rand.nextInt(9);
		}
		return resultat;
	}

	protected void optionsJeux() {
		int choix = 0;
		System.out.println("\rVoulez-vous : ");
		System.out.println("1 - Rejouer");
		System.out.println("2 - Changer de jeu");
		System.out.println("3 - Quitter");
		Scanner sc = new Scanner(System.in);
		choix = sc.nextInt();
		while (choix >= 1 && choix <=3) {
			if (choix == 1) {
				jouer();
			} else if (choix == 2) {
				GameFactory.createGame(new Menu().runMenu()).jouer();
			} else {
				return;
			}
		}
	}

	protected int[] createTabComputer(int[] essaiPrecedent, String reponse) {

		char[] array = reponse.toCharArray();
		int[] tabResultat = new int[essaiPrecedent.length];
		for (int i = 0; i < essaiPrecedent.length; i++) {
			if (array[i] == '=') {
				tabResultat[i] = essaiPrecedent[i];
			} else if (array[i] == '+') {
				tabResultat[i] = essaiPrecedent[i] + 1;
			} else {
				tabResultat[i] = essaiPrecedent[i] - 1;
			}
		}
		return tabResultat;
	}

	protected int[] askTab() {
		int[] resultat = new int[Constante.longueurCombinaison];
		System.out.println("\rVeuillez entrer votre combinaison");
		Scanner sc = new Scanner(System.in);
		String result = sc.nextLine();
		for (int i = 0; i < resultat.length; i++) {
			// result.charAt(i) == result[i]
			String carac = Character.toString(result.charAt(i));
			// Conversion du string carac en int
			resultat[i] = Integer.parseInt(carac);
		}
		return resultat;
	}

	protected void dev(int[] tab) {
		// Constructeur d'affichage du tableau avec paramètre
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i]);
		}
		System.out.println();
	}

	protected String compare(int tableauDefenseur[], int tableauOrdinateur[]) {
		String resultat = "";
		for (int i = 0; i < tableauOrdinateur.length; i++) {

			if (tableauOrdinateur[i] == tableauDefenseur[i]) {
				resultat += "=";
			} else if (tableauOrdinateur[i] < tableauDefenseur[i]) {
				resultat += "-";
			} else if (tableauOrdinateur[i] > tableauDefenseur[i]) {
				resultat += "+";
			} else {
				break;
			}
		}
		return resultat;
	}

	public void jouer() {

	}
}