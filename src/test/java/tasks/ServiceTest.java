package tasks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tasks.model.Task;
import tasks.services.TasksService;
import tasks.utils.ArrayTaskList;

import java.util.Collection;
import java.util.Date;

public class ServiceTest {

    @Test
    void ServiceTest1() {
        ArrayTaskList list = new ArrayTaskList();
        list.add(new Task("task1", new Date(1500)));
        TasksService tasksService = new TasksService(list);
        Iterable<Task> tasks = tasksService.filterTasks(new Date(1000), new Date(900));
        int size =  ((Collection<?>) tasks).size();
        assert size == 0;
    }

    @Test
    void ServiceTest2() {
        ArrayTaskList list = new ArrayTaskList();
        Task t = new Task("task1" , new Date(2000));
        t.setActive(true);
        Task t2 = new Task("task2" , new Date(500));
        t2.setActive(true);
        list.add(t);
        list.add(t2);
        TasksService tasksService = new TasksService(list);
        Iterable<Task> tasks = tasksService.filterTasks(new Date(1000), new Date(2000));
        int size =  ((Collection<?>) tasks).size();
        assert size == 1;
        for (Task i : tasks) {
            assert i.getTitle() == "task1";
        }

    }
}
