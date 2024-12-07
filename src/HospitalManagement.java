/**
 * Class HospitalManagement
 * Implements the HOSPITALInterface to manage patients, doctors, and appointments.
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HospitalManagement implements HOSPITALInterface {
    private List<PatientBase> patients;
    private List<Doctor> doctors;
    private List<Appointment> appointments;

    // Constructor
    public HospitalManagement() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    @Override
    public void addPatient(PatientBase patient) {
        patients.add(patient);
        System.out.println("Patient added: " + patient.getPatientId());
    }

    @Override
    public void removePatient(String patientId) {
        patients.removeIf(patient -> patient.getPatientId().equals(patientId));
        System.out.println("Patient removed: " + patientId);
    }

    @Override
    public PatientBase findPatientById(String patientId) {
        return patients.stream()
                .filter(patient -> patient.getPatientId().equals(patientId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor added: " + doctor.getDoctorId());
    }

    @Override
    public void assignDoctorToPatient(String patientId, String doctorId) {
        PatientBase patient = findPatientById(patientId);
        Doctor doctor = doctors.stream()
                .filter(d -> d.getDoctorId().equals(doctorId))
                .findFirst()
                .orElse(null);

        if (patient != null && doctor != null) {
            patient.associateDoctor(doctor);
            doctor.addAssignedPatient(patient);
            System.out.println("Doctor " + doctorId + " assigned to patient " + patientId);
        } else {
            System.out.println("Doctor or patient not found.");
        }
    }

    @Override
    public double calculatePatientBill(String patientId) {
        PatientBase patient = findPatientById(patientId);
        if (patient != null) {
            double cost = patient.calculateTreatmentCost();
            System.out.println("Total bill for patient " + patientId + ": " + cost);
            return cost;
        } else {
            System.out.println("Patient not found.");
            return 0;
        }
    }

    @Override
    public void listAllPatients() {
        patients.forEach(patient -> System.out.println(patient));
    }

    @Override
    public void listAllDoctors() {
        doctors.forEach(doctor -> System.out.println(doctor));
    }

    @Override
    public void scheduleAppointment(String patientId, String doctorId, LocalDate appointmentDate) {
        PatientBase patient = findPatientById(patientId);
        Doctor doctor = doctors.stream()
                .filter(d -> d.getDoctorId().equals(doctorId))
                .findFirst()
                .orElse(null);

        if (patient != null && doctor != null) {
            Appointment appointment = new Appointment("A" + (appointments.size() + 1), patient, doctor, appointmentDate);
            appointments.add(appointment);
            System.out.println("Appointment scheduled: " + appointment);
        } else {
            System.out.println("Doctor or patient not found.");
        }
    }

    // Find a doctor by their ID
    public Doctor findDoctorById(String doctorId) {
        return doctors.stream()
                .filter(doctor -> doctor.getDoctorId().equals(doctorId))
                .findFirst()
                .orElse(null);
    }


    @Override
    public void listAppointmentsByDoctor(String doctorId) {
        appointments.stream()
                .filter(appointment -> appointment.getDoctor().getDoctorId().equals(doctorId))
                .forEach(System.out::println);
    }
}
