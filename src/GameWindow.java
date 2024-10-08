import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;
public class GameWindow extends JFrame{
    GameWindow() {
        Assets assets = new Assets();
        OccupiedSpaceController occupiedSpace = new OccupiedSpaceController();
        GameRegistry registry = new GameRegistry(this);
        this.setTitle("Pear Tree: Awakening");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(782,805));
        this.setMinimumSize(new Dimension(782,805));
        this.setResizable(false);
        //new Sprite(15, 15, assets.grapevine, this);
        ImageIcon icon = new ImageIcon(getClass().getResource("/assets/icon.png"));
        //Position 0,0
        Tile placeholder = new Tile((byte) 16, (byte) 16, assets.grapevine, this);
        Tile[][] tileSpace = {{placeholder},{placeholder},{placeholder},{placeholder},{placeholder},{placeholder},{placeholder},{placeholder},{placeholder},{placeholder},{placeholder},{placeholder},{placeholder},{placeholder},{placeholder}, {placeholder}};
        for (byte i = 0; i < 16; i++) {
            Tile[] currentLine = {placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder};
            for (byte j = 0; j < 16; j++) {
                currentLine[j] = new Tile((byte) j, (byte) i, assets.ground, this);
            }
            tileSpace[i] = currentLine;
        }
        PlayerController player = new PlayerController((byte) 7, (byte) 7, (byte) 7, (byte) 7, registry);
        Monster monster = new Monster((byte) 3,(byte) 3, registry);
        //General Setup
        this.pack();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e){
                player.handleKeyPress(e.getKeyChar());
            }
            @Override
            public void keyTyped(KeyEvent e){

            }
            @Override
            public void keyReleased(KeyEvent e){

            }
        });
        this.setIconImage(icon.getImage());
        this.setVisible(true);
    }
    public void close(){
        this.setVisible(false);
        this.dispose();
    }
}
