package com;

import java.util.*;

public abstract class Game {

	private int nbrBienPlace;

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
		sc.close();
	}

	protected String resultatGagnant() {
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

	protected String[] createTabCompColor(String[] essaiPrecedent, boolean reponse) {
		String[] tabResultat = new String[essaiPrecedent.length];
		for (int i = 0; i < essaiPrecedent.length; i++) {
			for (int j = 0; j < tabResultat.length; j++) {
				if (essaiPrecedent[i].equals(tabResultat[j]) && i == j) {
					essaiPrecedent[i] = tabResultat[j++];
					if (essaiPrecedent[i].equals(tabResultat[j]) & i == j) {
						essaiPrecedent[i] = tabResultat[j];
					}
				}
			}
//			if (essaiPrecedent[i].equals(tabResultat[i])) {
//				tabResultat[i] = essaiPrecedent[i + 1];
//				System.out.println(i);
//			} else if (essaiPrecedent[i] == tabResultat[i]) {
//				tabResultat[i] = essaiPrecedent[i];
//				System.out.println(i);
//			} else {
//				tabResultat[i] = essaiPrecedent[i - 1];
//			}
		}
		System.out.println(tabResultat);
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

	protected String[] askTabColor() {
		Scanner sc = new Scanner(System.in);
		String[] resultat = new String[Constante.longueurCombinaison];
		System.out.println("\nVeuillez entrer votre combinaison à " + Constante.longueurCombinaison + " couleurs : ");
		System.out.println("\rVoici les couleurs disponibles : " + Arrays.toString(Constante.tabColor));
		for (int i = 0; i < resultat.length; i++) {
			System.out.println("\rCouleur " + (i + 1) + " :");
			resultat[i] = sc.nextLine();
		}
		return resultat;
	}

	protected void dev(int[] tab) {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i]);
		}
		System.out.println();
	}

	// Surcharge de la méthode dev
	protected void dev(String[] tab) {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i] + " ");
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
	protected boolean compare(String tableauJoueur[], String tableauJeu[]) {
		String resultat = " ";
		int nbrPresent = 0;
		nbrBienPlace = 0;
		boolean present = false;
		boolean bienPlace = false;
		for (int i = 0; i < tableauJoueur.length; i++) {
			for (int j = 0; j < tableauJeu.length; j++) {
				System.out.print(tableauJoueur[i]);
				System.out.print("=");
				System.out.println(tableauJeu[j]);
				if (tableauJoueur[i].equals(tableauJeu[j]) && i == j) {
					if (tableauJoueur[i].equals(tableauJeu[j])) {
						present = true;
						nbrPresent++;
						System.out.println("booléen présent " + present);
						System.out.println("variable présente " + nbrPresent);
						if (tableauJoueur[i].equals(tableauJeu[j]) & i == j) {
							bienPlace = true;
							nbrBienPlace++;
							System.out.println("booléen bien placé " + bienPlace);
							System.out.println("variable bien placée " + nbrBienPlace);
						}
					}
				}
			}
			if (present && bienPlace) {
				resultat = nbrPresent + " couleurs sont présentes et " + nbrBienPlace + " sont bien placées";
			} else {
				break;
			}
		}
		System.out.println();
		System.out.println(resultat);
		return nbrBienPlace == tableauJeu.length;
	}

	/*
	 * (Combinaison secr�te : 1234) Proposition : 4278 -> R�ponse : 1 pr�sent, 1
	 * bien placé Proposition : 6274 -> R�ponse : 2 bien plac�s ...
	 */
	public void jouer() {

	}
}