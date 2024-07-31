import javax.swing.*;
import java.awt.Container;
public class Player {
    private JLabel player;
    private OccupiedSpaceController occupiedSpace;
    Assets assets = new Assets();
    Player(byte x, byte y, GameWindow frame, OccupiedSpaceController occupiedSpace){
        if (x >= 16 || y >= 16){
            return;
        }
        occupiedSpace.occupySpace(this, x, y);
        this.occupiedSpace = occupiedSpace;
        Container contentPane = frame.getContentPane();
        JLabel player = new JLabel();
        player.setAlignmentX(SwingConstants.LEFT);
        player.setBounds(48*x, 48*y,48,48);
        player.setIcon(assets.player);
        contentPane.add(player);
        contentPane.setComponentZOrder(player, 1);
        this.player = player;
    }
    public void changePosition(byte fromX, byte fromY, byte toX, byte toY){
        if (toX >= 16 || toY >= 16){
            return;
        }
        this.occupiedSpace.moveItemInSpace(fromX, fromY, toX, toY);
        this.player.setBounds(48*toX, 48*toY,48,48);
    }
}
