package Poistenie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


// TODO: Auto-generated Javadoc
/**
 * The Class PoistnyZaznam.
 */
public class PoistnyZaznam {
	
	/** The vyskaskody. */
	private String vyskaskody;
	
	/** The suma. */
	private double suma;
	
	/** The vymazcislozaznamu. */
	private String vymazcislozaznamu;
	
	/** The buffered reader. */
	private BufferedReader bufferedReader;
    
	/**
	 * Instantiates a new poistny zaznam.
	 */
	public PoistnyZaznam() {
	}
	
	/**
	 * Instantiates a new poistny zaznam.
	 *
	 * @param vyskaskody the vyskaskody
	 */
	public PoistnyZaznam(String vyskaskody) {
		this.vyskaskody = vyskaskody;
	}
	
	/**
	 * Pocetzaznamov.
	 * funkcia, ktor� zr�ta po�et z�znamov o poisten� zo s�boru FinalnePoistenie.txt
	 * @param subor the subor
	 * @return the int
	 */
	public int pocetzaznamov(String subor) {
		int f=0;
		try {
 	        FileReader reader = new FileReader(subor);
 	        BufferedReader bufferedReader = new BufferedReader(reader);
 	        while ((bufferedReader.readLine()) != null) {
 	        	f++;
 	        }
 	        reader.close();
 	    } 
 		catch (IOException ex) {
 	        ex.printStackTrace();
 	    }
		return f;
	}
	
	/**
	 * Vypiskpz.
	 * funkcia, ktor� na z�klade po�tu z�znamov o poisten� zo s�boru FinalnePoistenie.txt vyp�e text
	 * @param message the message
	 */
	public void vypiskpz(Label message) {
		int f = pocetzaznamov("FinalnePoistenie.txt");
		if(f == 0) {
       		message.setText("Neexistuj� �iadne �daje.");
            message.setTextFill(Color.RED);
       	 }
       	 else {
	    		pouziwriter();
	    		message.setTextFill(Color.GREEN);
				if(f == 1) {
					message.setText("Bol vymazan� "+f+" �daj.");
				}
				else if (f == 2 || f == 3 || f == 4) {
					message.setText("Boli vymazan� "+f+" �daje.");
				}
				else {
					message.setText("Bolo vymazan�ch "+f+" �dajov.");
				}
			}
	}
	
	/**
	 * Ulozudajedolistu.
	 * funkcia, ktor� na��ta jednotliv� riadky zo s�boru do listu a n�sledne ich v�etky vyp�e
	 * @param textArea the text area
	 * @param poistenia the poistenia
	 */
	public void ulozudajedolistu(TextArea textArea, ArrayList<String>poistenia) {
		try {
	        FileReader reader = new FileReader("FinalnePoistenie.txt");
	        BufferedReader bufferedReader = new BufferedReader(reader);
	        String line;
	        int i=0;
	        while ((line = bufferedReader.readLine()) != null) {
	        	line=line.replace("; ","\n");
	        	poistenia.add(i, line);
	        	textArea.appendText(i+1+".\n"+poistenia.get(i)+"\n");
	        	i++;
	        	
	        }
	        reader.close();
	    } 
		catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
	
	/**
	 * Pouziwriter.
	 * funckia, ktor� sl��i na zmazanie v�etk�ch z�znamov o poisten� v s�bore FinalnePoistenie.txt
	 */
	public void pouziwriter() {
		PrintWriter writer;
		try {
			writer = new PrintWriter("Finalnepoistenie.txt");
			writer.print("");
    		writer.close();
		}
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * Sets the vymazcislozaznamu.
	 *
	 * @param vymazcislozaznamu the new vymazcislozaznamu
	 */
	public void setvymazcislozaznamu(String vymazcislozaznamu) {
		this.vymazcislozaznamu = vymazcislozaznamu;
	}
	
	/**
	 * Gets the vymazcislozaznamu.
	 *
	 * @return the vymazcislozaznamu
	 */
	public String getvymazcislozaznamu() {
		return vymazcislozaznamu;
	}
	
	/**
	 * Spracujzaznam.
	 *funkcia, ktor� sl��i na spracovanie z�znamu, admin zad� E�V vozidla a ak sa E�V nach�dza v s�bori PoistneZaznamy.txt, tak si admin 
	 *vyberie pomocou premennej x(0,1) �i chce z�znam potvrdi� alebo zamietnu�
	 * @param ecv the ecv
	 * @param x the x
	 * @param sprava the sprava
	 */
	public void spracujzaznam(String ecv, int x, Text sprava) {
		try {
			File inputFile = new File("PoistneZaznamy.txt");
	        File tempFile = new File("PoistneZaznamy2.txt");

	        BufferedReader reader = new BufferedReader(new FileReader("PoistneZaznamy.txt"));
	        BufferedWriter writer = new BufferedWriter(new FileWriter ("PoistneZaznamy2.txt"));

	        String line;
	        
	        while ((line = reader.readLine()) != null) {
	        	if(line.contains("E�V: "+ecv+";") && line.contains("Spracovanie; ")) {
        			if(x == 1) {
        				line=line.replace("Spracovanie; ","Potvrdene; ");
        				sprava.setText("Z�znam bol akceptovan�.");
        			}
        			else if(x == 0) {
        				line=line.replace("Spracovanie; ","Zamietnute; ");
        				sprava.setText("Z�znam bol zamietnut�.");
        			}
        			writer.write(line + System.getProperty("line.separator"));
	        	}
	        	else {
	        		writer.write(line + System.getProperty("line.separator"));
	        		sprava.setText("Z�znam o spracovan� neexistuje.");
	        	}
	        }
	        writer.close();
	        reader.close();
	        inputFile.delete();
	        tempFile.renameTo(inputFile);
	    } 
		catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
	
	/**
	 * Deletethisline.
	 * funkcia, ktor� sl��i na zmazanie jedn�ho konkr�tneho z�znamu zo s�boru FinalnePoistenie.txt, funkcie kop�ruje ostatn� z�znamy, ktor� 
	 * nechce admin zmaza� do s�boru FinalnePoistenie2.txt a na konci procesu sa zma�e s�bor FinalnePoistenie.txt
	 * a s�bor FinalnePoistenie2.txt sa premenuje na FinalnePoistenie.txt
	 */
	public void deletethisline() {
		try {
			File inputFile = new File("FinalnePoistenie.txt");
	        File tempFile = new File("FinalnePoistenie2.txt");

	        BufferedReader reader = new BufferedReader(new FileReader("FinalnePoistenie.txt"));
	        BufferedWriter writer = new BufferedWriter(new FileWriter("FinalnePoistenie2.txt"));

	        int lineToRemove = Integer.valueOf(getvymazcislozaznamu());
	        String currentLine;
	        int count = 0;

	        while ((currentLine = reader.readLine()) != null) {
	            count++;
	            if (count == lineToRemove) continue;
	            writer.write(currentLine + System.getProperty("line.separator"));
	        }
	        writer.close();
	        reader.close();
	        inputFile.delete();
	        tempFile.renameTo(inputFile);
	    } 
		catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
	
    /**
     * Vyskaskody.
     *
     * @return the double
     */
    public double vyskaskody() {
    	Double suma = Double.parseDouble(vyskaskody);
    	this.suma = suma;
    	return Math.floor(suma * 100) / 100;
    }

	/**
	 * Ulozudaje.
	 * met�da, ktor� do s�boru PoistneZaznamy.txt ulo�� na z�klade E�V a zvolenej v��ku �kody �daje o poisten� a �ak� na spracovanie z�znamu
	 * @param cecv the cecv
	 * @param poistnaudalost the poistnaudalost
	 */
	public void ulozudaje(String cecv, String poistnaudalost) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("PoistneZaznamy.txt"));
			FileReader reader = new FileReader("FinalnePoistenie.txt");
	        bufferedReader = new BufferedReader(reader);
	        String line;
	        while ((line = bufferedReader.readLine()) != null) {
	        	if(line.contains("E�V: "+cecv+";")) {
	        		bw.write("Spracovanie; ");
	        		bw.write(poistnaudalost+"; ");
	        		bw.write(suma+"; ");
	        		bw.write(line);
	                bw.newLine();
	        	}
	        }
	        reader.close();
	        bw.close();
        }
        catch(IOException ex)
        {
        ex.getMessage();
        }
	}

	
	/**
	 * Skontrolujspracovanie.
	 * funkcia, ktor� kontroluje v akom stave je z�znam o poistnej �dalosti
	 * @param ecv the ecv
	 * @return the int
	 */
	public int skontrolujspracovanie(String ecv) {
		boolean potvrdene = false;
		boolean nepotvrdene = false;
		boolean found = false;
		int max = 0;
		int pocet = 0;
		int pocet2 = 0;
		 try {
		        FileReader reader = new FileReader("PoistneZaznamy.txt");
		        BufferedReader bufferedReader = new BufferedReader(reader);
		        String line;
		        while ((line = bufferedReader.readLine()) != null) {
		        	pocet++;
		        	if(line.contains("E�V: "+ecv+";")) { //podmienka, ktor� zis�uje posledn� v�skyt konkr�tneho E�V vozidla v s�bore,
		        		max = pocet;					 //aby sa do premennej max mohol ulo�i� index riadku najnov�ej �iadosti poistnej udalosti
		        		found = true;
		        	}
		        }
		        reader.close();
		        
		        FileReader reader2 = new FileReader("PoistneZaznamy.txt");
		        BufferedReader bufferedReader2 = new BufferedReader(reader2);
		        String line2;
		        while ((line2 = bufferedReader2.readLine()) != null && pocet2 != max) {
		        	pocet2++;
		        	if(line2.contains("E�V: "+ecv+";") && pocet2 == max) {  	//podmienka ktor� h�ad� posledn� z�znam o vozidle na z�klade E�V a
		        		if(line2.contains("Potvrdene; ")) potvrdene = true;		//kontroluje �i bol z�znam potvrden� alebo zamietnut�
		        		else if(line2.contains("Zamietnute; ")) nepotvrdene = true;
		        	}
		        }
		        reader2.close();
		    }
			catch (IOException ex) {
		        ex.printStackTrace();
		    }
		
		if(potvrdene == true) return 1;			//return "Poistn� udalos� bola akceptovan�.";
		else if(nepotvrdene == true) return 2;	//return "Poistn� udalos� bola zamietnut�.";
		else if(found == false) return 0;		//return "Poistn� udalos� neexistuje.";
		else return 3;							//return "Poistn� udalos� sa spracov�va.";
	}
	
	/**
	 * Pzaznamvypis.
	 * met�da, ktor� pod�a zadan�ho ��sla z�znamu, ktor� chce admin zmaza� vyp�e spr�vu pod�a toho ak� je vstup
	 * @param message the message
	 */
	public void pzaznamvypis(Label message) {
		
		
		if(getvymazcislozaznamu().equals("")) {
			message.setText("Zadajte ��slo");
            message.setTextFill(Color.RED);
		}
		else if (!getvymazcislozaznamu().matches("[0-9]*")) {
			message.setText("Chybn� vstup, vstup akceptuje iba ��slo");
            message.setTextFill(Color.RED);
		}
		else if(getvymazcislozaznamu().matches("[0-9]*")) {
				if(Integer.valueOf(getvymazcislozaznamu()) > pocetzaznamov("FinalnePoistenie.txt")) {
					message.setText("Z�znam ��slo "+getvymazcislozaznamu()+". neexistuje");
	                message.setTextFill(Color.RED);
				}
				else if(Integer.valueOf(getvymazcislozaznamu()) == 0) {
					message.setText("Neplatn� ��slo");
	                message.setTextFill(Color.RED);
				}
				else {	
					deletethisline();
					message.setText("Z�znam ��slo "+getvymazcislozaznamu()+" �spe�ne zmazan�");
	                message.setTextFill(Color.GREEN);
				}
		}
	}
	
}