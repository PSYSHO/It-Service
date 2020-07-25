package test.task;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class TaskManager implements Serializable {
    private Task1 task1 =new Task1();
    private Task2 task2 = new Task2();



    public TaskManager(Task1 task1, Task2 task2) {
        this.task1 = task1;
        this.task2 = task2;
    }public TaskManager(TaskManager taskManager) {
        this.task1 = taskManager.getTask1();
        this.task2 = taskManager.getTask2();
    }

    public  TaskManager(){
    }

    public Task1 getTask1() {
        return task1;
    }

    public void setTask1(Task1 task1) {
        this.task1 = task1;
    }

    public Task2 getTask2() {
        return task2;
    }

    public void setTask2(Task2 task2) {
        this.task2 = task2;
    }
}
