package User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import Others.Address;
import Poistenie.CenaPoistenia;
import javafx.scene.text.Text;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
public class User {
    
	/** The userdata. */
	File userdata = new File("Userdata.txt");
	
	/** The finalpoistenie. */
	File finalpoistenie = new File("FinalnePoistenie.txt");
	
	/** The cena. */
	private CenaPoistenia cena;
	
    /** The meno. */
    private String meno;
    
    /** The datumnarodenia. */
    private LocalDate datumnarodenia;
    
    /** The kraj. */
    private String kraj;
    
    /** The pocetsu. */
    private String pocetsu;
    
    /** The address. */
    Address address;
    
    /**
     * Instantiates a new user.
     *
     * @param cena the cena
     * @param meno the meno
     * @param datumnarodenia the datumnarodenia
     * @param kraj the kraj
     * @param address the address
     * @param pocetsu the pocetsu
     */
    public User(CenaPoistenia cena, String meno, LocalDate datumnarodenia, String kraj, Address address, String pocetsu) {
    	this.cena = cena;
    	this.meno = meno;
        this.datumnarodenia = datumnarodenia;
        this.kraj = kraj;
        this.address = address;
        this.pocetsu = pocetsu;
    }

	/**
	 * Gets the datumnarodenia.
	 *
	 * @return the datumnarodenia
	 */
	public LocalDate getDatumnarodenia() {
		return datumnarodenia;
	}

	/**
	 * Gets the kraj.
	 *
	 * @return the kraj
	 */
	public String getKraj() {
		return kraj;
	}

	/**
	 * Returnpocetsu.
	 *
	 * @return the int
	 */
	public int returnpocetsu() {
		int intpocetsu = Integer.parseInt(pocetsu);
		return intpocetsu;
	}
	
	/**
	 * Returnperiod.
	 *	funkcia, ktorá poèíta rozdiel terajšieho dátumu s dátumom narodenia
	 * @return the period
	 */
	public Period returnperiod() {
		LocalDate date = datumnarodenia;
		LocalDate now = LocalDate.now();
		Period period = Period.between(date, now);
        return period;
	}
	
	/**
	 * Returnvek.
	 *	funkcia, ktorá z rozdielu z funkcie returnperiod vytvorí vek používate¾a
	 * @return the int
	 */
	public int returnvek() {
		Period period = returnperiod();
		return period.getYears();
	}

	/**
	 * Vypocitajvyskunazakladeusera.
	 * funkcia slúži na vypoèítanie výšky poistky na základe zadaných údajov, funkcia vracia hodnotu cenauser typu double
	 * @return the double
	 */
	public double vypocitajvyskunazakladeusera() {
		double cenauser = cena.getcena();
		if(getKraj().equals("Bratislavský")) cenauser = cenauser * 1.05;
    	else if (getKraj().equals("Trnavský")) cenauser = cenauser * 1.03;
    	else if (getKraj().equals("Trenèiansky")) cenauser = cenauser * 1.02;
    	else if (getKraj().equals("Nitriansky")) cenauser = cenauser * 1.03;
    	else if (getKraj().equals("Žilinský")) cenauser = cenauser * 1.02;
    	else if (getKraj().equals("Banskobystrický")) cenauser = cenauser * 1.03;
    	else if (getKraj().equals("Prešovský")) cenauser = cenauser * 1.03;
    	else if (getKraj().equals("Košický")) cenauser = cenauser * 1.04;

		if(returnpocetsu() == 0);
    	else if(1 <= returnpocetsu() && returnpocetsu() <= 2) cenauser = cenauser*1.1;
    	else if(3 <= returnpocetsu() && returnpocetsu() <= 4) cenauser = cenauser*1.2;
    	else if(5 <= returnpocetsu() && returnpocetsu() <= 6) cenauser = cenauser*1.3;
    	else if(7 <= returnpocetsu() && returnpocetsu() <= 8) cenauser = cenauser*1.5;
    	else if(9 <= returnpocetsu()) cenauser = cenauser*2;

		if(18 <= returnvek() && returnvek() <= 21) cenauser = cenauser * 1.2;
    	else if (22 <= returnvek() && returnvek() <= 25) cenauser = cenauser * 1.15;
    	else if (26 <= returnvek() && returnvek() <= 30) cenauser = cenauser * 1.1;
    	else if (31 <= returnvek() && returnvek() <= 40) cenauser = cenauser * 1.05;
    	else if (41 <= returnvek() && returnvek() <= 55) cenauser = cenauser * 1.1;
    	else if (55 <= returnvek() && returnvek() <= 65) cenauser = cenauser * 1.15;
    	else if (66 <= returnvek()) cenauser = cenauser * 1.2;
		return cenauser;
	}
	
	/**
	 * Checks if is empty.
	 * funkcia kontroluje, èi pri zadávaní údajov boli vyplnené všetky parametre
	 * @return true, if is empty
	 */
	public boolean isempty() {
		if(meno.equals("") ||address.getpsc().equals("") || address.getmesto().equals("") || address.getulica().equals("") || kraj.equals("Kraj")
    			|| address.getcislodomu().equals("") || pocetsu.equals("") || (datumnarodenia == null) ) return true;
		else return false;
	}

	/**
	 * Ulozudaje.
	 * funkcia ulozudaje slúži na uloženie údajov do súboru Userdata.txt, tieto údaje sa neskôr pomocou metódy precitajudaje vypíšu pri potvrdení poistenia
	 */
	public void ulozudaje() {
		try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(userdata.getAbsoluteFile(), true));
            bw.write("Meno priezvisko: "+meno+"; Dátum narodenia: "+datumnarodenia+"; Kraj: "+kraj+"; PSÈ: "
            +address.getpsc()+"; Mesto: "+address.getmesto()+"; Ulica: "+address.getulica()+"; Èíslo domu: "+address.getcislodomu()+"; Poèet škodových udalostí: "+pocetsu);
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
	 * funkcia, ktorá vypíše posledne uložené údaje o používate¾ovi zo súboru Userdata.txt
	 * @param ta the ta
	 */
	public void precitajudaje(Text ta){
		try {
	        FileReader reader = new FileReader("Userdata.txt");
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
	 * funkcia, ktorá zapisuje do súboru FinalnePoistenie.txt k údajom o vozidle údaje o používate¾ovi
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void zapisdofinalnehosuboru() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(finalpoistenie.getAbsoluteFile(), true));
        bw.write("Meno priezvisko: "+meno+"; Dátum narodenia: "+datumnarodenia+"; Kraj: "+kraj+"; PSÈ: "
        +address.getpsc()+"; Mesto: "+address.getmesto()+"; Ulica: "+address.getulica()+"; Èíslo domu: "+address.getcislodomu()+"; Poèet škodových udalostí: "+pocetsu+"; ");
        bw.close();
	}
}