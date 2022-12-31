package animal;

public class Chien extends Carnivore {
	private String sexe;

	public void changerK1(String race) {
		switch (race) {
		case "Chiens nordiques":
			k1 = 0.8;
			break;
		case "Levrier":
			k1 = 1.1;
			break;
		case "Terier":
			k1 = 1.4;
			break;
		case "Danois":
			k1 = 1.5;
			break;
		default:
			k1 = 1;
			break;
		}
	}

	public void changerK4(String etat) {
		switch (etat) {
		case "Lethargique":
			k4 = 0.7;
			break;
		case "Tres calme":
			k4 = 0.8;
			break;
		case "Calme":
			k4 = 0.9;
			break;
		case "Actif":
			k4 = 1.1;
			break;
		case "Hyperactif":
			k4 = 1.2;
			break;
		default:
			k4 = 1;
			break;
		}
	}

	public Chien(double poids, String sexe) {
		super(poids);
		this.sexe = sexe;
	}

	private boolean estMale() {
		return sexe.equals("adulte male");
	}

	private double calculBEE() {
		return 130 * (Math.pow(poids, 0.75)) * k1 * k2 * k3 * k4;
	}

	private double calculBP(double bee) {
		return bee * 0.06;
	}

	@Override
	public void calculPortion() {
		double bee = calculBEE();
		double bp = calculBP(bee);
		if (estMale()) {
			portion[0] = bp * 0.8 / 0.19;
			portion[1] = (bee * 0.05) / 0.33;
			portion[2] = (bee * 0.05) / 9;
			portion[3] = (bee * 0.1) / 1.1;
			portion[4] = 1;
		} else {
			portion[0] = bp * 0.9 / 0.19;
			portion[1] = (bee * 0.05) / 0.33;
			portion[2] = (bee * 0.05) / 9;
			portion[4] = 3;

		}
	}
}