package com;

import java.util.*;

public abstract class Game {

	/* protected signifie que seules les classes filles
	 * (héritant de Game) auront accès à ces méthodes */
	protected int[] createTab() {
		// Affectation au tableau de int resultat de quatre 0
		int[] resultat = { 0, 0, 0, 0 };
		// Initialisation de la méthode Random
		Random rand = new Random();
		// Création d'une boucle for permettant, en faisant appel à la méthode
		// Random, de générer aléatoirement 4 int inférieur ou égaux à 9
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
		
		return resultat;
	}

	protected int[] createTabComputer(int[] essaiPrecedent, String reponse) {

		/* Application de la méthode toCharArray
		 * (Convertit la chaîne de caractères en
		 * un tableau de caractères), sur le string
		 * reponse et affectation au tableau unidimensionnel
		 * array composé de caractères */
		char[] array = reponse.toCharArray();
		/* Affectation de la longueur de essaiPrecedent
		 * au tableau de int tabResultat */
		int[] tabResultat = new int[essaiPrecedent.length];
		/* Création d'une boucle for pour parcourir le
		 * tableau de int essaiPrecedent */
		for (int i = 0; i < essaiPrecedent.length; i++) {
			/* Si le int i dans l'array (tableau de char)
			 * est égal à '=' alors on affecte ce int, du
			 * tableau essaiPrecedent, au int i du tableau
			 * tabResultat */
			if (array[i] == '=') {
				tabResultat[i] = essaiPrecedent[i];
				/* Si le int i dans l'array (tableau de char)
				 * est égal à '+' alors on affecte ce int + 1
				 * du tableau essaiPrecedent au int i du tableau
				 * tabResultat */
			} else if (array[i] == '+') {
				tabResultat[i] = essaiPrecedent[i] + 1;
				/* Si aucune des deux hypothèses ci-dessus ne se
				 * vérifient alors on affecte ce int - 1 du tableau
				 * essaiPrecedent au int i du tableau tabResultat */
			} else {
				tabResultat[i] = essaiPrecedent[i] - 1;
			}
		}
		return tabResultat;
	}

	protected int[] askTab() {
		// Affectation au tableau de int resultat de quatre 0
		int[] resultat = { 0, 0, 0, 0 };
		// Affichage d'un message
		System.out.println("Veuillez taper 4 chiffres :");
		/* Initialisation de la méthode Scanner, permettant
		 * de capturer ce que l'utilisateur saisit au clavier */
		Scanner sc = new Scanner(System.in);
		// Affectation de la saisie clavier dans le string result
		String result = sc.nextLine();
		// Création d'une boucle for pour parcourir resultat
		for (int i = 0; i < resultat.length; i++) {
			/* Conversion d'un int en char (charAt) et d'un char
			 * en string (Character.toString)
			 * Le tout est affecté au string carac */
			String carac = Character.toString(result.charAt(i));
			// Conversion du string carac en int
			resultat[i] = Integer.parseInt(carac);
		}
		return resultat;
	}

	protected String[] askTabColor() {

		String[] resultat = { " ", " ", " ", " " };
		System.out.println("Veuillez taper 4 couleurs :");
		Scanner sc = new Scanner(System.in);
		String result = sc.nextLine();

		return resultat;
	}

	protected void dev(int[] tab) {
		// Constructeur d'affichage du tableau avec paramètre
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
		// Instanciation du string resultat sans attribution de valeur
		String resultat = "";
		// Création de la boucle for pour parcourir tableauOrdinateur
		for (int i = 0; i < tableauOrdinateur.length; i++) {

			/* Si tableauDefenseur est égal à tableauOrdinateur alors
			 * on affecte resultat du string "=" */
			if (tableauOrdinateur[i] == tableauDefenseur[i]) {
				resultat += "=";
			/* Si tableauDefenseur est supérieur à tableauOrdinateur alors
			 * on affecte resultat du string "-" */
			} else if (tableauOrdinateur[i] < tableauDefenseur[i]) {
				resultat += "-";
			/* Si tableauDefenseur est inférieur à tableauOrdinateur alors
			 * on affecte resultat du string "+" */
			} else if (tableauOrdinateur[i] > tableauDefenseur[i]) {
				resultat += "+";
			/* Si aucune des hypothèses ci-dessus ne se vérifient alors
			 * on sort de la boucle et on fait un return sur resultat */
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