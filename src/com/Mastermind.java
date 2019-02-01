package com;

import java.util.Scanner;

public class Mastermind extends Game {

	private String[] createTabColor() {
		String[] tabColor = new String[4];
		String[] colors = { "bleu", "rouge", "blanc", "noir" };
		tabColor[0] = colors[0];
		tabColor[1] = colors[1];
		tabColor[2] = colors[2];
		tabColor[3] = colors[3];
		for (String string : tabColor) {
			System.out.println(string);
		}
		return tabColor;
	}

	private String[] askTabColor() {

		String[] tabColor = { " ", " ", " ", " " };
		System.out.println("Veuillez taper 4 couleurs :");
		Scanner sc = new Scanner(System.in);
		String result = sc.nextLine();
		for (int i = 0; i < tabColor.length; i++) {
			String str = Character.toString(result.charAt(i));
			tabColor[i] = toString();
		}
		return tabColor;
	}

	private void dev(String[] tabColor) {
		for (int i = 0; i < tabColor.length; i++) {
			System.out.print(tabColor[i]);
		}
		System.out.println();
	}

	private String compare(String tabColorJeu[], String tabColorJoueur[]) {
		String tabAnswer = "";
		for (int i = 0; i < tabColorJoueur.length; i++) {

			if (tabColorJoueur[i] == tabColorJeu[i]) {
				tabAnswer += "true";
			} else if (tabColorJoueur[i] != tabColorJeu[i]) {
				tabAnswer += "false";
			} else {
				break;
			}
		}
		return tabAnswer;
	}

	public void jouer() {
		// A remplacer ensuite par une liste
		String[] tabColorJeu = createTabColor();
		String[] tabColorJoueur;
		dev(tabColorJeu);
		boolean win = false;

		while (!win) {
			tabColorJoueur = askTabColor();
			dev(tabColorJoueur);
			String compareResult = compare(tabColorJoueur, tabColorJeu);
			System.out.println(compareResult);
			win = compareResult.equals("====");
		}
	}
}
