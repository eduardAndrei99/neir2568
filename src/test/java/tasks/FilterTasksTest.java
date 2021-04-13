package tasks;

import org.junit.jupiter.api.*;
import tasks.model.Task;
import tasks.services.TasksService;
import tasks.utils.ArrayTaskList;

import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.fail;

public class FilterTasksTest {

    @Test
    @DisplayName("F02_TC01")
    void F02_TC01() {
        ArrayTaskList list = new ArrayTaskList();
        list.add(new Task("task1", new Date(1500)));
        TasksService tasksService = new TasksService(list);
        Iterable<Task> tasks = tasksService.filterTasks(new Date(1000), new Date(900));
        int size =  ((Collection<?>) tasks).size();
        assert size == 0;
    }

    @Test
    @DisplayName("F02_TC02")
    void F02_TC02() {
        ArrayTaskList list = new ArrayTaskList();
        list.add(new Task("task1", new Date(500)));
        TasksService tasksService = new TasksService(list);
        Iterable<Task> tasks = tasksService.filterTasks(new Date(1000), new Date(2000));
        int size =  ((Collection<?>) tasks).size();
        assert size == 0;
    }

    @Test
    @DisplayName("F02_TC03")
    void F02_TC03() {
        ArrayTaskList list = new ArrayTaskList();
        Task t = new Task("task1" , new Date(1500));
        t.setActive(true);
        list.add(t);
        TasksService tasksService = new TasksService(list);
        Iterable<Task> tasks = tasksService.filterTasks(new Date(1000), new Date(2000));
        int size =  ((Collection<?>) tasks).size();
        assert size == 1;
        for (Task i : tasks) {
            assert i.getTitle() == "task1";
        }

    }

    @Test
    @DisplayName("F02_TC04")
    void F02_TC04() {
        ArrayTaskList list = new ArrayTaskList();
        Task t = new Task("task1" , new Date(2000));
        t.setActive(true);
        list.add(t);
        TasksService tasksService = new TasksService(list);
        Iterable<Task> tasks = tasksService.filterTasks(new Date(1000), new Date(2000));
        int size =  ((Collection<?>) tasks).size();
        assert size == 1;
        for (Task i : tasks) {
            assert i.getTitle() == "task1";
        }

    }

    @Test
    @DisplayName("F02_TC05")
    void F02_TC05() {
        ArrayTaskList list = new ArrayTaskList();
        Task t = new Task("task1" , new Date(2000));
        t.setActive(true);
        Task t2 = new Task("task2" , new Date(500));
        t2.setActive(true);
        list.add(t);
        TasksService tasksService = new TasksService(list);
        Iterable<Task> tasks = tasksService.filterTasks(new Date(1000), new Date(2000));
        int size =  ((Collection<?>) tasks).size();
        assert size == 1;
        for (Task i : tasks) {
            assert i.getTitle() == "task1";
        }

    }


}
