package slot_gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Lakjeew on 11/9/2017.
 */
public class statistics {
   static Label display_wins;
   static Label display_loses;
   static Label display_won_credits;
   static Label display_lost_credits;

   static double won_credits;
   static double lose_credits;

   static TextArea display_won_credit_area = new TextArea();
   static TextArea display_lost_credit_area = new TextArea();
   static TextArea display_wins_area = new TextArea();
   static TextArea display_loses_area = new TextArea();

    public void display_Stats() {

    Stage window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL); //preventing the user to use the other window without closing the statistic window
    window.setTitle("Statistics");


    ColumnConstraints columnConstraints = new ColumnConstraints();
    columnConstraints.setPercentWidth(50);
    RowConstraints rowConstraints = new RowConstraints();
    rowConstraints.setPercentHeight(40);
        GridPane grid = new GridPane();
        //grid.setGridLinesVisible(true);
        grid.setPadding(new Insets(100,50,10,100));
        grid.setVgap(8);
        grid.setHgap(10);

        //styling and adding to the grid pane
         display_wins = new Label("No of Wins");
        display_wins.setStyle("-fx-font-size: 1cm");
        GridPane.setConstraints(display_wins,2,0);


        display_loses = new Label("No of Loses");
        GridPane.setConstraints(display_loses,4,0);
        display_loses.setStyle("-fx-font-size: 1cm");

        display_won_credits = new Label(" Average Won credits");
        GridPane.setConstraints(display_won_credits,2,2);
        display_won_credits.setStyle("-fx-font-size: 1cm");

        display_lost_credits = new Label("Average Lost Credits ");
        GridPane.setConstraints(display_lost_credits,4,2);
        display_lost_credits.setStyle("-fx-font-size: 1cm");

        //adding the saving statistics button
        Button save = new Button("Save Stats");
        GridPane.setConstraints(save,11,11);

        //adding the closing button
        Button close = new Button("Close");
        GridPane.setConstraints(close,7,11);

        //Taking the date and time
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(Calendar.getInstance().getTime());
        String datetime = timeStamp+".dat";
        System.out.println(datetime);

        //setting the action on the save button
        save.setOnAction(e->{
            try {
                FileWriter fw = new FileWriter(datetime); //create a file with current date and time

                //write following details to the a file
                    fw.write("Number of Wins :"+Spin.wins+"\n");
                    fw.write("");
                    fw.write("Number of Loses :"+Spin.loses+"\n");
                    fw.write("");
                    fw.write("Average Won Credits : "+won_credits+"\n");
                    fw.write("");
                    fw.write("Average Lose Credits : "+lose_credits+"\n");
                    fw.write("");
                    fw.write("Date and Time :"+timeStamp+"\n");
                    fw.write("");

                fw.close();
            }catch (IOException i){
                System.out.println("Invalid Marks");
            }
        });

        //setting action on closing button
        close.setOnAction(e->{
            window.close();
        });

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //pie chart to display data

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Wins", Spin.wins), //display number of wins
                        new PieChart.Data("Loses", Spin.loses)); //display number of loses
        final PieChart chart = new PieChart(pieChartData);
        chart.setStyle("-fx-text-fill: darkred");
        chart.setStyle("-fx-highlight-text-fill: darkred");
        chart.setStyle("-fx-font-weight: bold");
        chart.setTitle("Wins and Loses");
        GridPane.setConstraints(chart,15,2);

        //styling to the four Text areas to display wins,loses,won credits,lost credits

        display_wins_area.getStylesheets().add(getClass().getResource("scene3.css").toString());
        display_wins_area.setMaxSize(100,5);

        display_loses_area.getStylesheets().add(getClass().getResource("scene3.css").toString());
        display_loses_area.setMaxSize(100,5);

        display_won_credit_area.getStylesheets().add(getClass().getResource("scene3.css").toString());
        display_won_credit_area.setMaxSize(100,5);

        display_lost_credit_area.getStylesheets().add(getClass().getResource("scene3.css").toString());
        display_lost_credit_area.setMaxSize(100,5);

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        GridPane.setConstraints(display_wins_area,2,1);
        GridPane.setConstraints(display_loses_area,4,1);
        GridPane.setConstraints(display_won_credit_area,2,3);
        GridPane.setConstraints(display_lost_credit_area,4,3);



        grid.getChildren().addAll(display_wins,display_loses,display_lost_credits,display_won_credits,display_wins_area,display_loses_area
        ,display_won_credit_area,display_lost_credit_area,save,chart,close);

       Scene scene=new Scene(grid,2000,900);
       scene.getStylesheets().add(getClass().getResource("scene3.css").toString());
       window.setScene(scene);
       window.show();

}
}
