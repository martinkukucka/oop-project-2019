package VozidloUdaje;

// TODO: Auto-generated Javadoc
/**
 * trieda, ktor� sl��i na zistenie kateg�rie vozidla (Motocykel, Osobn� auto, N�kladn� auto)
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
	 *	funkcia vracia ak� kateg�ria vozidla bola zvolen� (Motocykel, Osobn� auto, N�kladn� auto)
	 * @return the string
	 */
	public String returnkategoriavozidla() {
		return kategoriavozidla;
	}
}
