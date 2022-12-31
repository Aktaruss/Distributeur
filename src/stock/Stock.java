package stock;

import animal.*;

public class Stock {
	private int nbMaxMarchandises = 10;
	private int nbViande = 0;
	private int nbPate = 0;
	private int nbLegume = 0;
	private int nbHuile = 0;
	private int nbMarchandises = 0;
	private Marchandises[] entrepot = new Marchandises[nbMaxMarchandises];

	public int getNbMaxMarxhandises() {
		return nbMaxMarchandises;
	}

	public int getNbViande() {
		return nbViande;
	}

	public int getNbPate() {
		return nbPate;
	}

	public int getNbLegume() {
		return nbLegume;
	}

	public int getNbHuile() {
		return nbHuile;
	}

	public int getNbMarchandises() {
		return nbMarchandises;
	}

	private void afficher(String texte) {
		System.out.println(texte);
	}

	public void afficherStock() {
		if (nbMarchandises <= 0) {
			afficher("Il n y a pas de marchandise dans cette machine");
		} else {
			afficher("Dans ce stock il y a : ");
			for (int i = 0; i < nbMarchandises; i++) {
				entrepot[i].afficherMarchandise();
			}
		}
	}

	private int trouverNourriture(Marchandises aliment) {
		int nb = 0;
		for (int i = 0; i < nbMarchandises; i++) {
			if (aliment == entrepot[i]) {
				return i;
			}
		}
		return nb;
	}

	public void ajouterNourriture(Marchandises aliment, String type) {
		if (nbMarchandises >= nbMaxMarchandises) {
			afficher("Il n y a plus de place dans cette entrepot");
		} else {
			entrepot[nbMarchandises] = aliment;
			nbMarchandises++;
			ajouternb(type, 1);
		}
	}

	public void changerNourriture(Marchandises ancienAliment, String ancienType, Marchandises nvAliment,
			String nvType) {
		int i = trouverNourriture(ancienAliment);
		entrepot[i] = nvAliment;
		ajouternb(nvType, 1);
		ajouternb(ancienType, -1);
	}

	private void ajouternb(String type, int nb) {
		switch (type) {
		case "viande":
			nbViande += nb;
			break;
		case "huile":
			nbHuile += nb;
			break;
		case "legume":
			nbLegume += nb;
			break;
		default:
			nbPate += nb;
			break;
		}

	}

	private void changerQuantite(Marchandises aliment, double quantite) {
		int i = trouverNourriture(aliment);
		entrepot[i].setQuantite(entrepot[i].getQuantite() + quantite);
	}

	public void ajouterQuantite(Marchandises aliment, double quantite) {
		changerQuantite(aliment, quantite);
	}

	public void retirerQuantite(Marchandises aliment, double quantite) {
		if (quantite > aliment.getQuantite()) {
			afficher("Il n y a pas assez de quantite pour " + aliment.getNom() + ".");
		} else {
			changerQuantite(aliment, -quantite);
		}
	}

	public void afficherBesoin(Carnivore animal, Viande viande, Legume legume, Huile huile, Pate pate, int nbJour) {
		if (contientIngredient(animal, viande, legume, huile, pate, nbJour)) {
			animal.afficherPortionTotal();
			if (animal.getNbFois() != 1) {
				System.out.println("\n");
				animal.afficherPortion();
			}
			System.out.println("\n");
			afficher("Pour un prix de : " + calculPrix(animal, viande, legume, huile, pate, nbJour) + " euros.");

		} else {
			afficher("Il n y a pas assez d ingredients dans les stocks.");
		}

	}

	private double calculPrix(Carnivore animal, Viande viande, Legume legume, Huile huile, Pate pate, int nbJour) {
		return (animal.getViande() * viande.getPrix() + animal.getLegume() * legume.getPrix()
				+ animal.getHuile() * huile.getPrix() + animal.getPate() * pate.getPrix()) * nbJour;
	}

	private boolean contientIngredient(Carnivore animal, Viande viande, Legume legume, Huile huile, Pate pate,
			int nbJour) {
		return animal.getViande() * nbJour <= viande.getQuantite()
				&& animal.getLegume() * nbJour <= legume.getQuantite()
				&& animal.getHuile() * nbJour <= huile.getQuantite() && animal.getPate() * nbJour <= pate.getQuantite();
	}

	public double sortirBesoin(double argent, Carnivore animal, Viande viande, Legume legume, Huile huile, Pate pate,
			int nbJour) {
		double argentDemandee = calculPrix(animal, viande, legume, huile, pate, nbJour);
		boolean disponibilite = contientIngredient(animal, viande, legume, huile, pate, nbJour);
		if (disponibilite && argentDemandee <= argent) {
			retirerCommande(animal, viande, legume, huile, pate, nbJour);
		}
		return argent - argentDemandee;
	}

	private void retirerCommande(Carnivore animal, Viande viande, Legume legume, Huile huile, Pate pate, int nbJour) {
		retirerQuantite(viande, animal.getViande() * nbJour);
		retirerQuantite(legume, animal.getLegume() * nbJour);
		retirerQuantite(huile, animal.getHuile() * nbJour);
		retirerQuantite(pate, animal.getPate() * nbJour);

	}
}