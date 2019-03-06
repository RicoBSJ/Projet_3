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
		int choix = 4;
		System.out.println("\rVoulez-vous : ");
		System.out.println("4 - Rejouer");
		System.out.println("5 - Changer de jeu");
		System.out.println("6 - Modifier la quantité de chiffres");
		System.out.println("7 - Quitter");
		Scanner sc = new Scanner(System.in);
		choix = sc.nextInt();
		while (choix != 0) {
			if (choix == 4) {
				jouer();
			} else if (choix == 5) {
				GameFactory.createGame(new Menu().runMenu()).jouer();
			} else if (choix == 6) {
				int longeurDemandee = Constante.longueurCombinaison;
				System.out.println("La longueur actuelle est de " + Constante.longueurCombinaison);
				System.out.println("Indiquez la longueur souhaitée :");
				Scanner lc = new Scanner(System.in);
				longeurDemandee = lc.nextInt();
				Constante.longueurCombinaison = longeurDemandee;
				jouer();
			} else if (choix == 7) {
				return;
			} else {
				System.out.println("Votre choix ne figure pas parmi ceux proposés");
				optionsJeux();
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