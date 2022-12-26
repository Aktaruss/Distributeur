package stock;

public class Main {
	public static void main(String[] args) {
		Stock entrepot = new Stock();
		Huile test = new Huile(10, "Huile");
		Viande test1 = new Viande(10, "viande");
		Pate test2 = new Pate(10, "Pate");
		Legume test3 = new Legume(10, "Legume");
		entrepot.ajouterNourriture(test);
		entrepot.ajouterNourriture(test1);
		entrepot.ajouterNourriture(test2);
		entrepot.ajouterNourriture(test3);
		entrepot.changerQuantite(test,-5);
		entrepot.afficherStock();
	}
}
