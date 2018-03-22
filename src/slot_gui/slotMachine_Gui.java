package slot_gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



/**
 * Created by Lakjeew on 11/3/2017.
 * Main Gui with all the buttons,labels and images
 */
public class slotMachine_Gui extends Application {

    Stage window;
    Scene scene2;
    static Label r1label = new Label();//reel one label to display images
    static Label r2label = new Label();//reel two label to display images
    static Label r3label = new Label();//reel three label to display images

    static ImageView r1imgV = new ImageView(); //first imageView to display reel images images
    static ImageView r2imgV = new ImageView();//second imageView to display reel images images
    static ImageView r3imgV = new ImageView();//third imageView to display reel images images

     static TextArea displaycredit;
     static TextArea displaybet;

     //Labels used to display whether won or lost the turn
     static Label status1;
     static Label status2;
     static Label status3;



     static int betmax_pressed=0; // to bet max only once per a spin
    static boolean ispressed = false; //boolean used to check whether spin button is pressed or not
    static int arereelspressed;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Slot Machine");
        primaryStage.getIcons().add(new Image("gui_images/icon_f.jpg"));
        Button start = new Button();
        start.setOnAction(e->{
            window.setScene(scene2);
        });

       //for the first scene
        GridPane grid1 = new GridPane();
        grid1.setPadding(new Insets(100,100,100,100));
        grid1.setVgap(8);
        grid1.setHgap(10);
        GridPane.setConstraints(start,50,40);
        grid1.getChildren().addAll(start);


        //Adding the grid to first scene
        Scene scene1 = new Scene(grid1,1300,700);

        //styling
        scene1.getStylesheets().add(getClass().getResource("scene1.css").toString());
        start.getStylesheets().add(getClass().getResource("scene1.css").toString());


        //calling the second scene
        secondScene();
        window.setScene(scene1);
        window.show();
    }

    public void secondScene(){
        //Grid Pane for the second scene
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`
        GridPane grid = new GridPane();
        //grid.setGridLinesVisible(true);
        grid.setPadding(new Insets(100,100,100,100));
        grid.setVgap(8);
        grid.setHgap(10);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`

        //image label to Credit area
        Image image = new Image("gui_images/creditarea.png");
        Label label1 = new Label();
        ImageView iv = new ImageView(image);
        iv.setFitWidth(200);
        iv.setFitHeight(80);
        label1.setGraphic(iv);
        GridPane.setConstraints(label1,0,0);

        // CreditArea TextArea--> to display credit value
         displaycredit = new TextArea();
        displaycredit.setText(String.valueOf(Spin.playercredit));
        displaycredit.setMaxSize(100,5);
        displaycredit.getStylesheets().add(getClass().getResource("scene2.css").toString());
        GridPane.setConstraints(displaycredit,0,1);

        //Add Coin Button
        Button addcoin = new Button();
        GridPane.setConstraints(addcoin,0,3);
        addcoin.getStylesheets().add(getClass().getResource("scene2.css").toString());
        Image addcoinImg = new Image("gui_images/addcoin.png");
        ImageView addcoimIV = new ImageView(addcoinImg);
        addcoin.setGraphic(addcoimIV);

        // BetArea TextArea--> to display current bet value
         displaybet = new TextArea();
        displaybet.setText(String.valueOf(Spin.betcredit));
        displaybet.setMaxSize(100,5);
        GridPane.setConstraints(displaybet,1,1);
        displaybet.getStylesheets().add(getClass().getResource("scene2.css").toString());

        //Bet one Coin Button
        Button betonecoin = new Button();
        GridPane.setConstraints(betonecoin,1,3);
        addcoin.getStylesheets().add(getClass().getResource("scene2.css").toString());
        Image betonecoinImg = new Image("gui_images/betonecoin.png");
        ImageView betonecoinIV = new ImageView(betonecoinImg);
        betonecoin.setGraphic(betonecoinIV);

        //Bet Max Coin Button
        Button betmaxcoin = new Button();
        GridPane.setConstraints(betmaxcoin,1,4);
        addcoin.getStylesheets().add(getClass().getResource("scene2.css").toString());
        Image betmaxcoinImg = new Image("gui_images/betmaxcoin.png");
        ImageView betmaxcoinIV = new ImageView(betmaxcoinImg);
        betmaxcoin.setGraphic(betmaxcoinIV);

        //Bet Area label
        Label betArea = new Label();
        Image betarealabelImg = new Image("gui_images/betarea.png");
        ImageView betarealabelIV = new ImageView(betarealabelImg);
        iv.setFitWidth(200);
        iv.setFitHeight(80);
        betArea.setGraphic(betarealabelIV);
        GridPane.setConstraints(betArea,1,0);

        //Reset Coin Button
        Button resetcoin = new Button();
        GridPane.setConstraints(resetcoin,1,6);
        resetcoin.getStylesheets().add("");
        Image resetcoinImg = new Image("gui_images/reset.png");
        ImageView resetcoinIV = new ImageView(resetcoinImg);
        resetcoin.setGraphic(resetcoinIV);


        //displaying three reels
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`
        //default image for reel 1
        Image tmp1 = new Image("Reel_Images/bell.png");
        r1imgV.setImage(tmp1);
        r1label.setPadding(new Insets(0,50,0,50));
        r1label.setAlignment(Pos.CENTER);
        r1label.setGraphic(r1imgV);
        r1label.setStyle("-fx-background-color: darkcyan");
        r1imgV.setFitHeight(150);
        r1imgV.setFitWidth(150);

        //default image for reel 2
        Image tmp2 = new Image("Reel_Images/watermelon.png");
        r2imgV.setImage(tmp2);
        r2label.setPadding(new Insets(0,50,0,50));
        r2label.setGraphic(r2imgV);
        r2label.setStyle("-fx-background-color: darkcyan");
        r2imgV.setFitHeight(150);
        r2imgV.setFitWidth(150);

        //default image for reel 3
        Image tmp3 = new Image("Reel_Images/cherry.png");
        r3imgV.setImage(tmp3);
        r3label.setPadding(new Insets(0,50,0,50));
        r3label.setGraphic(r3imgV);
        r3label.setStyle("-fx-background-color: darkcyan");
        r3imgV.setFitHeight(150);
        r3imgV.setFitWidth(150);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`

        //adding the labels of images to the grid pane(reels)

        GridPane.setConstraints(r1label,4,0);
        GridPane.setConstraints(r2label,6,0);
        GridPane.setConstraints(r3label,7,0);

        //Spin Coin Button
        Button spin = new Button();
        GridPane.setConstraints(spin,6,4);
        resetcoin.getStylesheets().add(getClass().getResource("scene2.css").toString());
        Image spinimg = new Image("gui_images/spin.png");
        ImageView spinimgIV = new ImageView(spinimg);
        spin.setGraphic(spinimgIV);

        //Statistics Button
        Button stats = new Button();
        GridPane.setConstraints(stats,7,6);
        stats.getStylesheets().add(getClass().getResource("scene2.css").toString());
        Image statImg = new Image("gui_images/stats.png");
        ImageView statIV = new ImageView(statImg);
        stats.setGraphic(statIV);

        //restart button
        Button restart = new Button("Regame");
        GridPane.setConstraints(restart,7,8);

        //status1 label
        status1 = new Label("");
        GridPane.setConstraints(status1,4,3);
        //status2 label
        status2 = new Label("");
        GridPane.setConstraints(status2,6,3);
        //status1 label
        status3 = new Label("");
        GridPane.setConstraints(status3,7,3);

        //setting actions to the buttons
        //add a coin button
        addcoin.setOnAction(e->{
            Spin.playercredit++;
            displaycredit.setText(String.valueOf(Spin.playercredit));
        });
        //bet one coin
        betonecoin.setOnAction(e->{
            if(Spin.playercredit > 0) {
                Spin.betcredit++;
                displaybet.setText(String.valueOf(Spin.betcredit));
                Spin.playercredit--;
                displaycredit.setText(String.valueOf(Spin.playercredit));
            }
            if(Spin.playercredit==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("No Credits ");
                alert.setContentText("Add credits and bet");
                alert.showAndWait();
            }
        });
        //bet max coin button
        betmaxcoin.setOnAction(e -> {

            if(Spin.playercredit > 2 && betmax_pressed==0) {
                //add 3 for the bet
                Spin.betcredit = Spin.betcredit + 3;
                //display the bet
                displaybet.setText(String.valueOf(Spin.betcredit));
                //deduct 3 from player credit
                Spin.playercredit = Spin.playercredit - 3;
                //display player credit
                displaycredit.setText(String.valueOf(Spin.playercredit));
                //increment bet max pressed by one,since only press it ones
                betmax_pressed++;

            }

            if(Spin.playercredit==0 && Spin.playercredit<3){
                Alert alert = new Alert(Alert.AlertType.ERROR);//alert if credit remaining is less 3 when pressing betmax
                alert.setTitle("No Credits ");
                alert.setContentText("Add credits and bet");
                alert.showAndWait();
            }

        });
        //reset button
        resetcoin.setOnAction(e->{
            //add all the betted amount for the for the current game
            Spin.playercredit += Spin.betcredit;
            //initialise betcredit to zero
            Spin.betcredit =0;
            //display the player credit
            displaycredit.setText(String.valueOf(Spin.playercredit));
            //set the bet value
            displaybet.setText(String.valueOf(Spin.betcredit));
            //and re initialise the betmax_pressed to zero
            betmax_pressed=0;
        });

        //spin button
        spin.setOnAction(e->{
            if(Spin.betcredit >0) {
                status2.setText(" Spinning ...");
                status1.setText("");
                status3.setText("");
                ispressed = true;
                arereelspressed=0;

                //disable all the buttons when spinning
                if(ispressed){
                    spin.setDisable(true);
                    betonecoin.setDisable(true);
                    betmaxcoin.setDisable(true);
                    resetcoin.setDisable(true);
                    addcoin.setDisable(true);
                    stats.setDisable(true);
                    restart.setDisable(true);
                }
                Spin.Spin_Reels(Spin.thread1,Spin.thread2,Spin.thread3,r1label,r2label,r3label,r1imgV,r2imgV,r3imgV);
                /*Spin.Spin_Reels(Spin.thread1,r2label,r2imgV);
                Spin.Spin_Reels(Spin.thread1,r3label,r3imgV);*/
                displaybet.setText(String.valueOf(0));
                betmax_pressed=0;
            }
            if(Spin.betcredit==0){

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Pay and Play");
                alert.setContentText("You cannot play without a bet");
                alert.showAndWait();
            }

        });

        //statistics button
        stats.setOnAction(e->{

            if(Spin.wins>0 || Spin.loses>0){ //to check whether player has spun once or not to view stats
                statistics k = new statistics();
                k.display_Stats();
                Spin.stats();
            }
            if(Spin.wins==0 && Spin.loses==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("No Single Game Played ");
                alert.setContentText("Play at least one game to see statistics");
                alert.showAndWait();
            }

        });

        //setting actions to labels

        r1label.setOnMouseClicked(e->{
            arereelspressed++;
            if(arereelspressed<2 ){
                Spin i = new Spin();
                i.credit_won(); //call the credit_won method in order to calculate the score
                ispressed = false; //make ispressed false to stop the reels being spin

                offDisable(betonecoin, spin, betmaxcoin, resetcoin, addcoin, stats,restart);//unable the button when pressed
            }

        });
        r2label.setOnMouseClicked(e->{
            arereelspressed++;
            if(arereelspressed<2 ) {
                Spin i = new Spin();
                i.credit_won();//call the credit_won method in order to calculate the score
                ispressed = false;//make ispressed false to stop the reels being spin

                offDisable(betonecoin, spin, betmaxcoin, resetcoin, addcoin, stats,restart);//unable the button when pressed
                System.out.println();
            }
        });
        r3label.setOnMouseClicked(e->{
            arereelspressed++;
            if(arereelspressed<2 ) {
                Spin i = new Spin();//call the credit_won method in order to calculate the score
                ispressed = false;//make ispressed false to stop the reels being spin

                offDisable(betonecoin, spin, betmaxcoin, resetcoin, addcoin, stats,restart);//unable the button when pressed
                i.credit_won();
            }
        });

        //set action to restart button
        restart.setOnAction(e->{
            Spin.playercredit=10;
            displaycredit.setText(String.valueOf(Spin.playercredit));
            Spin.betcredit=0;
            displaybet.setText(String.valueOf(Spin.betcredit));
            Spin.wins=0;
            Spin.loses=0;
            Spin.player_array.clear();
            status1.setText("");
            status2.setText("");
            status3.setText("");
            window.centerOnScreen();

        });
        //adding all to the second grid
        grid.getChildren().addAll(label1,displaycredit,addcoin,betonecoin,betmaxcoin,betArea,displaybet,resetcoin,r1label,
                r2label,r3label,spin,stats,status2,status1,status3,restart);

        scene2=new Scene(grid,1700,800);

        //styling
        scene2.getStylesheets().add(getClass().getResource("scene2.css").toString());
    }

    /*
    method to off disability
     */
    public void offDisable(Button betonecoin,Button spin,Button betmaxcoin,Button resetcoin,Button addcoin,Button stats,Button restart){
        if(!ispressed){
            betonecoin.setDisable(false);
            spin.setDisable(false);
            betmaxcoin.setDisable(false);
            resetcoin.setDisable(false);
            addcoin.setDisable(false);
            stats.setDisable(false);
            restart.setDisable(false);

        }
    }

}
