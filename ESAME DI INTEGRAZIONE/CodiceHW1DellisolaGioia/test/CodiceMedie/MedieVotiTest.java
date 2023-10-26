package CodiceMedie;
import static org.junit.jupiter.api.Assertions.assertFalse;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
	
public class MedieVotiTest {
	
	    private Student student;

	    @BeforeEach
	    void setUp() {
	        // Inizializza uno studente con dati di esempio
	        student = new Student("Mario", "Rossi", 25.0, 20.0);
	    }	    

    
	    @Test
	    //T1
	    void testNomeNull() {
	        // Verifica che il costruttore sollevi un'eccezione quando il nome è nullo
	        assertThrows(IllegalArgumentException.class, () -> new Student(null, "Rossi", 25.0, 20.0));
	    }

	    @Test
	    //T2
	    void testCognomeNull() {
	        // Verifica che il costruttore sollevi un'eccezione quando il cognome è nullo
	        assertThrows(IllegalArgumentException.class, () -> new Student("Mario", null, 25.0, 20.0));
	    }

	    @Test
	    //T3
	    void testMediaNaN() {
	        // Verifica che il costruttore sollevi un'eccezione quando la media dei voti è NaN
	        assertThrows(IllegalArgumentException.class, () -> new Student("Mario", "Rossi", Double.NaN, 20.0));
	    }

	    @Test
	    //T4
	    void testUltimoVotoNaN() {
	        // Verifica che il costruttore sollevi un'eccezione quando l'ultimo voto è NaN
	        assertThrows(IllegalArgumentException.class, () -> new Student("Mario", "Rossi", 25.0, Double.NaN));
	    }
	    
	    
	    
	    

	    @Test
	    //T5
	    void testNuovaMediaConVotoSuperioreUgualeA30() {
	        // Verifica che il metodo nuovaMedia() restituisca false quando l'ultimo voto è al di sopra del limite superiore (30)
	        student = new Student("Mario", "Rossi", 25.0, 31.0);
	        assertFalse(student.nuovaMedia());
	        
	        // Verifica che il metodo nuovaMedia() restituisca true quando l'ultimo voto è uguale al limite superiore (30)
	        student = new Student("Mario", "Rossi", 25.0, 30.0);
	        assertTrue(student.nuovaMedia());
	    }
	    
	    @Test
	    //T6
	    void testNuovaMediaConVotoInferioreUgualeA18() {
	        // Verifica che il metodo nuovaMedia() restituisca false quando l'ultimo voto è al di sotto del limite inferiore (18)
	        student = new Student("Mario", "Rossi", 25.0, 17.0);
	        assertFalse(student.nuovaMedia());
	        
	        // Verifica che il metodo nuovaMedia() restituisca true quando l'ultimo voto è uguale al limite inferiore (18)
	        student = new Student("Mario", "Rossi", 18.0, 18.0);
	        assertTrue(student.nuovaMedia());
	    }
	    
	    @Test
	    //T7
	    void testNuovaMediaUltimoVotoConsentito() {
	        // Verifica che il metodo nuovaMedia() restituisca false quando l'ultimo voto è nell'intervallo consentito
	        student = new Student("Mario", "Rossi", 25.0, 26.0);
	        assertTrue(student.nuovaMedia());
	    }
	    
	    @Test
	    //T8
	    void testStudentCostruttoreConNomeENaN() {
	        // Verifica che il costruttore gestisca correttamente il caso con nome nullo e valutazioni NaN
	        assertThrows(IllegalArgumentException.class, () -> new Student(null, null, Double.NaN, Double.NaN));
	    }

	    
	    @Test
	    //Test ToString
	    public void testToString() {
	        
	        Student student = new Student("John", "Doe", 90.50, 85.00);   
	        String expected = "John Doe: Media 90,50, Ultimo voto 85.0";
	        assertEquals(expected, student.toString());
	    }
	    
	    @Test
	    void testMedieVotiNoEccezioni() {
	        
	        // MedieVoti non deve sollevare eccezioni
	        assertDoesNotThrow(() -> MedieVoti.main(new String[]{}));
	    }

	    private void assertDoesNotThrow(Runnable runnable) {
	        try {
	            runnable.run();
	        } catch (Exception e) {
	            fail("Expected no exception, but got: " + e.getClass());
	        }
	    }
	    
	    
	}



