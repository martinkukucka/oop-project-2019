package Poistenie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.scene.text.Text;

// TODO: Auto-generated Javadoc
/**
 * The Class ClassPoistnaUdalost.
 */
public class ClassPoistnaUdalost {

    /** The b 1 mil. */
    private boolean b1mil;
    
    /** The b 3 mil. */
    private boolean b3mil;
    
    /** The b 5 mil. */
    private boolean b5mil;
    
    /** The vyskaskody. */
    private String vyskaskody;
    
    /** The poistnaudalost. */
    private String poistnaudalost;
    
    /** The bstretsozverou. */
    private boolean bstretsozverou = false;
    
    /** The bukradnutievozidla. */
    private boolean bukradnutievozidla = false;
    
    /** The bvandalizmus. */
    private boolean bvandalizmus = false;
    
    /** The bzivelnapohroma. */
    private boolean bzivelnapohroma = false;
    
    /** The pravda. */
    private boolean pravda = false;	
    
    /** The zadanaspz. */
    private String zadanaspz;
    
    /** The ta. */
    Text ta;
    
    /**
     * Instantiates a new class poistna udalost.
     *
     * @param vyskaskody the vyskaskody
     * @param b1mil the b 1 mil
     * @param b3mil the b 3 mil
     * @param b5mil the b 5 mil
     */
    public ClassPoistnaUdalost(String vyskaskody, boolean b1mil, boolean b3mil, boolean b5mil) {
    	this.vyskaskody = vyskaskody;
		this.b1mil = b1mil;
		this.b3mil = b3mil;
		this.b5mil = b5mil;
    }
    
    /**
     * Instantiates a new class poistna udalost.
     *
     * @param poistnaudalost the poistnaudalost
     * @param bstretsozverou the bstretsozverou
     * @param bukradnutievozidla the bukradnutievozidla
     * @param bvandalizmus the bvandalizmus
     * @param bzivelnapohroma the bzivelnapohroma
     */
    public ClassPoistnaUdalost(String poistnaudalost, boolean bstretsozverou, boolean bukradnutievozidla, boolean bvandalizmus, boolean bzivelnapohroma) {
    	this.poistnaudalost = poistnaudalost;
    	this.bstretsozverou = bstretsozverou;
    	this.bukradnutievozidla = bukradnutievozidla;
    	this.bvandalizmus = bvandalizmus;
    	this.bzivelnapohroma = bzivelnapohroma;
    }
    
    /**
     * Instantiates a new class poistna udalost.
     *
     * @param zadanaspz the zadanaspz
     */
    public ClassPoistnaUdalost(String zadanaspz) {
    	this.zadanaspz = zadanaspz;
    }
    
    /**
     * Instantiates a new class poistna udalost.
     *
     * @param pravda the pravda
     */
    public ClassPoistnaUdalost(boolean pravda) {
    	this.pravda = pravda;
    }
    
    /**
     * Returnvyskaskody.
     * funkcia, ktor� transformuje v��ku �kody na double a n�sledne ju returne
     * @return the double
     */
    public double returnvyskaskody() {
    	if(vyskaskody.matches("[0-9]*")) return Math.floor(Double.parseDouble(vyskaskody) * 100) / 100;
		return 0;
    }
    
	/**
	 * Skontrolujvyskuskody.
	 * funkcia, ktor� kontroluje �i u��vate� m� poisten� vozidlo do 1, do 3 alebo do 5 mili�nov �
	 * @return the int
	 */
	public int skontrolujvyskuskody() {
		if(returnvyskaskody() == 0) return 3;
		if(returnvyskaskody() <= 1000000) {
			if (b1mil == true || b3mil == true || b5mil == true) return 1;
			else return 2;
		}
		else if(returnvyskaskody() <= 3000000) {
			if (b3mil == true || b5mil == true) return 1;
			else return 2;
		}
		else if(returnvyskaskody()<= 5000000) {
			if (b5mil == true) return 1;
			else return 2;
		}
		else return 0;
	}

	/**
	 * Precitajudaje.
	 * met�da, ktor� pre zadan� E�V vozidla vyp�e v�etky �daje o vozidle, pou��vate�ovi, type poistenia zo s�boru FinalnePoistenie.txt
	 * @param ta the ta
	 */
	public void precitajudaje(Text ta) {
		try {
	        FileReader reader = new FileReader("FinalnePoistenie.txt");
	        BufferedReader bufferedReader = new BufferedReader(reader);
	        String line;
	        while ((line = bufferedReader.readLine()) != null && pravda == false) {
	        	if(line.contains("E�V: "+zadanaspz+";") && !zadanaspz.equals("")) {
	        		pravda = true;
	        		line=line.replace("; ","\n");
           	        line=line.replace("true","�no");
           	        line=line.replace("false","Nie");
           	        line=line.replace("E�V: ","\n�daje o vozidle\nE�V: ");
           	        line=line.replace("Meno priezvisko: ","�daje o u��vate�ovi\nMeno priezvisko: ");
           	        line=line.replace("Poistenie do v��ky: ","\nTyp poistenia\nPoistenie do v��ky: ");
           	        ta.setText(line);
           	        if(line.contains("Poistenie do v��ky: 1 mil�na �")) b1mil = true;
           	        else if (line.contains("Poistenie do v��ky: 3 mili�nov �")) b3mil = true;
           	        else if (line.contains("Poistenie do v��ky: 5 mili�nov �")) b5mil = true;
           	        
           	        if(line.contains("�iveln� pohroma: �no")) bzivelnapohroma = true;
           	        if (line.contains("Stret so zverou: �no")) bstretsozverou = true;
           	        if (line.contains("Ukradnutie vozidla: �no")) bukradnutievozidla = true;
           	        if (line.contains("Vandalizmus: �no")) bvandalizmus = true;
	        	}
	        }
	        reader.close();
	    }
		catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
	
	/**
	 * Skontrolujspz.
	 * funkcia, ktor� kontroluje zo s�boru �i pre zadan� E�V vozidla bola vytvoren� poistn� udalos�
	 * @return true, if successful
	 */
	public boolean skontrolujspz() {
		boolean found = false;
		try {
	        FileReader reader = new FileReader("PoistneZaznamy.txt");
	        BufferedReader bufferedReader = new BufferedReader(reader);
	        String line;
	        while ((line = bufferedReader.readLine()) != null && found == false) {
	        	if(line.contains("E�V: "+zadanaspz+";") && (line.contains("Spracovanie; "))) {
	        		found = true;
	        	}
	        }
	        reader.close();
	    }
		catch (IOException ex) {
	        ex.printStackTrace();
	    }
		if(found == true) return true;
		else return false;
	}
	
	
	/**
	 * Kontrolaparametrov.
	 *
	 * @return the int
	 */
	public int kontrolaparametrov() {
		String returnedpu = returnpoistnaudalost();
		if(returnedpu.equals("�koda sp�soben� vozidlom")
				|| (returnzivelnapohroma() == true && returnedpu.equals("�iveln� pohroma"))
				|| (returnstretsozverou() == true && returnedpu.equals("Stret so zverou"))
	        	|| (returnukradnutievozidla() == true && returnedpu.equals("Ukradnutie vozidla")) 
	        	|| (returnvandalizmus() == true && returnedpu.equals("Vandalizmus")) ) return 1;
    	else if (returnedpu.equals("Typ �kody")) return 2;
    	else return 0;
	}
	
	
	
	/**
	 * Returnb 1 mil.
	 *
	 * @return true, if successful
	 */
	public boolean returnb1mil() {
		return b1mil;
	}
	
	/**
	 * Returnb 3 mil.
	 *
	 * @return true, if successful
	 */
	public boolean returnb3mil() {
		return b3mil;
	}
	
	/**
	 * Returnb 5 mil.
	 *
	 * @return true, if successful
	 */
	public boolean returnb5mil() {
		return b5mil;
	}
	
	/**
	 * Returnzadanaspz.
	 *
	 * @return the string
	 */
	public String returnzadanaspz() {
		return zadanaspz;
	}
	
	/**
	 * Returnpoistnaudalost.
	 *
	 * @return the string
	 */
	public String returnpoistnaudalost() {
		return poistnaudalost;
	}
	
	/**
	 * Returnstretsozverou.
	 *
	 * @return true, if successful
	 */
	public boolean returnstretsozverou() {
		return bstretsozverou;
	}
	
	/**
	 * Returnukradnutievozidla.
	 *
	 * @return true, if successful
	 */
	public boolean returnukradnutievozidla() {
		return bukradnutievozidla;
	}
	
	/**
	 * Returnvandalizmus.
	 *
	 * @return true, if successful
	 */
	public boolean returnvandalizmus() {
		return bvandalizmus;
	}
	
	/**
	 * Returnzivelnapohroma.
	 *
	 * @return true, if successful
	 */
	public boolean returnzivelnapohroma() {
		return bzivelnapohroma;
	}
	
	/**
	 * Returnpravda.
	 *
	 * @return true, if successful
	 */
	public boolean returnpravda() {
		return pravda;
	}
	
}