package com.example.carts;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Button NewButton;

    @FXML
    private void NewTask() {
        // Este método se llamará cuando se haga clic en el botón NewButton
        System.out.println("¡Se hizo clic en el botón NewButton!");
        // Puedes agregar lógica adicional aquí
        try {
            // Cargar el FXML de la nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("task-title-input.fxml"));
            Parent root = loader.load();

            // Configurar el controlador de la nueva ventana
            TaskInputController taskInputController = loader.getController();

            // Crear una nueva escena y configurarla
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); // Hace que la nueva ventana sea modal
            stage.setScene(scene);
            stage.setTitle("Ingrese el título de la tarea");

            // Mostrar la nueva ventana y esperar hasta que se cierre
            stage.showAndWait();

            // Obtener el título ingresado desde el controlador de la nueva ventana
            String taskTitle = taskInputController.getTaskTitle();

            if (taskTitle != null && !taskTitle.isEmpty()) {
                // Aquí puedes hacer algo con el título de la tarea
                System.out.println("Título de la tarea ingresado: " + taskTitle);

                // Cerrar la ventana actual
                Stage currentStage = (Stage) NewButton.getScene().getWindow();
                currentStage.close();

                // Asignar el título a los botones en hello-view
                NewButton.setText(taskTitle);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setTaskTitle(String taskTitle) {

    }

    public void setTaskDescription(String taskDescription) {

    }
}
