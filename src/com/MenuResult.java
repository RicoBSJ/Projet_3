package com;

public class MenuResult {
	private int selectedGame;
	private int selectedMode;

	public void setSelectedGame(int selectedGameParam) {
		selectedGame = selectedGameParam;
	}

	public int getSelectedGame() {
		return selectedGame;
	}

	public void setSelectedMode(int selectedModeParam) { // selectedMode
		selectedMode = selectedModeParam;
	}

	public int getSelectedMode() {
		return selectedMode;
	}
}
