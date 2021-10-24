package enums;

public enum TaskType {
    FEATURE("Feature"),
    BUG("Bug"),
    STORY("Story"),
    SUBTASK("Sub Task");

    private String displayName;

    TaskType(String displayName){
        this.displayName=displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
