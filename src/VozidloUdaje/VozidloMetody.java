package VozidloUdaje;

import javafx.scene.text.Text;

// TODO: Auto-generated Javadoc
/**
 * interface pre triedy Motocykel,OsobneAuto,NakladneAuto
 * The Interface VozidloMetody.
 * 
 */
public interface VozidloMetody {
	
	/**
	 * Returnecv.
	 *
	 * @return the class ECV
	 */
	public ClassECV returnecv();
	
	/**
	 * Returnrokvyroby.
	 *
	 * @return the int
	 */
	public int returnrokvyroby();
	
	/**
	 * Returndruhpaliva.
	 *
	 * @return the string
	 */
	public String returndruhpaliva();
	
	/**
	 * Returnprevodovka.
	 *
	 * @return the string
	 */
	public String returnprevodovka();
	
	/**
	 * Returnobjemvalcov.
	 *
	 * @return the int
	 */
	public int returnobjemvalcov();
	
	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isempty();
	
	/**
	 * Ulozudaje.
	 */
	public void ulozudaje();
	
	/**
	 * Skontrolujudaje.
	 *
	 * @return true, if successful
	 */
	public boolean skontrolujudaje();
	
	/**
	 * Precitajudaje.
	 *
	 * @param ta the ta
	 */
	public void precitajudaje(Text ta);
	
	/**
	 * Vypocitajvyskunazakladevozidla.
	 *
	 * @return the double
	 */
	public double vypocitajvyskunazakladevozidla();
	
	/**
	 * interface rozsireny o funkciu pre nakladne auto
	 * The Interface NaklVozidlo.
	 */
	interface NaklVozidlo {
		
		/**
		 * Returnhmotnost.
		 *
		 * @return the string
		 */
		public String returnhmotnost() ;
	}
	
	/**
	 * interface rozsireny o funkciu pre osobne auto
	 * The Interface OsobVozidlo.
	 */
	interface OsobVozidlo {
		
		/**
		 * Returnpohon.
		 *
		 * @return the string
		 */
		public String returnpohon() ;
	}
}
