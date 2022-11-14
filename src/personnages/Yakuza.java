package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation;

	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
		this.reputation = 0;
	}

	public int getReputation() {
		return this.reputation;
	}

	public void extorquer(Commercant commercant) {
		int argent = commercant.getArgent();
		this.parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		this.parler(commercant.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		this.gagnerArgent(commercant.argent);
		commercant.seFaireExtorquer();
		this.parler("J’ai piqué les " + argent + " sous de " + commercant.getNom() + ", ce qui me fait "
				+ (argent + this.argent) + " sous dans ma poche. Hi ! Hi !");
	}

	public int perdre() {
		this.parler(
				"J’ai perdu mon duel et mes " + this.argent + " sous, snif... J'ai déshonoré le clan de " + this.clan);
		if (this.reputation > 0) {
			this.reputation -= 1;
		}
		return this.argent;
	}

	public void gagner(int gain) {
		this.parler("Ce ronin pensait vraiment battre " + this.getNom() + " du clan de " + this.clan
				+ " ? Je l'ai dépouillé de ses " + gain + " sous.");
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		this.parler("Mon clan est celui de " + this.clan);
	}
}
