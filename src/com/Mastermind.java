package com;

import java.util.Random;
import java.util.Scanner;

public class Mastermind extends Game {
	
	private String[] createTabColor() {
		String[] tabColor = {"jaune", "bleu", "rouge", "vert", "blanc", "noir"};
		
		return tabColor;
		}

		private String[] askTab() {

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

		private void dev(String[] tabColor) {
			for (int i = 0; i < tabColor.length; i++) {
				System.out.print(tabColor[i]);
			}
			System.out.println();
		}

		private String compare(String tabColorJeu[], String tabColorJoueur[]) {
			String resultat = "";
			for (int i = 0; i < tabColorJoueur.length; i++) {

				if (tabColorJoueur[i] == tabColorJeu[i]) {
					resultat += "=";
				} else if (tabColorJoueur[i] < tabColorJeu[i]) {
					resultat += "-";
				} else if (tabColorJoueur[i] > tabColorJeu[i]) {
					resultat += "+";
				} else {
					break;
				}
			}
			return resultat;
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
