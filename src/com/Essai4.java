package com;

import java.util.Scanner;

public class Essai4 {

	public static void main(String[] args) {

	}
	  public static String convertn2c(int number) {
	  String choiceColor="";
	  switch (number) {
	            case 0:  choiceColor="Rouge"; break;
	            case 1:  choiceColor="Vert"; break;
	            case 2:  choiceColor="Jaune"; break;
	            case 3:  choiceColor="Orange"; break;
	            case 4:  choiceColor="Bleu"; break;
	            case 5:  choiceColor="Violet"; break;
	            default: System.out.println("Invalid color");break;
	        }
	return choiceColor;
	  }
		public static String[] askTabColor() {
			Scanner sc = new Scanner(System.in);
			String[] resultat = new String[Constante.longueurCombinaison];
			System.out.println("\nVeuillez entrer votre combinaison à " + Constante.longueurCombinaison + " couleurs : ");
			for (int i = 0; i < resultat.length; i++) {
				System.out.println("Couleur " + (i + 1) + " : ");
				resultat[i] = sc.nextLine();
			}
			return resultat;
		}
}