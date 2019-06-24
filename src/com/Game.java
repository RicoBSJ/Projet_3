package com;

import java.util.*;
import org.apache.log4j.Logger;

public abstract class Game {

	protected static Logger logger = Logger.getLogger(Game.class);
	protected ArrayList<String> pool = new ArrayList<String>();

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
		logger.info("\rVoulez-vous : ");
		logger.info("1 - Rejouer");
		logger.info("2 - Changer de jeu");
		logger.info("3 - Quitter");
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
		logger.info("\rVeuillez entrer votre combinaison � " + Constante.longueurCombinaison + " chiffres : ");
		Scanner sc = new Scanner(System.in);
		String result = sc.nextLine();
		for (int i = 0; i < resultat.length; i++) {
			String carac = Character.toString(result.charAt(i));
			resultat[i] = Integer.parseInt(carac);
		}
		return resultat;
	}

	protected String[] askTabColor() {
		Scanner sc = new Scanner(System.in);
		String[] resultat = new String[Constante.longueurCombinaison];
		logger.info("\rVeuillez entrer votre combinaison � " + Constante.longueurCombinaison + " couleurs : ");
		logger.info("\rVoici les couleurs disponibles : " + Arrays.toString(Constante.tabColor));
		for (int i = 0; i < resultat.length; i++) {
			logger.info("\rCouleur " + (i + 1) + " :");
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

	protected boolean compare(String tableauJoueur[], String tableauJeu[]) {
		int nbrPresent = 0;
		int nbrBienPlace = 0;
		for (int i = 0; i < tableauJoueur.length; i++) {
			for (int j = 0; j < tableauJeu.length; j++) {
				if (tableauJoueur[i].equals(tableauJeu[j])) {
					if (i == j) {
						nbrBienPlace++;
					} else {
						nbrPresent++;
					}
				}
			}
		}
		logger.info("\r" + nbrPresent + " couleurs sont pr�sentes et " + nbrBienPlace + " sont bien plac�es");
		return nbrBienPlace == tableauJeu.length;
	}

	protected void addToPool(String couleur) {
		boolean dejaPresent = false;
		for (int i = 0; i < pool.size(); i++) {
			if (couleur.equals(pool.get(i))) {
				dejaPresent = true;
			}
		}
		if (dejaPresent == false) {
			pool.add(couleur);
		}
	}

	public void jouer() {

	}
}