import java.time.LocalDate;
import java.util.Arrays;

public class HospitalTester {

    public static void main(String[] args)
    {
        // Initialize HospitalManagement system
        HospitalManagement hospitalManagement = new HospitalManagement();

        System.out.println("===== Hospital Management System Testing =====\n");

        // Adding Doctors
        Doctor doctor1 = new Doctor("D001", "Dr. Alice Greene", "Cardiology");
        Doctor doctor2 = new Doctor("D002", "Dr. Bob Wilson", "Neurology");
        Doctor doctor3 = new Doctor("D003", "Dr. Charles Lee", "General Surgery");
        Doctor doctor4 = new Doctor("D004", "Dr. Edward Clark", "Pediatrics");

        hospitalManagement.addDoctor(doctor1);
        hospitalManagement.addDoctor(doctor2);
        hospitalManagement.addDoctor(doctor3);
        hospitalManagement.addDoctor(doctor4);

        // Adding Patients
        PatientBase patient1 = new SurgicalPatient("P001", "Surgical", 45, Arrays.asList("Diabetes"), null, "Surgery", "Ongoing", "Heart Surgery", LocalDate.of(2024, 1, 15), doctor3);
        PatientBase patient2 = new PediatricPatient("P002", "Pediatric", 10, Arrays.asList("Asthma"), null, "Pediatrics", "Ongoing", "Parent Name");
        PatientBase patient3 = new SurgicalPatient("P003", "Surgical", 60, Arrays.asList("Hypertension"), null, "Surgery", "Completed", "Knee Replacement", LocalDate.of(2023, 5, 10), doctor3);

        hospitalManagement.addPatient(patient1);
        hospitalManagement.addPatient(patient2);
        hospitalManagement.addPatient(patient3);

        // Assigning Doctors to Patients
        hospitalManagement.assignDoctorToPatient("P002", "D004");
        hospitalManagement.assignDoctorToPatient("P003", "D003");

        // Scheduling Appointments
        hospitalManagement.scheduleAppointment("P001", "D003", LocalDate.of(2024, 1, 20));
        hospitalManagement.scheduleAppointment("P002", "D004", LocalDate.of(2024, 2, 5));

        // Calculating Bills
        System.out.println("\n===== Calculating Bills =====");
        System.out.println("Bill for P001: " + hospitalManagement.calculatePatientBill("P001"));
        System.out.println("Bill for P002: " + hospitalManagement.calculatePatientBill("P002"));

        // Listing Patients and Doctors
        System.out.println("\n===== Listing All Patients =====");
        hospitalManagement.listAllPatients();

        System.out.println("\n===== Listing All Doctors =====");
        hospitalManagement.listAllDoctors();

        // Listing Appointments by Doctor
        System.out.println("\n===== Appointments for Doctor D003 =====");
        hospitalManagement.listAppointmentsByDoctor("D003");

        System.out.println("\n===== Appointments for Doctor D004 =====");
        hospitalManagement.listAppointmentsByDoctor("D004");

        // Finding a Doctor
        System.out.println("\n===== Finding Doctor D002 =====");
        Doctor foundDoctor = hospitalManagement.findDoctorById("D002");
        System.out.println(foundDoctor != null ? "Doctor Found: " + foundDoctor : "Doctor not found.");

        // Removing a Patient
        System.out.println("\n===== Removing Patient P003 =====");
        hospitalManagement.removePatient("P003");  // returns true/false
            System.out.println("Patient P003 removed.");

        System.out.println("\n===== Listing All Patients After Removal =====");
        hospitalManagement.listAllPatients();
    }
}
