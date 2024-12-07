/**
 * SurgicalPatient Class
 * Represents a specialized type of patient who requires or has undergone surgery.
 */
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SurgicalPatient extends PatientBase {
    private String surgeryType;
    private LocalDate surgeryDate;
    private Doctor surgeonAssigned;
    private static int surgicalPatientCount = 0;
    private static List<SurgicalPatient> surgicalPatientCatalog = new ArrayList<>();

    private static Map<String, Double> procedureCosts = new HashMap<>();

    static {
        procedureCosts.put("Heart Surgery", 15000.0);
        procedureCosts.put("Knee Replacement", 8000.0);
        procedureCosts.put("Appendectomy", 4000.0);
    }

    // Constructor
    public SurgicalPatient(String patientId, String patientCategory, int age, List<String> medicalHistory, Doctor assignedDoctor, String currentDepartment, String treatmentStatus, String surgeryType, LocalDate surgeryDate, Doctor surgeonAssigned) {
        super(patientId, patientCategory, age, medicalHistory, assignedDoctor, currentDepartment, treatmentStatus);
        this.surgeryType = surgeryType;
        this.surgeryDate = surgeryDate;
        this.surgeonAssigned = surgeonAssigned;
        surgicalPatientCount++;
        surgicalPatientCatalog.add(this);
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
        double baseCost = 5000.0; // Base cost for surgery
        double procedureCost = procedureCosts.getOrDefault(surgeryType, 0.0);
        double medicationCost = 300.0; // Example medication cost
        return baseCost + procedureCost + medicationCost;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Surgery Type: " + surgeryType);
        System.out.println("Surgery Date: " + surgeryDate);
        System.out.println("Surgeon Assigned: " + (surgeonAssigned != null ? surgeonAssigned.getName() : "None"));
    }

    public static int getSurgicalPatientCount() {
        return surgicalPatientCount;
    }

    public static void decrementSurgicalPatientCount() {
        surgicalPatientCount--;
    }

    public static List<SurgicalPatient> getSurgicalPatientCatalog() {
        return new ArrayList<>(surgicalPatientCatalog);
    }

    public static void addProcedureCost(String procedureType, double cost) {
        procedureCosts.put(procedureType, cost);
    }
}