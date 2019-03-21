package com;

import java.util.Scanner;

public class Essai2 {

	public static void main(String[] args) {
		
		saisieTab(3);
		saisieElementsOneTime(3);

	}

	static void saisieTab(int n) {
		String[] tab = saisieElementsOneTime(n);
		for (int i = 0; i < tab.length; i++) {
			System.out.println("index " + i + " = " + tab[i]);
		}
	}

	static String[] saisieElementsOneTime(int n) {
		String elements;
		String[] tab = new String[n];
		System.out.print("Saisir " + n + " valeur séparé par une ,\n");
		Scanner sc = new Scanner(System.in);
		elements = sc.next();

		String[] elementsToString = elements.split(",");
		try {
			for (int j = 0; j < elementsToString.length; j++) {
				if (tab.length > j) {
					
//                    tab[j] = Integer.valueOf(elementsToString[j]).intValue();
					
//					String carac = Character.toString(result.charAt(i));
//					// Conversion du string carac en int
//					resultat[i] = Integer.parseInt(carac);
					
				} else {
					System.out.println(
							"le nombre d'éléments saisi est trop grand, seulement " + n + " seront pris en compte");
					break;
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Vous devait saisir uniquement des nombres.");
			return new String[0];
		}
		return tab;
	}
}
/*
static void saisieTab(int n){
        int[] tab = saisieElementsOneTime(n);
        for (int i = 0; i < tab.length; i++) {
            System.out.println("index " + i +" = " + tab[i]);
        }
    }
 
    static int[] saisieElementsOneTime(int i){
        String elements;
        int[] tab = new int[i];
        System.out.print("Saisir "+i+" valeur séparé par une ,\n");
        Scanner sc=new Scanner(System.in);
        elements=sc.nextLine();
 
        String[] elementsToString = elements.split(",");
        try{
            for (int j = 0; j < elementsToString.length; j++) {
                if(tab.length>j){
                    tab[j] = Integer.valueOf(elementsToString[j]).intValue();
                }else{
                    System.out.println("le nombre d'éléments saisi est trop grand, seulement " + i + " seront pris en compte");
                    break;
                }
            }
        }catch (NumberFormatException e) {
             System.out.println("Vous devait saisir uniquement des nombres.");
                         return new int[0];
        }
        return tab;
    }
 */