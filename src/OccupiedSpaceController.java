import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
public class OccupiedSpaceController {
    private Object[][] rows;
    OccupiedSpaceController(){
        this.rows = new Object[16][16];
    }

    public void occupySpace(Object item, byte x, byte y){
        this.rows[x][y] = item;
    }

    public void deoccupySpace(byte x, byte y){
        this.rows[x][y] = null;
    }

    public void moveItemInSpace(byte fromX, byte fromY, byte toX, byte toY){
        Object temp = this.rows[fromX][fromY];
        deoccupySpace(fromX, fromY);
        occupySpace(temp, toX, toY);
    }

    public Object find(byte x, byte y){
        return this.rows[x][y];
    }
}
