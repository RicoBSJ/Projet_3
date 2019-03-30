package com;

public class Compare {
	
	public static boolean compare(String tableauJoueur[], String tableauJeu[]) {
	
	String tableauJeu2[] = new String[Constante.longueurCombinaison];
	String tableauJoueur2[] = new String[Constante.longueurCombinaison];
		
	String resultat = " ";
	boolean present;
	boolean bienPlace;
	int nbrPresent;
	int nbrBienPlace = 0;
	for (int i = 0; i < tableauJoueur2.length; i++) {
		present = false;
		bienPlace = false;
		nbrPresent = 0;
		for (int j = 0; j < tableauJeu2.length; j++) {
			if (tableauJoueur2[i].equals(tableauJeu2[j])) {
				present = true;
				nbrPresent++;
				if (i == j) {
					bienPlace = true;
					nbrBienPlace++;
				}
			}
		}
		if (bienPlace && present) {
			resultat = nbrPresent + " couleurs sont présentes et " + nbrBienPlace + " sont bien placées";
		} else {
			break;
		}
	}
	return nbrBienPlace == tableauJeu2.length;
}

	public static void main(String[] args) {
		
		String tableauJeu2[] = { "vert", "noir", "orange", "bleu", "jaune" };
		String tableauJoueur2[] = { "gris", "marron", "bleu foncé", "violet", "mauve" };
		
		compare(tableauJeu2,tableauJoueur2);

	}
}