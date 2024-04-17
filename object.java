import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class object implements MouseListener {
    int blockValue;
    Color color;
    int width;
    int height = 50;
    int x = 0;
    int y = 0;
    boolean holding = false;
    

    object() {
        Random rand = new Random();
        blockValue = rand.nextInt(50);

        if (blockValue < 11) {
            color = Color.red;
            width = 25;
        } else if (blockValue < 21) {
            color = Color.blue;
            width = 30;
        } else if (blockValue < 31) {
            color = Color.green;
            width = 40;
        } else if (blockValue < 41) {
            color = Color.yellow;
            width = 45;
        } else {
            color = Color.orange;
            width = 55;
        }
    }

    public int getBlockValue() {
        return blockValue;
    }

    public Color getColor() {
        return color;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("mouse clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }
}
