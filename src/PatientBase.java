import java.util.List;
public abstract class PatientBase
{
    private String patientId;

    private String patientCategory;
    private int age;
    private List<String> medicalHistory;
    private Doctor assignedDoctor;
    private String currentDepartment;
    private String treatmentStatus;

    // Default constructor
    public PatientBase()
    {
        this.patientId = "";
        this.patientCategory = "General";
        this.age = 0;
        this.currentDepartment = "Unknown";
        this.treatmentStatus = "Unknown";
    }
    // Parameterized constructor
    public PatientBase(String patientId, String patientCategory, int age, List<String> medicalHistory,
                       Doctor assignedDoctor, String currentDepartment, String treatmentStatus)
    {
        this.patientId = patientId;
        this.patientCategory = patientCategory;
        this.age = age;
        this.medicalHistory = medicalHistory;
        this.assignedDoctor = assignedDoctor;
        this.currentDepartment = currentDepartment;
        this.treatmentStatus = treatmentStatus;
    }

    // Getters and Setters
    public String getPatientId()
    {
        return patientId;
    }

    public String getPatientCategory()
    {
        return patientCategory;
    }

    public void setPatientCategory(String patientCategory)
    {
        this.patientCategory = patientCategory;
    }

    public int getAge()
    {
        return age;
    }

    public List<String> getMedicalHistory() {
        return medicalHistory;
    }

    public Doctor getAssignedDoctor() {
        return assignedDoctor;
    }

    public void associateDoctor(Doctor doctor) {
        this.assignedDoctor = doctor;
    }

    public String getCurrentDepartment() {
        return currentDepartment;
    }

    public String getTreatmentStatus() {
        return treatmentStatus;
    }

    // Abstract method to calculate treatment cost
    public abstract double calculateTreatmentCost();

    // Display patient details
    public void displayDetails()
    {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Category: " + patientCategory);
        System.out.println("Age: " + age);
        System.out.println("Department: " + currentDepartment);
        System.out.println("Treatment Status: " + treatmentStatus);
        if (assignedDoctor != null)
        {
            System.out.println("Assigned Doctor: " + assignedDoctor.getName());
        } else
        {
            System.out.println("Assigned Doctor: None");
        }
    }

    @Override
    public String toString()
    {
        return "Patient {" +
                "patientId='" + patientId + '\'' +
                ", patientCategory='" + patientCategory + '\'' +
                ", age=" + age +
                ", currentDepartment='" + currentDepartment + '\'' +
                ", treatmentStatus='" + treatmentStatus + '\'' +
                '}';
    }
}
