package tasks;

import org.junit.jupiter.api.*;
import tasks.model.Task;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.fail;

public class TaskTest {
    @Test
    @DisplayName("ECP1")
    void ECP1() {
        Task task = new Task("Curatenie", new Date(1616924736));
        assert task != null;
    }

    @Test
    @RepeatedTest(2)
    @Tag("IllegalArgumentExceptionTIME")
    void ECP7() {
        try {
            Task task2 = new Task("Curatenie", new Date(-2));
            assert false;
        }
        catch (IllegalArgumentException ex) {
            assert true;
        }
    }

    @Test
    @Tag("IllegalArgumentExceptionTITLE")
    @Timeout(5)
    void ECP11() {
        try {
            Task task2 = new Task("", new Date(2));
            assert false;
        }
        catch (IllegalArgumentException ex) {
            assert true;
        }
    }

    @Test
    @Disabled("Not implemented")
    void ECPnotImpl() {
        fail();
    }

    @Test
    @Timeout(5)
    void BVA1() {
        try {
            Task task2 = new Task("", new Date(123));
            assert false;
        }
        catch (IllegalArgumentException ex) {
            assert true;
        }
    }

    @Test
    @Timeout(5)
    @DisplayName("BVA 3 OK")
    void BVA3() {
        try {
            Task task2 = new Task("A", new Date(123));
            assert true;
        }
        catch (IllegalArgumentException ex) {
            assert false;
        }
    }

    @Test
    @DisplayName("BVA 10 OK ")
    void BVA10() {
        Task task = new Task("Curatenie", new Date(Long.MAX_VALUE - 1));
        assert task != null;
    }

    @Test
    @Timeout(5)
    @DisplayName("BVA 12 not OK")
    void BVA12() {
        try {
            Task task = new Task("Curatenie", new Date(Long.MAX_VALUE + 1));
            assert false;
        }
        catch (IllegalArgumentException ex) {
            assert true;
        }
    }

}
