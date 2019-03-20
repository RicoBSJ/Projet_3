package com;

public class CreateTabColor {

	public static void main(String[] args) {

//		String[] tabColor = new String[Constante.longueurCombinaison];
//		String couleurVert = "vert";
//		String couleurOrange = " orange";
//		String couleurJaune = " jaune";
//		String couleurGris = " gris";
//		String couleurNoir = " noir";
//		tabColor[0] = couleurVert;
//		tabColor[1] = couleurOrange;
//		tabColor[2] = couleurJaune;
//		tabColor[3] = couleurGris;
//		tabColor[4] = couleurNoir;
		
		String[] tabColor = {Constante.couleurVert, Constante.couleurOrange, Constante.couleurJaune, Constante.couleurGris, Constante.couleurNoir};

		for (int i = 0; i < tabColor.length; i++) {
			System.out.println(tabColor[i]);
		}
		System.out.println();
	}
}
