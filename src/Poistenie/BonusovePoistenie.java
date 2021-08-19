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
     *funkcia sl��i na vypo��tanie v��ky poistky na z�klade zadan�ch �dajov, funkcia vracia hodnotu cena typu double
     * @return the double
     */
    public double vypocitajvyskunazakladepoistenia() {
		double cena = cenap.getcena();
		if(returnvyska().equals("1 mil�na �")) cena = cena * 1.1;
    	else if(returnvyska().equals("3 mili�nov �")) cena = cena * 1.15;
    	else if(returnvyska().equals("5 mili�nov �")) cena = cena * 1.3;
		
		if(returnprve()) cena = cena * 1.05;
		if(returndruhe()) cena = cena * 1.05;
		if(returntretie()) cena = cena * 1.05;
		if(returnstvrte()) cena = cena * 1.05;
		return cena;
    }
    
    /**
     * Ulozudaje.
     * funkcia ulozudaje sl��i na ulo�enie �dajov do s�boru BPoistenie.txt, tieto �daje sa nesk�r pomocou met�dy precitajudaje vyp�u pri potvrden� poistenia
     */
    public void ulozudaje() {
    	try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(bpoistenie.getAbsoluteFile(), true));
            bw.write("Poistenie do v��ky: "+vyska+"; �iveln� pohroma: "+prve+"; Stret so zverou: "
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
     * funkcia, ktor� vyp�e posledne ulo�en� �daje o vozidle zo s�boru BPoistenie.txt
     * @param ta the ta
     */
    public void precitajudaje(Text ta) {
    	try {
	        FileReader reader = new FileReader("BPoistenie.txt");
	        BufferedReader bufferedReader = new BufferedReader(reader);
	        String line;
	        while ((line = bufferedReader.readLine()) != null) {
	         line=line.replace("; ","\n");
	         line=line.replace("true","�no");
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
	 * funkcia, ktor� zapisuje do s�boru BPoistenie.txt k �dajom o vozidle a �dajom o pou��vate�ovi �daje o zvolenom type poistenia + bonusov�ch poisteniach
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void zapisdofinalnehosuboru() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(finalpoistenie.getAbsoluteFile(), true));
		bw.write("Poistenie do v��ky: "+vyska+"; �iveln� pohroma: "+prve+"; Stret so zverou: "
                +druhe+"; Ukradnutie vozidla: "+tretie+"; Vandalizmus: "+stvrte+"; ");
       bw.newLine();
       bw.close();
	}
    
}
