package VozidloUdaje;

import Others.Sprava;

// TODO: Auto-generated Javadoc
// interface pre lambda výraz
interface xecv{  
    public String recv();  
}  

/**
 * The Class ClassECV.
 */
public class ClassECV {
	
	/** The ecv. */
	private String ecv;
	
	/**
	 * Instantiates a new class ECV.
	 *
	 * @param ecv the ecv
	 */
	public ClassECV(String ecv) {
		this.ecv = ecv;
	}
	
	/** The spz. */
	// použitie lambda  výrazu
	xecv spz=()->{  
        return ecv;
    };  
	
	/**
	 * Returnecvv.
	 * vracia hodnotu typu String s použitím lambda výrazu
	 * funkcia return the string
	 *
	 * @return the string
	 */
	public String returnecvv() {
		return spz.recv();
	}
    
   /**
    * Send message.
    * metóda použitá na návrhový vzor Mediator
    * @param message the message
    */
   public void sendMessage(String message){
	   Sprava.showMessage(this,message);
   }
}