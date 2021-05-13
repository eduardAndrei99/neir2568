package tasks;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tasks.model.Task;
import tasks.services.TasksService;
import tasks.utils.ArrayTaskList;

import java.util.Collection;
import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockEntityIntegrationTest {
    @Test
    void MockEntityIntegrationTest1() {
        ArrayTaskList list = new ArrayTaskList();
        Task t = mock(Task.class);
        Mockito.when(t.getTitle()).thenReturn("task1");
        Mockito.when(t.getTime()).thenReturn(new Date(1500));
        Mockito.when(t.isActive()).thenReturn(false);

        list.add(t);

        assert list.getTask(0).getTime().getTime() == 1500 && list.getTask(0).getTitle() == "task1" && list.size() == 1
               && list.getTask(0).isActive() == false;

        TasksService tasksService = new TasksService(list);
        Iterable<Task> tasks = tasksService.filterTasks(new Date(1000), new Date(900));
        int size =  ((Collection<?>) tasks).size();
        assert size == 0;
    }

    @Test
    void MockEntityIntegrationTest2() {
        ArrayTaskList list = new ArrayTaskList();
        Task t = mock(Task.class);
        Mockito.when(t.getTitle()).thenReturn("task1");
        Mockito.when(t.getTime()).thenReturn(new Date(2000));
        Mockito.when(t.isActive()).thenReturn(true);

        Task t2 = mock(Task.class);
        Mockito.when(t2.getTitle()).thenReturn("task2");
        Mockito.when(t2.getTime()).thenReturn(new Date(500));
        Mockito.when(t2.isActive()).thenReturn(true);

        list.add(t); list.add(t2);

        assert list.getTask(0).getTime().getTime() == 2000 && list.getTask(0).getTitle() == "task1" && list.size() == 2
                && list.getTask(0).isActive() == true && list.getTask(1).getTime().getTime() == 500 && list.getTask(1).getTitle() == "task2"
                && list.getTask(1).isActive() == true;

        TasksService tasksService = new TasksService(list);
        ObservableList<Task> tasks =  tasksService.getObservableList();
        assert  tasks.size() == 2 && tasks.contains(t) && tasks.contains(t2);
    }

}
