package com;

import java.util.Scanner;

public class Essai3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Combien de mots = ");
		int numWords = sc.nextInt();
		@SuppressWarnings("unused")
		String dummy = sc.nextLine();
		
		String[] words = new String[numWords];
		
		System.out.println("\nEnter in "+numWords+" Words ");
		
		for (int i = 0; i < words.length; i++) {
			System.out.println("Word "+(i+1)+": ");
			words[i] = sc.nextLine();
		}
		
		System.out.println("\nThe words you entered are : ");
		
		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
		}
		
	}
}
