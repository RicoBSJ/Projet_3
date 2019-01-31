package com;

import java.util.Random;
import java.util.Scanner;

public class Mastermind extends Game {
	
	private String[] createTabColor() {
		String[] tabColor = {" ", " ", " ", " "};
		String[] colors = {"bleu", "rouge", "blanc", "noir"};
		Random rand = new Random();
		for (int i = 0; i < tabColor.length; i++) {
			int j = rand.nextInt(5) + 1;
			colors[i] = tabColor[j];
			tabColor[i] = rand.nextLine();
		}
		return tabColor;
	}

//	String[] tabColor = {"bleu", "rouge", "blanc", "noir"};
//	int j = rand.nextInt(5) + 1; //ma variable j prend une valeur entre 1 et 6
//	couleurs[i] = tabCouleur[j];
	
		private String[] askTab() {

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
			String tabColor = "";
			for (int i = 0; i < tabColorJoueur.length; i++) {

				if (tabColorJoueur[i] == tabColorJeu[i]) {
					tabColor += "=";
				} else if (tabColorJoueur[i] < tabColorJeu[i]) {
					tabColor += "-";
				} else if (tabColorJoueur[i] > tabColorJeu[i]) {
					tabColor += "+";
				} else {
					break;
				}
			}
			return tabColor;
		}

		public void jouer() {
			// A remplacer ensuite par une liste
			String[] tabColorJeu = createTabColor();
			String[] tabColorJoueur;
			dev(tabColorJeu);
			boolean win = false;

			while (!win) {
				tabColorJoueur = askTab();
				dev(tabColorJoueur);
				String compareResult = compare(tabColorJoueur, tabColorJeu);
				System.out.println(compareResult);
				win = compareResult.equals("====");
			}
		}

}
