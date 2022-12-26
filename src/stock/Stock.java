package stock;

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

	public void afficher(String texte) {
		System.out.println(texte);
	}

	public void afficherStock() {
		if (nbMarchandises <= 0) {
			afficher("Il n y a pas de marchandise dans cette machine");
		} else {
			afficher("Dans ce stock : ");
			for (int i = 0; i < nbMarchandises; i++) {
				entrepot[i].afficherMarchandise();
			}
		}
	}

	public void ajouterNourriture(Marchandises aliment) {
		if (nbMarchandises >= nbMaxMarchandises) {
			afficher("Il n y a plus de place dans cette entrepot");
		} else {
			entrepot[nbMarchandises] = aliment;
			nbMarchandises++;
		}
	}

	public void changerQuantite(Marchandises aliment, int quantite) {
		for (int i = 0; i < nbMarchandises; i++) {
			if (aliment == entrepot[i]) {
				entrepot[i].setQuantite(entrepot[i].getQuantite() + quantite);
			} 
		}
	}
}