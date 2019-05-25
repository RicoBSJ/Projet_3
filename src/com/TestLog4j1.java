package com;

import java.util.logging.Logger;

public class TestLog4j1 {

  final static Logger logger = Logger.getLogger("TestLog4j1");
  
  public static void main(String[] args) {
	  
    logger.debug("msg de debogage");
    logger.info("msg d'information");
    logger.warn("msg d'avertissement");
    logger.error("msg d'erreur");
    logger.fatal("msg d'erreur fatale");
  }
}