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
 * trieda Motocykel je dc�rska trieda triedy Vozidlo a ded� od nej ur�it� parametre
 * The Class Motocykel.
 */
public class Motocykel extends Vozidlo implements VozidloMetody{
	
	/** The vykonmotora. */
	protected String vykonmotora;
	
	/** The motodata. */
	File motodata = new File("Motodata.txt");
	
	/** The finalpoistenie. */
	File finalpoistenie = new File("FinalnePoistenie.txt");
	
	/**
	 * Instantiates a new motocykel.
	 *
	 * @param cena the cena
	 * @param cecv the cecv
	 * @param znacka the znacka
	 * @param model the model
	 * @param rokvyroby the rokvyroby
	 * @param prevodovka the prevodovka
	 * @param druhpaliva the druhpaliva
	 * @param vykonmotora the vykonmotora
	 * @param objemvalcov the objemvalcov
	 */
	public Motocykel(CenaPoistenia cena, ClassECV cecv, String znacka, String model, String rokvyroby, String prevodovka, String druhpaliva, String vykonmotora, String objemvalcov) {
		super(cena, cecv, znacka, model, rokvyroby, prevodovka, druhpaliva, objemvalcov);
		this.vykonmotora = vykonmotora;
	}

	/* (non-Javadoc)
	 * @see VozidloUdaje.VozidloMetody#returnecv()
	 */
	public ClassECV returnecv() {
		return cecv;
	}
	
	/* (non-Javadoc)
	 * @see VozidloUdaje.VozidloMetody#returnrokvyroby()
	 */
	public int returnrokvyroby(){
		return Integer.parseInt(rokvyroby);
	}
	
	/* (non-Javadoc)
	 * @see VozidloUdaje.VozidloMetody#returndruhpaliva()
	 */
	public String returndruhpaliva(){
		return druhpaliva;
	}
	
	/* (non-Javadoc)
	 * @see VozidloUdaje.VozidloMetody#returnprevodovka()
	 */
	public String returnprevodovka(){
		return prevodovka;
	}
	
	/**
	 * Returnvykonmotora.
	 *
	 * @return the int
	 */
	public int returnvykonmotora(){
		return Integer.parseInt(vykonmotora);
	}
	
	/* (non-Javadoc)
	 * @see VozidloUdaje.VozidloMetody#returnobjemvalcov()
	 */
	public int returnobjemvalcov(){
		return Integer.parseInt(objemvalcov);
	}
	
	/* (non-Javadoc)
	 * funkcia sl��i na vypo��tanie v��ky poistky na z�klade zadan�ch �dajov, funkcia vracia hodnotu cenamoto typu double
	 * @see VozidloUdaje.VozidloMetody#vypocitajvyskunazakladevozidla()
	 */
	public double vypocitajvyskunazakladevozidla() {
		double cenamoto = cena.returncena();
		
		if(returnrokvyroby() <= 1990) cenamoto = cenamoto*1.1;
    	else if(1991 <= returnrokvyroby() && returnrokvyroby() <= 2000) cenamoto = cenamoto*1.15;
    	else if(2001 <= returnrokvyroby() && returnrokvyroby() <= 2005) cenamoto = cenamoto*1.2;
    	else if(2006 <= returnrokvyroby() && returnrokvyroby() <= 2010) cenamoto = cenamoto*1.25;
    	else if(2011 <= returnrokvyroby() && returnrokvyroby() <= 2015) cenamoto = cenamoto*1.3;
    	else cenamoto = cenamoto*1.5;

    	if(druhpaliva.equals("Benz�n")) cenamoto = cenamoto*1.1;
		else if(druhpaliva.equals("Diesel")) cenamoto = cenamoto*1.08;
		else if(druhpaliva.equals("Elektro")) cenamoto = cenamoto*1.05;
		else if(druhpaliva.equals("Hybrid")) cenamoto = cenamoto*1.07;

    	if(prevodovka.equals("Manu�lna")) cenamoto = cenamoto*1.1;
		else if(prevodovka.equals("Automatick�")) cenamoto = cenamoto*1.08;

    	if(returnvykonmotora() <= 20) cenamoto = cenamoto*1.02;
    	else if(21 <= returnvykonmotora() && returnvykonmotora() <= 30) cenamoto = cenamoto*1.05;
    	else if(31 <= returnvykonmotora() && returnvykonmotora() <= 50) cenamoto = cenamoto*1.08;
    	else if(51 <= returnvykonmotora() && returnvykonmotora() <= 65) cenamoto = cenamoto*1.15;
    	else if(66 <= returnvykonmotora() && returnvykonmotora() <= 80) cenamoto = cenamoto*1.25;
    	else if(81 <= returnvykonmotora() && returnvykonmotora() <= 100) cenamoto = cenamoto*1.5;
    	else if(101 <= returnvykonmotora() && returnvykonmotora() <= 150) cenamoto = cenamoto*1.75;
    	else cenamoto = cenamoto*2;

    	if(returnobjemvalcov() <= 100) cenamoto = cenamoto*1.02;
    	else if(101 <= returnobjemvalcov() && returnobjemvalcov() <= 150) cenamoto = cenamoto*1.05;
    	else if(151 <= returnobjemvalcov() && returnobjemvalcov() <= 200) cenamoto = cenamoto*1.1;
    	else if(201 <= returnobjemvalcov() && returnobjemvalcov() <= 300) cenamoto = cenamoto*1.15;
    	else if(301 <= returnobjemvalcov() && returnobjemvalcov() <= 500) cenamoto = cenamoto*1.25;
    	else if(501 <= returnobjemvalcov() && returnobjemvalcov() <= 750) cenamoto = cenamoto*1.5;
    	else if(751 <= returnobjemvalcov() && returnobjemvalcov() <= 1000) cenamoto = cenamoto*1.75;
    	else cenamoto = cenamoto*2;
    	
    	return cenamoto;
	}
	
	/* (non-Javadoc)
	 * funkcia kontroluje, �i pri zad�van� �dajov boli vyplnen� v�etky parametre
	 * @see VozidloUdaje.VozidloMetody#isempty()
	 */
	public boolean isempty() {
		if(cecv.returnecvv().equals("") || znacka.equals("") || model.equals("") || rokvyroby.equals("") || vykonmotora.equals("") 
		|| objemvalcov.equals("") || druhpaliva.equals("Druh paliva") || prevodovka.equals("Prevodovka")) return true;
		else return false;     
	}
	
	/* (non-Javadoc)
	 * funkcia ulozudaje sl��i na ulo�enie �dajov do s�boru Motodata.txt, tieto �daje sa nesk�r pomocou met�dy precitajudaje vyp�u pri potvrden� poistenia
	 * @see VozidloUdaje.VozidloMetody#ulozudaje()
	 */
	public void ulozudaje() {
		try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(motodata.getAbsoluteFile(), true));
            bw.write("E�V: "+cecv.returnecvv()+"; Zna�ka: "+znacka+"; Model: "+model+"; Rok v�roby: "+rokvyroby+"; Palivo: "
            +druhpaliva+"; Prevodovka: "+prevodovka+"; V�kon motora: "+vykonmotora+"; Zdvihov� objem valcov: "+objemvalcov);
            bw.newLine();
            bw.close();
        	}
        catch(IOException ex)
        	{
        	ex.getMessage();
        	}
	}
	
	/* (non-Javadoc)
	 * funkcia z nadtriedy, ktor� zistuje zo s�boru FinalnePoistenie.txt, �i sa v s�bore nach�dza poistenie pre dan� E�V vozidla
	 * @see VozidloUdaje.Vozidlo#skontrolujudaje()
	 */
	public boolean skontrolujudaje() {
		boolean pravda = super.skontrolujudaje();
		return pravda;
	}
	
	/* (non-Javadoc)
	 * funkcia, ktor� vyp�e posledne ulo�en� �daje o vozidle zo s�boru Motodata.txt
	 * @see VozidloUdaje.VozidloMetody#precitajudaje(javafx.scene.text.Text)
	 */
	public void precitajudaje(Text ta) {
		try {
			FileReader reader = new FileReader("Motodata.txt");
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
	 * funkcia, ktor� zapisuje do s�boru FinalnePoistenie.txt �daje o vozidle
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void zapisdofinalnehosuboru() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(finalpoistenie.getAbsoluteFile(), true));
		bw.write("E�V: "+cecv.returnecvv()+"; Zna�ka: "+znacka+"; Model: "+model+"; Rok v�roby: "+rokvyroby+"; Palivo: "+druhpaliva+"; Prevodovka: "+prevodovka+"; V�kon motora: "+vykonmotora+"; Zdvihov� objem valcov: "+objemvalcov+"; ");
        bw.close();
	}
}