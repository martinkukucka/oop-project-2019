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
 * trieda OsobneAuto je dc�rska trieda triedy Motocykel a ded� od nej ur�it� parametre
 * The Class OsobneAuto.
 */
public class OsobneAuto extends Motocykel implements VozidloMetody.OsobVozidlo{
	
	/** The pohon. */
	private String pohon;
	
	/** The cardata. */
	File cardata = new File("Cardata.txt");
	
	/** The finalpoistenie. */
	File finalpoistenie = new File("FinalnePoistenie.txt");
	
	/**
	 * Instantiates a new osobne auto.
	 *
	 * @param cena the cena
	 * @param cecv the cecv
	 * @param znacka the znacka
	 * @param model the model
	 * @param rokvyroby the rokvyroby
	 * @param pohon the pohon
	 * @param prevodovka the prevodovka
	 * @param druhpaliva the druhpaliva
	 * @param vykonmotora the vykonmotora
	 * @param objemvalcov the objemvalcov
	 */
	public OsobneAuto(CenaPoistenia cena, ClassECV cecv, String znacka, String model, String rokvyroby, String pohon, String prevodovka, String druhpaliva, String vykonmotora, String objemvalcov) {
		super(cena, cecv, znacka, model, rokvyroby, prevodovka, druhpaliva, vykonmotora, objemvalcov);
		this.pohon = pohon;
	}

	/* (non-Javadoc)
	 * @see VozidloUdaje.Motocykel#returnecv()
	 */
	public ClassECV returnecv() {
		return cecv;
	}
	
	/* (non-Javadoc)
	 * @see VozidloUdaje.Motocykel#returnrokvyroby()
	 */
	public int returnrokvyroby(){
		return Integer.parseInt(rokvyroby);
	}
	
	/* (non-Javadoc)
	 * @see VozidloUdaje.VozidloMetody.OsobVozidlo#returnpohon()
	 */
	public String returnpohon(){
		return pohon;
	}
	
	/* (non-Javadoc)
	 * @see VozidloUdaje.Motocykel#returndruhpaliva()
	 */
	public String returndruhpaliva(){
		return druhpaliva;
	}
	
	/* (non-Javadoc)
	 * @see VozidloUdaje.Motocykel#returnprevodovka()
	 */
	public String returnprevodovka(){
		return prevodovka;
	}
	
	/* (non-Javadoc)
	 * @see VozidloUdaje.Motocykel#returnvykonmotora()
	 */
	public int returnvykonmotora(){
		return Integer.parseInt(vykonmotora);
	}
	
	/* (non-Javadoc)
	 * @see VozidloUdaje.Motocykel#returnobjemvalcov()
	 */
	public int returnobjemvalcov(){
		return Integer.parseInt(objemvalcov);
	}
	
	/* (non-Javadoc)
	 * funkcia sl��i na vypo��tanie v��ky poistky na z�klade zadan�ch �dajov, funkcia vracia hodnotu cenaauto typu double
	 * @see VozidloUdaje.Motocykel#vypocitajvyskunazakladevozidla()
	 */
	public double vypocitajvyskunazakladevozidla() {
		double cenaauto = cena.returncena();

    	if(returnrokvyroby() <= 1990) cenaauto = cenaauto*1.1;
    	else if(1991 <= returnrokvyroby() && returnrokvyroby() <= 2000) cenaauto = cenaauto*1.15;
    	else if(2001 <= returnrokvyroby() && returnrokvyroby() <= 2005) cenaauto = cenaauto*1.2;
    	else if(2006 <= returnrokvyroby() && returnrokvyroby() <= 2010) cenaauto = cenaauto*1.25;
    	else if(2011 <= returnrokvyroby() && returnrokvyroby() <= 2015) cenaauto = cenaauto*1.3;
    	else cenaauto = cenaauto*1.5;

    	if(pohon.equals("Predn�")) cenaauto = cenaauto*1.05;
		else if(pohon.equals("Zadn�")) cenaauto = cenaauto*1.1;
		else if(pohon.equals("AWD")) cenaauto = cenaauto*1.06;
		else if(pohon.equals("4WD")) cenaauto = cenaauto*1.08;

    	if(druhpaliva.equals("Benz�n")) cenaauto = cenaauto*1.1;
		else if(druhpaliva.equals("Diesel")) cenaauto = cenaauto*1.08;
		else if(druhpaliva.equals("Elektro")) cenaauto = cenaauto*1.05;
		else if(druhpaliva.equals("Hybrid")) cenaauto = cenaauto*1.07;
		else if(druhpaliva.equals("Benz�n + LPG")) cenaauto = cenaauto*1.12;

    	if(prevodovka.equals("Manu�lna")) cenaauto = cenaauto*1.1;
		else if(prevodovka.equals("Automatick�")) cenaauto = cenaauto*1.08;

    	if(returnvykonmotora() <= 80) cenaauto = cenaauto*1.05;
    	else if(91 <= returnvykonmotora() && returnvykonmotora() <= 120) cenaauto = cenaauto*1.15;
    	else if(121 <= returnvykonmotora() && returnvykonmotora() <= 200) cenaauto = cenaauto*1.25;
    	else if(201 <= returnvykonmotora() && returnvykonmotora() <= 300) cenaauto = cenaauto*1.5;
    	else if(301 <= returnvykonmotora() && returnvykonmotora() <= 500) cenaauto = cenaauto*2;
    	else if(501 <= returnvykonmotora() && returnvykonmotora() <= 800) cenaauto = cenaauto*2.5;
    	else cenaauto = cenaauto*3;

    	if(returnobjemvalcov() <= 1000) cenaauto = cenaauto*1.02;
    	else if(1001 <= returnobjemvalcov() && returnobjemvalcov() <= 1300) cenaauto = cenaauto*1.08;
    	else if(1301 <= returnobjemvalcov() && returnobjemvalcov() <= 1600) cenaauto = cenaauto*1.1;
    	else if(1601 <= returnobjemvalcov() && returnobjemvalcov() <= 1800) cenaauto = cenaauto*1.2;
    	else if(1801 <= returnobjemvalcov() && returnobjemvalcov() <= 2000) cenaauto = cenaauto*1.25;
    	else if(2001 <= returnobjemvalcov() && returnobjemvalcov() <= 3000) cenaauto = cenaauto*1.5;
    	else if(3001 <= returnobjemvalcov() && returnobjemvalcov() <= 5000) cenaauto = cenaauto*1.75;
    	else cenaauto = cenaauto*2;
    	
    	return cenaauto;
    	}
	
	/* (non-Javadoc)
	 * funkcia kontroluje, �i pri zad�van� �dajov boli vyplnen� v�etky parametre
	 * @see VozidloUdaje.Motocykel#isempty()
	 */
	public boolean isempty() {
		if(cecv.returnecvv().equals("") || znacka.equals("") || model.equals("") || rokvyroby.equals("") || pohon.equals("Pohon") || vykonmotora.equals("") 
		|| objemvalcov.equals("") || druhpaliva.equals("Druh paliva") || prevodovka.equals("Prevodovka")) return true;
		else return false;     
	}
	
	/* (non-Javadoc)
	 * funkcia ulozudaje sl��i na ulo�enie �dajov do s�boru Cardata.txt, tieto �daje sa nesk�r pomocou met�dy precitajudaje vyp�u pri potvrden� poistenia
	 * @see VozidloUdaje.Motocykel#ulozudaje()
	 */
	public void ulozudaje(){
		try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(cardata.getAbsoluteFile(), true));
            bw.write("E�V: "+cecv.returnecvv()+"; Zna�ka: "+znacka+"; Model: "+model+"; Rok v�roby: "+rokvyroby+"; Pohon: "+pohon+
            "; Palivo: "+druhpaliva+"; Prevodovka: "+prevodovka+"; V�kon motora: "+vykonmotora+
            "; Zdvihov� objem valcov: "+objemvalcov);
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
	 * @see VozidloUdaje.Motocykel#skontrolujudaje()
	 */
	public boolean skontrolujudaje() {
		boolean pravda = super.skontrolujudaje();
		return pravda;
	}
	
	/* (non-Javadoc)
	 * funkcia, ktor� vyp�e posledne ulo�en� �daje o vozidle zo s�boru Cardata.txt
	 * @see VozidloUdaje.Motocykel#precitajudaje(javafx.scene.text.Text)
	 */
	public void precitajudaje(Text ta) {
		try {
			FileReader reader = new FileReader("Cardata.txt");
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

	/* (non-Javadoc)
	 * funkcia, ktor� zapisuje do s�boru FinalnePoistenie.txt �daje o vozidle
	 * @see VozidloUdaje.Motocykel#zapisdofinalnehosuboru()
	 */
	public void zapisdofinalnehosuboru() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(finalpoistenie.getAbsoluteFile(), true));
		bw.write("E�V: "+cecv.returnecvv()+"; Zna�ka: "+znacka+"; Model: "+model+"; Rok v�roby: "+rokvyroby+"; Pohon: "+pohon+
                "; Palivo: "+druhpaliva+"; Prevodovka: "+prevodovka+"; V�kon motora: "+vykonmotora+"; Zdvihov� objem valcov: "+objemvalcov+"; ");
        bw.close();
	}
}