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
	
	// Méthode pour mélanger les couleurs dans le tableau
	protected String[] createTabColor(String tabColor[]) {
		String[] tab = new String[Constante.longueurCombinaison];
	    for (int i = 0; i < Constante.longueurCombinaison; i++) {
	        int r = (int) random(0, tabColor.length);
	        tab[i] = tabColor[r];
	    }
	    return tab;
	}
	
	// Méthode de mélange aléatoire des couleurs
	protected double random(double min, double max) {
	    return min + Math.random() * (max - min);
	}

	protected void optionsJeux() {
		int choix = 0;
		System.out.println("\rVoulez-vous : ");
		System.out.println("1 - Rejouer");
		System.out.println("2 - Changer de jeu");
		System.out.println("3 - Quitter");
		Scanner sc = new Scanner(System.in);
		choix = sc.nextInt();
		switch (choix) {
		case 1:
			jouer();
			break;
		case 2:
			GameFactory.createGame(new Menu().runMenu()).jouer();
			break;
		default:
			break;
		}
	}

	protected String resultatGagnant() {
		String resultatGagnant = "";
		for (int i = 0; i < Constante.longueurCombinaison; i++) {
			resultatGagnant += "=";
		}
		return resultatGagnant;
	}
	
	// Surcharge de la méthode resultatGagnant
	protected String resultatGagnantColor() {
		String resultatGagnant = "";
		for (int i = 0; i < Constante.longueurCombinaison; i++) {
			resultatGagnant += "=";
		}
		return resultatGagnant;
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
		System.out.println("\rVeuillez entrer votre combinaison à " + Constante.longueurCombinaison + " chiffres : ");
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
	
	// Surcharge de la méthode askTab()
	protected String[] askTabColor() {
		String[] resultat = new String[Constante.longueurCombinaison];
		System.out.println("\rVeuillez entrer votre combinaison à " + Constante.longueurCombinaison + " couleurs : ");
		Scanner sc = new Scanner(System.in);
		String result = sc.nextLine();
		for (int i = 0; i < resultat.length; i++) {
			System.out.println("Couleurs: " + result);
//			// result.charAt(i) == result[i]
//			String carac = Character.toString(result.charAt(i));
//			// Conversion du string carac en int
//			resultat[i] = carac;
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
		// Surcharge de la méthode dev
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
	
	// Surcharge de la méthode compare()
	protected String compare(String tableauDefenseur[], String tableauOrdinateur[]) {
		String resultat = " ";
		for (int i = 0; i < tableauOrdinateur.length; i++) {
			if (tableauOrdinateur[i] == tableauDefenseur[i]) {
				resultat += "présent";
			} else if (tableauOrdinateur[i] != tableauDefenseur[i]) {
				resultat += "absent";
			} else {
				break;
			}
		}
		return resultat;
	}

	public void jouer() {

	}
}