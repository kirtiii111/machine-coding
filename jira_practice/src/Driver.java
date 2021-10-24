import Dao.Dao;
import models.Sprint;
import models.Task;
import models.User;
import service.TaskService;
import service.impl.TaskServiceImpl;

import java.util.Date;

public class Driver {
    public static void main(String[] args) {
         Dao dao = new Dao();
        TaskService taskService = new TaskServiceImpl(dao);

        User creator = new User("Kirti");
        User assignee = new User("Purvisha");

        Sprint sprint = new Sprint("sprint1");
        Task story = taskService.createStory("Story1", creator, assignee, new Date(), sprint, "descriptionOfStory");
        User newAssignee = new User("Ridhesh");
        taskService.printTasks();
        taskService.changeAssigneeOfTask(story, newAssignee);
        taskService.printTasks();
    }
}
