import javax.swing.*;
import java.awt.Container;
public class Player {
    private JLabel player;
    private OccupiedSpaceController occupiedSpace;
    public int xPosition;
    public int yPosition;
    public byte displayXPosition;
    public byte displayYPosition;
    private EntityRegistry registry;
    private int registryId;
    Assets assets = new Assets();
    Player(byte x, byte y, GameWindow frame, OccupiedSpaceController occupiedSpace, EntityRegistry registry){
        if (x >= 16 || y >= 16){
            return;
        }
        this.registry = registry;
        occupiedSpace.occupySpace(this, x, y);
        this.occupiedSpace = occupiedSpace;
        Container contentPane = frame.getContentPane();
        JLabel player = new JLabel();
        player.setAlignmentX(SwingConstants.LEFT);
        this.displayXPosition = x;
        this.displayYPosition = y;
        player.setBounds(48*x, 48*y,48,48);
        player.setIcon(assets.player);
        contentPane.add(player);
        contentPane.setComponentZOrder(player, 1);
        registryId = registry.registerPlayer(this);
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
