package com;

import java.util.Scanner;

public class Mastermind extends Game {

	private String[] createTabColor(int x, int y) {
		String[] tabColor = new String[4];
		String[] colors = { "bleu", "rouge", "blanc", "noir" };
		String tmp;
		tmp = colors[x];
		colors[x] = tabColor[y];
		tabColor[y] = tmp;
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
		String[] tabColorJeu = createTabColor(0, 0);
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
