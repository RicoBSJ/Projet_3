package com;

public class Main {
	/*
	 * 
	 */
	public static void main(String[] args) {
		Menu menu = new Menu();
		MenuResult menuResult = menu.runMenu();
		GameFactory.createGame(menuResult);
		Game game = GameFactory.createGame("Plus ou Moins");
		game.jouer();

		if (args.length != 0) {
			if (args[0].equals("-dev")) {
				System.out.print(true);
			} else {
				System.out.print(false);
			}
		}
	}
}
