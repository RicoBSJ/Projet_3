package com;

import java.util.Scanner;

public class Menu {
	private MenuResult menuResult;

	public void setMenuResult(MenuResult menuResultParam) {
		menuResult = menuResultParam;
	}

	public MenuResult getMenuResult() {
		return menuResult;
	}

	public MenuResult runMenu() {
		menuResult = new MenuResult();
		Scanner sc = new Scanner(System.in);
		System.out.println("Choisissez un jeu");
		System.out.println("1 - Master Mind");
		System.out.println("2 - Plus ou Moins");
		menuResult.setSelectedGame(sc.nextInt());
		System.out.println("Choisissez un mode");
		System.out.println("1 - Joueur");
		System.out.println("2 - Défenseur");
		System.out.println("3 - Challengeur");
		menuResult.setSelectedMode(sc.nextInt());
		return menuResult;
	}
}
