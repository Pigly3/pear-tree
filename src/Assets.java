import javax.swing.*;
import java.awt.Image;
public class Assets {
    ImageIcon grapevine;
    ImageIcon spawner;
    ImageIcon monster;
    ImageIcon player;
    ImageIcon ground;
    Assets() {
        //Grapevine
        ImageIcon grapevineIcon = new ImageIcon(getClass().getResource("/assets/grapevine.png"));
        Image grapevineImg = grapevineIcon.getImage();
        this.grapevine = new ImageIcon(grapevineImg.getScaledInstance(48,48, Image.SCALE_SMOOTH));
        ImageIcon spawnerIcon = new ImageIcon(getClass().getResource("/assets/spawner.png"));
        Image spawnerImg = spawnerIcon.getImage();
        this.spawner = new ImageIcon(spawnerImg.getScaledInstance(48,48, Image.SCALE_SMOOTH));
        ImageIcon monsterIcon = new ImageIcon(getClass().getResource("/assets/monster.png"));
        Image monsterImg = monsterIcon.getImage();
        this.monster = new ImageIcon(monsterImg.getScaledInstance(48,48, Image.SCALE_SMOOTH));
        ImageIcon playerIcon = new ImageIcon(getClass().getResource("/assets/player.png"));
        Image playerImg = playerIcon.getImage();
        this.player = new ImageIcon(playerImg.getScaledInstance(48,48, Image.SCALE_SMOOTH));
        ImageIcon groundIcon = new ImageIcon(getClass().getResource("/assets/ground.png"));
        Image groundImg = groundIcon.getImage();
        this.ground = new ImageIcon(groundImg.getScaledInstance(48,48, Image.SCALE_SMOOTH));
    }
}
