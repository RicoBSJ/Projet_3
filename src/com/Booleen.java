package com;

import java.util.Scanner;

public class Booleen {
	
	   static boolean [ ]creerGrille(int nbr) {
		   
			boolean grille[ ]=new boolean[5];
			for(int i=0; i<grille.length; i++) {
				if(i+1==nbr)
					grille[ i ] = true;
			}
			return grille;
		}

	public static void main(String[] args) {
		
		for(int i=0; i<=4; i++){                   
			System.out.print("entrer un entier entre 1 et 4 : ");
			Scanner sc = new Scanner(System.in);
			int nbr=sc.nextInt();
 
			creerGrille(nbr);
		}
	}
}
