package com;

public class GameFactory {

	public static Game createGame(MenuResult menuResult) {
		if (menuResult.getSelectedGame() == 1) {
			if (menuResult.getSelectedMode() == 1) {
				System.out.println("Vous avez choisi Mastermind en mode duel");
				return new MastermindDuel();
			} else if (menuResult.getSelectedMode() == 2) {
				System.out.println("Vous avez choisi Mastermind en mode d/È/fenseur");
				return new MastermindDefenseur();
			} else if (menuResult.getSelectedMode() == 3) {
				System.out.println("Vous avez choisi Mastermind en mode challengeur");
				return new MastermindChallengeur();
			}
		} else if (menuResult.getSelectedGame() == 2) {
			if (menuResult.getSelectedMode() == 1) {
				System.out.println("Vous avez choisi Plus ou Moins en mode duel");
				return new PlusOuMoinsDuel();
			} else if (menuResult.getSelectedMode() == 2) {
				System.out.println("Vous avez choisi Plus ou Moins en mode d√©fenseur");
				return new PlusOuMoinsDefenseur();
			} else if (menuResult.getSelectedMode() == 3) {
				System.out.println("Vous avez choisi Plus ou Moins en mode challengeur");
				return new PlusOuMoinsChallengeur();
			}
		}
		return null;
	}
}
