package tasks;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tasks.model.Task;
import tasks.services.TasksService;
import tasks.utils.ArrayTaskList;

import java.util.Collection;
import java.util.Date;

import static org.mockito.Mockito.mock;

public class MockServiceRepoIntegrationTest {

    @Test
    public void MockServiceRepoIntegrationTest1() {

        ArrayTaskList list = mock(ArrayTaskList.class);
        TasksService tasksService = new TasksService(list);

        Task task = mock(Task.class);
        Mockito.when(task.getTitle()).thenReturn("task1");
        Mockito.when(task.getTime()).thenReturn(new Date(10000));
        Mockito.when(task.getRepeatInterval()).thenReturn(1000);

        String s = tasksService.getIntervalInHours(task);
        assert s.equals("00:16");
    }

    @Test
    public void MockServiceRepoIntegrationTest2() {

        ArrayTaskList list = mock(ArrayTaskList.class);
        TasksService tasksService = new TasksService(list);

        String s = tasksService.formTimeUnit(51312222);
        assert s.equals("51312222");
    }
}
