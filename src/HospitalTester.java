/**
 * HospitalTester Class
 * Used to test the functionality of the HospitalManagement system.
 */
import java.time.LocalDate;
import java.util.Arrays;

public class HospitalTester {
    public static void main(String[] args) {
        // Initialize the HospitalManagement system
        HospitalManagement hospitalManagement = new HospitalManagement();

        // Create sample doctors
        Doctor doctor1 = new Doctor("D001", "Dr. Alice Greene", "Cardiology");
        Doctor doctor2 = new Doctor("D002", "Dr. Bob Wilson", "Neurology");
        hospitalManagement.addDoctor(doctor1);
        hospitalManagement.addDoctor(doctor2);

        // Create sample patients
        PatientBase patient1 = new GeneralPatient("P001", "General", 45, Arrays.asList("Flu"), null, "General Medicine", "Ongoing");
        PatientBase patient2 = new GeneralPatient("P002", "General", 35, Arrays.asList("Headache"), null, "Neurology", "Completed");
        hospitalManagement.addPatient(patient1);
        hospitalManagement.addPatient(patient2);

        // Assign doctors to patients
        hospitalManagement.assignDoctorToPatient("P001", "D001");
        hospitalManagement.assignDoctorToPatient("P002", "D002");

        // Schedule appointments
        hospitalManagement.scheduleAppointment("P001", "D001", LocalDate.of(2024, 12, 10));
        hospitalManagement.scheduleAppointment("P002", "D002", LocalDate.of(2024, 12, 11));

        // Calculate patient bills
        System.out.println("Bill for P001: " + hospitalManagement.calculatePatientBill("P001"));
        System.out.println("Bill for P002: " + hospitalManagement.calculatePatientBill("P002"));

        // List all patients
        System.out.println("\nAll Patients:");
        hospitalManagement.listAllPatients();

        // List all doctors
        System.out.println("\nAll Doctors:");
        hospitalManagement.listAllDoctors();

        // List appointments for a specific doctor
        System.out.println("\nAppointments for Doctor D001:");
        hospitalManagement.listAppointmentsByDoctor("D001");

        System.out.println("\nAppointments for Doctor D002:");
        hospitalManagement.listAppointmentsByDoctor("D002");

        // Remove a patient and verify
        hospitalManagement.removePatient("P002");
        System.out.println("\nAll Patients after removal:");
        hospitalManagement.listAllPatients();
    }
}

/**
 * GeneralPatient Class
 * Represents a basic implementation of the PatientBase class for testing.
 */
class GeneralPatient extends PatientBase {
    public GeneralPatient(String patientId, String patientCategory, int age, java.util.List<String> medicalHistory, Doctor assignedDoctor, String currentDepartment, String treatmentStatus) {
        super(patientId, patientCategory, age, medicalHistory, assignedDoctor, currentDepartment, treatmentStatus);
    }

    @Override
    public double calculateTreatmentCost() {
        // Simple cost calculation for demonstration
        return 1000.0;
    }
}
