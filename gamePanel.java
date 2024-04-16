import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

public class gamePanel extends JPanel implements ActionListener{
    static final int SCREEN_WIDTH = 900;
    static final int SCREEN_HEIGHT = 700;
    boolean running = false;
    Timer timer;

    gamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new mykeyAdapter());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }

    public void startGame() {
        running = true;
        timer = new Timer(75, this);

    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.drawLine(0, (SCREEN_HEIGHT/4)*3, SCREEN_WIDTH, (SCREEN_HEIGHT/4)*3);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public class mykeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub
        }
    }
}
