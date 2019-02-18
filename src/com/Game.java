package com;

import java.util.*;

public abstract class Game {

	protected int[] createTab() {
		int[] resultat = { 0, 0, 0, 0 };
		Random rand = new Random();
		for (int i = 0; i < resultat.length; i++) {
			resultat[i] = rand.nextInt(9);
		}
		return resultat;
	}

	protected String[] createTabColor() {

		String[] resultat = { " ", " ", " ", " " };
		String bleu = "bleu";
		String rouge = "rouge";
		String blanc = "blanc";
		String noir = "noir";
		
		int value = Integer.parseInt(bleu);

		return value;
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

	protected String[] askTabColor() {

		String[] resultat = { " ", " ", " ", " " };
		System.out.println("Veuillez taper 4 couleurs :");
		Scanner sc = new Scanner(System.in);
		String result = sc.nextLine();
		for (int i = 0; i < resultat.length; i++) {
			String str = Character.toString(result.charAt(i));
			resultat[i] = toString();
		}
		return resultat;
	}

	protected void dev(int[] tab) {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i]);
		}
		System.out.println();
	}

	protected void dev(String[] tab) {
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

	protected String compareString(String tabColorJeu[], String tabColorJoueur[]) {
		String resultat = "";
		for (int i = 0; i < tabColorJoueur.length; i++) {

			if (tabColorJoueur[i] == tabColorJeu[i]) {
				resultat += "true";
			} else if (tabColorJoueur[i] != tabColorJeu[i]) {
				resultat += "false";
			} else {
				break;
			}
		}
		return resultat;
	}

	public void jouer() {

	}
}
