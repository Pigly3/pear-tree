import javax.swing.*;
import java.awt.Container;
public class Tile {
    private JLabel tile;
    Tile(byte x, byte y, ImageIcon icon, GameWindow frame){
        if (x >= 16 || y >= 16){
            return;
        }
        Container contentPane = frame.getContentPane();
        JLabel tile = new JLabel();
        tile.setAlignmentX(SwingConstants.LEFT);
        tile.setBounds(48*x, 48*y,48,48);
        tile.setIcon(icon);
        contentPane.add(tile);
        contentPane.setComponentZOrder(tile, 0);
        this.tile = tile;
    }
    public static void changeIcon(){

    }
    public JLabel getTile(){
        return this.tile;
    }
}
