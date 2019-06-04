package io;

//Package à importer
import java.io.Serializable;

public class Jeu implements Serializable {
	private String nom, style;
	private double prix;

	public Jeu(String nom, String style, double prix) {
		this.nom = nom;
		this.style = style;
		this.prix = prix;
	}

	public String toString() {
		return "Nom du jeu : " + this.nom +
				"\nStyle de jeu : " + this.style +
				"\nPrix du jeu : " + this.prix + "\n";
	}
}