
/**
 * PediatricPatient Class
 * Represents a specialized type of patient with age-based care and parental contact details.
 */
import java.util.ArrayList;
import java.util.List;

public class PediatricPatient extends PatientBase {
    private String parentalContact;
    private int ageLimit;
    private static int pediatricPatientCount = 0;
    private static List<PediatricPatient> pediatricPatientCatalog = new ArrayList<>();

    // Constructor
    public PediatricPatient(String patientId, String patientCategory, int age, List<String> medicalHistory, Doctor assignedDoctor, String currentDepartment, String treatmentStatus, String parentalContact) {
        super(patientId, patientCategory, age, medicalHistory, assignedDoctor, currentDepartment, treatmentStatus);
        this.parentalContact = parentalContact;
        this.ageLimit = ageLimit;
        pediatricPatientCount++;
        pediatricPatientCatalog.add(this);
    }

    // Getter for parentalContact
    public String getParentalContact() {
        return parentalContact;
    }

    // Setter for parentalContact
    public void setParentalContact(String parentalContact) {
        this.parentalContact = parentalContact;
    }

    // Getter for ageLimit
    public int getAgeLimit() {
        return ageLimit;
    }

    // Checks if the patient is within the age limit
    public boolean isWithinAgeLimit() {
        return getAge() <= ageLimit;
    }

    @Override
    public double calculateTreatmentCost() {
        // Sample calculation for demonstration
        return 1500.0; // Base cost for pediatric patients
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Parental Contact: " + parentalContact);
        System.out.println("Age Limit: " + ageLimit);
        System.out.println("Within Age Limit: " + isWithinAgeLimit());
    }

    public static int getPediatricPatientCount() {
        return pediatricPatientCount;
    }

    public static void decrementPediatricPatientCount() {
        pediatricPatientCount--;
    }

    public static List<PediatricPatient> getPediatricPatientCatalog() {
        return new ArrayList<>(pediatricPatientCatalog);
    }
}
