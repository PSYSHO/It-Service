package test;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import test.controllers.SaveLoadController;
import test.task.Task1;
import test.task.Task2;
import test.task.TaskManager;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class App extends Application {
    public static void main(String[] args) {
        final File file = new File("Tasks");
        if (file.exists());
        else{//todo Создание базовых данных для проверки
           Task1 task1 = new Task1();
           Task2 task2 = new Task2();
           task2.setNumb(15523);
           task2.setResult(task2.expandedForm(task2.getNumb()));
           String[] a1 = {"arp","live","strong"};
           String[] a2 = {"lively","alive","harp","sharp","armstrong"};
            task1.setA1(a1);task1.setA2(a2);
           String[] r = task1.sort();
           task1.setR(r);
           TaskManager taskManager = new TaskManager();
           taskManager.setTask1(task1);taskManager.setTask2(task2);
           SaveLoadController saveLoadController = new SaveLoadController();saveLoadController.save("Tasks",taskManager);
        }

        Application.launch();
    }

    public void start(Stage primaryStage) throws Exception {
        String path = "Tasks";
        SaveLoadController saveLoadController = new SaveLoadController();
        TaskManager taskManager = new TaskManager(saveLoadController.load(path));
        Task1 task1 = taskManager.getTask1();
        Task2 task2 = taskManager.getTask2();
        primaryStage.setTitle("Test");
        Button execute = new Button("Execute");
        Button save = new Button("Save");
        Button load = new Button("Load");
        TextField textField = new TextField();
        TextField textField1 = new TextField();
        Label result = new Label("");
        ObservableList<String> strings = FXCollections.observableArrayList("Task1", "Task2");
        ComboBox<String> comboBox = new ComboBox<String>(strings);
        comboBox.getSelectionModel().select(0);
        AnchorPane anchorPane = new AnchorPane();
        HBox hBox = new HBox();
        VBox vBox = new VBox();
        Label coment = new Label("Enter substrings in the form - arp,live");
        Label coment1 = new Label("Enter the lines that will be checked - sharp,alive,lively ");
        HBox input1 = new HBox(textField, coment);
        HBox input2 = new HBox(textField1, coment1);
        hBox.getChildren().addAll(execute, save, load, comboBox);
        vBox.getChildren().addAll(input1, input2, result, hBox);
        anchorPane.getChildren().addAll(vBox);
        anchorPane.setLeftAnchor(vBox, Double.valueOf(10));
        Scene scene = new Scene(anchorPane, 500, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
        execute.setOnAction(e -> {
            if (comboBox.getSelectionModel().getSelectedItem().equals("Task1")) {
                String[] a1 = String.valueOf(textField.getText()).split(",");
                String[] a2 = String.valueOf(textField1.getText()).split(",");
                task1.setA1(a1);
                task1.setA2(a2);
                result.setText(Arrays.toString(task1.sort()));

            } else {
                String str = String.valueOf(textField.getText());
                result.setText(task2.expandedForm(Integer.parseInt(str)));
            }
        });
        comboBox.setOnAction(t -> {
            if (comboBox.getSelectionModel().getSelectedItem().equals("Task2")) {
                textField.setText(String.valueOf(task2.getNumb()));
                result.setText(task2.getResult());
                textField1.setVisible(false);
                coment.setText("enter an integer");
                coment1.setText("");
            } else {
                textField1.setVisible(true);
                textField.setText(Arrays.toString(taskManager.getTask1().getA1()).replace("[","").replace("]",""));
                textField1.setText(Arrays.toString(taskManager.getTask1().getA2()).replace("[","").replace("]",""));
                result.setText(Arrays.toString(taskManager.getTask1().getR()).replace("[","").replace("]",""));
                coment.setText("Enter substrings in the form - arp,live");
                coment1.setText("Enter the lines that will be checked - sharp,alive,lively ");
            }
        });
        load.setOnAction(l -> {
            if (comboBox.getSelectionModel().getSelectedItem().equals("Task2")) {
                textField1.setVisible(false);
                textField.setText(String.valueOf(taskManager.getTask2().getNumb()));
                result.setText(taskManager.getTask2().getResult());
                coment.setText("enter an integer");
                coment1.setText("");
            } else {
                textField1.setVisible(true);
                textField.setText(Arrays.toString(taskManager.getTask1().getA1()).replace("[","").replace("]",""));
                textField1.setText(Arrays.toString(taskManager.getTask1().getA2()).replace("[","").replace("]",""));
                result.setText(Arrays.toString(taskManager.getTask1().getR()).replace("[","").replace("]",""));
                coment.setText("Enter substrings in the form - arp,live");
                coment1.setText("Enter the lines that will be checked - sharp,alive,lively ");
            }
        });
        save.setOnAction(s -> {
            taskManager.setTask1(task1);
            taskManager.setTask2(task2);
            saveLoadController.save(path, taskManager);
        });
    }

}
