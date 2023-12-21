package com.example.carts;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class TaskInputController {

    public Button saveTitleButton;
    @FXML
    private TextField titleTextField;

    private String taskTitle;

    @FXML
    private void initialize() {
        // Puedes realizar inicializaciones aquí si es necesario
    }

    @FXML
    private void onSaveTitleButtonClick() {
        // Obtener el título ingresado y cerrar la ventana
        taskTitle = titleTextField.getText();
        System.out.println("Titulo de la tarea: " + taskTitle);

        openDescriptionInputWindow();
        closeWindow();
    }

    private void openDescriptionInputWindow() {
        try {
            // Cargar el FXML de la nueva ventana (task-description-input.fxml)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("task-description-input.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la nueva ventana
            TaskInputDescriptionController descriptionInputController = loader.getController();

            // Crear una nueva escena y configurarla
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); // Hace que la nueva ventana sea modal
            stage.setScene(scene);
            stage.setTitle("Ingrese la descripción de la tarea");

            // Mostrar la nueva ventana y esperar hasta que se cierre
            stage.showAndWait();

            // Cerrar la ventana actual después de que se cierre la nueva ventana
            closeWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    private void closeWindow() {
        // Cerrar la ventana actual
        Stage stage = (Stage) saveTitleButton.getScene().getWindow();
        stage.close();
    }
}
