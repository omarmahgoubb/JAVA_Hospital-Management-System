
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String doctorId;
    private String name;
    private String specialization;
    private String contactDetails;
    private LocalDate employmentDate;
    private List<PatientBase> assignedPatients;

    // Constructor to initialize essential attributes
    public Doctor(String doctorId, String name, String specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.assignedPatients = new ArrayList<>();
    }

    // Overloaded constructor to initialize all attributes
    public Doctor(String doctorId, String name, String specialization, String contactDetails, LocalDate employmentDate) {
        this(doctorId, name, specialization);
        this.contactDetails = contactDetails;
        this.employmentDate = employmentDate;
    }

    // Getters and Setters
    public String getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public List<PatientBase> getAssignedPatients() {
        return assignedPatients;
    }

    // Add a patient to the doctor's assigned list
    public void addAssignedPatient(PatientBase patient) {
        assignedPatients.add(patient);
    }

    // Check if the doctor is eligible for surgery based on years of experience
    public boolean isEligibleForSurgery(int experienceThreshold) {
        if (employmentDate == null) {
            return false;
        }
        return LocalDate.now().getYear() - employmentDate.getYear() >= experienceThreshold;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId='" + doctorId + '\'' +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", contactDetails='" + contactDetails + '\'' +
                ", employmentDate=" + employmentDate +
                '}';
    }
}
