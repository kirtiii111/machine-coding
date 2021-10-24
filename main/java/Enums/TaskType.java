package Enums;

public enum TaskType {
    FEATURE("Feature"),
    BUG("Bug"),
    SUBTASK("Sub Task"),
    STORY("Story");

    private String displayName;

    TaskType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
