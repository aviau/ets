/****************************************
Cours:              LOG121
Session:            Automne 2014
Groupe:             03
Projet:             Exercice 1
Étudiant(e)(s)      Viau, Alexandre
Code(s) perm.:      VIAA08029409
Chargé de cours:    Dominic St-Jacques
Chargés de labo:    Alvine Boaye et Jean-Nichola Blanchet
Nom du ficher:      Bonjour.java
Date créé:          2014-09-12
Date dern. modif.:  2014-09-12
 *****************************************
Historique des modificaitons
 *****************************************
2014-09-12          Version initiale
 *****************************************/

import java.util.regex.*;

public class CreateurFormes {

	private static CreateurFormes createurFormes = new CreateurFormes();

	/*
	 * Input possible:
	 * 9999 <CARRE> x1 y1 x2 y2 </CARRE>
	 * 9999 <RECTANGLE> x1 y1 x2 y2 </RECTANGLE>
	 * 9999 <CERCLE> centreX centreY rayon </CERCLE>
	 * 49152 <OVALE> 164 82 10 69 </OVALE>
	 * 9999 <LIGNE> x1 y1 x2 y2 </LIGNE>
	 * Regex sans escape: (\p{Alnum}+) <(CERCLE|OVALE|LIGNE|RECTANGLE|CARRE)>(( \p{Alnum}+)+) </(CERCLE|OVALE|LIGNE|RECTANGLE|CARRE)>
	 * Doc regex: http://docs.oracle.com/javase/6/docs/api/java/util/regex/Pattern.html
	 */
	Pattern pattern = Pattern.compile("(\\p{Alnum}+) <(CERCLE|OVALE|LIGNE|RECTANGLE|CARRE)>(( \\p{Alnum}+)+) </(CERCLE|OVALE|LIGNE|RECTANGLE|CARRE)>");


	/*
	 * Pattern de Singleton emprunté ici: http://www.tutorialspoint.com/java/java_using_singleton.htm
	 */
	private CreateurFormes(){}

	public static CreateurFormes getInstance( ) {
		return createurFormes;
	}

	/**
	 * Crée une nouvelle forme. Cette méthode reçoit la chaîne de
	 * caractères provenant du serveur de formes, elle détermine de quelle
	 * forme il s'agit et applique l'opérateur new sur le constructeur de
	 * la forme désirée.
	 *
	 * @param chaineForme un objet String contenant la chaîne de caractères
	 * qui décrit une forme et provenant du serveur de formes.
	 *
	 * @return une instance d'une des sous-classes de la classe abstraite
	 *
	Forme avec les paramètres passés par la chaîne d'entrée.
	 */
	public Forme creerForme(String chaineForme) {

		Matcher matcher = pattern.matcher(chaineForme);
		Forme forme = null;

		if (matcher.matches()){
			String nseq = matcher.group(1);
			String typeForme = matcher.group(2);

			/*
			 * Code pour split emprunté: http://stackoverflow.com/questions/8348591/splitting-string-and-put-it-on-int-array
			 */
			String[] strArray = matcher.group(3).trim().split(" ");
			int[] points = new int[strArray.length];
			for(int i = 0; i < strArray.length; i++) {
				points[i] = Integer.parseInt(strArray[i]);
			}

			switch (typeForme) {
			case "CERCLE":
				forme = new Cercle();
				break;
			case "OVALE":
				forme = new Ovale();
				break;
			case "LIGNE":
				forme = new Ligne();
				break;
			case "RECTANGLE":
				forme = new Rectangle();
				break;
			case "CARRE":
				forme = new Carre();
				break;
			}
		}

		return forme;
	}

}
