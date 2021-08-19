package VozidloUdaje;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Poistenie.CenaPoistenia;
import javafx.scene.text.Text;

// TODO: Auto-generated Javadoc
/**
 * trieda NakladneAuto je dcérska trieda triedy Vozidlo a dedí od nej urèité parametre
 * The Class NakladneAuto.
 */
public class NakladneAuto extends Vozidlo implements VozidloMetody.NaklVozidlo{
	
	/** The hmotnost. */
	private String hmotnost;
	
	/** The truckdata. */
	File truckdata = new File("Truckdata.txt");
	
	/** The finalpoistenie. */
	File finalpoistenie = new File("FinalnePoistenie.txt");
	
	/**
	 * Instantiates a new nakladne auto.
	 *
	 * @param cena the cena
	 * @param cecv the cecv
	 * @param znacka the znacka
	 * @param model the model
	 * @param rokvyroby the rokvyroby
	 * @param hmotnost the hmotnost
	 * @param prevodovka the prevodovka
	 * @param druhpaliva the druhpaliva
	 * @param objemvalcov the objemvalcov
	 */
	public NakladneAuto(CenaPoistenia cena, ClassECV cecv, String znacka, String model, String rokvyroby, String hmotnost, String prevodovka, String druhpaliva, String objemvalcov) {
		super(cena, cecv, znacka, model, rokvyroby, prevodovka, druhpaliva, objemvalcov);
		this.hmotnost = hmotnost;
	}
	
	/**
	 * Returnecv.
	 *
	 * @return the class ECV
	 */
	public ClassECV returnecv() {
		return cecv;
	}

	/**
	 * Returnrokvyroby.
	 *
	 * @return the int
	 */
	public int returnrokvyroby(){
		return Integer.parseInt(rokvyroby);
	}
	
	/* (non-Javadoc)
	 * @see VozidloUdaje.VozidloMetody.NaklVozidlo#returnhmotnost()
	 */
	public String returnhmotnost(){
		return hmotnost;
	}
	
	/**
	 * Returndruhpaliva.
	 *
	 * @return the string
	 */
	public String returndruhpaliva(){
		return druhpaliva;
	}
	
	/**
	 * Returnprevodovka.
	 *
	 * @return the string
	 */
	public String returnprevodovka(){
		return prevodovka;
	}

	/**
	 * Returnobjemvalcov.
	 *
	 * @return the int
	 */
	public int returnobjemvalcov(){
		return Integer.parseInt(objemvalcov);
	}
	
	/**
	 * Vypocitajvyskunazakladevozidla.
	 * funkcia slúži na vypoèítanie výšky poistky na základe zadaných údajov, funkcia vracia hodnotu cenanauto typu double
	 * @return the double
	 */
	public double vypocitajvyskunazakladevozidla() {
		double cenanauto = cena.returncena();

		if(returnrokvyroby() <= 1990) cenanauto = cenanauto*1.1;
    	else if(1991 <= returnrokvyroby() && returnrokvyroby() <= 2000) cenanauto = cenanauto*1.15;
    	else if(2001 <= returnrokvyroby() && returnrokvyroby() <= 2005) cenanauto = cenanauto*1.2;
    	else if(2006 <= returnrokvyroby() && returnrokvyroby() <= 2010) cenanauto = cenanauto*1.25;
    	else if(2011 <= returnrokvyroby() && returnrokvyroby() <= 2015) cenanauto = cenanauto*1.3;
    	else cenanauto = cenanauto*1.5;

    	if(hmotnost.equals("do 3500kg")) cenanauto = cenanauto*1.05;
		else if(hmotnost.equals("3500 - 12000kg")) cenanauto = cenanauto*1.25;
		else if(hmotnost.equals("nad 12000kg")) cenanauto = cenanauto*1.5;

    	if(druhpaliva.equals("Benzín")) cenanauto = cenanauto*1.1;
		else if(druhpaliva.equals("Diesel")) cenanauto = cenanauto*1.08;
		else if(druhpaliva.equals("Elektro")) cenanauto = cenanauto*1.05;
		else if(druhpaliva.equals("Hybrid")) cenanauto = cenanauto*1.07;
		else if(druhpaliva.equals("Benzín + LPG")) cenanauto = cenanauto*1.12;

    	if(prevodovka.equals("Manuálna")) cenanauto = cenanauto*1.1;
		else if(prevodovka.equals("Automatická")) cenanauto = cenanauto*1.08;

    	if(returnobjemvalcov() <= 2500) cenanauto = cenanauto*1.1;
    	else if(2501 <= returnobjemvalcov() && returnobjemvalcov() <= 3500) cenanauto = cenanauto*1.15;
    	else if(3501 <= returnobjemvalcov() && returnobjemvalcov() <= 5000) cenanauto = cenanauto*1.25;
    	else if(5001 <= returnobjemvalcov() && returnobjemvalcov() <= 8000) cenanauto = cenanauto*1.5;
    	else if(8001 <= returnobjemvalcov() && returnobjemvalcov() <= 12000) cenanauto = cenanauto*1.75;
    	else cenanauto = cenanauto*2;
		
		return cenanauto;
	}
	
	/**
	 * Checks if is empty.
	 * funkcia kontroluje, èi pri zadávaní údajov boli vyplnené všetky parametre
	 * @return true, if is empty
	 */
	public boolean isempty()
	{
		if(cecv.returnecvv().equals("") || znacka.equals("") || model.equals("") || rokvyroby.equals("") || hmotnost.equals("Hmotnos")
				|| objemvalcov.equals("") || druhpaliva.equals("Druh paliva") || prevodovka.equals("Prevodovka")) return true;
		else return false;
	}
	
	/**
	 * funkcia ulozudaje slúži na uloženie údajov do súboru Truckdata.txt, tieto údaje sa neskôr pomocou metódy precitajudaje vypíšu pri potvrdení poistenia
	 * Ulozudaje.
	 */
	public void ulozudaje(){
		try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(truckdata.getAbsoluteFile(), true));
            bw.write("EÈV: "+cecv.returnecvv()+"; Znaèka: "+znacka+"; Model: "+model+"; Rok výroby: "+rokvyroby+"; Hmotnos: "+hmotnost
            		+"; Palivo: "+druhpaliva+"; Prevodovka: "+prevodovka+"; Zdvihový objem valcov: "+objemvalcov);
            bw.newLine();
            bw.close();
        	}
        catch(IOException ex)
        	{
        	ex.getMessage();
        	}
	}
	
	/* (non-Javadoc)
	 * funkcia z nadtriedy, ktorá zistuje zo súboru FinalnePoistenie.txt, èi sa v súbore nachádza poistenie pre dané EÈV vozidla
	 * @see VozidloUdaje.Vozidlo#skontrolujudaje()
	 */
	public boolean skontrolujudaje() {
		boolean pravda = super.skontrolujudaje();
		return pravda;
	}
	
	/**
	 * Precitajudaje.
	 * funkcia, ktorá vypíše posledne uložené údaje o vozidle zo súboru Truckdata.txt
	 * @param ta the ta
	 */
	public void precitajudaje(Text ta) {
		try {
			FileReader reader = new FileReader("Truckdata.txt");
	        BufferedReader bufferedReader = new BufferedReader(reader);
	        String line;
	        while ((line = bufferedReader.readLine()) != null) {
	         line=line.replace("; ","\n");
	            ta.setText(line);
	        }
	        reader.close();
	    } 
		catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
	
	/**
	 * Zapisdofinalnehosuboru.
	 * funkcia, ktorá zapisuje do súboru FinalnePoistenie.txt údaje o vozidle
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void zapisdofinalnehosuboru() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(finalpoistenie.getAbsoluteFile(), true));
		bw.write("EÈV: "+cecv.returnecvv()+"; Znaèka: "+znacka+"; Model: "+model+"; Rok výroby: "+rokvyroby+"; Pohon: "+hmotnost+
                "; Palivo: "+druhpaliva+"; Prevodovka: "+prevodovka+"; Zdvihový objem valcov: "+objemvalcov+"; ");
        bw.close();
	}

}