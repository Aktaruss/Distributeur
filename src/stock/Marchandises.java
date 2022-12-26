package stock;

public class Marchandises {
	private int quantite;
	private String mesure;
	private String nom;

	public Marchandises(int quantite, String mesure, String nom) {
		super();
		this.quantite = quantite;
		this.mesure = mesure;
		this.nom = nom;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getMesure() {
		return mesure;
	}

	public void setMesure(String mesure) {
		this.mesure = mesure;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void afficher(String texte) {
		System.out.println(texte);
	}

	public void afficherMarchandise() {
		afficher("Il y a " + quantite + " " + mesure + " de " + nom + ".");
	}

}
