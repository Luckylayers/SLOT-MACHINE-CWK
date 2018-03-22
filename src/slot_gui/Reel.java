package slot_gui;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Lakjeew on 11/4/2017.
 */
public class Reel {
     ArrayList<symbol> symbolArray1 = new ArrayList<>(); //declaring an array to save the images


    //initialising the constructor withmiage url and value of that image
    static symbol seven = new symbol(new Image("Reel_Images/redseven.png"),7);
    static symbol bell = new symbol(new Image("Reel_Images/bell.png"),6);
    static symbol watermelon = new symbol(new Image("Reel_Images/watermelon.png"),5);
    static symbol plum = new symbol(new Image("Reel_Images/plum.png"),4);
    static symbol lemon = new symbol(new Image("Reel_Images/lemon.png"),3);
    static symbol cherry = new symbol(new Image("Reel_Images/cherry.png"),2);

    //initialising the array with symbol objects which holds the image object and value of that image
    public Reel(){
        symbolArray1.add(seven);
        symbolArray1.add(bell);
        symbolArray1.add(watermelon);
        symbolArray1.add(plum);
        symbolArray1.add(lemon);
        symbolArray1.add(cherry);
    }


    //shuffle the array inorder to a different image each time when method calls
    public ArrayList<symbol> spin(){
        Collections.shuffle(symbolArray1);
        return symbolArray1;

    }
}
