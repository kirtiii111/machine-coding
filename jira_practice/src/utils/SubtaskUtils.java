package utils;

import enums.TaskStatus;
import exceptions.IncompleteSubtaskException;
import exceptions.InvalidStoryForSubTaskException;
import models.Story;
import models.SubTask;

public class SubtaskUtils {
    public static void assignOrUpdateStoryWithSubtask(SubTask subTask, Story linkedStory) {
        if(TaskStatus.COMPLETED.equals(linkedStory.getStatus())) {
            throw new InvalidStoryForSubTaskException();
        }
        unlinkStoryIfPresent(subTask);
        subTask.setLinkedStory(linkedStory);
        linkedStory.getSubTasks().add(subTask);
    }

    private static void unlinkStoryIfPresent(SubTask subTask) {
        if (subTask.getLinkedStory() != null) {
            subTask.getLinkedStory().getSubTasks().remove(subTask);
            subTask.setLinkedStory(null);
        }
    }

    public static void checkIfAllSubtasksFinished(Story story) {
        for (SubTask subTask : story.getSubTasks()) {
            if (!TaskStatus.COMPLETED.equals(subTask.getStatus())) {
                throw new IncompleteSubtaskException();
            }
        }
    }
}
