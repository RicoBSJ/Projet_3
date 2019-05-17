package com;

import java.util.*;

public class MastermindDefenseur extends Game {

	private String[] presenteEtBienPlace;
	private int nbrEssaiDef = 0;
	ArrayList<String> pool = new ArrayList<String>();
	ArrayList<String[]> essaiPrecedent = new ArrayList<String[]>();

	public void jouer() {
		// A remplacer ensuite par une liste
		initializeTab();
		nbrEssaiDef = 0;
		System.out.println("\rL'ordinateur a droit à " + Constante.nombreEssai + " essais");
		String[] tableauDefenseur = askTabColor();
		System.out.print("\rLe défenseur a entré la combinaison : ");
		dev(tableauDefenseur);
		boolean win = false;

		while (!win && nbrEssaiDef < Constante.nombreEssai) {
			String[] essaiComp = creerCombinaison();
			System.out.println("\rL'ordinateur essaie avec : " + Arrays.toString(essaiComp));
			nbrEssaiDef++;
			System.out.println("C'est votre " + nbrEssaiDef + "ème essai(s)");
			win = compareDefenseur(essaiComp, tableauDefenseur);
		}
		if (win == true) {
			System.out.println("\rL'ordinateur gagne en " + nbrEssaiDef + " essai(s)");
		} else {
			System.out.println("\rL'ordinateur a perdu !");
		}
		optionsJeux();
	}
	
	private boolean dejaUtilise (String[] essai) {
		boolean present = false;
		for ( String[] x : essaiPrecedent) {
			if (Arrays.equals( x, essai)) {
				present = true;
			}
		}
		return present;
	}

	private boolean compareDefenseur(String tableauJoueur[], String tableauJeu[]) {
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
		System.out.println(nbrPresent + " couleurs sont mal placées et " + nbrBienPlace + " sont bien placées");
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
		return tabComp;
	}

	private void initializeTab() {
		this.presenteEtBienPlace = new String[Constante.longueurCombinaison];
		for (int i = 0; i < Constante.longueurCombinaison; i++) {
			presenteEtBienPlace[i] = null;
		}
	}
}