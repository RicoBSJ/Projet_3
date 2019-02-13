package com;

import java.io.IOException;

class TriDicho {

	public static Integer[] trier(Integer tab1[]) throws IOException {

		int debut = 0;
		int fin = 0;
		int pos = 0;
		Integer[] tab2 = new Integer[tab1.length];

		for (int i = 0; i < tab2.length; i++) {
			pos = rechercheposition(tab1[i].intValue(), tab2, debut, fin);
			fin = i;
			insertion(tab1[i].intValue(), tab2, pos);
		}
		;
		return tab2;
	}

	private static void insertion(int val, Integer tab[], int pos) throws IOException {

		int zr;

		for (int i = tab.length - 2; i > pos - 1; i--) {
			zr = (tab[i] == null) ? 0 : tab[i].intValue();

			if (pos != i)
				tab[i] = tab[i - 1];
			else
				tab[i] = val;

			tab[i + 1] = zr;
		}
		;
	}

	private static int round(double nb) throws IOException {

		int monint = (int) nb;
		double mondouble = (double) monint;

		if (mondouble != nb)
			return (int) nb + 1;

		return (int) nb;
	}

	private static int rechercheposition(int val, Integer tab[], int debut, int fin) throws IOException {

		int milieu;
		do {
			milieu = round((double) ((double) debut + (double) fin) / 2);

			/*
			 * si la valeur du tableau est null et que la fin (nombre le plus grand connu)
			 * est 0 retourne 0. Dans le cas du premier nombre inscrit au tableau
			 */

			// System.out.println("valeur: "+tab[0].intValue());
			if ((tab[milieu] == null) && (fin == 0))
				return 0;

			/*
			 * si la valeur est superieure et qu'il n'y a plus d'écart entre fin et debut
			 * retourne fin+1
			 */

			if ((tab[milieu].intValue() <= val) && (debut == fin))
				return fin + 1;

			/*
			 * si la valeur est inferieure et qu'il n'y a plus d'ecart entre fin et debut
			 * retourne fin+1
			 */

			if ((tab[milieu].intValue() > val) && (debut == fin))
				return fin;

			/*
			 * quand la valeur du tableau coordonee milieu est superieure a la valeur a
			 * entrer
			 */

			if (tab[milieu].intValue() > val) {

				/*
				 * si il ne reste que deux cases, alors la deuxieme est inutile
				 */

				if (fin - debut == 1)
					fin = fin - 1;

				// sinon fin est initialise avec milieu
				else
					fin = milieu;
			}

			/*
			 * si la valeur du tableau a la coordonee de milieu est inferieure ou egale a la
			 * valeur a entrer, alors on oublie tout ce qui se trouve avant
			 */

			if (tab[milieu].intValue() <= val)
				debut = milieu;
		}

		while (milieu != -1);
		return 0;
	}
}