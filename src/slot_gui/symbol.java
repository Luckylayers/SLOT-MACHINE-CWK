package slot_gui;

import javafx.scene.image.Image;

/**
 * Created by Lakjeew on 11/4/2017.
 */
public class symbol implements ISymbol {

    Image image;
    int value;

    public symbol(Image image,int value){

        this.image=image;
        this.value=value;
    }

    @Override
    public void setImage(String path) {

    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void setValue(int credit) {

    }

    @Override
    public int getValue() {
        return value;
    }
}

