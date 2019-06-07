package com;

class LireFichierTexte {
	public static void main(String[] arg) throws java.io.IOException {
		java.util.Scanner lecteur;

		java.io.File fichier = new java.io.File(arg[0]);
		lecteur = new java.util.Scanner(fichier);

		/*
		 * ou bien java.io.InputStream entree =
		 * LireFichierTexteBis.class.getResourceAsStream((arg[0])); lecteur = new
		 * java.util.Scanner(entree);
		 */

		int somme = 0;
		while (lecteur.hasNextInt())
			somme += lecteur.nextInt();
		System.out.println(somme);
	}
}

/*
 * Cet exemple permet d'illustrer le fait que la classe Scanner permet une
 * lecture quelquefois plus aisée des fichiers. Dans notre exemple, il s'agit
 * d'additionner des entiers contenus dans un fichier. On donne encore deux
 * possibilités (dont une en commentaires), selon qu'on souhaite localiser le
 * fichier par rapport au répertoire d'exécution ou par rapport au bytecode
 * d'une certaine classe.
 */