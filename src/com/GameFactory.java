package com;

public class GameFactory {

	public static Game createGame(MenuResult menuResult) {
		// System.out.println(menuResult.getSelectedGame());
		// System.out.println(menuResult.getSelectedMode());
		if (menuResult.getSelectedGame() == 1) {
			if (menuResult.getSelectedMode() == 1) {
				System.out.println("Vous avez choisi Mastermind en mode joueur");
				return null;
			} else if (menuResult.getSelectedMode() == 2) {
				System.out.println("Vous avez choisi Mastermind en mode défenseur");
				return null;
			} else if (menuResult.getSelectedMode() == 3) {
				System.out.println("Vous avez choisi Mastermind en mode challengeur");
				return null;
			}
		} else if (menuResult.getSelectedGame() == 2) {
			if (menuResult.getSelectedMode() == 1) {
				System.out.println("Vous avez choisi Plus ou Moins en mode joueur");
				return new PlusOuMoinsJoueur();// rajout
			} else if (menuResult.getSelectedMode() == 2) {
				System.out.println("Vous avez choisi Plus ou Moins en mode défenseur");
				return new PlusOuMoinsDefenseur();// rajout
			} else if (menuResult.getSelectedMode() == 3) {
				System.out.println("Vous avez choisi Plus ou Moins en mode challengeur");
				return new PlusOuMoinsChallengeur();
			}
		}
		return null;
	}
}
