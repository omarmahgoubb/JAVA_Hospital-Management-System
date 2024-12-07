import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Doctor Class
 * Represents a doctor who provides treatment to patients in the hospital.
 */
public class Doctor {
    private String doctorId;
    private String name;
    private String specialization;
    private String contactDetails;
    private LocalDate employmentDate;
    private List<PatientBase> assignedPatients;

    // Constructor with basic attributes
    public Doctor(String doctorId, String name, String specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.assignedPatients = new ArrayList<>();
    }

    // Constructor with all attributes
    public Doctor(String doctorId, String name, String specialization, String contactDetails, LocalDate employmentDate) {
        this(doctorId, name, specialization);
        this.contactDetails = contactDetails;
        this.employmentDate = employmentDate;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for doctorId
    public String getDoctorId() {
        return doctorId;
    }

    // Getter for specialization
    public String getSpecialization() {
        return specialization;
    }

    // Getter for contactDetails
    public String getContactDetails() {
        return contactDetails;
    }

    // Setter for contactDetails
    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    // Adds a patient to the list of assigned patients
    public void addAssignedPatient(PatientBase patient) {
        assignedPatients.add(patient);
    }

    // Retrieves the list of assigned patients
    public List<PatientBase> getAssignedPatients() {
        return new ArrayList<>(assignedPatients);
    }

    // Determines if the doctor is eligible to perform surgeries
    public boolean isEligibleForSurgery(int experienceThreshold) {
        if (employmentDate == null) {
            return false;
        }
        int yearsOfExperience = LocalDate.now().getYear() - employmentDate.getYear();
        return yearsOfExperience >= experienceThreshold;
    }

    @Override
    public String toString() {
        return "Doctor ID: " + doctorId +
                ", Name: " + name +
                ", Specialization: " + specialization +
                ", Contact Details: " + (contactDetails != null ? contactDetails : "N/A") +
                ", Assigned Patients: " + assignedPatients.size();
    }
}
