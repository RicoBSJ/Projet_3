package com;

import java.util.logging.*;
import java.io.*;
import java.sql.SQLException;

public class log4jExample {
	/* Get actual class name to be printed on */
	static Logger log = Logger.getLogger(log4jExample.class.getName());

	public static void main(String[] args)

			throws IOException, SQLException {

		log.severe("serious failure");
		log.warning("potential problem");
		log.info("informational messages");
		log.config("static configuration messages");
		log.fine("tracing information");
		log.finer("fairly detailed tracing message");
		log.finest("highly detailed tracing message");
	}
}
