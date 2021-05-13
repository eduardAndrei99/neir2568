package tasks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tasks.model.Task;
import tasks.services.TasksService;
import tasks.utils.ArrayTaskList;

import java.util.Collection;
import java.util.Date;

public class RepositoryTest {

    @Test
    void RepositoryTest1() {
        ArrayTaskList list = new ArrayTaskList();
        list.add(new Task("task1", new Date(1500)));

        assert list.size() == 1 && list.getTask(0).getTitle() == "task1"  && list.getTask(0).getTime().getTime() == 1500;
    }

    @Test
    void RepositoryTest2() {
        ArrayTaskList list = new ArrayTaskList();
        list.add(new Task("task1", new Date(1500)));
        list.add(new Task("task2", new Date(150)));
        list.remove(list.getTask(0));

        assert list.size() == 1 && list.getTask(0).getTitle() == "task2"  && list.getTask(0).getTime().getTime() == 150;
    }
}
