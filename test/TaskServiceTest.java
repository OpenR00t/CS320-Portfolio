package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import task.TaskService;

class TaskServiceTest {

    @Test
    void addTaskTest() {
        TaskService service = new TaskService();
        service.newTask("Task Name", "Test Task Description");
        assertTrue(service.getTasks().get(0).getTaskName().equals("Task Name"));
        assertTrue(service.getTasks().get(0).getTaskDescription().equals("Test Task Description"));
    }

    @Test
    void deleteTaskTest() {
        TaskService service = new TaskService();
        service.newTask("Task Name", "Test Task Description");
        Assertions.assertThrows(Exception.class, () -> {
            service.deleteTask("01");
        });
        Assertions.assertAll( () -> {
            service.deleteTask(service.getTasks().get(0).getTaskId());
        });
    }

    @Test
    void changeTaskTest() throws Exception {
        TaskService service = new TaskService();
        service.newTask("Task Name", "Test Task Description");
        service.changeTaskName(service.getTasks().get(0).getTaskId(), "Test Name");
        service.changeTaskDescription(service.getTasks().get(0).getTaskId(),"Task Desc test");
        assertEquals("Test Name", service.getTasks().get(0).getTaskName());
        assertEquals("Task Desc test", service.getTasks().get(0).getTaskDescription());
        assertThrows(Exception.class, () -> {
            service.changeTaskName("01", "Test Name");
        });
        assertThrows(Exception.class, () -> {
            service.changeTaskDescription("01", "Task Desc test");
        });
    }
}
