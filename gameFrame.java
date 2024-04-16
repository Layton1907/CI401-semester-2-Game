import javax.swing.JFrame;

/**
 * gameFrame
 */
public class gameFrame extends JFrame {
    gameFrame() {

        gamePanel panel = new gamePanel();
        this.add(panel);
        this.setTitle("game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}