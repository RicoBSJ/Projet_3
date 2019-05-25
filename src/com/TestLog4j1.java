package com;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestLog4j1 {

  final static Logger logger = Logger.getLogger("TestLog4j1");
  
  public static void main(String[] args) {
	  
    logger.log(Level.DEBUG,"msg de debogage");
    logger.log(Level.INFO,"msg d'information");
    logger.log(Level.WARN,"msg d'avertissement");
    logger.log(Level.ERROR,"msg d'erreur");
    logger.log(Level.FATAL,"msg d'erreur fatale");
  }
}