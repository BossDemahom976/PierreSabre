package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation;

	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
		this.reputation = 0;
	}

	public void extorquer(Commercant commercant) {
		int argent = commercant.getArgent();
		this.parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		this.parler(commercant.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		commercant.seFaireExtorquer();
		this.parler("J’ai piqué les " + argent + " sous de " + commercant.getNom() + ", ce qui me fait "
				+ (argent + this.argent) + " sous dans ma poche. Hi ! Hi !");
		this.gagnerArgent(commercant.argent);
	}
}
