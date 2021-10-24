package Enums;

public enum TaskStatus {
    OPEN("Open"),
    IN_PROGRESS("In Progress"),
    FIXED("Fixed"),
    TESTING("Testing"),
    DEPLOYED("Deployed"),
    COMPLETED("Completed");

    private String displayName;

    TaskStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
