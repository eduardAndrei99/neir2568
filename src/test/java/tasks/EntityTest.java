package tasks;

import org.junit.jupiter.api.*;
import tasks.model.Task;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.fail;

public class EntityTest {

    @Test
    @DisplayName("TaskEntityTest1")
    void TaskEntityTest1() {
        Task task = new Task("Curatenie", new Date(1616924736));
        assert task != null;
    }

    @Test
    @Tag("IllegalArgumentExceptionTIMETaskEntityTest2")
    void IllegalArgumentExceptionTIMETaskEntityTest2() {
        try {
            Task task2 = new Task("Curatenie", new Date(-2));
            assert false;
        }
        catch (IllegalArgumentException ex) {
            assert true;
        }
    }

    @Test
    @Tag("IllegalArgumentExceptionTITLETaskEntityTest3")
    void IllegalArgumentExceptionTITLETaskEntityTest3() {
        try {
            Task task2 = new Task("", new Date(2));
            assert false;
        }
        catch (IllegalArgumentException ex) {
            assert true;
        }
    }

}
