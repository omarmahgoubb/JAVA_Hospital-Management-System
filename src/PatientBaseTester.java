import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class PatientBaseTester
{

    public static void main(String[] args)
    {
        // Create a Doctor object using the constructor with all attributes
        Doctor doctor = new Doctor("D001", "Dr.Ahmed", "Surgeon", "01001001001", LocalDate.of(2015, 5, 20));

        // Create a list for medical history
        List<String> medicalHistory = new ArrayList<>();
        medicalHistory.add("Hypertension");
        medicalHistory.add("Diabetes");

        // Create a SurgicalPatient object using the constructor
        SurgicalPatient surgicalPatient = new SurgicalPatient
                ("P1001", "Surgical", 45, medicalHistory, doctor, "Surgery Department",
                "In Treatment", "Heart Surgery", LocalDate.of(2023, 6, 15), doctor
        );

        // Create a PediatricPatient object using the appropriate constructor
        PediatricPatient pediatricPatient = new PediatricPatient
                ("P1002", "Pediatric", 12, medicalHistory, doctor, "Pediatrics Department",
                "Stable", "01234567890"
        );

        // Display details for SurgicalPatient
        System.out.println("Surgical Patient Details:");
        surgicalPatient.displayDetails();
        System.out.println("Treatment Cost: $" + surgicalPatient.calculateTreatmentCost());

        // Display details for PediatricPatient
        System.out.println("\nPediatric Patient Details:");
        pediatricPatient.displayDetails();
        System.out.println("Treatment Cost: $" + pediatricPatient.calculateTreatmentCost());

        // Test isSurgeryCompleted() method for SurgicalPatient
        System.out.println("\nIs the surgery completed for the surgical patient? " + surgicalPatient.isSurgeryCompleted());

        // Test if PediatricPatient is within age limit
        System.out.println("\nIs the pediatric patient within age limit? " + pediatricPatient.isWithinAgeLimit());

        // Test if Doctor is eligible for surgery (experience >= 5 years)
        System.out.println("\nIs the doctor eligible for surgery? " + doctor.isEligibleForSurgery(5));

        // Add another SurgicalPatient for testing
        SurgicalPatient surgicalPatient2 = new SurgicalPatient
                ("P1003", "Surgical", 60, medicalHistory, doctor, "Surgery Department",
                "In Treatment", "Knee Replacement", LocalDate.of(2022, 1, 10), doctor
        );

        // Display the updated SurgicalPatient catalog
        System.out.println("\nUpdated Surgical Patient Catalog:");
        for (SurgicalPatient sp : SurgicalPatient.getSurgicalPatientCatalog())
        {
            sp.displayDetails();
            System.out.println("Treatment Cost:" + sp.calculateTreatmentCost());
            System.out.println("-------");
        }

        // Add another PediatricPatient for testing
        PediatricPatient pediatricPatient2 = new PediatricPatient
                ("P1004", "Pediatric", 17, medicalHistory, doctor, "Pediatrics Department",
                "Stable", "01224567890"
        );

        // Display the updated PediatricPatient catalog
        System.out.println("\nUpdated Pediatric Patient Catalog:");
        for (PediatricPatient pp : PediatricPatient.getPediatricPatientCatalog())
        {
            pp.displayDetails();
            System.out.println("Treatment Cost:" + pp.calculateTreatmentCost());
            System.out.println("-------");
        }
    }
}
