
/**
 * Outpatient Class
 * Represents a specialized type of patient who visits the hospital for regular follow-ups or appointments.
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Outpatient extends PatientBase {
    private String appointmentFrequency;
    private LocalDate nextAppointmentDate;
    private static int outpatientCount = 0;
    private static List<Outpatient> outpatientCatalog = new ArrayList<>();

    private static double medicationCost = 300.0; // Example medication cost

    // Constructor
    public Outpatient(String patientId, String patientCategory, int age, List<String> medicalHistory, Doctor assignedDoctor, String currentDepartment, String treatmentStatus, String appointmentFrequency, LocalDate nextAppointmentDate) {
        super(patientId, patientCategory, age, medicalHistory, assignedDoctor, currentDepartment, treatmentStatus);
        this.appointmentFrequency = appointmentFrequency;
        this.nextAppointmentDate = nextAppointmentDate;
        outpatientCount++;
        outpatientCatalog.add(this);
    }

    // Getter for appointmentFrequency
    public String getAppointmentFrequency() {
        return appointmentFrequency;
    }

    // Setter for appointmentFrequency
    public void setAppointmentFrequency(String appointmentFrequency) {
        this.appointmentFrequency = appointmentFrequency;
    }

    // Checks if a follow-up is required
    public boolean isFollowUpRequired() {
        return LocalDate.now().isAfter(nextAppointmentDate);
    }

    @Override
    public double calculateTreatmentCost() {
        double baseCost = 200.0; // Base cost for outpatient visits
        return baseCost + medicationCost;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Appointment Frequency: " + appointmentFrequency);
        System.out.println("Next Appointment Date: " + nextAppointmentDate);
    }

    public static int getOutpatientCount() {
        return outpatientCount;
    }

    public static void decrementOutpatientCount() {
        outpatientCount--;
    }

    public static List<Outpatient> getOutpatientCatalog() {
        return new ArrayList<>(outpatientCatalog);
    }

    public static void setMedicationCost(double cost) {
        medicationCost = cost;
    }
}
