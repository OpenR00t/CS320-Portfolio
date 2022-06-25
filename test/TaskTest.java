package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import task.Task;

public class TaskTest {

    //testing class creation
    @Test
    void testTask() {
        Task task = new Task("01", "Task Name", "Test Task Description");
        assertTrue(task.getTaskId().equals("01"));
        assertTrue(task.getTaskName().equals("Task Name"));
        assertTrue(task.getTaskDescription().equals("Test Task Description"));
    }
    
    @Test
    void testSetTask() {
        Task task = new Task("01", "Task Name", "Test Task Description");
        task.setTaskName("Test Name");
        task.setTaskDescription("Task Desc test");
        assertTrue(task.getTaskName().equals("Test Name"));
        assertTrue(task.getTaskDescription().equals("Task Desc test"));
    }

    //testing intiail variable lengths
    @Test
    void testTaskIdLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("00000000001", "Task Name", "Test Task Description");
        });
    }

    @Test
    void testTaskNameLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("01", "Task Namexxxxxxxxxxxx", "Test Task Description");
        });
    }

    @Test
    void testTaskDescLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("01", "Task Name", "Test Task Descriptionxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        });
    }

    //testing setter variable lengths
    @Test
    void testSetTaskNameLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task("01", "Task Name", "Test Task Description");
            task.setTaskName("Task Namexxxxxxxxxxxx");
        });
    }

    @Test
    void testSetTaskDescLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task("01", "Task Name", "Test Task Description");
            task.setTaskDescription("Test Task Descriptionxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        });
    }

    //testing if variable is null
    @Test
    void testTaskIdNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Task Name", "Test Task Description");
        });
    }

    @Test
    void testTaskNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("01", null, "Test Task Description");
        });
    }

    @Test
    void testTaskDescNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("01", "Task Name", null);
        });
    }

    //testing if setter variable is null
    @Test
    void testSetTaskNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task("01", "Task Name", "Test Task Description");
            task.setTaskName(null);
        });
    }

    @Test
    void testSetTaskDescNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task("01", "Task Name", "Test Task Description");
            task.setTaskDescription(null);
        });
    }
}
