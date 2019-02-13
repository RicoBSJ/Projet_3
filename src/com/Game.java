package com;

import java.util.Random;
import java.util.Scanner;

public abstract class Game {

	protected int[] createTab() {
		int[] resultat = { 0, 0, 0, 0 };
		Random rand = new Random();
		for (int i = 0; i < resultat.length; i++) {
			resultat[i] = rand.nextInt(9);
		}
		return resultat;
	}

	protected int[] createTabComputer() {
		/*
		 * premier essai aléatoire réponse donnée par le défenseur comparaison entre
		 * l'essai et la réponse donnée si + rajouter le double si - diviser par deux si
		 * = garder return réponse
		 */
		int[] resultComputer = { 0, 0, 0, 0 };
		Random rand = new Random();
		for (int i = 0; i < resultComputer.length; i++) {
			resultComputer[i] = rand.nextInt(9);
		}
		return resultComputer;

		/*
		 * fonction de recherche dichotomique qui renvoie un indice où se trouve la
		 * valeur "val" s'il est dans le tableau "tab[]" et -1 si cette valeur n'y est
		 * pas
		 */

		/* déclaration des variables locales à la fonction */
		boolean trouve; // vaut faux tant que la valeur "val" n'aura pas été trouvée
		int id; // indice de début
		int ifin; // indice de fin
		int im; // indice de "milieu"

		/* initialisation de ces variables avant la boucle de recherche */
		trouve = false; // la valeur n'a pas encore été trouvée
		id = 0; // intervalle de recherche compris entre 0...
		ifin = 4; // ...et nbVal

		/* boucle de recherche */
		while (!trouve && ((ifin - id) > 1)) {

			im = (id + ifin) / 2; // on détermine l'indice de milieu

			trouve = (resultComputer[im] == resultat.askTab[id]); // on regarde si la valeur recherchée est à cet indice

			if (resultComputer[im] > resultat)
				ifin = im; // si la valeur qui est à la case "im" est supérieure à la valeur recherchée,
							// l'indice de fin "ifin" << devient >> l'indice de milieu, ainsi l'intervalle
							// de recherche est restreint lors du prochain tour de boucle
			else
				id = im; // sinon l'indice de début << devient >> l'indice de milieu et l'intervalle est
							// de la même façon restreint
		}

		/* test conditionnant la valeur que la fonction va renvoyer */
		if (resultComputer[id] == val)
			return (id); // si on a trouvé la bonne valeur, on retourne l'indice
		else
			return (-1); // sinon on retourne -1

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

	protected void dev(int[] tab) {
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
