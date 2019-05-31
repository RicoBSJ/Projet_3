package com;

import org.apache.log4j.*;

public class log4jExample {

	private static Logger logger = Logger.getLogger(log4jExample.class);

	public static void main(String[] args) {

		logger.trace("msg de traces d'exécution");
		logger.debug("msg de debogage");
		logger.info("msg d'information");
		logger.warn("msg d'avertissement");
		logger.error("msg d'erreur");
		logger.fatal("msg d'erreur fatale");
		
		/*
		 * La bibliothèque log4j met trois sortes
		 * de composants à disposition du programmeur : 
		 * les loggers permettent d'écrire les messages,
		 * les appenders servent à sélectionner la destination des messages,
		 * les layouts mettent en forme les messages.
		 * 
		 * La bibliothèque vous propose 4 layouts par défaut :
		 * HTMLLayout permet de générer des journaux au format HTML,
		 * SimpleLayout affiche simplement le message et son niveau,
		 * PatternLayout sert à formater l'affichage d'une manière semblable au printf() du C
		 * TTCCLayout sert à afficher le contexte d'exécution du message.
		 * 
		 * Les classes Category et Priority sont déclarées deprecated et sont remplacées
		 * respectivement par les classes Logger et Level qui en héritent.
		 */

	}
}
