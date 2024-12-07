import java.time.LocalDate;
import java.util.List;

public class SurgicalPatient extends PatientBase {
    private String surgeryType;
    private LocalDate surgeryDate;
    private Doctor surgeonAssigned;

    // Constructor
    public SurgicalPatient(String patientId, String patientCategory, int age, List<String> medicalHistory, Doctor assignedDoctor, String currentDepartment, String treatmentStatus, String surgeryType, LocalDate surgeryDate, Doctor surgeonAssigned) {
        super(patientId, patientCategory, age, medicalHistory, assignedDoctor, currentDepartment, treatmentStatus);
        this.surgeryType = surgeryType;
        this.surgeryDate = surgeryDate;
        this.surgeonAssigned = surgeonAssigned;
    }

    // Getter for surgeryType
    public String getSurgeryType() {
        return surgeryType;
    }

    // Setter for surgeryType
    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }

    // Checks if the surgery is completed
    public boolean isSurgeryCompleted() {
        return LocalDate.now().isAfter(surgeryDate);
    }

    @Override
    public double calculateTreatmentCost() {
        // Sample calculation for demonstration
        return 5000.0; // Base cost for surgery
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Surgery Type: " + surgeryType);
        System.out.println("Surgery Date: " + surgeryDate);
        System.out.println("Surgeon Assigned: " + (surgeonAssigned != null ? surgeonAssigned.getName() : "None"));
    }
}

