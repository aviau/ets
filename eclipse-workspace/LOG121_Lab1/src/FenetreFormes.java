/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FenetreFormes.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JComponent;

/**
 * Cette fenêtre gère l'affichage des formes
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetreFormes extends JComponent{

	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(500,500);
	private ListeFormes formes;

	/**
	 * Constructeur
	 */
	public FenetreFormes(ListeFormes formes){
		this.formes = formes;
	}

	/**
	 * Affiche la liste de formes
	 */
	@Override
	public void paintComponent(Graphics g){

		// Affiche la liste de formes
		for (Forme forme : formes){
			forme.dessiner(g);
		}
	}

	/*
	 * Le Layout qui utilise (contient) FenetreFormes doit réserver
	 * l'espace nécessaire à son affichage
	 */
	@Override
	public Dimension getPreferredSize(){
		return dimension;
	}
}
