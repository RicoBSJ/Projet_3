package com;

import java.io.*;

import org.apache.log4j.Logger;

public class FileLecteur {
	
	protected static Logger logger = Logger.getLogger(FileLecteur.class);

	static public void read() {

		File file = new File("variables.properties");
		BufferedReader bufferedReader = null;

		try {
			FileReader fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			String line;
			while ((line = bufferedReader.readLine()) != null) {

				String[] sep = line.split("=");
				if (sep[0].equals("longueurCombinaison")) {
					Constante.longueurCombinaison = Integer.parseInt(sep[1]);
				} else if (sep[0].equals("nombreEssai")) {
					Constante.nombreEssai = Integer.parseInt(sep[1]);
				} else if (sep[0].equals("tabColor")) {
					String tmp = sep[1];
					Constante.tabColor = tmp.split(",");
				}
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