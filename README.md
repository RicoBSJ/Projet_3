OPENCLASSROOMS Projet 3 : Mettez votre logique à l'épreuve !

	1. COMPILATION

		1.1 Compilation avec IDE (Eclipse)

On lance l'application via Eclipse. On positionne le curseur sur le projet java et d'un clic droit, on acc�de � un menu. On choisit l'option "Export." On d�roule le menu "Java" et on choisit "Runnable JAR file", on clique sur "Next." Dans "Launch configuration", on d�signe le main du projet et dans "Export destination", on choisit le chemin d'enregistrement du fichier JAR. Dans "Library handling", on coche "Extract required libraries into generated JARD" et on clique sur "Finish" pour g�n�rer le fichier JAR

		1.2 Compilation en ligne de commande

Il faut tout d'abord cr�er un fichier que l'on nommera MANIFEST.MF, � partir d'un �diteur de texte. Dans ce fichier texte, on tape : "Main-Class: Main." Il est important de faire un retour chariot, sans �a, la compilation g�n�rera un erreur. On enregistre ce fichier dans le r�pertoire du projet java. On ouvre le terminal (ou la console pour Windows) et on se rend dans le r�pertoire du projet java. On tape sur la ligne de commande : jar cvmf MANIFEST.MF Test.jar bin\com\*.class (si l'on travaille sur Mac, il faudra taper : jar cvmf MANIFEST.MF Test.jar bin/com/*.class) On tape sur Entr�e et le fichier est compil�.

	2. LANCEMENT DU LOGICIEL

		2.1 Lancement du logiciel avec IDE (Eclipse)

Dans le menu "Run", on choisit "Run Configurations." Une fen�tre s'ouvre, on v�rifie que l'onglet "Main" soit correctement renseign�. On se rend dans l'onglet "Arguments" et, si l'on souhaite activer le mode d�veloppeur, on tape "-dev." On clique en bas sur "Apply" et sur "Run."

		2.2 Lancement du logiciel en ligne de commande
		
On lance l'application en utilisant le fichier OCR_Projet_3_DA_Java_AUBRUN_Eric.jar :
- Il est nécessaire de décompresser le fichier dans un répertoire.
- Ensuite, lancer l'invite de commande depuis le répertoire où le fichier a été décompressé.
- Dans l'invite de commande, exécuter la commande java -jar OCR_Projet_3_DA_Java_AUBRUN_Eric.jar.
- L'application se lance.

	3. PARAMETRAGE DU JEU

		3.1 Fichier properties

Le fichier "config.properties" contient les 4 variables "longueurCombinaison", "nombreEssai", "tabColor" et "dev". Dans le fichier properties, des valeurs sont affect�es � ces variables et si le d�veloppeur souhaite modifier ces valeurs, c'est � cet endroit-ci qu'il devra le faire : augmenter ou diminuer la longueur de la combinaison de chiffres ou de couleurs ainsi que le nombre maximum d'essais. Les deux autres variables ne devraient en principe pas �tre modidif�es : "tabColor" affiche les couleurs disponibles et "dev" est une variable boul�enne initialis�e � false. Si "dev" passe � l'�tat "true", le mode d�veloppeur sera activ�.

		3.2 Mode développeur

Si l'on souhaite activer le mode développeur, en ligne de commande ou via Eclipse, il est nécessaire de rajouter l'option "-dev".
