package personnages;

public class Commercant extends Humain {

	public Commercant(String nom, int argent) {
		super(nom, "th�", argent);
	}

	public int seFaireExtorquer() {
		this.perdreArgent(this.argent);
		this.parler("J�ai tout perdu! Le monde est trop injuste...");
		return this.argent;
		// On peut aussi utiliser this.getArgent() a la place de argent
	}

	public void recevoir(int gain) {
		this.gagnerArgent(gain);
		this.parler(gain + " sous ! Je te remercie g�n�reux donateur!");
	}

}
