package User;

// TODO: Auto-generated Javadoc
// Name/meno: admin
// Password/heslo: admin


/**
 * The Class Admin.
 */
public class Admin {
	
	/** The meno. */
	private String meno;
    
    /** The heslo. */
    private String heslo;
    
    /**
     * Instantiates a new admin.
     *
     * @param meno the meno
     * @param heslo the heslo
     */
    public Admin(String meno, String heslo) {
        this.meno = meno;
        this.heslo = heslo;
    }
    
    /**
     * Skontrolujudaje.
     *	funkcia kontroluje èi boli zadané správne údaje
     * @return true, if successful
     */
    public boolean skontrolujudaje() {
    	if(meno.equals("admin") && heslo.equals("admin")) return true;
    	else return false;
    }
    
}
