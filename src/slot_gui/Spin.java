package slot_gui;


import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Lakjeew on 11/4/2017.
 */
public class Spin  {

    static int playercredit = 10;
    static int betcredit = 0;
    static int loses =0;
    static int wins=0;



    //A temporary array to store players details
    public static ArrayList<Spin> player_array = new ArrayList<>();

    private  int won_credits;//to hold won credits each time when the player wins
    private  int lost_credits;//to hold won credits each time when the player wins



    public Spin(){

    }

    /*
    constructor to intialize won credits and lost credits
     */
    public Spin(int  won_credits , int lost_credits){
        this.won_credits=won_credits;
        this.lost_credits = lost_credits;
    }
    //creating the a  thread
    public static Thread thread1 = new Thread();
    public static  Thread thread2 = new Thread();
    public static  Thread thread3 = new Thread();


    /*
    Implementation of the runnable,
    Running the three reels
     */

    public static void Spin_Reels(Thread threadA,Thread threadB,Thread threadC,Label lblA,Label lblB,Label lblC,ImageView imageViewA,ImageView imageViewB,ImageView imageViewC){
        threadA= new Thread(new Runnable() {
            @Override
            public void run() {
                Reel k = new Reel(); //calling the default constructor
                k.spin();//calling the spin method in Reel class to get a shuffled array of images
                while (slotMachine_Gui.ispressed) { //while spin button is pressed
                    int index = new Random().nextInt(6);//generate a random number
                    ArrayList<symbol> temparr = k.symbolArray1;//make an temporary array
                    imageViewA.setFitHeight(150);//set the height to the image view
                    imageViewA.setFitWidth(150);//set the width to the image view
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            imageViewA.setImage(temparr.get(index).getImage());//set the image to the new image view
                            lblA.setGraphic(imageViewA);//setting the image view to the label
                        }
                    });

                    try {

                        Thread.sleep(70); //sleep the thread

                    } catch (InterruptedException r) {
                        r.printStackTrace();
                    } catch (Exception e) {

                    }
                }
            }
        });
        threadA.start();//start the thread

        threadB= new Thread(new Runnable() {
            @Override
            public void run() {
                Reel k = new Reel(); //calling the default constructor
                k.spin();//calling the spin method in Reel class to get a shuffled array of images
                while (slotMachine_Gui.ispressed) { //while spin button is pressed
                    int index = new Random().nextInt(6);//generate a random number
                    ArrayList<symbol> temparr = k.symbolArray1;//make an temporary array
                    imageViewB.setFitHeight(150);//set the height to the image view
                    imageViewB.setFitWidth(150);//set the width to the image view
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            imageViewB.setImage(temparr.get(index).getImage());//set the image to the new image view
                            lblB.setGraphic(imageViewB);//setting the image view to the label
                            System.out.println();
                        }
                    });

                    try {

                        Thread.sleep(70); //sleep the thread

                    } catch (InterruptedException r) {
                        r.printStackTrace();
                    } catch (Exception e) {

                    }
                }
            }
        });
        threadB.start();//start the thread

        threadC= new Thread(new Runnable() {
            @Override
            public void run() {
                Reel k = new Reel(); //calling the default constructor
                k.spin();//calling the spin method in Reel class to get a shuffled array of images
                while (slotMachine_Gui.ispressed) { //while spin button is pressed
                    int index = new Random().nextInt(6);//generate a random number
                    ArrayList<symbol> temparr = k.symbolArray1;//make an temporary array
                    imageViewC.setFitHeight(150);//set the height to the image view
                    imageViewC.setFitWidth(150);//set the width to the image view
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            imageViewC.setImage(temparr.get(index).getImage());//set the image to the new image view
                            lblC.setGraphic(imageViewC);//setting the image view to the label
                        }
                    });

                    try {

                        Thread.sleep(70); //sleep the thread

                    } catch (InterruptedException r) {
                        r.printStackTrace();
                    } catch (Exception e) {
                        System.out.println();
                    }
                }
            }
        });
        threadC.start();//start the thread
    }

    /*
    calculate the number of credits won and lost by every game according to the play
     */
    public  void credit_won(){
        Reel obj = new Reel();
        Image url1=slotMachine_Gui.r1imgV.getImage(); //get the image from first image label
        Image url2=slotMachine_Gui.r2imgV.getImage(); //get the image from second image label
        Image url3 =slotMachine_Gui.r3imgV.getImage(); //get the image from third image label


        //checking whether all the images are equal in the three reels or else check accordingly and assign credits

        if((url1==url2) && (url1==url3)) { //check whether all three are equal
            for (symbol i : obj.symbolArray1){   //loop through the symbol array to find the needed image
                if (i.getImage()==url1) { //logic to find the needed image
                    won_credits = betcredit * i.getValue(); //get the value from that object and calculate the won credit amount
                   // System.out.println("Image taken " + url1);
                    System.out.println("value taken " + i.getValue());
                }
        }
                wins++;
            slotMachine_Gui.status1.setText("  You Won !!! ");
                slotMachine_Gui.status2.setText(" "+String.valueOf(won_credits) + " Credits Earned !");
                slotMachine_Gui.status3.setText("  Spin Again...");
        }
        else if(url1==url2){ //check whether images are equal in 1 and 2
            for(symbol i : obj.symbolArray1) {  //loop through the symbol array to find the needed image
                if (i.getImage()==url1) { //logic to find the needed image
                    won_credits = betcredit * i.getValue(); //get the value from that object and calculate the won credit amount
                    System.out.println("value  taken " + i.getValue());
                }
            }
                wins++;
            slotMachine_Gui.status1.setText("  You Won !!! ");
            slotMachine_Gui.status2.setText(" "+String.valueOf(won_credits) + " Credits Earned");
            slotMachine_Gui.status3.setText(" Spin Again...");
        }

         else if(url1==url3){ //check whether images are equal in 1 and 3
            for(symbol i : obj.symbolArray1) { //loop through the symbol array to find the needed image
                if (i.getImage()==url3) { //logic to find the needed image
                    won_credits = betcredit * i.getValue();//get the value from that object and calculate the won credit amount
                    System.out.println("value taken " + i.getValue());

                }
            }
           
             System.out.print("");
             wins++;

            slotMachine_Gui.status1.setText(" You Won !!! ");
            slotMachine_Gui.status2.setText(" "+String.valueOf(won_credits) + " Credits Earned");
            slotMachine_Gui.status3.setText(" Spin Again...");

        }

         else if(url2==url3){ //check whether images are equal in 2 and 3
            for(symbol i : obj.symbolArray1) {  //loop through the symbol array to find the needed image
                if (i.getImage()==url3) {  //logic to find the needed image
                    won_credits = betcredit * i.getValue(); //get the value from that object and calculate the won credit amount
                    System.out.println("value taken  " + i.getValue());

                }
            }
             System.out.println();
            wins++;
            slotMachine_Gui.status1.setText("  You Won !!! ");
            slotMachine_Gui.status2.setText(" "+String.valueOf(won_credits) + " Credits Earned");
            slotMachine_Gui.status3.setText("Spin Again...");
        }
        else {
             loses++;
             lost_credits = betcredit;
            slotMachine_Gui.status1.setText("  You Lose !!! ");
            slotMachine_Gui.status2.setText(" "+String.valueOf(won_credits) + " Credits Earned");
            slotMachine_Gui.status3.setText("  Spin Again...");
        }
        playercredit += won_credits; //add the won credits to playercredit after each game if it's won
        slotMachine_Gui.displaycredit.setText(String.valueOf(playercredit)); //display won  credit
        Spin attempt = new Spin(won_credits,lost_credits); //pass the won credits and lost credit to an array until the game is over
        player_array.add(attempt); //player array
        betcredit=0; //let bet credit to zero
    }

    /*
    Calculate all the statistics
    */
    public static void stats(){
        double tot_win_credits=0;
        double tot_lost_credits=0;

        statistics.display_wins_area.setText(String.valueOf(wins));//displaying total wins in the static windows
        statistics.display_loses_area.setText(String.valueOf(loses));//displaying total loses in the static windows

        for(Spin i : player_array){

            tot_win_credits+=i.won_credits;
            tot_lost_credits+=i.lost_credits;
        }

        tot_win_credits=tot_win_credits/(wins+loses);//taking the average of won credits
        tot_lost_credits=tot_lost_credits/(wins+loses);//taking the average of lost credits

        statistics.display_won_credit_area.setText(String.valueOf(tot_win_credits));
        statistics.display_lost_credit_area.setText(String.valueOf(tot_lost_credits));
        statistics.won_credits=tot_win_credits;
        statistics.lose_credits=tot_lost_credits;

    }

}
