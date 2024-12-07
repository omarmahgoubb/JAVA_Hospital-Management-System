
public class TreatmentData {
    private String treatmentId;
    private String treatmentType;
    private double treatmentCost;

    // Constructor
    public TreatmentData(String treatmentId, String treatmentType, double treatmentCost) {
        this.treatmentId = treatmentId;
        this.treatmentType = treatmentType;
        this.treatmentCost = treatmentCost;
    }

    // Getters and Setters
    public String getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(String treatmentId) {
        this.treatmentId = treatmentId;
    }

    public String getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(String treatmentType) {
        this.treatmentType = treatmentType;
    }

    public double getTreatmentCost() {
        return treatmentCost;
    }

    public void setTreatmentCost(double treatmentCost) {
        this.treatmentCost = treatmentCost;
    }

    @Override
    public String toString() {
        return "TreatmentData{" +
                "treatmentId='" + treatmentId + '\'' +
                ", treatmentType='" + treatmentType + '\'' +
                ", treatmentCost=" + treatmentCost +
                '}';
    }
}
