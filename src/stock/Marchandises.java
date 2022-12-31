package stock;

public class Marchandises {
	protected double quantite;
	protected String mesure;
	protected String nom;
	protected double prix;

	public Marchandises(double quantite, String mesure, String nom, double prix) {
		super();
		this.quantite = quantite;
		this.mesure = mesure;
		this.nom = nom;
		this.prix = prix;
	}

	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(double quantite) {
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

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	protected void afficher(String texte) {
		System.out.println(texte);
	}

	public void afficherMarchandise() {
		afficher(nom + " : " + quantite + mesure + " a " + prix + " eur/" + mesure + ".");
	}

}
