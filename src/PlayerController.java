import javax.swing.*;
import java.awt.*;
public class PlayerController {
    private int x;
    private int y;
    private byte displayX;
    private byte displayY;
    private Player player;
    private OccupiedSpaceController occupiedSpace;
    public PlayerController(int x, int y, byte displayX, byte displayY, GameWindow window, OccupiedSpaceController occupiedSpace){
        this.x = x;
        this.y = y;
        this.displayX = displayX;
        this.displayY = displayY;
        this.player =  new Player((byte) displayX, (byte) displayY, window, occupiedSpace);
        this.occupiedSpace = occupiedSpace;
    }
    private void changePosition(int x, int y, byte displayX, byte displayY){
        if (this.occupiedSpace.find(displayX, displayY) != null){
            return;
        }
        this.player.changePosition(this.displayX, this.displayY, displayX, displayY);
        this.x = x;
        this.y = y;
        this.displayY = displayY;
        this.displayX = displayX;
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
        if (this.occupiedSpace.find(tempToX, tempToY) != null){
            return;
        }
        this.x += changeX;
        this.y += changeY;
        this.displayX = tempToX;
        this.displayY = tempToY;

        this.player.changePosition(tempDisplayX, tempDisplayY, tempToX, tempToY);
    }
    public void handleKeyPress(char key, OccupiedSpaceController occupiedSpace){
        switch (key){
            case 'w':
                movePosition(0,-1);
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
}
