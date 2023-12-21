package com.example.carts;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TaskInputDescriptionController {

    public TextField descriptionTextField;
    public Button saveDescriptionButton;

    public String taskDescription;





        // ... (existing code)
        public void onDescriptionButtonClick(ActionEvent actionEvent) {
            // Obtener la descripción ingresada
            taskDescription = descriptionTextField.getText();



            System.out.println("Descripción de la tarea: " + taskDescription);

            try {
                // Load the new FXML file for the "hello-view"
                FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
                Parent root = loader.load();

                // Get the controller for the "hello-view"
                HelloController helloController = loader.getController();

                // Pass necessary data to the "hello-view" controller
                helloController.setTaskDescription(taskDescription);

                // Create a new stage for the "hello-view"
                Stage newStage = new Stage();
                newStage.setTitle("Hello View");
                newStage.setScene(new Scene(root));

                // Show the new stage
                newStage.show();

                // Close the current stage (optional)
                ((Stage) saveDescriptionButton.getScene().getWindow()).close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    public String getTaskDescription() {
        return taskDescription;
    }
}
