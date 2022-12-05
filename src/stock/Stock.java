package stock;

public class Stock {
	private int viande;
	private int legumeVerts;
	private int huileColza;
	private int pates;

	public Stock(int viande, int legumeVerts, int huileColza, int pates) {
		super();
		this.viande = viande;
		this.legumeVerts = legumeVerts;
		this.huileColza = huileColza;
		this.pates = pates;
	}

	public int getViande() {
		return viande;
	}

	public void setViande(int viande) {
		this.viande = viande;
	}

	public int getLegumeVerts() {
		return legumeVerts;
	}

	public void setLegumeVerts(int legumeVerts) {
		this.legumeVerts = legumeVerts;
	}

	public int getHuileColza() {
		return huileColza;
	}

	public void setHuileColza(int huileColza) {
		this.huileColza = huileColza;
	}

	public int getPates() {
		return pates;
	}

	public void setPates(int pates) {
		this.pates = pates;
	}

	public void afficher(String texte) {
		System.out.println(texte);
	}

	public void ajouter(int ajout, String nom) {
		switch (nom) {
		case "viande":
			setViande(ajout + viande);
			afficher("La viande est maintenant a " + viande + " kilos.");
			break;
		case "legume":
			setLegumeVerts(ajout + legumeVerts);
			afficher("Les legume sont maintenant a " + legumeVerts + " kilos.");
			break;
		case "huile":
			setHuileColza(ajout + huileColza);
			afficher("L huile est maintenant a " + huileColza + " litre.");
			break;
		case "pate":
			setViande(ajout + viande);
			afficher("Les pates sont maintenant a " + pates + " kilos.");
			break;

		default:
			break;
		}
	}

	
	
}