package enums;

public enum FeatureImpact {
    MODERATE("Moderate");

    private String displayName;
    FeatureImpact(String displayName) {
        this.displayName=displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
