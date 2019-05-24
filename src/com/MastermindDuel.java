package com;

import java.util.*;

public class MastermindDuel extends Game {

	private String[] presenteEtBienPlace;
	private int nbrEssaiDef = 0;
	ArrayList<String> pool = new ArrayList<String>();
	ArrayList<String[]> essaiPrecedent = new ArrayList<String[]>();

	public void jouer() {
		// A remplacer ensuite par une liste
		initializeTab();
		nbrEssaiDef = 0;
		System.out.println("\rNombre d'essais maximum : " + Constante.nombreEssai);
		String[] tabComputer = createTabColor(Constante.tabColor);
		System.out.println("\rL'ordinateur a choisi : " + Arrays.toString(tabComputer));
		boolean winC = false;
		boolean winJ = false;
		int nbrEssaiJoueur = 0;
		int nbrEssaiComputer = 0;

		while (!winJ && nbrEssaiJoueur < Constante.nombreEssai && !winC && nbrEssaiComputer < Constante.nombreEssai) {
			nbrEssaiJoueur++;
			nbrEssaiComputer++;
			String[] tentativesJoueur = askTabColor();
			System.out.print("\rLe joueur essaie avec : ");
			dev(tentativesJoueur);
			winJ = compare(tentativesJoueur, tabComputer);
			String[] essaiComp = creerCombinaison();
			System.out.println("\rL'ordinateur essaie avec : " + Arrays.toString(essaiComp));
			nbrEssaiDef++;
			winC = compareDuel(essaiComp, tabComputer);
			System.out.println("\rIl s'agit du " + nbrEssaiDef + "ème essai(s)");
		}
		if (winJ == true) {
			System.out.println("\rLe joueur gagne en " + nbrEssaiJoueur + " essai(s)");
		} else {
			System.out.println("\rVous avez perdu !");
		}

		if (winC == true) {
			System.out.println("\rL'ordinateur gagne en " + nbrEssaiComputer + " essai(s)");
		} else {
			System.out.println("\rL'ordinateur a perdu !");
		}
		optionsJeux();
	}

	private boolean dejaUtilise(String[] essai) {
		boolean present = false;
		for (String[] x : essaiPrecedent) {
			if (tableauEgal(x, essai)) {
				present = true;
			}
		}
		return present;
	}

	private boolean tableauEgal(String[] tab1, String[] tab2) {
		boolean egal = true;
		for (int i = 0; i < tab1.length; i++) {
			if (!tab1[i].equals(tab2[i])) {
				egal = false;
			}
		}
		return egal;
	}

	private boolean compareDuel(String tableauJoueur[], String tableauJeu[]) {
		int nbrPresent = 0;
		int nbrBienPlace = 0;
		for (int i = 0; i < tableauJoueur.length; i++) {
			for (int j = 0; j < tableauJeu.length; j++) {
				if (tableauJoueur[i].equals(tableauJeu[j])) {
					if (i == j) {
						nbrBienPlace++;
						presenteEtBienPlace[i] = tableauJoueur[i];
					} else {
						nbrPresent++;
						pool.add(tableauJoueur[i]);
					}
				}
			}
		}
		System.out.println(pool.toString());
		System.out.println("\r" + nbrPresent + " couleurs sont mal placées et " + nbrBienPlace + " sont bien placées");
		return nbrBienPlace == tableauJeu.length;
	}

	private String cherchePresent() {
		Random rand = new Random();
		if (pool.isEmpty()) {
			return null;
		} else {
			int i = rand.nextInt(pool.size());
			String resultat = pool.get(i);
			pool.remove(i);
			return resultat;
		}
	}

	private String[] creerCombinaison() {
		boolean ok = false;
		String[] tabComp = null;
		while (ok == false) {
			if (nbrEssaiDef == 0) {
				tabComp = createTabColor(Constante.tabColor);
			} else {
				tabComp = presenteEtBienPlace.clone();
			}
			for (int i = 0; i < tabComp.length; i++) {
				if (tabComp[i] == null) {
					String result = cherchePresent();
					if (result != null) {
						tabComp[i] = result;
					} else {
						Random rand = new Random();
						String newColor = Constante.tabColor[rand.nextInt(Constante.tabColor.length)];
						tabComp[i] = newColor;
					}
				}
			}
			if (!dejaUtilise(tabComp)) {
				ok = true;
			}
		}
		essaiPrecedent.add(tabComp);
		return tabComp;
	}

	private void initializeTab() {
		this.presenteEtBienPlace = new String[Constante.longueurCombinaison];
		for (int i = 0; i < Constante.longueurCombinaison; i++) {
			presenteEtBienPlace[i] = null;
		}
	}
}
