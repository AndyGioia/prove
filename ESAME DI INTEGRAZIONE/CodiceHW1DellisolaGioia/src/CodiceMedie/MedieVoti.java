package CodiceMedie;

import java.text.DecimalFormat;

class Student {
    String firstName;
    String lastName;
    double averageGrade;
    double lastGrade;

    public Student(String firstName, String lastName, double averageGrade, double lastGrade) {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("Il nome e il cognome dello studente non possono essere nulli.");
        }
        if (Double.isNaN(averageGrade) || Double.isNaN(lastGrade)) {
            throw new IllegalArgumentException("La media dei voti e l'ultimo voto dello studente non possono essere nulli.");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.averageGrade = averageGrade;
        this.lastGrade = lastGrade;
    }

    public boolean nuovaMedia() {
        if (lastGrade >= 18 && lastGrade <= 30) {
            double newAverage = (averageGrade + lastGrade) / 2.0;
            return newAverage >= averageGrade;
        }
        return false;
    }
    
    

    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return firstName + " " + lastName + ": Media " + df.format(averageGrade) + ", Ultimo voto " + lastGrade;
    }
}

public class MedieVoti {
    public static void main(String[] args) {
        String[] firstNames = {
                "MARIO", "LUCA", "MARCO", "GABRIELE", "ANDREA",
                "LETIZIA", "CLAUDIA", "PAOLO", "ENRICO", "VINCENZO"
        };

        String[] lastNames = {
                "ROSSI", "BIANCHI", "TOGNI", "ISOLA", "GIOIA",
                "GUERRA", "GIALLI", "VERDI", "FERMI", "TESTA"
        };

        Student[] students = new Student[10];

        for (int i = 0; i < students.length; i++) {
            double averageGrade = 18 + Math.random() * 12;
            double lastGrade = 18 + Math.random() * 12;
            averageGrade = Math.round(averageGrade * 100.0) / 100.0;
            lastGrade = Math.round(lastGrade * 100.0) / 100.0;
            students[i] = new Student(firstNames[i], lastNames[i], averageGrade, lastGrade);
        }

        for (Student student : students) {
            System.out.println(student);
            System.out.println("Nuova media supera quella precedente? " + student.nuovaMedia());
            System.out.println(); // Empty line for readability
        }
    }
}
