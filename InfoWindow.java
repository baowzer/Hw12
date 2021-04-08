/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw10;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author BN
 */
public class InfoWindow {

    public static Loan inputWindow(Stage window, int loanType, double primeInterest, int loanNumber) {

        window.setTitle("Info GUI");
        window.setOnCloseRequest(e -> {
            e.consume();
            window.close();
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //lastname label
        Label lastNameLabel = new Label("Enter lastname:");
        GridPane.setConstraints(lastNameLabel, 0, 0);

        //lastname textfield
        TextField lastNameInput = new TextField();
        GridPane.setConstraints(lastNameInput, 1, 0);

        //Ammount label
        Label ammountLabel = new Label("Enter ammount:");
        GridPane.setConstraints(ammountLabel, 0, 1);

        //ammount textfield
        TextField ammountField = new TextField();
        GridPane.setConstraints(ammountField, 1, 1);

        //term label
        Label termLabel = new Label("Enter term:");
        GridPane.setConstraints(termLabel, 0, 2);

        //ammount textfield
        TextField termField = new TextField();
        GridPane.setConstraints(termField, 1, 2);

        ArrayList<Object> info = new ArrayList<>();
        //button
        Button goButton = new Button("Add");
        goButton.setOnAction(e -> {

            info.add(lastNameInput.getText());
            info.add(Double.parseDouble(ammountField.getText()));
            info.add(Integer.parseInt(termField.getText()));

        });

        GridPane.setConstraints(goButton, 1, 3);

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> window.close());
        GridPane.setConstraints(cancelButton, 1, 4);

        grid.getChildren().addAll(lastNameLabel, lastNameInput, ammountLabel,
                ammountField, termLabel, termField, goButton, cancelButton);

        Scene scene = new Scene(grid, 300, 200);

        window.setScene(scene);
        window.show();
        
        if (loanType == 1) {
            return new BusinessLoan(loanNumber, (String) info.get(0),
                    (double) info.get(1), (int) info.get(2), primeInterest);
        } else {
            return new PersonalLoan(loanNumber, (String) info.get(0),
                    (double) info.get(1), (int) info.get(2), primeInterest);
        }
    }

}
