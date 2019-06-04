package io;

//Packages à importer afin d'utiliser l'objet File
import java.io.*;

public class Jeux {
public static void main(String[] args) {
  //Nous déclarons nos objets en dehors du bloc try/catch
  ObjectInputStream ois;
  ObjectOutputStream oos;
  try {
    oos = new ObjectOutputStream(
            new BufferedOutputStream(
              new FileOutputStream(
                new File("game.txt"))));
      	
    //Nous allons écrire chaque objet Jeu dans le fichier
    oos.writeObject(new Jeu("Assassin Creed", "Aventure", 45.69));
    oos.writeObject(new Jeu("Tomb Raider", "Plateforme", 23.45));
    oos.writeObject(new Jeu("Tetris", "Stratégie", 2.50));
    //Ne pas oublier de fermer le flux !
    oos.close();
      	
    //On récupère maintenant les données !
    ois = new ObjectInputStream(
            new BufferedInputStream(
              new FileInputStream(
                new File("game.txt"))));
          
    try {
      System.out.println("Affichage des jeux :");
      System.out.println("*************************\n");
      System.out.println(((Jeu)ois.readObject()).toString());
      System.out.println(((Jeu)ois.readObject()).toString());
      System.out.println(((Jeu)ois.readObject()).toString());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
	
    ois.close();
      	
  } catch (FileNotFoundException e) {
    e.printStackTrace();
  } catch (IOException e) {
    e.printStackTrace();
  }     	
}
}