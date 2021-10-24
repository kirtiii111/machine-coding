package service;

import models.*;

public interface SprintService {
    Sprint createSpring(String title);
    void addTaskToSprint(Sprint sprint, Task task);
    void removeTaskToSprint(Sprint sprint, Task task);
}
