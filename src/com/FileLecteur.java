package com;

import java.io.*;
import org.apache.log4j.Logger;

public class FileLecteur {

	protected static Logger logger = Logger.getLogger(log4jExample.class);

	static public void read() {
		logger.info("Je vais lire un fichier");
		File file = new File("variables.properties");
		BufferedReader bufferedReader = null;

		try {
			FileReader fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				logger.info(line);
			}

		} catch (FileNotFoundException e) {
			logger.error("Le fichier n'a pas été trouvé");
		} catch (IOException e) {
			logger.error("Impossible de lire le contenu du fichier");
		}

		try {
			bufferedReader.close();
		} catch (IOException e) {
			logger.error("Impossible de fermer le fichier");
		} catch (NullPointerException e) {
			logger.error("Impossible d'ouvrir le fichier");
		}
	}
}