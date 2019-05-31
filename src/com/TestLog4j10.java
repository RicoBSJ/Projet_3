package com;

import java.io.*;
import org.apache.log4j.*;
import org.apache.log4j.xml.XMLLayout;

public class TestLog4j10 {
  
  public static void main(
      String[] args) {
    Logger logRoot = Logger.getRootLogger();
    ConsoleAppender ca = new ConsoleAppender();
    ca.setName("console");
    ca.setLayout(new SimpleLayout());
    ca.activateOptions();
    logRoot.addAppender(ca);
    logRoot.setLevel(Level.DEBUG);
    
    logRoot.debug("message 1");
    
    Logger log = Logger.getLogger(TestLog4j10.class);
    
    log.setAdditivity(false);
    try {
      FileAppender fa = new FileAppender(new XMLLayout(), "c:/log.txt");
      fa.setName("FichierLog");
      log.addAppender(fa);
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    log.debug("message 2");
    
    Logger logTest = Logger.getLogger("com.jmdoudoux.test.log4j");
    logTest.debug("message 3");
  }
}