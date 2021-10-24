import Dao.Dao;
import Enums.FeatureImpact;
import models.*;
import service.TaskService;
import service.TaskServiceImpl;

import java.sql.Date;
import java.util.List;

public class Driver {
    public static void main(String[] args){
        Dao dao = new Dao();
        TaskService taskService = new TaskServiceImpl(dao);
        User user = new User("Atman");
        User user1 = new User("Atman Slave");
        dao.getUsers().add(user);
        dao.getUsers().add(user1);
        Task t1 = taskService.createFeature("Title 1", user, user1, Date.valueOf("2021-09-10"), null,
                "Some important feature", FeatureImpact.MODERATE);
        dao.printAllTasks();
    }
}
