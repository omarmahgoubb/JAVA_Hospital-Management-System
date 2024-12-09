import java.util.ArrayList;
import java.util.List;


public class PatientCategory
{
    private String categoryId;
    private String categoryName;
    private int ageLimit;
    private boolean isSpecialCareRequired;
    private Doctor recentDoctor;
    private List<String> commonMedicalConditions;

    // Constructor
    public PatientCategory(String categoryId, String categoryName, int ageLimit, boolean isSpecialCareRequired)
    {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.ageLimit = ageLimit;
        this.isSpecialCareRequired = isSpecialCareRequired;
        this.commonMedicalConditions = new ArrayList<>();
    }

    // Getter for categoryId
    public String getCategoryId()
    {
        return categoryId;
    }

    // Getter for categoryName
    public String getCategoryName()
    {
        return categoryName;
    }

    // Getter for ageLimit
    public int getAgeLimit()
    {
        return ageLimit;
    }

    // Getter for isSpecialCareRequired
    public boolean getCareRequirement()
    {
        return isSpecialCareRequired;
    }

    // Adds a new medical condition to the list
    public void addMedicalCondition(String condition)
    {
        commonMedicalConditions.add(condition);
    }

    // Checks if specialized care is required
    public boolean requiresSpecializedCare()
    {
        return isSpecialCareRequired;
    }

    // Sets the most recent doctor assigned to this category
    public void setRecentDoctor(Doctor doctor)
    {
        this.recentDoctor = doctor;
    }

    // Checks if a patient's age is appropriate for this category
    public boolean isAgeAppropriate(int age)
    {
        return age <= ageLimit;
    }

    @Override
    public String toString()
    {
        return "Category ID: " + categoryId +
                "\nCategory Name: " + categoryName +
                "\nAge Limit: " + ageLimit +
                "\nSpecial Care Required: " + isSpecialCareRequired +
                "\nRecent Doctor: " + (recentDoctor != null ? recentDoctor.getName() : "None") +
                "\nCommon Medical Conditions: " + commonMedicalConditions;
    }
}
