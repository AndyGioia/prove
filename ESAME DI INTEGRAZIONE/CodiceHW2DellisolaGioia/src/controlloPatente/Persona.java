package controlloPatente;
import java.util.Random;
import java.util.function.BooleanSupplier;


	
	
	public class Persona {
	    protected int eta;
	    protected boolean haPatente;
	    protected boolean haAssicurazione;

	    public Persona() {
	        Random random = new Random();
	        eta = random.nextInt(62)+ 18; // Genera un'età casuale tra 18 e 79
	        haPatente = random.nextBoolean(); // Genera casualmente true o false per la patente
	        haAssicurazione = random.nextBoolean(); // Genera casualmente true o false per l'assicurazione
	        
	    }

	    public void eseguiTestPatente() {
	        System.out.println("Età: " + eta);
	        System.out.println("Ha la patente: " + haPatente);
	        System.out.println("Ha l'assicurazione: " + haAssicurazione);

	        if (haPatente) {
	            if (haAssicurazione) {
	                System.out.println("Puoi guidare il tuo veicolo, hai la patente e l'assicurazione.");
	            } else {
	                System.out.println("Puoi guidare auto di altri, hai la patente anche se non hai l'assicurazione.");
	            }
	        } else {
	            System.out.println("Non puoi guidare un'auto.");
	        }
	    }

	    public static void main(String[] args) {
	        for (int i = 1; i <= 5; i++) {
	            System.out.println("Persona " + i + ":");
	            Persona persona = new Persona();
	            persona.eseguiTestPatente();
	            System.out.println();
	        }
	    }

		public Object getHaPatente() {
			// TODO Auto-generated method stub
			return haPatente;
		}

		public Object getHaAssicurazione() {
			// TODO Auto-generated method stub
			return haAssicurazione;
		}

		public double getEta() {
			// TODO Auto-generated method stub
			return eta;
		}

		

		

		
	}



