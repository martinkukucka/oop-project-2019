package Poistenie;

import User.User;
import VozidloUdaje.ClassKategoriaVozidla;
import VozidloUdaje.Motocykel;
import VozidloUdaje.NakladneAuto;
import VozidloUdaje.OsobneAuto;

// TODO: Auto-generated Javadoc
/**
 * The Class CenaPoistenia.
 */
public class CenaPoistenia{

	/** The cena. */
	private double cena;

	/** The auto. */
	OsobneAuto auto;
	
	/** The moto. */
	Motocykel moto;
	
	/** The nauto. */
	NakladneAuto nauto;
	
	/** The pouzivatel. */
	User pouzivatel;
	
	/** The bp. */
	BonusovePoistenie bp;
	
	/**
	 * The Interface xcena.
	 */
	interface xcena{  
		// interface pre lambda výraz
    	/**
    	 * Rcena.
    	 *
    	 * @return the double
    	 */
    	public double rcena();  
	}  
	
	/**
	 * Instantiates a new cena poistenia.
	 *
	 * @param cena the cena
	 */
	public CenaPoistenia(double cena) {
		this.cena = cena;
	}
	
	/**
	 * Gets the cena.
	 *
	 * @return the cena
	 */
	public double getcena() {
		return cena;
	}
	
	/**
	 * Instantiates a new cena poistenia.
	 *
	 * @param pouzivatel the pouzivatel
	 * @param classkv the classkv
	 * @param auto the auto
	 * @param moto the moto
	 * @param nauto the nauto
	 * @param bp the bp
	 * do premennej cena sa naèíta suma vypoèítana vo funkcii vypocitajvyskunazakladevozidla() pod¾a toho, ktoré vozidlo chce používate¾ poisti
	 */
	public CenaPoistenia(User pouzivatel, ClassKategoriaVozidla classkv, OsobneAuto auto, Motocykel moto, NakladneAuto nauto, BonusovePoistenie bp) {
		this.auto = auto;
		this.moto = moto;
		this.nauto = nauto;
		this.pouzivatel = pouzivatel;
		this.bp = bp;
		
		if(classkv.returnkategoriavozidla().equals("Osobné auto")) cena = auto.vypocitajvyskunazakladevozidla();
		else if (classkv.returnkategoriavozidla().equals("Motocykel")) cena = moto.vypocitajvyskunazakladevozidla();
		else if (classkv.returnkategoriavozidla().equals("Nákladné auto")) cena = nauto.vypocitajvyskunazakladevozidla();
		cena = cena * pouzivatel.vypocitajvyskunazakladeusera() * bp.vypocitajvyskunazakladepoistenia();
	}

	/** The price. */
	//použitie lambda  výrazu na vrátenie ceny
	xcena price=()->{ 
		cena = Math.floor(cena * 100) / 100;
        return cena;  
    };  
	
	/**
	 * Returncena.
	 * funkcia vracia hodnotu typu double s použitím lambda výrazu
	 * @return the double
	 */
	public double returncena() {
		return price.rcena();
	}
}