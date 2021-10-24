package service;

import models.Sprint;
import models.User;

public interface DisplayService {
    void displayTasksForUser(User user);
    void displaySprintSnapShot(Sprint sprint);
}
