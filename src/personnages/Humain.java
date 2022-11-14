package personnages;

public class Humain {
	protected String nom;
	private String boisson;
	protected int argent;
	protected Humain[] memoire = new Humain[30];
	protected int nbConnaissance = 0;

	public Humain(String nom, String boisson, int argent) {
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
	}

	public String getNom() {
		return this.nom;
	}

	public int getArgent() {
		return this.argent;
	}

	protected void parler(String texte) {
		System.out.println("(" + this.nom + ") - " + texte);
	}

	public void direBonjour() {
		this.parler("Bonjour ! Je m'appelle " + this.nom + " et j'aime boire du " + this.boisson + ".");
	}

	public void boire() {
		this.parler("Mmmm, un bon verre de " + this.boisson + " ! GLOUPS !");
	}

	public void gagnerArgent(int gain) {
		this.argent += gain;
	}

	public void perdreArgent(int perte) {
		this.argent -= perte;
	}

	public void acheter(String bien, int prix) {
		if (this.argent > prix) {
			this.parler("J'ai " + this.argent + " sous en poche. Je vais pouvoir m'offrir un/une " + bien + " à " + prix
					+ " sous.");
			this.perdreArgent(prix);
		} else {
			this.parler("Je n'ai plus que " + this.argent + " sous en poche. Je ne peux même pas m'offrir un kimono à "
					+ prix + " sous.");
		}
	}

	public void faireConnaissanceAvec(Humain humain) {
		this.direBonjour();
		this.repondre(humain);
		this.memoriser(humain);
	}

	private void memoriser(Humain humain) {
		this.memoire[this.nbConnaissance] = humain;
		this.nbConnaissance = (this.nbConnaissance + 1) % 30;
	}

	private void repondre(Humain humain) {
		humain.direBonjour();
		humain.memoriser(this);
	}

	public void listerConnaissance() {
		this.parler("Je connais beaucoup de monde dont : ");
		for (Humain connaissance : this.memoire) {
			if (connaissance == null) {
				break;
			}
			System.out.print(connaissance.getNom() + " ");
		}
		System.out.println("");
	}
}
