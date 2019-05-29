package com;

import org.apache.log4j.Logger;

public class log4jExample {
	/* Get actual class name to be printed on */
	private static Logger log = Logger.getLogger(log4jExample.class);

	public static void main(String[] args) {

		log.debug("msg de debogage");
		log.info("msg d'information");
		log.warn("msg d'avertissement");
		log.error("msg d'erreur");
		log.fatal("msg d'erreur fatale");

	}
}
