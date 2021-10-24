package Utils;

import Enums.TaskStatus;
import exceptions.IncompleteSubtaskException;
import exceptions.InvalidStoryForSubTaskException;
import models.Story;
import models.Subtask;

public class SubtaskUtils {
    public static void assignOrChangeStoryToSubTask(Subtask subtask, Story story){
        if(TaskStatus.COMPLETED.equals(story.getStatus())){
            throw new InvalidStoryForSubTaskException();
        }
        unlinkStoryIfPresent(subtask);
        subtask.setLinkedStory(story);
        story.getSubtasks().add(subtask);
    }

    public static void checkIfAllSubTasksFinished(Story story){
        for(Subtask subtask : story.getSubtasks()){
            if(!TaskStatus.COMPLETED.equals(subtask.getStatus())){
                throw new IncompleteSubtaskException();
            }
        }
    }

    private static void unlinkStoryIfPresent(Subtask subtask) {
        if(subtask.getLinkedStory() != null){
            subtask.getLinkedStory().getSubtasks().remove(subtask);
            subtask.setLinkedStory(null);
        }
    }
}
