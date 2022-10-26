package histoire;

import personnages.Commercant;
import personnages.Humain;
import personnages.Ronin;
import personnages.Yakuza;

public class HistoireTP4 {

	public static void main(String[] args) {

		Humain prof = new Humain("Prof", "kombucha", 54);
		prof.direBonjour();
		prof.acheter("boisson", 12);
		prof.boire();
		prof.acheter("jeu", 2);
		prof.acheter("kimono", 50);

		Commercant commercant = new Commercant("Marco", 15);
		commercant.direBonjour();
		commercant.seFaireExtorquer();
		commercant.recevoir(15);
		commercant.boire();

		Yakuza yakuza = new Yakuza("Yaku Le Noir", "whisky", 30, "Warsong");
		yakuza.direBonjour();
		yakuza.extorquer(commercant);

		Ronin ronin = new Ronin("Roro", "shochu", 60);
		ronin.direBonjour();
		ronin.donner(commercant);

		ronin.provoquer(yakuza);
	}

}
