package com;

/*
PROJET : TriDicho AUTEUR : Alexandre Alcuyet DATE : 27/09/2008
Trier un tableau par dichotomie.
Le tri par dichotomie est un tri très efficace qui consiste
à éliminer successivement la motié des possibilités restantes,
jusqu'à parvenir au résultat.
Ce code n'a qu'un intérêt pédagogique, au titre d'algorithme car
l'API contient déjà de nombreuses solutions pour trier. Il
n'est pas question ici de trier des Collections mais des entiers,
mais libre à vous d'adapter le code.
*/

import java.io.IOException;
import java.lang.Integer;

public class Main_TriDicho {

	public static void main(String args[]) throws IOException {

		Integer[] tnb = { Integer.valueOf(0), Integer.valueOf(54), Integer.valueOf(2), Integer.valueOf(321326),
				Integer.valueOf(1255), Integer.valueOf(10128), Integer.valueOf(65), Integer.valueOf(4),
				Integer.valueOf(101254), Integer.valueOf(4), Integer.valueOf(10), Integer.valueOf(5),
				Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(8) };

		affichetableau(tnb);
		tnb = TriDicho.trier(tnb);
		affichetableau(tnb);
		System.exit(0);
	}

	public static void affichetableau(Object tab[]) throws IOException {

		for (int i = 0; i < tab.length - 1; i++)
			System.out.format("%s - ", tab[i].toString());

		System.out.format("%s%n", tab[tab.length - 1].toString());
	}
}