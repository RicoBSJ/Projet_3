package com;

import java.io.IOException;

import org.apache.log4j.*;

public class log4jExample {

	private static Logger logger = Logger.getLogger(log4jExample.class);

	public static void main(String[] args) throws IOException {

		logger.trace("msg de traces d'exécution");
		logger.debug("msg de debogage");
		logger.info("msg d'information");
		logger.warn("msg d'avertissement");
		logger.error("msg d'erreur");
		logger.fatal("msg d'erreur fatale");
		
		Logger.getRootLogger().addAppender(new ConsoleAppender());
		Logger log1 = Logger.getLogger("org");
		log1.setAdditivity(false);
		log1.addAppender(new FileAppender(new SimpleLayout(), "progx.log"));
		Logger log2 = Logger.getLogger("org.progx");

		/*
		 * TRACE
		 * DEBUG
		 * INFO
		 * WARN
		 * ERROR
		 * FATAL
		 */

	}
}
