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
                    addPatientMenu(hospitalManagement, scanner);
                    break;

                case 2:
                    System.out.print("Enter Patient ID to remove: ");
                    String removeId = scanner.nextLine();
                    hospitalManagement.removePatient(removeId);
                    break;

                case 3:
                    addDoctorMenu(hospitalManagement, scanner);
                    break;

                case 4:
                    System.out.print("Enter Patient ID: ");
                    String assignPatientId = scanner.nextLine();
                    System.out.print("Enter Doctor ID: ");
                    String assignDoctorId = scanner.nextLine();
                    hospitalManagement.assignDoctorToPatient(assignPatientId, assignDoctorId);
                    break;

                case 5:
                    scheduleAppointmentMenu(hospitalManagement, scanner);
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

    // Menu for adding a new patient
    private static void addPatientMenu(HospitalManagement hospitalManagement, Scanner scanner) {
        System.out.println("\nChoose Patient Type:");
        System.out.println("1. Surgical");
        System.out.println("2. Pediatric");
        System.out.println("3. Outpatient");
        System.out.print("Enter your choice: ");
        int patientTypeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Current Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Treatment Status: ");
        String status = scanner.nextLine();

        switch (patientTypeChoice) {
            case 1:
                System.out.print("Enter Surgery Type: ");
                String surgeryType = scanner.nextLine();
                System.out.print("Enter Surgery Date (YYYY-MM-DD): ");
                LocalDate surgeryDate = LocalDate.parse(scanner.nextLine());
                System.out.print("Enter Surgeon ID (or leave blank for none): ");
                String surgeonId = scanner.nextLine();
                Doctor surgeon = surgeonId.isEmpty() ? null : hospitalManagement.findDoctorById(surgeonId);
                SurgicalPatient surgicalPatient = new SurgicalPatient(
                        patientId, "Surgical", age, null, null, department, status, surgeryType, surgeryDate, surgeon);
                hospitalManagement.addPatient(surgicalPatient);
                break;

            case 2:
                System.out.print("Enter Parental Contact Information: ");
                String parentalContact = scanner.nextLine();
                PediatricPatient pediatricPatient = new PediatricPatient(
                        patientId, "Pediatric", age, null, null, department, status, parentalContact);
                hospitalManagement.addPatient(pediatricPatient);
                break;

            case 3:
                System.out.print("Enter Appointment Frequency (e.g., Weekly, Monthly): ");
                String frequency = scanner.nextLine();
                System.out.print("Enter Next Appointment Date (YYYY-MM-DD): ");
                LocalDate nextAppointmentDate = LocalDate.parse(scanner.nextLine());
                Outpatient outpatient = new Outpatient(
                        patientId, "Outpatient", age, null, null, department, status, frequency, nextAppointmentDate);
                hospitalManagement.addPatient(outpatient);
                break;

            default:
                System.out.println("Invalid choice for patient type.");
        }
    }


    // Menu for adding a new doctor
    private static void addDoctorMenu(HospitalManagement hospitalManagement, Scanner scanner) {
        System.out.print("Enter Doctor ID: ");
        String doctorId = scanner.nextLine();
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();
        Doctor doctor = new Doctor(doctorId, name, specialization);
        hospitalManagement.addDoctor(doctor);
    }

    // Menu for scheduling an appointment
    private static void scheduleAppointmentMenu(HospitalManagement hospitalManagement, Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();
        System.out.print("Enter Doctor ID: ");
        String doctorId = scanner.nextLine();
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        LocalDate appointmentDate = LocalDate.parse(scanner.nextLine());
        hospitalManagement.scheduleAppointment(patientId, doctorId, appointmentDate);
    }
}
