import javax.swing.*;
import java.awt.Container;
public class Player {
    private Sprite player;
    public int xPosition;
    public int yPosition;
    public byte displayXPosition;
    public byte displayYPosition;
    private GameRegistry registry;
    private int registryId;
    private PlayerController controller;
    Assets assets = new Assets();
    Player(byte x, byte y, GameRegistry registry, PlayerController controller){
        if (x >= 16 || y >= 16){
            return;
        }
        this.registry = registry;
        registry.occupySpace(this, x, y);
        Container contentPane = registry.getWindow().getContentPane();
        Sprite player = new Sprite(x, y, assets.player, registry.getWindow());
        this.displayXPosition = x;
        this.displayYPosition = y;
        registryId = registry.registerPlayer(this);
        this.player = player;
        this.controller = controller;
    }
    public void changePosition(byte fromX, byte fromY, byte toX, byte toY){
        if (toX >= 16 || toY >= 16){
            return;
        }
        registry.moveItemInSpace(fromX, fromY, toX, toY);
        player.changePos(toX, toY);
    }
    public void changeHealth(short change){
        controller.changeHealth(change);
    }
}
