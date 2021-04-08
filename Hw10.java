/*
 * This program is a loan calculator, it allows the user to create and view business and
 * personal loans thorugh a gui
 */
package hw10;

import java.util.ArrayList;
import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author BN
 */
public class Hw10 extends Application {

    //stores created loan objects
    ArrayList<Loan> loanList = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        //set up primary window
        primaryStage.setTitle("Loan Input");

        //closes program with red button
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            primaryStage.close();
        });

        //set up pane for first scene
        GridPane layout1 = new GridPane();
        layout1.setPadding(new Insets(10, 10, 10, 10));
        layout1.setVgap(8);
        layout1.setHgap(10);

        //primeinterest label
        Label primeInterestLabel = new Label("Enter Prime Interest:");
        GridPane.setConstraints(primeInterestLabel, 0, 0);

        //primeinterest textfield
        TextField primeInterestField = new TextField(".0325");
        GridPane.setConstraints(primeInterestField, 1, 0);

        //lastname label
        Label lastNameLabel = new Label("Enter lastname:");
        GridPane.setConstraints(lastNameLabel, 0, 1);

        //lastname textfield
        TextField lastNameField = new TextField();
        GridPane.setConstraints(lastNameField, 1, 1);

        //Ammount label
        Label ammountLabel = new Label("Enter ammount:");
        GridPane.setConstraints(ammountLabel, 0, 2);

        //ammount textfield
        TextField ammountField = new TextField();
        GridPane.setConstraints(ammountField, 1, 2);

        //term label
        Label termLabel = new Label("Enter term:");
        GridPane.setConstraints(termLabel, 0, 3);

        //ammount textfield
        TextField termField = new TextField();
        GridPane.setConstraints(termField, 1, 3);

        //indicates how many loans have been created
        Label loansLabel = new Label("Number of Loans added: " + loanList.size());
        GridPane.setConstraints(loansLabel, 0, 4);

        //add business loan button, creates object from texts inside various text fields
        Button businessButton = new Button("Add as Business Loan");
        businessButton.setOnAction(e -> {
            loanList.add(new BusinessLoan(
                    loanList.size() + 1,
                    lastNameField.getText(),
                    Double.parseDouble(ammountField.getText()),
                    Integer.parseInt(termField.getText()),
                    Double.parseDouble(primeInterestField.getText())));

            //clears text fields except prime interest rate after each loan is made
            lastNameField.setText("");
            ammountField.setText("");
            termField.setText("");
            loansLabel.setText("Number of Loans added: " + loanList.size());

        });
        GridPane.setConstraints(businessButton, 0, 5);

        //add personal loan button, creates object from texts inside various text fields        
        Button personalButton = new Button("Add as Personal loan");
        personalButton.setOnAction(e -> {
            loanList.add(new PersonalLoan(
                    loanList.size() + 1,
                    lastNameField.getText(),
                    Double.parseDouble(ammountField.getText()),
                    Integer.parseInt(termField.getText()),
                    Double.parseDouble(primeInterestField.getText())));

            //clears text fields except prime interest rate after each loan is made 
            lastNameField.setText("");
            ammountField.setText("");
            termField.setText("");
            loansLabel.setText("Number of Loans added: " + loanList.size());
        });
        GridPane.setConstraints(personalButton, 1, 5);

        //priamrystage <- scene2 <- stackpane <- scrollpane <- outputlabel
        StackPane layout2 = new StackPane();
        Scene scene2 = new Scene(layout2, 325, 250);

        //layout 2 output label
        Label outputLabel = new Label();

        //create scrollpane for scene two outputlabel
        ScrollPane scrollPane = new ScrollPane();

        //add output label to scrollpane
        scrollPane.setContent(outputLabel);

        //add items on to pane for sceen two
        layout2.getChildren().add(scrollPane);

        //output loans button. 
        Button displayButton = new Button("Display Loans");
        displayButton.setOnAction(e -> {
            String str = "";
            for (int i = 0; i < loanList.size(); i++) {
                str = str + loanList.get(i).toString() + "\n\n";

            }
            //switches to scene2
            outputLabel.setText(str);
            primaryStage.setScene(scene2);
            primaryStage.setTitle("Loan Output");

        });
        GridPane.setConstraints(displayButton, 0, 6);

        //add nodes to pane for scene 1
        layout1.getChildren().addAll(primeInterestLabel, primeInterestField, lastNameLabel, lastNameField, ammountLabel,
                ammountField, termLabel, termField, loansLabel, businessButton, personalButton, displayButton);

        //priamrystage <- scene1 <- stackpane <- scrollpane <- outputlabel        
        Scene scene1 = new Scene(layout1, 320, 235);
        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
