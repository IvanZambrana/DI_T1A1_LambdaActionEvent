/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package lambdaactionevent;

import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Ivan
 */
public class LambdaActionEvent extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        //Creating GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        //Creating Labels
        Label labelAIR = new Label("Annual Interest Rate:");
        grid.add(labelAIR, 1, 0);
        Label labelNOI = new Label("Number of Years: ");
        grid.add(labelNOI, 1, 1);
        Label labelLA = new Label("Loan Amount");
        grid.add(labelLA, 1, 2);
        Label labelMP = new Label("Monthly Payment");
        grid.add(labelMP, 1, 3);
        Label labelTP = new Label("Total Payment");
        grid.add(labelTP, 1, 4);
        
        //Creating TextFields
        TextField tfAnnualInterestRate = new TextField();
        grid.add(tfAnnualInterestRate, 2, 0);
        TextField tfNumberOfYears = new TextField();
        grid.add(tfNumberOfYears, 2, 1);
        TextField tfLoanAmount = new TextField();
        grid.add(tfLoanAmount, 2, 2);
        TextField tfMonthlyPayment = new TextField();
        grid.add(tfMonthlyPayment, 2, 3);
        TextField tfTotalPayment = new TextField();
        grid.add(tfTotalPayment, 2, 4);
        
        //Creating button
        Button btnCalculate = new Button("Calculate");
        grid.add(btnCalculate, 2, 5);
        
        //Lambda expression
        btnCalculate.setOnAction(e -> {
            try {
                    double i = Double.parseDouble(tfAnnualInterestRate.getText());
                    int n = Integer.parseInt(tfNumberOfYears.getText());
                    int h = Integer.parseInt(tfLoanAmount.getText()); 
                    
                    double r = i /1200;
                    double m = h * r / (1 - Math.pow((1 + r), -12 * n));
                    double t = n * 12 * m;
                    
                    DecimalFormat decimalFormat = new DecimalFormat("#.##");
                     String formattedDoubleM = decimalFormat.format(m);
                     String formattedDoubleT = decimalFormat.format(t);
                    tfMonthlyPayment.setText("$"+ formattedDoubleM);
                    tfTotalPayment.setText("$"+formattedDoubleT);
                    
                } catch (NumberFormatException E)
                {
                    System.out.println("Format error or empty fields!!");
                }
        });
        //Creating Scene
        Scene scene = new Scene(grid, 350, 250);
        primaryStage.setTitle("Loan Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
