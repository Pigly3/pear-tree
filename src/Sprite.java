import javax.swing.*;
import java.awt.*;
public class Sprite {
    private JLabel sprite;
    Sprite(int displayX, int displayY, ImageIcon asset, JFrame window){
        Container contentPane = window.getContentPane();
        JLabel sprite = new JLabel();
        sprite.setBounds(48*displayX, 48*displayY,48,48);
        sprite.setIcon(asset);
        contentPane.add(sprite);
        contentPane.setComponentZOrder(sprite, 1);
        this.sprite = sprite;
    }

    public void changePos(byte displayX, byte displayY){
        sprite.setBounds(48*displayX, 48*displayY,48,48);
    }
}
