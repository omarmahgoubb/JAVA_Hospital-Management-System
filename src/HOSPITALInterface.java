
import java.time.LocalDate;
import java.util.List;

public interface HOSPITALInterface {

    // Adds a new patient to the system
    void addPatient(PatientBase patient);

    // Removes a patient from the system using their unique ID
    void removePatient(String patientId);

    // Finds and returns a patient based on their unique ID
    PatientBase findPatientById(String patientId);

    // Adds a new doctor to the system
    void addDoctor(Doctor doctor);

    // Assigns a doctor to a specific patient
    void assignDoctorToPatient(String patientId, String doctorId);

    // Calculates and returns the total bill for a patient
    double calculatePatientBill(String patientId);

    // Lists all patients in the hospital system
    void listAllPatients();

    // Lists all doctors registered in the hospital system
    void listAllDoctors();

    // Schedules an appointment between a patient and a doctor
    void scheduleAppointment(String patientId, String doctorId, LocalDate appointmentDate);

    // Lists all appointments for a specific doctor
    void listAppointmentsByDoctor(String doctorId);
}
