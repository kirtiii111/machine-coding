package models;

import Enums.TaskStatus;
import Enums.TaskType;
import Utils.SubtaskUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Subtask extends BaseTask {

    public static final Set<TaskStatus> SUPPORTED_STATUS_FOR_SUB_TASK = Collections.unmodifiableSet(
            new HashSet<>(Arrays.asList(TaskStatus.OPEN, TaskStatus.IN_PROGRESS, TaskStatus.COMPLETED))
    );

    private Story linkedStory;

    public Subtask(String title) {
        super(title, TaskStatus.OPEN, TaskType.SUBTASK);
        this.linkedStory = null;
    }

    public Story getLinkedStory() {
        return linkedStory;
    }

    public void setLinkedStory(Story linkedStory) {
        SubtaskUtils.assignOrChangeStoryToSubTask(this, linkedStory);
    }

    @Override
    public Set<TaskStatus> getSupportedStatus() {
        return SUPPORTED_STATUS_FOR_SUB_TASK;
    }
}
