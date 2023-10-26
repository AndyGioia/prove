package personaTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controlloPatente.Persona;

public class PersonaTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    
    public class PersonaConPatenteEAassicurazione extends Persona {
        public PersonaConPatenteEAassicurazione() {
            Random random = new Random();
            eta = random.nextInt(62) + 18;
            haPatente = true;
            haAssicurazione = true;
        }
    }
    
    public class PersonaSoloConPatente extends Persona {
        public PersonaSoloConPatente() {
            Random random = new Random();
            eta = random.nextInt(62) + 18;
            haPatente = true;
            haAssicurazione = false;
        }
    }
    
    public class PersonaSoloConAssicurazione extends Persona {
        public PersonaSoloConAssicurazione() {
            Random random = new Random();
            eta = random.nextInt(62) + 18;
            haPatente = false;
            haAssicurazione = true;
        }
    }
    public class PersonaSenzaPatenteEAssicurazione extends Persona {
        public PersonaSenzaPatenteEAssicurazione() {
            Random random = new Random();
            eta = random.nextInt(62) + 18;
            haPatente = false;
            haAssicurazione = false;
        }
    }
    
    
    
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    
@BeforeEach
    public void setUpStreams1() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams1() {
        System.setOut(originalOut);
    }
    

    @Test
    public void testPersona_Si_Patente_No_Assicurazione() {
    	Persona persona = new PersonaSoloConPatente(); 
        persona.eseguiTestPatente();

        String expectedOutput = "Puoi guidare auto di altri, hai la patente anche se non hai l'assicurazione.";
        assertTrue(outContent.toString().contains(expectedOutput));
       
    }

    @Test
    public void testPersona_No_Patente_Si_Assicurazione() {
    	Persona persona = new PersonaSoloConAssicurazione(); 
        persona.eseguiTestPatente();

        String expectedOutput = "Non puoi guidare un'auto.";
        assertTrue(outContent.toString().contains(expectedOutput));
        
    }

    @Test
    public void testPersona_No_Patente_No_Assicurazione() {
    	Persona persona = new PersonaSenzaPatenteEAssicurazione(); 
        persona.eseguiTestPatente();

        String expectedOutput = "Non puoi guidare un'auto.";
        assertTrue(outContent.toString().contains(expectedOutput));
        
    }
     
    @Test 
    public void testPersona_Si_Patente_Si_Aassicurazione() {
        Persona persona = new PersonaConPatenteEAassicurazione(); 
        persona.eseguiTestPatente();

        String expectedOutput = "Puoi guidare il tuo veicolo, hai la patente e l'assicurazione.";
        assertTrue(outContent.toString().contains(expectedOutput));
    } 
    @Test 
    public void testOutputdelMain() {
        Persona.main(new String[0]); // Chiamo il main

        
        String actualOutput = outContent.toString();
        assertFalse(actualOutput.isEmpty()); // Verifico che l'output non sia vuoto
    }
    
    @Test
    public void testBooleaniNonVuoti() {
        Persona persona = new Persona();

        assertNotNull(persona.getHaPatente());
        assertNotNull(persona.getHaAssicurazione());
    }
    
    @Test
    public void testEtàNonNaN() {
        Persona persona = new Persona();

        double eta = persona.getEta();
        assertFalse(Double.isNaN(eta));
    }
   
    
  }
    
    
    
    
    

