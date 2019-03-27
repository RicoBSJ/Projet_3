package com;

import java.util.Scanner;

public class Essai2 {

	public static int Position(String[] vecteur, String x) {
		int i = 1, indice = 0;
		while (i != vecteur.length && !vecteur[i].equals(x)) {
			i++;
		}
		if (vecteur[i].equals(x))
			indice = i;
		return indice;
	}

	/*-----------------------------------------------------------------------*/
	public static int Last(String[] v) {
		int i;
		if (v[0] == null)
			i = 0;
		else {
			i = 0;
			while (i != v.length && v[i] != null) {
				i++;
			}
		}
		return i;
	}

	/*---------------------------------------------------------------------*/
	public static boolean Loockup(String[] vecteur, String x) {
		int i = 0, k = vecteur.length;
		boolean trouver;
		while (i != k && !vecteur[i].equals(x)) {
			i++;
		}
		if (vecteur[i].equals(x)) {
			trouver = true;
		} else {
			trouver = false;
		}
		return trouver;
	}

	/*----------------------------------------------------------------------*/
	public static String[] Insert(String[] v, String x) {
		int i = Last(v);
		if (v[0] == null)
			v[0] = x;
		else if (i == v.length)
			System.out.println("impossible d'inserer tableau plein");
		else
			v[i + 1] = x;
		return v;
	}

	/**********************************************************************/
	public static String[] Delete(String[] v, String x) {
		if (v[0] == null) {
			System.out.println("Tableau vide");
		}

		else {
			if (Loockup(v, x)) {
				for (int i = Position(v, x); i <= Last(v); i++) {
					v[i] = v[i + 1];
				}
			}
		}
		return v;
	}

	/************************************************************************/
	public static String[] Intersection(String[] v1, String[] v2, String[] v) {
		for (int i = 0; i <= Last(v1); i++) {
			if (Loockup(v2, v1[i])) {
				v[i] = v1[i];
			}
		}
		return v;
	}

	/***************************************************************************************************/
	public static String[] Union(String[] v1, String[] v2, String[] v) {
		v1 = DifferenceSymetrique(v1, v2, v);
		v2 = Intersection(v1, v2, v);
		int j = 0, i = 0, k = Last(v) + 1;
		while (i != Last(v1)) {
			v[i] = v[i];
			i++;

		}
		while (j != Last(v2)) {
			v[k] = v[j];
			k++;
			j++;
		}

		return v;
	}

	/******************************************************************************/
	public static String[] Difference(String[] v1, String[] v2, String[] v) {
		if (v2[0] == null) {
			for (int i = 0; i <= Last(v1); i++) {
				v[i] = v1[i];
			}
		} else {
			for (int j = 0; j <= Last(v1); j++) {
				if (!Loockup(v2, v1[j])) {
					v[j] = v1[j];
				}
			}
		}
		return v;
	}

	/*****************************************************************************************/
	public static String[] DifferenceSymetrique(String[] v1, String[] v2, String[] v) {
		v1 = Difference(v1, v2, v);
		v2 = Difference(v2, v1, v);
		int j = 0, i = 0, k = Last(v) + 1;
		while (i != Last(v1)) {
			v[i] = v[i];
			i++;

		}
		while (j != Last(v2)) {
			v[k] = v[j];
			k++;
			j++;
		}
		return v;
	}

	/**************************************************************************************************/
	/* ici nous allons creer notre vecteur binaire et le remplir */
	public static String[] MyVecteurB(String[] v) {
		int n = v.length;
		String[] vectoB = new String[n];
		for (int i = 0; i <= Last(v); i++) {
			if ((v[i].length() % 2) == 0) {
				vectoB[i] = "true";
			} else {
				vectoB[i] = "false";
			}
		}
		return vectoB;
	}

	/***************************************************************************************************/

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String v1[] = new String[8];
		String v2[] = new String[8];
		String v[] = new String[8];
		System.out.println("please entrer vos chaine de carractéres de v1 \n");
		for (int i = 0; i <= 5; i++) {
			v1[i] = sc.nextLine();
		}
		System.out.println("please entrer vos chaine de carractéres de v2 \n");
		for (int i = 0; i <= 5; i++) {
			v2[i] = sc.nextLine();
		}
		v = Intersection(v1, v2, v);
		for (int j = 0; j < Last(v); j++) {
			System.out.println(v);
		}

	}
}