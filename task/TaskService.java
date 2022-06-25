package task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskService {
    private String uniqueID;
    private List<Task> tasks = new ArrayList<>();

    public void newTask(String taskName, String taskDescription) {
        Task task = new Task(newUniqueID(), taskName, taskDescription);
        tasks.add(task);
    }

    public void deleteTask(String id) throws Exception {
        tasks.remove(taskSearch(id));
    }

    public void changeTaskName(String id, String taskName) throws Exception {
        taskSearch(id).setTaskName(taskName);
    }

    public void changeTaskDescription(String id, String taskDescription) throws Exception {
        taskSearch(id).setTaskDescription(taskDescription);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    private String newUniqueID() {
        return uniqueID = UUID.randomUUID().toString().substring(
            0, Math.min(toString().length(), 10));
    }

    private Task taskSearch(String id) throws Exception {
        int index = 0;
        while (index < tasks.size()) {
            if (id.equals(tasks.get(index).getTaskId())) {
                return tasks.get(index);
            }
            index++;
        }
        throw new Exception("The id could not be found");
    }
}