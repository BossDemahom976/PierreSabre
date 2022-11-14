package personnages;

import java.util.Random;

public class Traitre extends Samourai {
	public int niveauTraitrise = 0;

	public Traitre(String seigneur, String nom, String boisson, int argent) {
		super(seigneur, nom, boisson, argent);
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		this.parler("Mon niveau de traitrise est de " + this.niveauTraitrise + ".");
	}

	public void ranconner(Commercant commercant) {
		if (this.niveauTraitrise < 3) {
			int argentRanconner = commercant.getArgent() * 2 / 10;
			commercant.perdreArgent(argentRanconner);
			this.gagnerArgent(argentRanconner);
			++this.niveauTraitrise;
			this.parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi" + argentRanconner
					+ " sous ou gare à toi !");
			commercant.parler("Tout de suite grand " + this.getNom() + ".");
		} else {
			this.parler("Mince je ne peux plus rançonner personne sinon un samouraï risque de me démasquer !");
		}
	}

	public void faireLeGentil() {
		if (this.nbConnaissance < 1) {
			this.parler("Je ne peux pas faire ami ami avec personne car je ne connais personne ! Snif.");
		} else {
			Random rand = new Random();
			int don = this.argent * 1 / 20;
			Humain Ami = this.memoire[rand.nextInt(this.nbConnaissance)];
			this.parler("il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + Ami.getNom()
					+ ".");
			this.parler("Bonjour l'ami ! " + "Je voudairais vous aider en vous donnant " + don + " sous.");
			Ami.gagnerArgent(don);
			this.perdreArgent(don);
			Ami.parler("Merci" + this.getNom() + " Vous êtes quelqu'un de bien.");
			--this.niveauTraitrise;
		}
	}
}
