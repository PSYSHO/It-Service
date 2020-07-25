package test.controllers;

import com.google.gson.Gson;
import test.task.TaskManager;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveLoadController {
    public TaskManager load(String path) {
        TaskManager taskManager = new TaskManager();
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader(path);
            taskManager = gson.fromJson(reader, TaskManager.class);
            reader.close();
        } catch (IOException e) {
        }
        return taskManager;
    }

    public void save(String path, TaskManager taskManager) {
        Gson gson = new Gson();
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(gson.toJson(taskManager));
            writer.close();
        } catch (IOException e) {
        }
    }
}
