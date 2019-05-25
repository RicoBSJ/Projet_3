package com;

import java.util.logging.*;

public class TestLog4j1 {

  final static Logger logger = Logger.getLogger("TestLog4j1");
  
  public static void main(String[] args) {

      logger.severe("serious failure");
      logger.warning("potential problem");
      logger.info("informational messages");
      logger.config("static configuration messages");
      logger.fine("tracing information");
      logger.finer("fairly detailed tracing message");
      logger.finest("highly detailed tracing message");
  }
}