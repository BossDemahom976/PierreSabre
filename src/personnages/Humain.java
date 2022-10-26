package personnages;

public class Humain {
	private String nom;
	private String boisson;
	private int argent;

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

	private void parler(String texte) {
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
			this.parler("J'ai " + this.argent + " sous en poche. Je vais pouvoir m'offrir un/une " + bien + " � " + prix
					+ " sous.");
			this.perdreArgent(prix);
		} else {
			this.parler("Je n'ai plus que " + this.argent + " sous en poche. Je ne peux m�me pas m'offrir un kimono � "
					+ prix + " sous.");
		}
	}

}
