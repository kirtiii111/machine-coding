package Utils;

import Enums.TaskStatus;
import exceptions.InvalidStatusForTaskException;
import models.BaseTask;

public class StatusUtils {
    public static void validateStatus(BaseTask task, TaskStatus status){
        if(!task.getSupportedStatus().contains(status)){
            throw new InvalidStatusForTaskException();
        }
    }
}
