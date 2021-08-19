package GUI;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Others.Address;
import Others.ChybaMessage;
import Poistenie.*;
import User.Admin;
import User.User;
import VozidloUdaje.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main extends Application{
	
	/** The buttonpv. */
	//Poistenie vozidla
    Button buttonpv = new Button("Poistenie vozidla");
    	
	    /** The kategoriavozidla. */
	    ComboBox<String> kategoriavozidla = new ComboBox<>();
    	
	    /** The buttondalej. */
	    Button buttondalej = new Button("œalej");
	    
    	/** The buttonspat. */
    	Button buttonspat = new Button("Sp‰ù");
	    
	/** The buttonpu. */
	//Poistn· udalosù
	Button buttonpu = new Button("Poistn· udalosù");
	    
    	/** The poistnaudalost. */
    	ComboBox<String> poistnaudalost;
	    
    	/** The zadanaspz. */
    	String zadanaspz;
    	
	    /** The zadajspz. */
	    TextField zadajspz = new TextField();
	    
    	/** The buttondalejzadajspz. */
    	Button buttondalejzadajspz = new Button ("œalej");
		
		/** The buttonspatzadajspz. */
		Button buttonspatzadajspz = new Button ("Sp‰ù");
	    
    	/** The buttondalej 2. */
    	Button buttondalej2 = new Button("œalej");
	    
    	/** The buttonspat 2. */
    	Button buttonspat2 = new Button("Sp‰ù");
	   
	/** The skontrolujzaznam. */
	//Skontroluj z·znam
	Button skontrolujzaznam = new Button("Kontrola z·znamu");
		
		/** The zadajspz 2. */
		TextField zadajspz2 = new TextField();
		
		/** The buttonzaznamkontrola. */
		Button buttonzaznamkontrola = new Button("Kontrola poistenia");
	    
    	/** The buttonzaznamspat. */
    	Button buttonzaznamspat = new Button("Sp‰ù");
	    
    	/** The stackpanezaznam. */
    	StackPane stackpanezaznam = new StackPane();
		
		/** The scenezaznam. */
		Scene scenezaznam = new Scene(stackpanezaznam, 600, 800);
	    
	/** The buttonpo. */
	//Podmienky
    Button buttonpo = new Button("Podmienky");
    	
	    /** The buttonspatpo. */
	    Button buttonspatpo = new Button("Sp‰ù");
    	
    /** The buttonadmin. */
    //Admin
	Button buttonadmin = new Button("Admin");
		
		/** The text area. */
		final TextArea textArea = new TextArea();
		
		/** The ameno. */
		TextField ameno = new TextField();
		
		/** The vymazcislozaznamu. */
		TextField vymazcislozaznamu = new TextField();
		
		/** The aheslo. */
		PasswordField aheslo = new PasswordField();
		
		/** The buttondalejadmin. */
		Button buttondalejadmin = new Button("œalej");
	    
    	/** The buttonspatadmin. */
    	Button buttonspatadmin = new Button("Sp‰ù");
	    
    	/** The vypisvsetkyzaznamy. */
    	Button vypisvsetkyzaznamy = new Button("VypÌö vöetky z·znamy");
		
		/** The vymazvsetkyzaznamy. */
		Button vymazvsetkyzaznamy = new Button("Vymaû vöetky z·znamy");
		
		/** The vymazcislo. */
		Button vymazcislo = new Button("Vymaû");
		
		/** The logout. */
		Button logout = new Button("Odhl·siù sa");
		
		/** The adminvbox. */
		VBox adminvbox = new VBox();
		
		/** The adminvbox 2. */
		VBox adminvbox2 = new VBox();
	    
    	/** The stackpaneadmin. */
    	StackPane stackpaneadmin = new StackPane();
	    
    	/** The stackpaneadmin 2. */
    	StackPane stackpaneadmin2 = new StackPane();
	    
    	/** The sceneadmin. */
    	Scene sceneadmin = new Scene(stackpaneadmin, 600, 800);
	    
    	/** The sceneadmin 2. */
    	Scene sceneadmin2 = new Scene(stackpaneadmin2, 600, 800);
		
		/** The message. */
		final Label message = new Label("");
		
		/** The potvrdzaznam. */
		Button potvrdzaznam = new Button("Potvrdenie z·znamu");
		
		/** The nepotvrdzaznam. */
		Button nepotvrdzaznam = new Button("Zamietnutie z·znamu");
    	
    /** The buttonkoniec. */
    //Koniec	
    Button buttonkoniec = new Button("Koniec");
	    
  /** The meno. */
  //User
    TextField meno = new TextField();
	
	/** The psc. */
	TextField psc = new TextField();
	
	/** The mesto. */
	TextField mesto = new TextField();
    
    /** The ulica. */
    TextField ulica = new TextField();
    
    /** The cislodomu. */
    TextField cislodomu = new TextField();
    
    /** The pocetsu. */
    TextField pocetsu = new TextField();
	
	/** The datumnarodenia. */
	DatePicker datumnarodenia = new DatePicker();
	
	/** The kraj. */
	public ComboBox<String> kraj = new ComboBox<>();
    
    /** The buttondalejou. */
    Button buttondalejou = new Button ("œalej");
   	
	   /** The buttonspatou. */
	   Button buttonspatou = new Button ("Sp‰ù");
   	
  /** The aecv. */
  //OsobnÈ auto
	TextField aecv = new TextField();
    
    /** The aznacka. */
    TextField aznacka = new TextField();
	
	/** The amodel. */
	TextField amodel = new TextField();
	
	/** The aobjemvalcov. */
	TextField aobjemvalcov = new TextField();
	
	/** The avykon. */
	TextField avykon = new TextField();
	
	/** The arok. */
	TextField arok = new TextField();
	
	/** The aprevodovka. */
	ComboBox<String> aprevodovka = new ComboBox<>();
	
	/** The adruhpaliva. */
	ComboBox<String> adruhpaliva = new ComboBox<>();
	
	/** The apohon. */
	ComboBox<String> apohon = new ComboBox<>();
	
	/** The buttonadalej. */
	Button buttonadalej = new Button("œalej");
    
    /** The buttonaspat. */
    Button buttonaspat = new Button("Sp‰ù");
    
  /** The mecv. */
  //Motocykel
	TextField mecv = new TextField();
    
    /** The mznacka. */
    TextField mznacka = new TextField();
    
    /** The mmodel. */
    TextField mmodel = new TextField();
    
    /** The mobjemvalcov. */
    TextField mobjemvalcov = new TextField();
    
    /** The mvykon. */
    TextField mvykon = new TextField();
    
    /** The mrok. */
    TextField mrok = new TextField();
    
    /** The mdruhpaliva. */
    ComboBox<String> mdruhpaliva = new ComboBox<>();
	
	/** The mprevodovka. */
	ComboBox<String> mprevodovka = new ComboBox<>();
    
    /** The buttonmdalej. */
    Button buttonmdalej = new Button("œalej");
    
    /** The buttonmspat. */
    Button buttonmspat = new Button("Sp‰ù");
    
  /** The necv. */
  //N·kladnÈ auto
    TextField necv = new TextField();
	
	/** The nznacka. */
	TextField nznacka = new TextField();
    
    /** The nmodel. */
    TextField nmodel = new TextField();
    
    /** The nobjemvalcov. */
    TextField nobjemvalcov = new TextField();
    
    /** The nrok. */
    TextField nrok = new TextField();
    
    /** The ndruhpaliva. */
    ComboBox<String> ndruhpaliva = new ComboBox<>();
	
	/** The nhmotnost. */
	ComboBox<String> nhmotnost = new ComboBox<>();
	
	/** The nprevodovka. */
	ComboBox<String> nprevodovka = new ComboBox<>();
	
	/** The buttonndalej. */
	Button buttonndalej = new Button("œalej");
    
    /** The buttonnspat. */
    Button buttonnspat = new Button("Sp‰ù");
    
  /** The kategoriapoistenia. */
  //BonusovÈ poistenie
    ComboBox<String> kategoriapoistenia = new ComboBox<>();
    
    /** The buttondalejbonus. */
    Button buttondalejbonus = new Button ("œalej");
   	
	   /** The buttonspatbonus. */
	   Button buttonspatbonus = new Button ("Sp‰ù");
   	
  /** The dalejvypocitaj. */
  //Potvrdenie
	Button dalejvypocitaj = new Button("VypoËÌtaj cenu");
	
	/** The spatvypocitaj. */
	Button spatvypocitaj = new Button("Sp‰ù");
	
	/** The potvrd. */
	Button potvrd = new Button("Potvrdenie");
	
  /** The hlavnemenu. */
  //PotvrdenÈ a vytvorenÈ
	Button hlavnemenu = new Button("HlavnÈ menu");
	   	
	/** The stackpane. */
	StackPane stackpane = new StackPane();
	
	/** The stackpanepv. */
	StackPane stackpanepv = new StackPane();
	
	/** The stackpanepo. */
	StackPane stackpanepo = new StackPane();
	
	/** The stackpanepu. */
	StackPane stackpanepu = new StackPane();
	
	/** The stackpaneautomobil. */
	StackPane stackpaneautomobil = new StackPane();
	
	/** The stackpanemotocykel. */
	StackPane stackpanemotocykel = new StackPane();
	
	/** The stackpanenakladne. */
	StackPane stackpanenakladne = new StackPane();
	
	/** The stackpaneuser. */
	StackPane stackpaneuser = new StackPane();
	
	/** The stackpanebonus. */
	StackPane stackpanebonus = new StackPane();
	
	/** The stackpanepotvrdenie. */
	StackPane stackpanepotvrdenie = new StackPane();
	
	/** The stackpaneskodasposobenavozidlom. */
	StackPane stackpaneskodasposobenavozidlom = new StackPane();
	
	/** The stackpaneskodasposobenavozidlom 2. */
	StackPane stackpaneskodasposobenavozidlom2 = new StackPane();
	
	/** The stackpanekalkulacia. */
	StackPane stackpanekalkulacia = new StackPane();
	
	/** The stackpanezadajspz. */
	StackPane stackpanezadajspz = new StackPane();
	
	/** The scenezadajspz. */
	Scene scenezadajspz = new Scene(stackpanezadajspz, 600, 800);
	
	/** The scene. */
	Scene scene = new Scene(stackpane, 600, 800);
	
	/** The scenepv. */
	Scene scenepv = new Scene(stackpanepv, 600, 800);
	
	/** The scenepo. */
	Scene scenepo = new Scene(stackpanepo, 600, 800);
	
	/** The scenepu. */
	Scene scenepu = new Scene(stackpanepu, 600, 800);
	
	/** The automobil. */
	Scene automobil = new Scene(stackpaneautomobil, 600, 800);
	
	/** The motocykel. */
	Scene motocykel = new Scene(stackpanemotocykel, 600, 800);
	
	/** The nakladne. */
	Scene nakladne = new Scene(stackpanenakladne, 600, 800);
	
	/** The user. */
	Scene user = new Scene(stackpaneuser, 600, 800);
	
	/** The bonus. */
	Scene bonus = new Scene(stackpanebonus, 600, 800);
	
	/** The potvrdenie. */
	Scene potvrdenie = new Scene(stackpanepotvrdenie, 600, 800);
	
	/** The skodasposobenavozidlom. */
	Scene skodasposobenavozidlom = new Scene(stackpaneskodasposobenavozidlom, 600, 800);
	
	/** The skodasposobenavozidlom 2. */
	Scene skodasposobenavozidlom2 = new Scene(stackpaneskodasposobenavozidlom2, 600, 800);
	
	/** The kalkulacia. */
	Scene kalkulacia = new Scene(stackpanekalkulacia, 600, 800);
	
    /** The alabel. */
    Label alabel = new Label();
    
    /** The mlabel. */
    Label mlabel = new Label();
    
    /** The nlabel. */
    Label nlabel = new Label();

    /** The admin. */
    Admin admin;
    
    /** The moto. */
    Motocykel moto;
    
    /** The osobnea. */
    OsobneAuto osobnea;
    
    /** The nakladnea. */
    NakladneAuto nakladnea;
    
    /** The pouzivatel. */
    User pouzivatel;
    
    /** The bonuspoi. */
    BonusovePoistenie bonuspoi;
    
    /** The cpoistenia. */
    CenaPoistenia cpoistenia;
    
    /** The classkv. */
    ClassKategoriaVozidla classkv;
    
    /** The classpu. */
    ClassPoistnaUdalost classpu;
    
    /** The pzaznam. */
    PoistnyZaznam pzaznam;
    
    /** The classecv. */
    ClassECV classecv;
    
    /** The vozidlo. */
    Vozidlo vozidlo;
    
    /** The address. */
    Address address;
    
    /** The users. */
    ArrayList<User>users = new ArrayList<User>();
    
    /** The bzivelnapohroma. */
    public boolean bzivelnapohroma = false;
	
	/** The bstretsozverou. */
	public boolean bstretsozverou = false;
	
	/** The bukradnutievozidla. */
	public boolean bukradnutievozidla = false;
	
	/** The bvandalizmus. */
	public boolean bvandalizmus = false;
	
	/** The b 1 mil. */
	public boolean b1mil = false;
	
	/** The b 3 mil. */
	public boolean b3mil = false;
	
	/** The b 5 mil. */
	public boolean b5mil = false;

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
  
    /**
     * V box.
     *
     * @param vvbox the vvbox
     */
    public void VBox(VBox vvbox) {
        vvbox.setPadding(new Insets(50, 50, 50, 50));
        vvbox.setSpacing(15);
        vvbox.setAlignment(Pos.CENTER);
    	vvbox.setStyle("-fx-background-color: lightgreen");
    }

    /**
     * H box.
     *
     * @param hhbox the hhbox
     */
    public void HBox(HBox hhbox) {
        hhbox.setSpacing(5);
        hhbox.setAlignment(Pos.CENTER_RIGHT);
    }
    
    /**
     * Nastav button.
     *
     * @param but the but
     */
    public void nastavButton (Button but) {
    	but.setMaxWidth(100);
    }
    
    /**
     * The Interface SendErrorMessage.
     */
    interface SendErrorMessage{  
        
        /**
         * pouûitÈ na n·vrhov˝ vzor Mediator
         * Send.
         */
        void send();  
    }  
    
    /**
     * Nastav button.
     *
     * @param but the but
     * @param butsize the butsize
     */
    public void nastavButton (Button but, int butsize) {
    	but.setMaxWidth(butsize);
    }
    
    /**
     * Textfield.
     *
     * @param textfield the textfield
     * @param maxwidthh the maxwidthh
     * @param textt the textt
     */
    public void textfield (TextField textfield, int maxwidthh, String textt) {
    	textfield.setMaxWidth(maxwidthh);
	    textfield.setPromptText(textt);
    }
    
	 /* (non-Javadoc)
 	 * @see javafx.application.Application#start(javafx.stage.Stage)
 	 */
 	public void start(Stage primaryStage){ 
		 	SendErrorMessage emessage = ChybaMessage::sendmessage; //pouûitie referencie na metÛdu
		 
		    nastavButton (buttondalejzadajspz, 150);
		    nastavButton (buttonspatzadajspz, 150);
		    nastavButton (buttondalej2, 150);
		    nastavButton (buttonspat2, 150);
	    	nastavButton (buttonpv, 150);
	    	nastavButton (buttonpu, 150);
	    	nastavButton (buttonpo, 150);
	    	nastavButton (buttonkoniec, 150);
	    	nastavButton (buttonspat);
	    	nastavButton (buttondalej);
	    	nastavButton (buttondalej2);
	    	nastavButton (buttonspat2);
	    	nastavButton (buttonspatpo);
	    	nastavButton (buttondalejou);
	        nastavButton (buttonspatou);
	        nastavButton (buttondalejbonus);
	        nastavButton (buttonspatbonus);
	        nastavButton (buttondalejadmin);
	        nastavButton (buttonspatadmin);
	        nastavButton (buttonadmin, 150);
	    	nastavButton(vypisvsetkyzaznamy, 150);
	    	nastavButton(vymazvsetkyzaznamy, 150);
	    	nastavButton(vymazcislo, 150);
	    	nastavButton(logout);
	    	nastavButton (skontrolujzaznam, 150);
	    	nastavButton (buttonzaznamspat, 150);
	    	nastavButton (buttonzaznamkontrola, 150);
	    	nastavButton (potvrdzaznam, 150);
	    	nastavButton (nepotvrdzaznam, 150);
	    	textfield (zadajspz2, 150, "E»V");
	    	
	    	Label label = new Label("Online poistenie vozidla");
	    	label.setFont(Font.font("", FontWeight.BOLD, 34));
	    	
	    	VBox vbox = new VBox();
	    	VBox(vbox);
	    	vbox.getChildren().addAll(label, buttonpv, buttonpu, buttonpo, skontrolujzaznam, buttonadmin, buttonkoniec);
	    	kategoriavozidla.setMaxWidth(150);
	    	kategoriavozidla.setValue("KategÛria vozidla");
	    	kategoriavozidla.getItems().addAll(
	    		"Motocykel",
	    		"OsobnÈ auto",
	    		"N·kladnÈ auto"
	        );
	    	
	    	buttondalej.setOnAction(e -> {
	    		meno.clear();
	    		psc.clear();
	    		mesto.clear();
	    		ulica.clear();
	    	    cislodomu.clear();
	    	    pocetsu.clear();
	    	    kraj.setValue("Kraj");
	    	    datumnarodenia.setValue(null);
	    		
	    	    
	    	    //pouûitie RTTI
	    	    classkv = new ClassKategoriaVozidla(kategoriavozidla.getValue().toString());
	    	    Object Avoz = new Object();
	    	    if(classkv.returnkategoriavozidla().equals("Motocykel")) Avoz = new Motocykel(null, null, null, null, null, null, null, null, null);
	    	    else if(classkv.returnkategoriavozidla().equals("OsobnÈ auto")) Avoz = new OsobneAuto(null, null, null, null, null, null, null, null, null, null);
	    	    else if(classkv.returnkategoriavozidla().equals("N·kladnÈ auto")) Avoz = new NakladneAuto(null, null, null, null, null, null, null, null, null);
	    	   
	    	    if(OsobneAuto.class.isInstance(Avoz)) 
	        	{
	            	aecv.clear();
	        	    aznacka.clear();
	            	amodel.clear();
	            	aobjemvalcov.clear();
	            	avykon.clear();
	            	arok.clear();
	            	aprevodovka.setValue("Prevodovka");
	            	adruhpaliva.setValue("Druh paliva");
	            	apohon.setValue("Pohon");
	            	
	        		primaryStage.setScene(automobil);
	        		alabel.setText("Poistenie - "+classkv.returnkategoriavozidla());
	        	}
	    	    
	    	    else if(Motocykel.class.isInstance(Avoz)) 
	    		{
	    	    	mecv.clear();
	    		    mznacka.clear();
	    		    mmodel.clear();
	    		    mobjemvalcov.clear();
	    		    mvykon.clear();
	    		    mrok.clear();
	    	    	mdruhpaliva.setValue("Druh paliva");
	    	    	mprevodovka.setValue("Prevodovka");
	    	    	
	    			primaryStage.setScene(motocykel);
	    			mlabel.setText("Poistenie - "+classkv.returnkategoriavozidla());
	    		}
	    			
	    		else if(NakladneAuto.class.isInstance(Avoz)) 
	    		{
	        	    necv.clear();
	            	nznacka.clear();
	        	    nmodel.clear();
	        	    nobjemvalcov.clear();
	        	    nrok.clear();
	        	    ndruhpaliva.setValue("Druh paliva");
	    	    	nhmotnost.setValue("Hmotnosù");
	    	    	nprevodovka.setValue("Prevodovka");
	    	    	
	        		primaryStage.setScene(nakladne);
	        		nlabel.setText("Poistenie - "+classkv.returnkategoriavozidla());
	        	}
	    		}
	    	);

	    	poistnaudalost = new ComboBox<>();
	    	poistnaudalost.setValue("Typ ökody");
	    	poistnaudalost.getItems().addAll(
	    		"äkoda spÙsoben· vozidlom",
	    		"éiveln· pohroma",
	            "Stret so zverou",
	            "Ukradnutie vozidla",
	            "Vandalizmus"
	        );

	    	//Button poistenie vozidla
		        Label labelpv = new Label("Poistenie vozidla");
		        labelpv.setFont(Font.font("", FontWeight.BOLD, 18));
		        buttonpv.setOnAction(e -> {
		        	primaryStage.setScene(scenepv);
		        });
		        
		        VBox vboxpv = new VBox();
		        
		        stackpanepv.getChildren().addAll(vboxpv);
		    	VBox (vboxpv);
		        vboxpv.getChildren().addAll(labelpv,kategoriavozidla,buttondalej,buttonspat);

		    	buttonspat.setOnAction(e -> primaryStage.setScene(scene));
		    	
	        //Button poistna udalost
		    	VBox vboxzadajspz = new VBox();
		    	VBox(vboxzadajspz);
		    	Label labelzadajspz = new Label("EvidenËnÈ ËÌslo vozidla");
		    	textfield (zadajspz, 150, "E»V");
		    	labelzadajspz.setFont(Font.font("", FontWeight.BOLD, 18));

		    	Text vyskasposobenejskodytext = new Text("V˝öka spÙsobenej ökody");
		    	TextField vyskasposobenejskody = new TextField();
		    	textfield (vyskasposobenejskody, 150, "V˝öka spÙsobenej ökody");
		    	
		    	Button buttonskodasposobenavozidlomdalej = new Button("œalej");
		    	Button buttonskodasposobenavozidlomspat = new Button("Sp‰ù");
		    	
		    	VBox vboxskodasposobenavozidlom = new VBox();		    	
		    	VBox(vboxskodasposobenavozidlom);
		    	
		    	vboxskodasposobenavozidlom.getChildren().addAll(vyskasposobenejskodytext, vyskasposobenejskody, buttonskodasposobenavozidlomdalej,buttonskodasposobenavozidlomspat);
		       	stackpaneskodasposobenavozidlom.getChildren().add(vboxskodasposobenavozidlom);
		    	buttonskodasposobenavozidlomspat.setOnAction(e -> primaryStage.setScene(scenepu));
		    	
		    	Text ta4 = new Text();
		    	
		    	buttondalejzadajspz.setOnAction(e -> {
			    	boolean pravda = false;
			    	bzivelnapohroma = false;
			    	bstretsozverou = false;
			    	bukradnutievozidla = false;
			    	bvandalizmus = false;
			    	b1mil = false;
			    	b3mil = false;
			    	b5mil = false;
			    	vyskasposobenejskody.clear();
			    	poistnaudalost.setValue("Typ ökody");
			    	
			    	classpu = new ClassPoistnaUdalost(zadajspz.getText());
			    	classpu.precitajudaje(ta4);
			    	pravda = classpu.returnpravda();
			    	b1mil = classpu.returnb1mil();
			    	b3mil = classpu.returnb3mil();
			    	b5mil = classpu.returnb5mil();
			    	bzivelnapohroma = classpu.returnzivelnapohroma();
			    	bstretsozverou = classpu.returnstretsozverou();
			    	bukradnutievozidla = classpu.returnukradnutievozidla();
			    	bvandalizmus = classpu.returnvandalizmus();
		    		if(pravda == true) {
		    			if(!classpu.skontrolujspz()) primaryStage.setScene(scenepu);
		    			else JOptionPane.showMessageDialog(null, "Ned· sa nahl·siù Ôaæöia poistn· udalosù, pokiaæ sa nespracuje predoöl·.","Chyba",JOptionPane.INFORMATION_MESSAGE);
		    		}
    	        	else JOptionPane.showMessageDialog(null, "Poistenie pre danÈ vozidlo neexistuje.","Chyba",JOptionPane.INFORMATION_MESSAGE);
		    	});
		    	
		    	buttondalej2.setOnAction(e -> {
		    		classpu = new ClassPoistnaUdalost(poistnaudalost.getValue().toString(), bstretsozverou, bukradnutievozidla, bvandalizmus, bzivelnapohroma);
		    		
		    		if(classpu.kontrolaparametrov() == 1) primaryStage.setScene(skodasposobenavozidlom);
		        	else if (classpu.kontrolaparametrov() == 2) JOptionPane.showMessageDialog(null, "Zvolte typ ökodovej udalost","Chyba",JOptionPane.INFORMATION_MESSAGE);
		        	else JOptionPane.showMessageDialog(null, "Vaöe vozidlo nie je poistenÈ proti poloûke - "+poistnaudalost.getValue().toString(),"Chyba",JOptionPane.INFORMATION_MESSAGE);
		    		
		    		}
		    	);

		    	buttonspatzadajspz.setOnAction(e -> primaryStage.setScene(scene));
		    	
		    	vboxzadajspz.getChildren().addAll(labelzadajspz, zadajspz, buttondalejzadajspz, buttonspatzadajspz);
		    	stackpanezadajspz.getChildren().add(vboxzadajspz);
		    	
		        Label labelpu = new Label("Poistn· udalosù");
		        labelpu.setFont(Font.font("", FontWeight.BOLD, 18));
		        buttonpu.setOnAction(e -> {
		        	primaryStage.setScene(scenezadajspz);
		        	zadajspz.clear();
		        });
		        
		        VBox vboxpu = new VBox();
		        
		        stackpanepu.getChildren().add(vboxpu);
		        
		        VBox (vboxpu);
		        vboxpu.getChildren().addAll(labelpu, ta4, poistnaudalost, buttondalej2, buttonspat2);
		        
		    	buttonspat2.setOnAction(e -> {
		    		primaryStage.setScene(scenezadajspz);
		    		zadajspz.clear();
		    	});
		    
		    	
		    	buttonskodasposobenavozidlomdalej.setOnAction(e -> {
		    		classpu = new ClassPoistnaUdalost(vyskasposobenejskody.getText(), b1mil, b3mil, b5mil);
			    	if(classpu.skontrolujvyskuskody() == 1) {
			    		pzaznam = new PoistnyZaznam(vyskasposobenejskody.getText());
			    		//pzaznam.vyskaskody();
			    		pzaznam.ulozudaje(zadajspz.getText(), poistnaudalost.getValue().toString());
			    		JOptionPane.showMessageDialog(null, "Nahl·senie poistnej udalosti v rozmedzÌ ökody "+classpu.returnvyskaskody()+" bolo ˙speönÈ.","⁄speönÈ nahl·senie",JOptionPane.INFORMATION_MESSAGE);
			    		primaryStage.setScene(scene);
			    	}
			    	else if(classpu.skontrolujvyskuskody() == 2) JOptionPane.showMessageDialog(null, "V˝öka ökody presahuje preplatenie poistenia","Chyba",JOptionPane.INFORMATION_MESSAGE);
			    	else if(classpu.skontrolujvyskuskody() == 3) JOptionPane.showMessageDialog(null, "Neplatn· hodnota","Chyba",JOptionPane.INFORMATION_MESSAGE);
			    	else JOptionPane.showMessageDialog(null, "äkoda presahuje hranicu preplatenia, poisùovÚa t˙to ökodu nepreplatÌ","Chyba",JOptionPane.INFORMATION_MESSAGE);
			    	});
		    	
		    //Button skontrolujzaznam
		    	skontrolujzaznam.setOnAction(e -> {
		    		primaryStage.setScene(scenezaznam);
		    		zadajspz2.clear();
		    	});
		    	Label labelzadajspz2 = new Label("EvidenËnÈ ËÌslo vozidla");
		    	labelzadajspz2.setFont(Font.font("", FontWeight.BOLD, 18));
		    	VBox vboxzaznam = new VBox();
		    	VBox(vboxzaznam);
		    	vboxzaznam.getChildren().addAll(labelzadajspz2, zadajspz2,buttonzaznamkontrola,buttonzaznamspat);
		    	stackpanezaznam.getChildren().add(vboxzaznam);
		    	buttonzaznamspat.setOnAction(e -> primaryStage.setScene(scene));
		    	buttonzaznamkontrola.setOnAction(e-> {
		    		pzaznam = new PoistnyZaznam();
		    		ClassECV zadajcecv;
			    	zadajcecv = new ClassECV(zadajspz2.getText());
			    	int vratenahodnota = pzaznam.skontrolujspracovanie(zadajcecv.returnecvv());
			    	if(vratenahodnota == 1)zadajcecv.sendMessage("bola akceptovan·"); //pouûitÈ na n·vrhov˝ vzor Mediator
			    	else if(vratenahodnota == 2)zadajcecv.sendMessage("bola zamietnut·"); //pouûitÈ na n·vrhov˝ vzor Mediator
			    	if(vratenahodnota == 0)zadajcecv.sendMessage("neexistuje"); //pouûitÈ na n·vrhov˝ vzor Mediator
			    	if(vratenahodnota == 3)zadajcecv.sendMessage("sa spracov·va"); //pouûitÈ na n·vrhov˝ vzor Mediator
		    	});
		    	

		    //Button podmienky
		        Label labelpo = new Label("Podmienky");
		        labelpo.setFont(Font.font("", FontWeight.BOLD, 18));
		        buttonpo.setOnAction(e -> primaryStage.setScene(scenepo));
		        
		        VBox vboxpo = new VBox();
		        stackpanepo.getChildren().add(vboxpo);
		        
		        Text textpo = new Text();
		        textpo.setText("- osob·m mladöÌm ako 18 rokov nemÙûe byù poskytnutÈ akÈkoævek poistenie\n"
		        		+ "- pri ökodovej udalosti nebude uhraden· ökoda, ak ökoda prev˝öila v˝öku vami zvolenÈho poistenia\n"
		        		+ "- poisùovna neuhradÌ ak˙koævek ökodu nad hranicu 5 miliÛnov Ä");
		        
		        VBox (vboxpo);
		        vboxpo.getChildren().addAll(labelpo, textpo, buttonspatpo);
		        buttonspatpo.setOnAction((event) -> {
		        	primaryStage.setScene(scene);
		        });

		    	
		    //Button koniec
		    	ButtonBar.setButtonData(buttonkoniec, ButtonBar.ButtonData.CANCEL_CLOSE);
		    	buttonkoniec.setCancelButton(true);
		    	buttonkoniec.setOnAction(e -> Platform.exit());
		    	buttonkoniec.setMaxWidth(150);
		    	
	    	stackpane.getChildren().addAll(vbox);
	    	
	    	primaryStage.setScene(scene);
	    	primaryStage.show();
	    	primaryStage.setTitle("Online poistenie vozidla");
	    	
	    	
/****************************************************************************User****************************************************************************/
    	Label ulabel = new Label("OsobnÈ ˙daje");
    	ulabel.setFont(Font.font("", FontWeight.BOLD, 20));  	
	    textfield (meno, 150, "Meno + priezvisko");   	
	    textfield (psc, 150, "PS»");	    
	    textfield (mesto, 150, "Mesto");    
	    textfield (ulica, 150, "Ulica");    
	    textfield (cislodomu, 150, "»Ìslo domu");    
	    textfield (pocetsu, 150, "PoËet ökodov˝ch udalostÌ");
	    
	    HBox hmeno = new HBox();
    	HBox(hmeno);
    	Label labelhmeno = new Label ("Meno + priezvisko");
    	hmeno.getChildren().addAll(labelhmeno, meno);
    	hmeno.setPadding(new Insets(0, 175, 0, 0));
    	
    	HBox hdatumnarodenia = new HBox();
    	HBox(hdatumnarodenia);
    	Label labelhdatumnarodenia = new Label ("D·tum narodenia");
    	hdatumnarodenia.getChildren().addAll(labelhdatumnarodenia, datumnarodenia);
    	hdatumnarodenia.setPadding(new Insets(0, 175, 0, 0));
    	datumnarodenia.setMaxWidth(150);

    	HBox hpsc = new HBox();
    	HBox(hpsc);
    	Label labelhpsc = new Label ("PS»");
    	hpsc.getChildren().addAll(labelhpsc, psc);
    	hpsc.setPadding(new Insets(0, 175, 0, 0));
    	
    	HBox hmesto = new HBox();
    	HBox(hmesto);
    	Label labelhmesto = new Label ("Mesto");
    	hmesto.getChildren().addAll(labelhmesto, mesto);
    	hmesto.setPadding(new Insets(0, 175, 0, 0));
    	
    	HBox hulica = new HBox();
    	HBox(hulica);
    	Label labelhulica = new Label ("Ulica");
    	hulica.getChildren().addAll(labelhulica, ulica);
    	hulica.setPadding(new Insets(0, 175, 0, 0));
	    
    	HBox hcislodomu = new HBox();
    	HBox(hcislodomu);
    	Label labelhcislodomu = new Label ("»Ìslo domu");
    	hcislodomu.getChildren().addAll(labelhcislodomu, cislodomu);
    	hcislodomu.setPadding(new Insets(0, 175, 0, 0));
    	
    	HBox hpocetsu = new HBox();
    	HBox(hpocetsu);
    	Label labelhpocetsu = new Label ("PoËet ökodov˝ch udalostÌ");
    	hpocetsu.getChildren().addAll(labelhpocetsu, pocetsu);
    	hpocetsu.setPadding(new Insets(0, 175, 0, 0));
    	
    	kraj.setMaxWidth(150);
	    kraj.setValue("Kraj");
	    kraj.getItems().addAll(
    		"Bratislavsk˝",
    		"Trnavsk˝",
    		"TrenËiansky",
    		"Nitriansky",
    		"éilinsk˝",
    		"Banskobystrick˝",
    		"Preöovsk˝",
    		"Koöick˝"
        );

	    buttondalejou.setOnAction(e -> {
	    	cpoistenia = new CenaPoistenia(1);
	    	address = new Address(psc.getText(), mesto.getText(), ulica.getText(), cislodomu.getText());
	    	pouzivatel = new User(cpoistenia, meno.getText(), datumnarodenia.getValue(), kraj.getValue().toString(), address, pocetsu.getText());
	    	if(pouzivatel.isempty()) emessage.send();
	    	else try {
			    if(pouzivatel.returnvek() < 18) // vlastn· podmienka na kontrolu veku
			        throw new Exception();
			    else
			    	pouzivatel.ulozudaje();
	            	users.add(pouzivatel);
	            	primaryStage.setScene(bonus);
			}
			catch (Exception ex) {                
				JOptionPane.showMessageDialog(null, "Osoba nie je dospel·","Chyba",JOptionPane.INFORMATION_MESSAGE);
			}

    		kategoriapoistenia.setValue("Poistenie do v˝öky");
    	});
	    
	    VBox uvbox = new VBox();
    	VBox (uvbox);
    	uvbox.getChildren().addAll(ulabel, hmeno, hdatumnarodenia, kraj, hpsc, hmesto, hulica, hcislodomu, hpocetsu, buttondalejou, buttonspatou);
    	stackpaneuser.getChildren().add(uvbox);

/*************************************************************************Admin*************************************************************************/
    	buttonadmin.setOnAction(e -> primaryStage.setScene(sceneadmin));
        textfield (ameno, 150, "Meno");
    	textfield (aheslo, 150, "Heslo");
    	VBox(adminvbox);
    	VBox(adminvbox2);
    	textfield (vymazcislozaznamu, 150, "Vymaû ËÌslo z·znamu");
    	TextField spracujspz = new TextField();
    	textfield (spracujspz, 150, "E»V na spracovanie");
    	Text sprava = new Text();
    	sprava.setText("");
    	
    	
    	logout.setOnAction(e -> {
    		vymazcislozaznamu.clear();
    		primaryStage.setScene(scene);
    	});
    	
    	adminvbox2.getChildren().addAll(vypisvsetkyzaznamy, vymazvsetkyzaznamy, vymazcislozaznamu, vymazcislo, spracujspz, potvrdzaznam, nepotvrdzaznam, message, sprava, logout);
    	stackpaneadmin2.getChildren().addAll(adminvbox2);
    	adminvbox.getChildren().addAll(ameno, aheslo, buttondalejadmin, buttonspatadmin);
    	stackpaneadmin.getChildren().addAll(adminvbox);
    	buttondalejadmin.setOnAction(e -> {
    		sprava.setText("");
    		admin = new Admin(ameno.getText(), aheslo.getText());
    		if(admin.skontrolujudaje() == false) JOptionPane.showMessageDialog(null, "NeplatnÈ ˙daje.","Chyba",JOptionPane.INFORMATION_MESSAGE);
    		else primaryStage.setScene(sceneadmin2);
    		ameno.clear();
    		aheslo.clear();
    		pzaznam = new PoistnyZaznam();
    		message.setText("");
    	});
    	
    	potvrdzaznam.setOnAction(e -> {
    		pzaznam = new PoistnyZaznam();
    		pzaznam.spracujzaznam(spracujspz.getText(), 1, sprava);
    		spracujspz.clear();
    	});
    	
    	nepotvrdzaznam.setOnAction(e -> {
    		pzaznam = new PoistnyZaznam();
    		pzaznam.spracujzaznam(spracujspz.getText(), 0, sprava);
    		spracujspz.clear();
    	});
    	
    	buttonspatadmin.setOnAction(e -> primaryStage.setScene(scene));
    	
    	vypisvsetkyzaznamy.setOnAction(new EventHandler<ActionEvent>() {
	         public void handle(ActionEvent event) {
	        	int f = pzaznam.pocetzaznamov("FinalnePoistenie.txt");
	        	if(f == 0){
	            	message.setText("Neexistuj˙ ûiadne ˙daje.");
	                message.setTextFill(Color.RED);
	            }
	        	else {
		            StackPane stackpanezaznamy = new StackPane();
		            Scene scenezaznamy = new Scene(stackpanezaznamy, 600, 800);
		            Stage newWindow = new Stage();
		            newWindow.setTitle("Z·znamy");
		            newWindow.setScene(scenezaznamy);
		            newWindow.initModality(Modality.WINDOW_MODAL);
		            newWindow.initOwner(primaryStage);
		            newWindow.setMaximized(true);
		            newWindow.show();
	            
		            ArrayList<String>poistenia= new ArrayList<String>();
		            poistenia.removeAll(poistenia); 
		            textArea.setText("");
	        		pzaznam.ulozudajedolistu(textArea, poistenia);
	        		stackpanezaznamy.getChildren().add(textArea);
	        		textArea.setPrefSize( Double.MAX_VALUE, Double.MAX_VALUE );
	        		textArea.setEditable(false);
	        		textArea.setFocusTraversable(false);
	        		textArea.positionCaret( 0 );
	        	}
	         }
      });
    	
    	vymazvsetkyzaznamy.setOnAction(e-> {
	    	pzaznam.vypiskpz(message);
    	});

    	vymazcislo.setOnAction(e-> {
    		pzaznam.setvymazcislozaznamu(vymazcislozaznamu.getText());
    		pzaznam.pzaznamvypis(message);
    		vymazcislozaznamu.clear();
    	});
    	
/*************************************************************************OsobnÈ auto*************************************************************************/
    	alabel.setFont(Font.font("", FontWeight.BOLD, 20));
	    textfield (aecv, 150, "EvidenËnÈ ËÌslo vozidla");
	    textfield (aznacka, 150, "Znacka automobilu");
    	textfield (amodel, 150, "Model automobilu");	
    	textfield (aobjemvalcov, 150, "Zdvihov˝ objem valcov");
    	textfield (avykon, 150, "V˝kon motora v kW");
	    textfield (arok, 150, "Rok v˝roby");
	    
        nastavButton (buttonadalej);
        nastavButton (buttonaspat);
        
       	HBox haecv = new HBox();
    	HBox(haecv);
    	Label labelhaecv = new Label ("EvidenËnÈ ËÌslo vozidla");
    	haecv.getChildren().addAll(labelhaecv, aecv);
    	haecv.setPadding(new Insets(0, 175, 0, 0));
    	
    	HBox haznacka = new HBox();
    	HBox(haznacka);
    	Label labelhaznacka = new Label ("ZnaËka");
    	haznacka.getChildren().addAll(labelhaznacka, aznacka);
    	haznacka.setPadding(new Insets(0, 175, 0, 0));
    	
    	HBox hamodel = new HBox();
    	HBox(hamodel);
    	Label labelhamodel = new Label ("Model");
    	hamodel.getChildren().addAll(labelhamodel, amodel);
    	hamodel.setPadding(new Insets(0, 175, 0, 0));
    	
    	HBox harok = new HBox();
    	HBox(harok);
    	Label labelharok = new Label ("Rok v˝roby");
    	harok.getChildren().addAll(labelharok, arok);
    	harok.setPadding(new Insets(0, 175, 0, 0));
    	
    	HBox havykon = new HBox();
    	HBox(havykon);
    	Label labelhavykon = new Label ("V˝kon motora v kW");
    	havykon.getChildren().addAll(labelhavykon, avykon);
    	havykon.setPadding(new Insets(0, 175, 0, 0));
    	
    	HBox haobjemvalcov = new HBox();
    	HBox(haobjemvalcov);
    	Label labelhaobjemvalcov = new Label ("Zdvihov˝ objem valcov");
    	haobjemvalcov.getChildren().addAll(labelhaobjemvalcov, aobjemvalcov);
    	haobjemvalcov.setPadding(new Insets(0, 175, 0, 0));
        
	    adruhpaliva.setMaxWidth(150);
	    adruhpaliva.getItems().addAll(
    		"BenzÌn",
    		"Diesel",
    		"Elektro",
    		"Hybrid",
    		"BenzÌn + LPG"
        );
	    
	    aprevodovka.setMaxWidth(150);
	    aprevodovka.getItems().addAll(
    		"Manu·lna",
    		"Automatick·"
        );
	    
	    apohon.setMaxWidth(150);
	    apohon.getItems().addAll(
    		"Predn˝",
    		"Zadn˝",
    		"AWD",
    		"4WD"
        );

    	VBox avbox = new VBox();
    	VBox (avbox);
    	avbox.getChildren().addAll(alabel, haecv, haznacka, hamodel, harok, apohon, adruhpaliva, aprevodovka, havykon, haobjemvalcov, buttonadalej, buttonaspat);
    	stackpaneautomobil.getChildren().add(avbox);
    	
    	buttonadalej.setOnAction(e -> {
    		ClassECV cecv = new ClassECV(aecv.getText());
    		vozidlo = new Vozidlo(new CenaPoistenia(50), cecv, aznacka.getText(), amodel.getText(), arok.getText(), aprevodovka.getValue().toString(), adruhpaliva.getValue().toString(), aobjemvalcov.getText());
    		osobnea = new OsobneAuto(vozidlo.getcena(), vozidlo.getcecv(), vozidlo.getznacka(), vozidlo.getmodel(), vozidlo.getrokvyroby(), apohon.getValue().toString(), vozidlo.getprevodovka(), vozidlo.getdruhpaliva(), avykon.getText(), vozidlo.getobjemvalcov());

			if(osobnea.isempty()) emessage.send();
    		else if(!osobnea.returnecv().returnecvv().equals("")) {
    			if (osobnea.skontrolujudaje() == true) JOptionPane.showMessageDialog(null, "Poistenie pre danÈ vozidlo uû existuje.","Chyba",JOptionPane.INFORMATION_MESSAGE);
    			else if(osobnea.skontrolujudaje() == false) {
    	    		osobnea.ulozudaje();
    	    		primaryStage.setScene(user);
    	    	}
    		}
    	});
    	
    	buttonaspat.setOnAction(e -> primaryStage.setScene(scenepv));

/****************************************************************************Motocykel****************************************************************************/
    	mlabel.setFont(Font.font("", FontWeight.BOLD, 20));
	    textfield (mecv, 150, "EvidenËnÈ ËÌslo vozidla");
	    textfield (mznacka, 150, "Znacka");
    	textfield (mmodel, 150, "Model");
    	textfield (mobjemvalcov, 150, "Zdvihov˝ objem valcov");
    	textfield (mvykon, 150, "V˝kon motora v kW");
	    textfield (mrok, 150, "Rok v˝roby");
	    nastavButton (buttonmdalej);
	    nastavButton (buttonmspat);
	    
	    mdruhpaliva.setMaxWidth(150);
	    mdruhpaliva.getItems().addAll(
    		"BenzÌn",
    		"Diesel",
    		"Elektro",
    		"Hybrid"
        );
	    
	    mprevodovka.setMaxWidth(150);
	    mprevodovka.getItems().addAll(
    		"Manu·lna",
    		"Automatick·"
        );
	    
    	HBox hmecv = new HBox();
    	HBox(hmecv);
    	Label labelhmecv = new Label ("EvidenËnÈ ËÌslo vozidla");
    	hmecv.getChildren().addAll(labelhmecv, mecv);
    	hmecv.setPadding(new Insets(0, 175, 0, 0));
    	
    	HBox hmznacka = new HBox();
    	HBox(hmznacka);
    	Label labelhmznacka = new Label ("ZnaËka motocyklu");
    	hmznacka.getChildren().addAll(labelhmznacka, mznacka);
    	hmznacka.setPadding(new Insets(0, 175, 0, 0));
    	
    	HBox hmmodel = new HBox();
    	HBox(hmmodel);
    	Label labelhmodel = new Label ("Model motocyklu");
    	hmmodel.getChildren().addAll(labelhmodel, mmodel);
    	hmmodel.setPadding(new Insets(0, 175, 0, 0));
    	
    	HBox hmrok = new HBox();
    	HBox(hmrok);
    	Label labelhmrok = new Label ("Rok v˝roby");
    	hmrok.getChildren().addAll(labelhmrok, mrok);
    	hmrok.setPadding(new Insets(0, 175, 0, 0));
    	
    	HBox hmvykon = new HBox();
    	HBox(hmvykon);
    	Label labelhmvykon = new Label ("V˝kon motora v kW");
    	hmvykon.getChildren().addAll(labelhmvykon, mvykon);
    	hmvykon.setPadding(new Insets(0, 175, 0, 0));
    	
    	HBox hmobjemvalcov = new HBox();
    	HBox(hmobjemvalcov);
    	Label labelhmobjemvalcov = new Label ("Zdvihov˝ objem valcov");
    	hmobjemvalcov.getChildren().addAll(labelhmobjemvalcov, mobjemvalcov);
    	hmobjemvalcov.setPadding(new Insets(0, 175, 0, 0));
	    
    	VBox mvbox = new VBox();
    	stackpanemotocykel.getChildren().add(mvbox);
    	VBox(mvbox);
    	
    	mvbox.getChildren().addAll(mlabel, hmecv, hmznacka, hmmodel, hmrok, mdruhpaliva, mprevodovka, hmvykon, hmobjemvalcov, buttonmdalej, buttonmspat);
    	
    	buttonmdalej.setOnAction(e -> {
    		ClassECV cecv = new ClassECV(mecv.getText());
    		vozidlo = new Vozidlo(new CenaPoistenia(20), cecv, mznacka.getText(), mmodel.getText(), mrok.getText(), mprevodovka.getValue().toString(), mdruhpaliva.getValue().toString(), mobjemvalcov.getText());
    		moto = new Motocykel(vozidlo.getcena(), vozidlo.getcecv(), vozidlo.getznacka(), vozidlo.getmodel(), vozidlo.getrokvyroby(), vozidlo.getprevodovka(), vozidlo.getdruhpaliva(), mvykon.getText(), vozidlo.getobjemvalcov());
    		
    		if(moto.isempty()) emessage.send();  
    		else if(!moto.returnecv().returnecvv().equals("")) {
    			if(moto.skontrolujudaje() == true) JOptionPane.showMessageDialog(null, "Poistenie pre danÈ vozidlo uû existuje.","Chyba",JOptionPane.INFORMATION_MESSAGE);
    			else if(moto.skontrolujudaje() == false) {
    				moto.ulozudaje();
    	    		primaryStage.setScene(user);
    			}
        	}
    	});
    	
buttonmspat.setOnAction(e -> primaryStage.setScene(scenepv));

/*************************************************************************N·kladnÈ auto*************************************************************************/
    	nlabel.setFont(Font.font("", FontWeight.BOLD, 20));
	    textfield (necv, 150, "EvidenËnÈ ËÌslo vozidla");
	    textfield (nznacka, 150, "Znacka automobilu");
    	textfield (nmodel, 150, "Model automobilu");	
        nastavButton (buttonndalej);
        nastavButton (buttonnspat);
    	textfield (nobjemvalcov, 150, "Zdvihov˝ objem valcov");
	    textfield (nrok, 150, "Rok v˝roby");
        
       	HBox hnecv = new HBox();
    	HBox(hnecv);
    	Label labelhnecv = new Label ("EvidenËnÈ ËÌslo vozidla");
    	hnecv.getChildren().addAll(labelhnecv, necv);
    	hnecv.setPadding(new Insets(0, 175, 0, 0));
    	
    	HBox hnznacka = new HBox();
    	HBox(hnznacka);
    	Label labelhnznacka = new Label ("ZnaËka");
    	hnznacka.getChildren().addAll(labelhnznacka, nznacka);
    	hnznacka.setPadding(new Insets(0, 175, 0, 0));
    	
    	HBox hnmodel = new HBox();
    	HBox(hnmodel);
    	Label labelhnmodel = new Label ("Model");
    	hnmodel.getChildren().addAll(labelhnmodel, nmodel);
    	hnmodel.setPadding(new Insets(0, 175, 0, 0));
    	
    	HBox hnrok = new HBox();
    	HBox(hnrok);
    	Label labelhnrok = new Label ("Rok v˝roby");
    	hnrok.getChildren().addAll(labelhnrok, nrok);
    	hnrok.setPadding(new Insets(0, 175, 0, 0));
    	
    	HBox hnobjemvalcov = new HBox();
    	HBox(hnobjemvalcov);
    	Label labelhnobjemvalcov = new Label ("Zdvihov˝ objem valcov");
    	hnobjemvalcov.getChildren().addAll(labelhnobjemvalcov, nobjemvalcov);
    	hnobjemvalcov.setPadding(new Insets(0, 175, 0, 0));
        
	    ndruhpaliva.setMaxWidth(150);
	    ndruhpaliva.getItems().addAll(
    		"BenzÌn",
    		"Diesel",
    		"Elektro",
    		"Hybrid",
    		"BenzÌn + LPG"
        );
	    
	    nhmotnost.setMaxWidth(150);
	    nhmotnost.getItems().addAll(
    		"do 3500kg",
    		"3500 - 12000kg",
    		"nad 12000kg"
        );
	    
	    nprevodovka.setMaxWidth(150);
	    nprevodovka.getItems().addAll(
    		"Manu·lna",
    		"Automatick·"
        );

    	VBox nvbox = new VBox();
    	VBox (nvbox);
    	nvbox.getChildren().addAll(nlabel, hnecv, hnznacka, hnmodel, hnrok, nhmotnost, ndruhpaliva, nprevodovka, hnobjemvalcov, buttonndalej, buttonnspat);
    	stackpanenakladne.getChildren().add(nvbox);
    	
    	buttonndalej.setOnAction(e -> {
    		ClassECV cecv = new ClassECV(necv.getText());
    		vozidlo = new Vozidlo(new CenaPoistenia(80), cecv, nznacka.getText(), nmodel.getText(), nrok.getText(), nprevodovka.getValue().toString(), ndruhpaliva.getValue().toString(), nobjemvalcov.getText());
    		nakladnea = new NakladneAuto(vozidlo.getcena(), vozidlo.getcecv(), vozidlo.getznacka(), vozidlo.getmodel(), vozidlo.getrokvyroby(), nhmotnost.getValue().toString(), vozidlo.getprevodovka(), vozidlo.getdruhpaliva(), vozidlo.getobjemvalcov());
    		
    		if(nakladnea.isempty()) emessage.send();  
    		else if(!nakladnea.returnecv().returnecvv().equals("")) {
    			if(nakladnea.skontrolujudaje() == true) JOptionPane.showMessageDialog(null, "Poistenie pre danÈ vozidlo uû existuje.","Chyba",JOptionPane.INFORMATION_MESSAGE);
    			else if(nakladnea.skontrolujudaje() == false) {
    				nakladnea.ulozudaje();
    				primaryStage.setScene(user);
    			}
    		}
    	});
    	buttonnspat.setOnAction(e -> primaryStage.setScene(scenepv));
    	
//////////////////////////////////////////////////////////////////////////////////////
    	nastavButton(dalejvypocitaj);
    	nastavButton(spatvypocitaj);
    	nastavButton(potvrd);
    	nastavButton(hlavnemenu);
    	
    	VBox bvbox = new VBox();
    	VBox (bvbox);
    	Label plabel = new Label ("Poistenie do v˝öky:");
    	plabel.setFont(Font.font("", FontWeight.BOLD, 18));
    	Label blabel = new Label ("BonusovÈ poistenie\nvoËi:");
    	blabel.setFont(Font.font("", FontWeight.BOLD, 15));
    	CheckBox checkbox1 = new CheckBox("éiveln· pohroma");
    	CheckBox checkbox2 = new CheckBox("Stret so zverou");
    	CheckBox checkbox3 = new CheckBox("Ukradnutie vozidla");
    	CheckBox checkbox4 = new CheckBox("Vandalizmus");
    	
    	kategoriapoistenia.setMaxWidth(150);
    	kategoriapoistenia.setValue("Poistenie do v˝öky");
	    kategoriapoistenia.getItems().addAll(
    		"1 milÛna Ä",
    		"3 miliÛnov Ä",
    		"5 miliÛnov Ä"
        );

	    Text ta = new Text();
	    Text ta2 = new Text();
	    Text ta3 = new Text();
	    Text ukazcenu = new Text();
	    
    	bvbox.getChildren().addAll(plabel, kategoriapoistenia, blabel, checkbox1, checkbox2, checkbox3, checkbox4, buttondalejbonus, buttonspatbonus);
    	stackpanebonus.getChildren().addAll(bvbox);

    	dalejvypocitaj.setOnAction(e -> {
    		ukazcenu.setText(String.valueOf(cpoistenia.returncena())+"Ä roËne");
    	});
    	spatvypocitaj.setOnAction(e -> {
			primaryStage.setScene(bonus);
    	});
    	
    	buttondalejbonus.setOnAction(e -> {
    		cpoistenia = new CenaPoistenia(1);
    		bonuspoi = new BonusovePoistenie(cpoistenia, kategoriapoistenia.getValue().toString(), checkbox1.isSelected(), checkbox2.isSelected(), checkbox3.isSelected(), checkbox4.isSelected());

    		if(bonuspoi.returnvyska().equals("Poistenie do v˝öky")) emessage.send();  
        	else {
        		
        		cpoistenia = new CenaPoistenia(pouzivatel, classkv, osobnea, moto, nakladnea, bonuspoi);
        				
        		bonuspoi.ulozudaje();
        		        		
        		pouzivatel.precitajudaje(ta);
        		
        		if(classkv.returnkategoriavozidla() == "OsobnÈ auto") osobnea.precitajudaje(ta2);
        		else if(classkv.returnkategoriavozidla() == "N·kladnÈ auto") nakladnea.precitajudaje(ta2);
        		else if(classkv.returnkategoriavozidla() == "Motocykel") moto.precitajudaje(ta2);
    			
        		bonuspoi.precitajudaje(ta3);
        		primaryStage.setScene(potvrdenie);
        	}
    	});
 
    	buttonspatbonus.setOnAction(e -> {
			primaryStage.setScene(user);
    	});
    	
    	Label labeludaje = new Label("OsobnÈ ˙daje");
    	labeludaje.setFont(Font.font("", FontWeight.BOLD, 18));
    	Label labeludajevozidlo = new Label("⁄daje o vozidle");
    	labeludajevozidlo.setFont(Font.font("", FontWeight.BOLD, 18));
    	Label labelbpoistenie = new Label("V˝öka poistenia + bonusovÈ poistenie");
    	labelbpoistenie.setFont(Font.font("", FontWeight.BOLD, 18));
    	VBox pvbox = new VBox();
    	VBox (pvbox);
    	pvbox.getChildren().addAll(labeludaje,ta,labeludajevozidlo,ta2,labelbpoistenie,ta3,ukazcenu,dalejvypocitaj,potvrd,spatvypocitaj);
    	stackpanepotvrdenie.getChildren().add(pvbox);
    	
    	Text potvrdene = new Text("Poistenie bolo vytvorenÈ");
    	VBox pvbox2 = new VBox();
    	VBox (pvbox2);
    	pvbox2.getChildren().addAll(potvrdene, hlavnemenu);
    
    	potvrd.setOnAction(e -> {
    		primaryStage.setScene(kalkulacia);
    		
    		try {
				pouzivatel.zapisdofinalnehosuboru();
				if(classkv.returnkategoriavozidla().equals("OsobnÈ auto")) osobnea.zapisdofinalnehosuboru();
				else if(classkv.returnkategoriavozidla().equals("N·kladnÈ auto")) nakladnea.zapisdofinalnehosuboru();
				else if(classkv.returnkategoriavozidla().equals("Motocykel")) moto.zapisdofinalnehosuboru();
	    		bonuspoi.zapisdofinalnehosuboru();
				} 
    		catch (IOException ex) {
				ex.printStackTrace();
			}
    	});
    	
    	hlavnemenu.setOnAction(e -> primaryStage.setScene(scene));
    	stackpanekalkulacia.getChildren().add(pvbox2);

    	buttonspatou.setOnAction(e -> {
    		if(classkv.returnkategoriavozidla().equals("Motocykel")) {
    			primaryStage.setScene(motocykel);
    		}
    		else if(classkv.returnkategoriavozidla().equals("OsobnÈ auto")) {
    			primaryStage.setScene(automobil);
    		}
    		else if(classkv.returnkategoriavozidla().equals("N·kladnÈ auto")) {
    			primaryStage.setScene(nakladne);
    		}
		});
    }
}