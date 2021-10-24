package Enums;

public enum FeatureImpact {
    LOW("Low"),
    MODERATE("Moderate"),
    HIGH("High");

    private String displayName;

    FeatureImpact(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
