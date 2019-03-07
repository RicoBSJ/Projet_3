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

	// On crée une méthode dans laquelle le joueur choisi une option
	protected void optionsJeux() {
		// On instancie la variable choix
		int choix;
		System.out.println("\rVoulez-vous : ");
		System.out.println("4 - Rejouer");
		System.out.println("5 - Changer de jeu");
		System.out.println("6 - Modifier la quantitÃ© de chiffres");
		System.out.println("7 - Quitter");
		Scanner sc = new Scanner(System.in);
		choix = sc.nextInt();
		while (choix != 0) {
			if (choix == 4) {
				// On relance le mode challenger
				jouer();
			} else if (choix == 5) {
				// On peut changer de jeu
				GameFactory.createGame(new Menu().runMenu()).jouer();
			} else if (choix == 6) {
				// On instancie et on initialise à 0 la variable pour changer la longueur du tableau 
				int longeurDemandee = 0;
				// On donne la longueur actuelle
				System.out.println("La longueur actuelle est de " + Constante.longueurCombinaison);
				// On demande à l'utilisateur la longueur souhaitée
				System.out.println("Indiquez la longueur souhaitÃ©e :");
				Scanner lc = new Scanner(System.in);
				longeurDemandee = lc.nextInt();
				// On enregistre la nouvelle longueur du tableau
				Constante.longueurCombinaison = longeurDemandee;
				jouer();
			} else if (choix == 7) {
				// On arrêt le jeu
				return;
			} else {
				// On relance le menu si l'utilisateur tape un choix non prévu
				System.out.println("Votre choix ne figure pas parmi ceux proposÃ©s");
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
		// Constructeur d'affichage du tableau avec paramÃ¨tre
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