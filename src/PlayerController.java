import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class PlayerController {
    private int x;
    private int y;
    private byte displayX;
    private byte displayY;
    private Player player;
    private GameRegistry registry;
    private short health = 100;
    private int damage = 5;
    public PlayerController(int x, int y, byte displayX, byte displayY, GameRegistry registry){
        this.x = x;
        this.y = y;
        this.displayX = displayX;
        this.displayY = displayY;
        this.player =  new Player((byte) displayX, (byte) displayY, registry, this);
        this.registry = registry;
        java.util.Timer timer = new Timer();
        TimerTask checkHealth = new TimerTask(){
            public void run(){
                checkHealth();
            }
        };
        timer.schedule(checkHealth, 0, 200);
    }
    private void changePosition(int x, int y, byte displayX, byte displayY){
        if (registry.findInSpace(displayX, displayY) != null){
            return;
        }
        this.player.changePosition(this.displayX, this.displayY, displayX, displayY);
        this.x = x;
        this.y = y;
        this.displayY = displayY;
        this.displayX = displayX;
        this.player.displayYPosition = displayY;
        this.player.displayXPosition = displayX;
    }
    private void movePosition(int changeX, int changeY){
        byte tempDisplayX = this.displayX;
        byte tempDisplayY = this.displayY;
        byte tempToX;
        byte tempToY;
        if (!(this.displayX + changeX < 16 && this.displayX + changeX >= 0)){
            tempToX = this.displayX;
        } else {
            tempToX = (byte) (this.displayX + changeX);
        }
        if (!(this.displayY + changeY < 16 && this.displayY + changeY >= 0)){
            tempToY = this.displayY;
        } else {
            tempToY = (byte) (this.displayY + changeY);
        }
        if (registry.findInSpace(tempToX, tempToY) != null){
            return;
        }
        this.x += changeX;
        this.y += changeY;
        this.displayX = tempToX;
        this.displayY = tempToY;
        this.player.displayYPosition = this.displayY;
        this.player.displayXPosition = this.displayX;

        this.player.changePosition(tempDisplayX, tempDisplayY, tempToX, tempToY);
    }
    public void handleKeyPress(char key){
        switch (key){
            case 'w':
                movePosition(0, -1);
                break;
            case 'a':
                movePosition(-1, 0);
                break;
            case 's':
                movePosition(0, 1);
                break;
            case 'd':
                movePosition(1, 0);
                break;
        }
    }
    public void checkHealth(){
        if (health <= 0){
            handleDeath();
        }
    }
    public void handleDeath(){
        JOptionPane.showMessageDialog(registry.getWindow(),"You Died");
        registry.getWindow().close();
        System.exit(666);
    }
    public void changeHealth(short change){
        health += change;
    }
}
