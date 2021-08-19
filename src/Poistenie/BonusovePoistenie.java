package Poistenie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.scene.text.Text;

// TODO: Auto-generated Javadoc
/**
 * The Class BonusovePoistenie.
 */
public class BonusovePoistenie {
    
    /** The vyska. */
    String vyska;
    
    /** The prve. */
    boolean prve;
    
    /** The druhe. */
    boolean druhe;
    
    /** The tretie. */
    boolean tretie;
    
    /** The stvrte. */
    boolean stvrte;
    
    /** The cenap. */
    CenaPoistenia cenap;
    
    /** The bpoistenie. */
    File bpoistenie = new File("BPoistenie.txt");
    
    /** The finalpoistenie. */
    File finalpoistenie = new File("FinalnePoistenie.txt");
    
    /**
     * Instantiates a new bonusove poistenie.
     *
     * @param cenap the cenap
     * @param vyska the vyska
     * @param prve the prve
     * @param druhe the druhe
     * @param tretie the tretie
     * @param stvrte the stvrte
     */
    public BonusovePoistenie(CenaPoistenia cenap, String vyska, boolean prve, boolean druhe, boolean tretie, boolean stvrte) {
        this.vyska = vyska;
        this.prve = prve;
        this.druhe = druhe;
        this.tretie = tretie;
        this.stvrte = stvrte;
        this.cenap = cenap;
    }
    
    /**
     * Returnvyska.
     *
     * @return the string
     */
    public String returnvyska() {
    	return vyska;
    }
    
    /**
     * Returnprve.
     *
     * @return true, if successful
     */
    public boolean returnprve() {
    	return prve;
    }
    
    /**
     * Returndruhe.
     *
     * @return true, if successful
     */
    public boolean returndruhe() {
    	return druhe;
    }
    
    /**
     * Returntretie.
     *
     * @return true, if successful
     */
    public boolean returntretie() {
    	return tretie;
    }
    
    /**
     * Returnstvrte.
     *
     * @return true, if successful
     */
    public boolean returnstvrte() {
    	return stvrte;
    }
    
    /**
     * Vypocitajvyskunazakladepoistenia.
     *funkcia slúži na vypoèítanie výšky poistky na základe zadaných údajov, funkcia vracia hodnotu cena typu double
     * @return the double
     */
    public double vypocitajvyskunazakladepoistenia() {
		double cena = cenap.getcena();
		if(returnvyska().equals("1 milóna €")) cena = cena * 1.1;
    	else if(returnvyska().equals("3 miliónov €")) cena = cena * 1.15;
    	else if(returnvyska().equals("5 miliónov €")) cena = cena * 1.3;
		
		if(returnprve()) cena = cena * 1.05;
		if(returndruhe()) cena = cena * 1.05;
		if(returntretie()) cena = cena * 1.05;
		if(returnstvrte()) cena = cena * 1.05;
		return cena;
    }
    
    /**
     * Ulozudaje.
     * funkcia ulozudaje slúži na uloženie údajov do súboru BPoistenie.txt, tieto údaje sa neskôr pomocou metódy precitajudaje vypíšu pri potvrdení poistenia
     */
    public void ulozudaje() {
    	try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(bpoistenie.getAbsoluteFile(), true));
            bw.write("Poistenie do výšky: "+vyska+"; Živelná pohroma: "+prve+"; Stret so zverou: "
            +druhe+"; Ukradnutie vozidla: "+tretie+"; Vandalizmus: "+stvrte);
            bw.newLine();
            bw.close();
        	}
        catch(IOException ex)
        	{
        	ex.getMessage();
        	}
    }
    
    /**
     * Precitajudaje.
     * funkcia, ktorá vypíše posledne uložené údaje o vozidle zo súboru BPoistenie.txt
     * @param ta the ta
     */
    public void precitajudaje(Text ta) {
    	try {
	        FileReader reader = new FileReader("BPoistenie.txt");
	        BufferedReader bufferedReader = new BufferedReader(reader);
	        String line;
	        while ((line = bufferedReader.readLine()) != null) {
	         line=line.replace("; ","\n");
	         line=line.replace("true","Áno");
	         line=line.replace("false","Nie");
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
	 * funkcia, ktorá zapisuje do súboru BPoistenie.txt k údajom o vozidle a údajom o používate¾ovi údaje o zvolenom type poistenia + bonusových poisteniach
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void zapisdofinalnehosuboru() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(finalpoistenie.getAbsoluteFile(), true));
		bw.write("Poistenie do výšky: "+vyska+"; Živelná pohroma: "+prve+"; Stret so zverou: "
                +druhe+"; Ukradnutie vozidla: "+tretie+"; Vandalizmus: "+stvrte+"; ");
       bw.newLine();
       bw.close();
	}
    
}
