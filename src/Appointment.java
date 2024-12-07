import java.time.LocalDate;

public class Appointment {
    private String appointmentId;
    private PatientBase patient;
    private Doctor doctor;
    private LocalDate appointmentDate;

    // Constructor to initialize all attributes
    public Appointment(String appointmentId, PatientBase patient, Doctor doctor, LocalDate appointmentDate) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
    }

    // Getters and Setters
    public String getAppointmentId() {
        return appointmentId;
    }

    public PatientBase getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", patient=" + (patient != null ? patient.getPatientId() : "None") +
                ", doctor=" + (doctor != null ? doctor.getDoctorId() : "None") +
                ", appointmentDate=" + appointmentDate +
                '}';
    }
}
