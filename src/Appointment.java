import java.time.LocalDate;

public class Appointment
{
    private String appointmentId;
    private PatientBase patient;
    private Doctor doctor;
    private LocalDate appointmentDate;

    // Constructor
    public Appointment(String appointmentId, PatientBase patient, Doctor doctor, LocalDate appointmentDate)
    {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
    }

    // Getter for appointmentId
    public String getAppointmentId()
    {
        return appointmentId;
    }

    // Getter for patient
    public PatientBase getPatient()
    {
        return patient;
    }

    // Getter for doctor
    public Doctor getDoctor()
    {
        return doctor;
    }

    // Getter for appointmentDate
    public LocalDate getAppointmentDate()
    {
        return appointmentDate;
    }

    @Override
    public String toString()
    {
        return "Appointment ID: " + appointmentId +
                "\nPatient: " + (patient != null ? patient.getPatientId() : "None") +
                "\nDoctor: " + (doctor != null ? doctor.getName() : "None") +
                "\nAppointment Date: " + appointmentDate;
    }
}
