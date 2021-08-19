package VozidloUdaje;

import Others.Sprava;

// TODO: Auto-generated Javadoc
// interface pre lambda v�raz
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
	// pou�itie lambda  v�razu
	xecv spz=()->{  
        return ecv;
    };  
	
	/**
	 * Returnecvv.
	 * vracia hodnotu typu String s pou�it�m lambda v�razu
	 * funkcia return the string
	 *
	 * @return the string
	 */
	public String returnecvv() {
		return spz.recv();
	}
    
   /**
    * Send message.
    * met�da pou�it� na n�vrhov� vzor Mediator
    * @param message the message
    */
   public void sendMessage(String message){
	   Sprava.showMessage(this,message);
   }
}