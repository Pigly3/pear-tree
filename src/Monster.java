import javax.swing.*;
import java.awt.Container;
public class Monster {
    private JLabel monster;
    Monster(byte screenX, byte screenY, GameWindow frame, OccupiedSpaceController occupiedSpace){
        if (screenX >= 16 || screenY >= 16){
            return;
        }
        occupiedSpace.occupySpace(this, screenX, screenY);
        Assets assets = new Assets();
        Container contentPane = frame.getContentPane();
        JLabel monster = new JLabel();
        monster.setAlignmentX(SwingConstants.LEFT);
        monster.setBounds(48*screenX, 48*screenY,48,48);
        monster.setIcon(assets.monster);
        contentPane.add(monster);
        contentPane.setComponentZOrder(monster, 1);
        this.monster = monster;
    }
    public JLabel getMonster(){
        return this.monster;
    }
}
