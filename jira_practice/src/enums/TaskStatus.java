package enums;

public enum TaskStatus {
    OPEN("Open"),
    IN_PROGRESS("In_progress"),
    TESTING("testing"),
    FIXED("fixed"),
    COMPLETED("Completed"),
    DEPLOYED("deployed");


    private String displayName;
    TaskStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
