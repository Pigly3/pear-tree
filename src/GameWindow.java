import javax.swing.*;
public class Display extends JFrame{
    Display() {
        this.setTitle("Pear Tree: Awakening");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1024,1024);
        ImageIcon icon = new ImageIcon("/assets/logo.png");
        this.setIconImage(icon.getImage());
        this.setVisible(true);
    }
}
