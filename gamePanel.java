import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.FontMetrics;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseListener;
import java.awt.MouseInfo;

import javax.swing.Timer;

public class gamePanel extends JPanel implements MouseListener, ActionListener{
    static final int SCREEN_WIDTH = 900;
    static final int SCREEN_HEIGHT = 700;
    boolean running = false;
    Timer timer;
    Integer level = 1;
    List<object> list;
    int goalNumber;
    boolean finding;
    boolean clicked = false;
    boolean singleHold = false;

    gamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.gray);
        this.setFocusable(true);
        this.addKeyListener(new mykeyAdapter());
        this.addMouseListener(this);
        startGame();
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }

    public void startGame() {
        int blockweightx = 0;
        running = true;
        finding = true;
        int numOfBlocks = blockNumber();
        int startHeight = (SCREEN_HEIGHT/4)*3;



        //emptying the list of blocks and resetting the goal number each time startGame is called
        list = new ArrayList<object>();
        goalNumber = 0;

        // creating all the blocks and goal number
        while (finding) {
            for (int i = 1; i < (numOfBlocks+1); i++) {
                object block = new object();

                //creating intial draw coordinates for the blocks
                block.x = (i*20) + blockweightx;
                block.y = (SCREEN_HEIGHT/4)*3 + 20;
                blockweightx += block.getWidth();
                System.out.println("blockx: " + block.x);

                goalNumber += block.getBlockValue();
                list.add(block);
            }
            if (goalNumber % 2 == 0) {
                finding = false;
            } else {
                list.clear();
                blockweightx = 0;
                goalNumber = 0;
            }
        }
        //System.out.println(MouseInfo.getPointerInfo().getLocation().x + " " + MouseInfo.getPointerInfo().getLocation().y);
    }

    public void update() {
        int mousePosX = getMousePosition().x;
        int mousePosY = getMousePosition().y;

        for (object block : list) {
            if (mousePosX > block.x && mousePosX < block.x + block.getWidth() && mousePosY > block.y && mousePosY < block.y + block.getHeight()){
                if (clicked && singleHold == false) {
                    System.out.println("mouse is on block");
                    block.holding = true;
                    singleHold = true;
                }
            }
        
            if (block.holding && clicked) {
                    block.x = mousePosX - (block.getWidth() / 2);
                    block.y = mousePosY - (block.getHeight() / 2);
            }
        }
    }

    public void draw(Graphics g) {
        update();
        g.setColor(Color.white);
        g.drawLine(0, (SCREEN_HEIGHT/4)*3, SCREEN_WIDTH, (SCREEN_HEIGHT/4)*3);
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        String text;

        for (int i = 0; i < list.size(); i++) {
            object block = list.get(i);

            //drawing the shape of the blocks
            g.setColor(block.getColor());
            g.fillRect(block.x, block.y, block.getWidth(), 50);
            g.setColor(Color.black);
            g.drawRect(block.x, block.y, block.getWidth(), 50);

            //drawing the blockvalues ontop of the blocks 
            text = Integer.toString(block.getBlockValue());
            g.setColor(Color.black);
            g.drawString(text, (block.x + (block.getWidth() / 2)) - (metrics.stringWidth(text) / 2), (block.y + (block.getHeight() / 2) + metrics.getHeight() / 2));
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public int blockNumber() {
        int startNum = 5;
        int bonusNum = (level/5);
        return startNum + bonusNum;
    }

    public class mykeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        clicked = false;
        singleHold = false;
        System.out.println("mouse released");
        for (object block : list) {
            block.holding = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mouse pressed");
        clicked = true;
    }
}
