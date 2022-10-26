package personnages;

public class Ronin extends Humain {

	private int honneur;

	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
		this.honneur = 1;
	}

	public void donner(Commercant commercant) {
		int argent = (int) (this.argent * 0.10);
		this.parler(commercant.getNom() + " prend ces " + argent + " sous.");
		this.perdreArgent(argent);
		commercant.recevoir(argent);
	}
}
