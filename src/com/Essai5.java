package com;

import java.util.Scanner;

public class Essai5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String[] words = new String[100];
		String ans = "";
		int count = 0;

		System.out.println("Enter Words (type \"done\" when finished) : ");

		do {
			System.out.println("Words " + (count + 1) + " : ");
			ans = sc.nextLine();
			if (!ans.equalsIgnoreCase("done")) {
				words[count] = ans;
				count++;
			}
		} while (!ans.equalsIgnoreCase("done"));

		System.out.println("\nThe words you entered are : ");

		for (int i = 0; i < count; i++) {
			System.out.println(words[i]);
		}

	}

}
