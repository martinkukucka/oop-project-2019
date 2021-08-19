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
	 * funkcia, ktorá zráta poèet záznamov o poistení zo súboru FinalnePoistenie.txt
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
	 * funkcia, ktorá na základe poètu záznamov o poistení zo súboru FinalnePoistenie.txt vypíše text
	 * @param message the message
	 */
	public void vypiskpz(Label message) {
		int f = pocetzaznamov("FinalnePoistenie.txt");
		if(f == 0) {
       		message.setText("Neexistujú žiadne údaje.");
            message.setTextFill(Color.RED);
       	 }
       	 else {
	    		pouziwriter();
	    		message.setTextFill(Color.GREEN);
				if(f == 1) {
					message.setText("Bol vymazaný "+f+" údaj.");
				}
				else if (f == 2 || f == 3 || f == 4) {
					message.setText("Boli vymazané "+f+" údaje.");
				}
				else {
					message.setText("Bolo vymazaných "+f+" údajov.");
				}
			}
	}
	
	/**
	 * Ulozudajedolistu.
	 * funkcia, ktorá naèíta jednotlivé riadky zo súboru do listu a následne ich všetky vypíše
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
	 * funckia, ktorá slúži na zmazanie všetkých záznamov o poistení v súbore FinalnePoistenie.txt
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
	 *funkcia, ktorá slúži na spracovanie záznamu, admin zadá EÈV vozidla a ak sa EÈV nachádza v súbori PoistneZaznamy.txt, tak si admin 
	 *vyberie pomocou premennej x(0,1) èi chce záznam potvrdi alebo zamietnu
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
	        	if(line.contains("EÈV: "+ecv+";") && line.contains("Spracovanie; ")) {
        			if(x == 1) {
        				line=line.replace("Spracovanie; ","Potvrdene; ");
        				sprava.setText("Záznam bol akceptovaný.");
        			}
        			else if(x == 0) {
        				line=line.replace("Spracovanie; ","Zamietnute; ");
        				sprava.setText("Záznam bol zamietnutý.");
        			}
        			writer.write(line + System.getProperty("line.separator"));
	        	}
	        	else {
	        		writer.write(line + System.getProperty("line.separator"));
	        		sprava.setText("Záznam o spracovaní neexistuje.");
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
	 * funkcia, ktorá slúži na zmazanie jedného konkrétneho záznamu zo súboru FinalnePoistenie.txt, funkcie kopíruje ostatné záznamy, ktoré 
	 * nechce admin zmaza do súboru FinalnePoistenie2.txt a na konci procesu sa zmaže súbor FinalnePoistenie.txt
	 * a súbor FinalnePoistenie2.txt sa premenuje na FinalnePoistenie.txt
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
	 * metóda, ktorá do súboru PoistneZaznamy.txt uloží na základe EÈV a zvolenej výšku škody údaje o poistení a èaká na spracovanie záznamu
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
	        	if(line.contains("EÈV: "+cecv+";")) {
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
	 * funkcia, ktorá kontroluje v akom stave je záznam o poistnej údalosti
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
		        	if(line.contains("EÈV: "+ecv+";")) { //podmienka, ktorá zisuje posledný výskyt konkrétneho EÈV vozidla v súbore,
		        		max = pocet;					 //aby sa do premennej max mohol uloži index riadku najnovšej žiadosti poistnej udalosti
		        		found = true;
		        	}
		        }
		        reader.close();
		        
		        FileReader reader2 = new FileReader("PoistneZaznamy.txt");
		        BufferedReader bufferedReader2 = new BufferedReader(reader2);
		        String line2;
		        while ((line2 = bufferedReader2.readLine()) != null && pocet2 != max) {
		        	pocet2++;
		        	if(line2.contains("EÈV: "+ecv+";") && pocet2 == max) {  	//podmienka ktorá h¾adá posledný záznam o vozidle na základe EÈV a
		        		if(line2.contains("Potvrdene; ")) potvrdene = true;		//kontroluje èi bol záznam potvrdený alebo zamietnutý
		        		else if(line2.contains("Zamietnute; ")) nepotvrdene = true;
		        	}
		        }
		        reader2.close();
		    }
			catch (IOException ex) {
		        ex.printStackTrace();
		    }
		
		if(potvrdene == true) return 1;			//return "Poistná udalos bola akceptovaná.";
		else if(nepotvrdene == true) return 2;	//return "Poistná udalos bola zamietnutá.";
		else if(found == false) return 0;		//return "Poistná udalos neexistuje.";
		else return 3;							//return "Poistná udalos sa spracováva.";
	}
	
	/**
	 * Pzaznamvypis.
	 * metóda, ktorá pod¾a zadaného èísla záznamu, ktoré chce admin zmaza vypíše správu pod¾a toho aký je vstup
	 * @param message the message
	 */
	public void pzaznamvypis(Label message) {
		
		
		if(getvymazcislozaznamu().equals("")) {
			message.setText("Zadajte èíslo");
            message.setTextFill(Color.RED);
		}
		else if (!getvymazcislozaznamu().matches("[0-9]*")) {
			message.setText("Chybný vstup, vstup akceptuje iba èíslo");
            message.setTextFill(Color.RED);
		}
		else if(getvymazcislozaznamu().matches("[0-9]*")) {
				if(Integer.valueOf(getvymazcislozaznamu()) > pocetzaznamov("FinalnePoistenie.txt")) {
					message.setText("Záznam èíslo "+getvymazcislozaznamu()+". neexistuje");
	                message.setTextFill(Color.RED);
				}
				else if(Integer.valueOf(getvymazcislozaznamu()) == 0) {
					message.setText("Neplatné èíslo");
	                message.setTextFill(Color.RED);
				}
				else {	
					deletethisline();
					message.setText("Záznam èíslo "+getvymazcislozaznamu()+" úspešne zmazaný");
	                message.setTextFill(Color.GREEN);
				}
		}
	}
	
}