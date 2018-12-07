package com;

import java.util.Scanner;

public class PlusOuMoins extends Game {

	public void jouer() {
		
		int tableauCaractere[] = new int[4];
		int i = 0;
		int reponse = ' ',carac = ' ';
		Scanner sc = new Scanner(System.in);
		
		    i = 0;
		    System.out.println("Rentrez une lettre en minuscule, SVP ");
		                
		    carac = sc.nextLine().charAt(0);
		    //Boucle de recherche dans le tableau
		    for (i < tableauCaractere.length && carac != tableauCaractere[i])
		      i++;
		         
		    //Si i < 7 c'est que la boucle n'a pas dépassé le nombre de cases du tableau 
		    if (i < tableauCaractere.length)
		      System.out.println(" La lettre " +carac+ " se trouve bien dans le tableau !");
		    else //Sinon
		      System.out.println(" La lettre " +carac+ " ne se trouve pas dans le tableau !");
		         
		  }while(i >= tableauCaractere.length);

		  //Tant que la lettre de l'utilisateur ne correspond pas à une lettre du tableau    
		  do{
		    System.out.println("Voulez-vous essayer à nouveau ? (O/N)");
		    reponse = sc.nextLine().charAt(0);
		  }while(reponse != 'N' && reponse != 'O');      
		}while (reponse == 'O');
		                
		System.out.println("Au revoir !");
		
		/*
		do {
			Scanner nombre = new Scanner(System.in);
			System.out.println("Veuillez entrer un nombre...");
			Nombre = nombre.nextInt();

			if (Nombre < NombreMystere) {
				System.out.println("C'est plus ! ");
				essais++;
			} else if (Nombre > NombreMystere) {
				System.out.println("C'est moins !");
				essais++;
			} else {
				System.out.println("Trouver en " + essais + " essais ! Bien Joué !");
			}
		} while (Nombre != NombreMystere);
		*/
	}
}
