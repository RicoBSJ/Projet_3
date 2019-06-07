package com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class LireLigne {
	public static void main(String[] argv) throws IOException {
		BufferedReader lecteurAvecBuffer = null;
		String ligne;

		try {
			lecteurAvecBuffer = new BufferedReader(new FileReader(argv[0]));
		} catch (FileNotFoundException exc) {
			System.out.println("Erreur d'ouverture");
		}
		while ((ligne = lecteurAvecBuffer.readLine()) != null)
			System.out.println(ligne);
		lecteurAvecBuffer.close();
	}
}

/*
 * Il s'agit ici de lire un fichier de type texte ligne par ligne et de
 * reproduire ce qui est lu directement à l'écran. On compose pour cela un
 * BufferdReader avec un FileReader.
 */