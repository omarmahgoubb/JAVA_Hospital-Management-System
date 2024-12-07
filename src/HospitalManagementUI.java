/**
 * HospitalManagementUI Class
 * Provides a command-line interface for the Hospital Management System.
 */
import java.time.LocalDate;
import java.util.Scanner;

public class HospitalManagementUI {
    public static void main(String[] args) {
        HospitalManagement hospitalManagement = new HospitalManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Add a new patient");
            System.out.println("2. Remove a patient");
            System.out.println("3. Add a new doctor");
            System.out.println("4. Assign a doctor to a patient");
            System.out.println("5. Schedule an appointment");
            System.out.println("6. View all patients");
            System.out.println("7. View all doctors");
            System.out.println("8. Calculate and display a patient's bill");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    String patientId = scanner.nextLine();
                    System.out.print("Enter Patient Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter Patient Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Current Department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter Treatment Status: ");
                    String status = scanner.nextLine();
                    PatientBase patient = new GeneralPatient(patientId, category, age, null, null, department, status);
                    hospitalManagement.addPatient(patient);
                    break;

                case 2:
                    System.out.print("Enter Patient ID to remove: ");
                    String removeId = scanner.nextLine();
                    hospitalManagement.removePatient(removeId);
                    break;

                case 3:
                    System.out.print("Enter Doctor ID: ");
                    String doctorId = scanner.nextLine();
                    System.out.print("Enter Doctor Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Specialization: ");
                    String specialization = scanner.nextLine();
                    Doctor doctor = new Doctor(doctorId, name, specialization);
                    hospitalManagement.addDoctor(doctor);
                    break;

                case 4:
                    System.out.print("Enter Patient ID: ");
                    String assignPatientId = scanner.nextLine();
                    System.out.print("Enter Doctor ID: ");
                    String assignDoctorId = scanner.nextLine();
                    hospitalManagement.assignDoctorToPatient(assignPatientId, assignDoctorId);
                    break;

                case 5:
                    System.out.print("Enter Patient ID: ");
                    String appointmentPatientId = scanner.nextLine();
                    System.out.print("Enter Doctor ID: ");
                    String appointmentDoctorId = scanner.nextLine();
                    System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    LocalDate appointmentDate = LocalDate.parse(date);
                    hospitalManagement.scheduleAppointment(appointmentPatientId, appointmentDoctorId, appointmentDate);
                    break;

                case 6:
                    System.out.println("\nAll Patients:");
                    hospitalManagement.listAllPatients();
                    break;

                case 7:
                    System.out.println("\nAll Doctors:");
                    hospitalManagement.listAllDoctors();
                    break;

                case 8:
                    System.out.print("Enter Patient ID: ");
                    String billPatientId = scanner.nextLine();
                    hospitalManagement.calculatePatientBill(billPatientId);
                    break;

                case 9:
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);

        scanner.close();
    }
}
