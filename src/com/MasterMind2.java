package com;

public class MasterMind2 {

	public static void main(String[] args) {

		int j = 0;
		String[] tabColor = new String[4];
		String[] colors = { "bleu", "rouge", "blanc", "noir" };
		
		for (int i = 0; i < colors.length; i++) {
			tabColor[j] = colors[i];
			}
			System.out.println(tabColor);
		}
}
