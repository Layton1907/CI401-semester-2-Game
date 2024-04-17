import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;

public class object {
    int blockValue;
    Color color;
    int width;
    int height; 
    int x = 0;
    int y = 0;

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
}
