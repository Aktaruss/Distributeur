package animal;

public class Carnivore {
	protected double k1 = 1;
	protected double k2 = 1;
	protected double k3 = 1;
	protected double k4 = 1;
	protected double poids;
	protected double[] portion = { 0, 0, 0, 0, 0 };

	public Carnivore(double poids) {
		this.poids = poids;
	}

	public void afficherPortionTotal() {
		System.out.println("Pour votre animal il faudrait par jour  " + "\nViande : " + portion[0] + "g\nLegume : "
				+ portion[1] + "g\nHuile : " + portion[2] + "g\nPate : " + portion[3] + "g\nNb de fois par jour : "
				+ portion[4]);
	}

	public void afficherPortion() {
		System.out.println("Une seule portion est egale a : \nViande : " + portion[0] / portion[4] + "g\nLegume : "
				+ portion[1] / portion[4] + "g\nHuile : " + portion[2] / portion[4] + "g\nPate : "
				+ portion[3] / portion[4] + "g");
	}

	public double getViande() {
		return portion[0] / 1000;
	}

	public double getLegume() {
		return portion[1] / 1000;
	}

	public double getHuile() {
		return portion[2] / 850;
	}

	public double getPate() {
		return portion[3] / 1000;
	}

	public double getNbFois() {
		return portion[4];
	}

	public void calculPortion() {
		// sert juste a etre redefini dans chien et chat
	}
}
