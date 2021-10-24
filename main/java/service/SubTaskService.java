package service;

import models.Story;
import models.Subtask;

public interface SubTaskService {
    Subtask createSubTask(String title, Story linkedStory);
    Subtask changeLinkedStoryForSubTask(Subtask subTask, Story linkedStory);
}
