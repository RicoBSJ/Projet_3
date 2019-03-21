package com;

import java.util.Scanner;

public class Essai3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez " +Constante.longueurCombinaison+ " couleurs : ");

		// String input
		String couleur1 = sc.nextLine();
		String couleur2 = sc.nextLine();
		String couleur3 = sc.nextLine();
		String couleur4 = sc.nextLine();
		String couleur5 = sc.nextLine();

		// Output input by user
		System.out.println("Couleur1: " + couleur1);
		System.out.println("Couleur2: " + couleur2);
		System.out.println("Couleur3: " + couleur3);
		System.out.println("Couleur4: " + couleur4);
		System.out.println("Couleur5: " + couleur5);
	}
}
