package slot_gui;

import javafx.scene.image.Image;

/**
 * Created by Lakjeew on 11/4/2017.
 */
public interface ISymbol {

    public void setImage(String path);
    public Image getImage();
    public void setValue(int credit);
    public int getValue();

}
