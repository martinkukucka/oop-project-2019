package VozidloUdaje;

// TODO: Auto-generated Javadoc
/**
 * trieda, ktorá slúži na zistenie kategórie vozidla (Motocykel, Osobné auto, Nákladné auto)
 * The Class ClassKategoriaVozidla.
 */
public class ClassKategoriaVozidla {
	
	/** The kategoriavozidla. */
	private String kategoriavozidla;
	
	/**
	 * Instantiates a new class kategoria vozidla.
	 *
	 * @param kategoriavozidla the kategoriavozidla
	 */
	public ClassKategoriaVozidla(String kategoriavozidla) {
		this.kategoriavozidla = kategoriavozidla;
	}

	/**
	 * Returnkategoriavozidla.
	 *	funkcia vracia aká kategória vozidla bola zvolená (Motocykel, Osobné auto, Nákladné auto)
	 * @return the string
	 */
	public String returnkategoriavozidla() {
		return kategoriavozidla;
	}
}
