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

	public void provoquer(Yakuza advairsaire) {
		int force = this.honneur * 2;
		this.parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		if (force >= advairsaire.getReputation()) {
			this.parler("Je t’ai eu petit yakusa!");
			advairsaire.perdre();
		} else {
			this.parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			this.honneur -= 1;
			advairsaire.gagner(this.argent);
			this.perdreArgent(this.argent);
		}
	}
}
