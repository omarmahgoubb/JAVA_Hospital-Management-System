import java.util.List;

public class PediatricPatient extends PatientBase {
    private String parentalContact;
    private int ageLimit;

    // Constructor
    public PediatricPatient(String patientId, String patientCategory, int age, List<String> medicalHistory, Doctor assignedDoctor, String currentDepartment, String treatmentStatus, String parentalContact, int ageLimit) {
        super(patientId, patientCategory, age, medicalHistory, assignedDoctor, currentDepartment, treatmentStatus);
        this.parentalContact = parentalContact;
        this.ageLimit = ageLimit;
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
}