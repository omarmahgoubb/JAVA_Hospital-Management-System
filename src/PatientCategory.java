import java.util.ArrayList;
import java.util.List;

public class PatientCategory {
    private String categoryId;
    private String categoryName;
    private int ageLimit;
    private boolean isSpecialCareRequired;
    private Doctor recentDoctor;
    private List<String> commonMedicalConditions;

    // Constructor to initialize all attributes
    public PatientCategory(String categoryId, String categoryName, int ageLimit, boolean isSpecialCareRequired) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.ageLimit = ageLimit;
        this.isSpecialCareRequired = isSpecialCareRequired;
        this.commonMedicalConditions = new ArrayList<>();
    }

    // Getters and Setters
    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public boolean isSpecialCareRequired() {
        return isSpecialCareRequired;
    }

    public Doctor getRecentDoctor() {
        return recentDoctor;
    }

    public void setRecentDoctor(Doctor recentDoctor) {
        this.recentDoctor = recentDoctor;
    }

    public List<String> getCommonMedicalConditions() {
        return commonMedicalConditions;
    }

    public void addMedicalCondition(String condition) {
        commonMedicalConditions.add(condition);
    }

    // Check if a patient's age is appropriate for this category
    public boolean isAgeAppropriate(int age) {
        return age <= ageLimit;
    }

    @Override
    public String toString() {
        return "PatientCategory{" +
                "categoryId='" + categoryId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", ageLimit=" + ageLimit +
                ", isSpecialCareRequired=" + isSpecialCareRequired +
                ", recentDoctor=" + (recentDoctor != null ? recentDoctor.getName() : "None") +
                '}';
    }
}
