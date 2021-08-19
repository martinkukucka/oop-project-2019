package VozidloUdaje;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Poistenie.CenaPoistenia;

// TODO: Auto-generated Javadoc
/**
 * The Class Vozidlo.
 */
/* metódy a funkcie pre triedy Motocykel, OsobneAuto, NakladneAuto
 * The Class Vozidlo.
 */
public class Vozidlo {
    
	/** The cecv. */
	ClassECV cecv;
	
	/** The znacka. */
	protected String znacka;
    
    /** The model. */
    protected String model;
    
    /** The rokvyroby. */
    protected String rokvyroby;
    
    /** The prevodovka. */
    protected String prevodovka;
    
    /** The druhpaliva. */
    protected String druhpaliva;
    
    /** The objemvalcov. */
    protected String objemvalcov;
    
    /** The cena. */
    CenaPoistenia cena;
    
    /**
     * Instantiates a new vozidlo.
     *
     * @param cena the cena
     * @param cecv the cecv
     * @param znacka the znacka
     * @param model the model
     * @param rokvyroby the rokvyroby
     * @param prevodovka the prevodovka
     * @param druhpaliva the druhpaliva
     * @param objemvalcov the objemvalcov
     */
    public Vozidlo(CenaPoistenia cena, ClassECV cecv, String znacka, String model, String rokvyroby, String prevodovka, String druhpaliva, String objemvalcov) {
        this.cena = cena;
    	this.cecv = cecv;
        this.znacka = znacka;
        this.model = model;
        this.rokvyroby = rokvyroby;
        this.prevodovka = prevodovka;
        this.druhpaliva = druhpaliva;
        this.objemvalcov = objemvalcov;
    }
    
    /**
     * Gets the cecv.
     *
     * @return the cecv
     */
    public ClassECV getcecv() {
    	return cecv;
    }
    
    /**
     * Gets the znacka.
     *
     * @return the znacka
     */
    public String getznacka() {
    	return znacka;
    }
    
    /**
     * Gets the model.
     *
     * @return the model
     */
    public String getmodel() {
    	return model;
    }
    
    /**
     * Gets the rokvyroby.
     *
     * @return the rokvyroby
     */
    public String getrokvyroby() {
    	return rokvyroby;
    }
    
    /**
     * Gets the prevodovka.
     *
     * @return the prevodovka
     */
    public String getprevodovka() {
    	return prevodovka;
    }
    
    /**
     * Gets the druhpaliva.
     *
     * @return the druhpaliva
     */
    public String getdruhpaliva() {
    	return druhpaliva;
    }
    
    /**
     * Gets the objemvalcov.
     *
     * @return the objemvalcov
     */
    public String getobjemvalcov() {
    	return objemvalcov;
    }
    
    /**
     * Gets the cena.
     *
     * @return the cena
     */
    public CenaPoistenia getcena() {
    	return cena;
    }
    
    /**
     * Skontrolujudaje.
     * funkcia, ktorá zistuje zo súboru FinalnePoistenie.txt, èi sa v súbore nachádza poistenie pre dané EÈV vozidla
     * @return true, if successful
     */
    public boolean skontrolujudaje() {
		boolean pravda = false;
		try {
	        FileReader reader = new FileReader("FinalnePoistenie.txt");
	        BufferedReader bufferedReader = new BufferedReader(reader);
	        String line;
	        while ((line = bufferedReader.readLine()) != null) {
	        	if(line.contains("EÈV: "+cecv.returnecvv())) {
	        		pravda = true;
	        	}
	        }
	        reader.close();
	    }
		catch (IOException ex) {
	        ex.printStackTrace();
	    }
		return pravda;
	}
    
}