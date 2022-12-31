package animal;

public class Chat extends Carnivore {
	public Chat(double poids) {
		super(poids);
	}

	public void changerK1(String race) {
		switch (race) {
		case "Abyssin":
			k1 = 1.2;
			break;
		case "bengal":
			k1 = 1.1;
			break;
		case "oriental shorhair":
			k1 = 1.1;
			break;
		case "savannah":
			k1 = 1.1;
			break;
		case "sphynx":
			k1 = 1.2;
			break;
		default:
			k1 = 1;
			break;
		}
	}

	public void changerK2(String age) {
		switch (age) {
		case "2 a 4":
			k2 = 2;
			break;
		case "4 a 6":
			k2 = 1.6;
			break;
		case "6 a 8":
			k2 = 1.3;
			break;
		case "8 a 12":
			k2 = 1.1;
			break;
		default:
			k2 = 1;
			break;
		}
	}

	public void changerK3(String corpulence) {
		switch (corpulence) {
		case "surpoids":
			k3 = 0.85;
			break;
		case "un peu maigre":
			k3 = 1.1;
			break;
		case "maigre":
			k3 = 1.3;
			break;
		default:
			k3 = 1;
			break;
		}
	}

	public void changerK4(String etat) {
		switch (etat) {
		case "tres calme":
			k1 = 0.8;
			break;
		case "calme":
			k1 = 0.9;
			break;
		case "actif":
			k1 = 1.1;
			break;
		default:
			k1 = 1;
			break;
		}
	}

	private double calculBEE() {
		return 100 * (Math.pow(poids, 0.67)) * k1 * k2 * k3 * k4;
	}

	private double calculBP(double bee) {
		return bee * 0.1;
	}

	@Override
	public void calculPortion() {
		double bee = calculBEE();
		double bp = calculBP(bee);
		portion[0] = bp / 0.19;
		portion[1] = (bee * 0.05) / 0.33;
		portion[2] = (bee * 0.05) / 9;
		portion[4] = 1;

	}

}
