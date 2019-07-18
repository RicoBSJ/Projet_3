package com;

public class Main {

	public static void main(String[] args) { 

		FileLecteur.read();
		if (args.length != 0) {
			System.out.println(args[0]);
			if (args[0].equals("-dev")) {
				Constante.dev = true;
			}
		}
		Menu menu = new Menu();
		MenuResult menuResult = menu.runMenu();
		Game game = GameFactory.createGame(menuResult);
		game.jouer();

	}
}