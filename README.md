OPENCLASSROOMS Projet 3 : Mettez votre logique Ã  l'Ã©preuve !

	1. COMPILATION

		1.1 Compilation avec IDE (Eclipse)

On lance l'application via Eclipse. On positionne le curseur sur le projet java et d'un clic droit, on accède à un menu. On choisit l'option "Export." On déroule le menu "Java" et on choisit "Runnable JAR file", on clique sur "Next." Dans "Launch configuration", on désigne le main du projet et dans "Export destination", on choisit le chemin d'enregistrement du fichier JAR. Dans "Library handling", on coche "Extract required libraries into generated JARD" et on clique sur "Finish" pour générer le fichier JAR

		1.2 Compilation en ligne de commande

Il faut tout d'abord créer un fichier que l'on nommera MANIFEST.MF, à partir d'un éditeur de texte. Dans ce fichier texte, on tape : "Main-Class: Main." Il est important de faire un retour chariot, sans ça, la compilation génèrera un erreur. On enregistre ce fichier dans le répertoire du projet java. On ouvre le terminal (ou la console pour Windows) et on se rend dans le répertoire du projet java. On tape sur la ligne de commande : jar cvmf MANIFEST.MF Test.jar bin\com\*.class (si l'on travaille sur Mac, il faudra taper : jar cvmf MANIFEST.MF Test.jar bin/com/*.class) On tape sur Entrée et le fichier est compilé.

	2. LANCEMENT DU LOGICIEL

		2.1 Lancement du logiciel avec IDE (Eclipse)

Dans le menu "Run", on choisit "Run Configurations." Une fenêtre s'ouvre, on vérifie que l'onglet "Main" soit correctement renseigné. On se rend dans l'onglet "Arguments" et, si l'on souhaite activer le mode développeur, on tape "-dev." On clique en bas sur "Apply" et sur "Run."

		2.2 Lancement du logiciel en ligne de commande
		
On lance l'application en utilisant le fichier OCR_Projet_3_DA_Java_AUBRUN_Eric.jar :
- Il est nÃ©cessaire de dÃ©compresser le fichier dans un rÃ©pertoire.
- Ensuite, lancer l'invite de commande depuis le rÃ©pertoire oÃ¹ le fichier a Ã©tÃ© dÃ©compressÃ©.
- Dans l'invite de commande, exÃ©cuter la commande java -jar OCR_Projet_3_DA_Java_AUBRUN_Eric.jar.
- L'application se lance.

	3. PARAMETRAGE DU JEU

		3.1 Fichier properties

Le fichier "config.properties" contient les 4 variables "longueurCombinaison", "nombreEssai", "tabColor" et "dev". Dans le fichier properties, des valeurs sont affectées à ces variables et si le développeur souhaite modifier ces valeurs, c'est à cet endroit-ci qu'il devra le faire : augmenter ou diminuer la longueur de la combinaison de chiffres ou de couleurs ainsi que le nombre maximum d'essais. Les deux autres variables ne devraient en principe pas être modidifées : "tabColor" affiche les couleurs disponibles et "dev" est une variable bouléenne initialisée à false. Si "dev" passe à l'état "true", le mode développeur sera activé.

		3.2 Mode dÃ©veloppeur

Si l'on souhaite activer le mode dÃ©veloppeur, en ligne de commande ou via Eclipse, il est nÃ©cessaire de rajouter l'option "-dev".
