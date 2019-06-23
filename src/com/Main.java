package com;

//import org.apache.log4j.*;

public class Main {
	
//	protected static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		FileLecteur.read();
		if (args.length != 0) {
			System.out.println(args[0]);
			if (args[0].equals("-dev")) {
				Constante.dev = true;
			} else {
				Constante.dev = false;
//				logger.setLevel(Level.WARN);
			}
		} else {
			Constante.dev = false;
//			logger.setLevel(Level.WARN);
		}
		Menu menu = new Menu();
		MenuResult menuResult = menu.runMenu();
		Game game = GameFactory.createGame(menuResult);
		game.jouer();

	}
}
/*
 * l'ordinateur génère une combinaison aléatoire affichage du message
 * "l'ordinateur a choisi sa combinaison" (combinaison choisie) affichage
 * "veuillez rentrer votre combinaison" le joueur entre la combinaison
 * 
 * l'ordinateur fait une proposition et affichage de la proposition avec le
 * message "l'ordinateur essaie avec : "+combinaison on compare la combinaison
 * du joueur avec la proposition de l'ordinateur à la fin, affichage de la
 * réponse avec "+" "-" ou "=" on affiche le message qui demande au joueur de
 * rentrer sa proposition "entrez votre proposition" le joueur entre sa
 * proposition ensuite l'ordinateur fait la comparaison entre la proposition du
 * joueur et la proposition de l'ordinateur affichage du résultat boucle jusque
 * ce que l'ordinateur ou le joueur devine la combinaison
 */