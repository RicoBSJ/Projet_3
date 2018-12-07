package com;

public class GameFactory {
	/*
	 * Je crée la variable "createGame" Je lui attribue en paramêtre la class
	 * MenuResult et j'associe à la class la variable "menuResult"
	 */
	public static void createGame(MenuResult menuResult) {
		if (menuResult.getSelectedGame() == 1) {
			if (menuResult.getSelectedMode() == 1) {
				System.out.println("Vous avez choisi Mastermind en mode joueur");
			} else if (menuResult.getSelectedMode() == 2) {
				System.out.println("Vous avez choisi Mastermind en mode défenseur");
			} else if (menuResult.getSelectedMode() == 3) {
				System.out.println("Vous avez choisi Mastermind en mode challengeur");
			}
		} else if (menuResult.getSelectedMode() == 2) {
			if (menuResult.getSelectedMode() == 1) {
				System.out.println("Vous avez choisi Plus ou Moins en mode joueur");
			} else if (menuResult.getSelectedMode() == 2) {
				System.out.println("Vous avez choisi Plus ou Moins en mode défenseur");
			} else if (menuResult.getSelectedMode() == 3) {
				System.out.println("Vous avez choisi Plus ou Moins en mode challengeur");
			}
		}
	}

	public static Game createGame(String res) {
		Game game = null;
		if (res == "Mastermind") {
			game = new Mastermind();
		} else {
			game = new PlusOuMoins();
		}
		return game;
	}
}
