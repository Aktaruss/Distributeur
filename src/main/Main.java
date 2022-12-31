package main;

import stock.*;
import animal.*;

public class Main {
	private static void ajoutCalcul(Stock entrepot, Viande viande, Legume legume, Pate pate, Huile huile,
			Carnivore animal) {
		entrepot.ajouterNourriture(huile, "huile");
		entrepot.ajouterNourriture(viande, "viande");
		entrepot.ajouterNourriture(pate, "pate");
		entrepot.ajouterNourriture(legume, "legume");
		animal.calculPortion();
	}

	public static void chienNormalAdulte(Stock entrepot, Viande viande, Legume legume, Pate pate, Huile huile,
			Carnivore animal, int nbJour) {
		double argentRedonner;
		ajoutCalcul(entrepot, viande, legume, pate, huile, animal);
		entrepot.afficherStock();
		System.out.println("\n");
		entrepot.afficherBesoin(animal, viande, legume, huile, pate, nbJour);
		System.out.println("\n");
		argentRedonner = entrepot.sortirBesoin(365, animal, viande, legume, huile, pate, nbJour);
		System.out.println(argentRedonner);
		System.out.println("\n");
		entrepot.afficherStock();
	}

	public static void chienNormalBebe(Stock entrepot, Viande viande, Legume legume, Pate pate, Huile huile,
			Carnivore animal, int nbJour) {
		double argentRedonner;
		ajoutCalcul(entrepot, viande, legume, pate, huile, animal);
		entrepot.afficherStock();
		System.out.println("\n");
		entrepot.afficherBesoin(animal, viande, legume, huile, pate, nbJour);
		System.out.println("\n");
		argentRedonner = entrepot.sortirBesoin(365, animal, viande, legume, huile, pate, nbJour);
		System.out.println(argentRedonner);
		System.out.println("\n");
		entrepot.afficherStock();
	}

	public static void chatTresCalme(Stock entrepot, Viande viande, Legume legume, Pate pate, Huile huile,
			Carnivore animal, int nbJour) {
		double argentRedonner;
		animal.changerK4("tres calme");
		ajoutCalcul(entrepot, viande, legume, pate, huile, animal);
		entrepot.afficherStock();
		System.out.println("\n");
		entrepot.afficherBesoin(animal, viande, legume, huile, pate, nbJour);
		System.out.println("\n");
		argentRedonner = entrepot.sortirBesoin(365, animal, viande, legume, huile, pate, nbJour);
		System.out.println(argentRedonner);
		System.out.println("\n");
		entrepot.afficherStock();
	}

	public static void main(String[] args) {
		int nbJour = 7;
		Stock entrepot = new Stock();
		Viande steakHachee = new Viande(100, "Steack hachee", 14.98);
		Legume legumevert = new Legume(100, "Legume vert", 3);
		Huile huileColza = new Huile(100, "huile de colza", 2.47);
		Pate macaronni = new Pate(100, "macaronni", 2.19);
		Chien dingo = new Chien(25, "adulte male");
		Chien bethoven = new Chien(10, "bebe male");
		Chat garfield = new Chat(9);
		chienNormalAdulte(entrepot, steakHachee, legumevert, macaronni, huileColza, dingo, nbJour);
//		chienNormalBebe(entrepot, steakHachee, legumevert, macaronni, huileColza, bethoven, nbJour);
//		chatTresCalme(entrepot, steakHachee, legumevert, macaronni, huileColza, garfield, nbJour);
	}

}