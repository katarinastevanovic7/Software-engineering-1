import javax.swing.*;
import java.awt.*;

/**
 * Simple 2D canvas with line and circle drawing methods
 *
 * @author Johannes C. Schneider
 */
public class Draw extends JPanel {

    //Implement your drawing inside the draw() method (which can call additional methods).
    //drawLine(...) and drawCircle(...) can be used to actually add something to the canvas.
    //With setColor(...), you can change the default color blue to another color.
    //The canvas has 20x20 virtual units (which are converted to pixels by multiplying with SCALING)
    //Note that (unlike coordinate systems in school), the TOP LEFT corner is (0,0), and x goes
    //to the right and y to the bottom.
    void draw() {
        drawLine(1, 1, 1, 5);
        drawLine(3, 3, 5, 5);
        drawCircle(10, 10, 5);
    }

    //DON'T CHANGE THE CODE BELOW THIS LINE

    //return an instance of this class
    private static JPanel getThisClassInstance() {
        return new draw_intro.Draw();
    }

    private Graphics2D g2d;

    private static final int SCALING = 40;

    private void drawCircle(float x, float y, float r) {
        g2d.drawOval(Math.round((x - r) * SCALING), Math.round((y - r) * SCALING),
                Math.round(2 * r * SCALING), Math.round(2 * r * SCALING));
    }

    private void drawLine(float xFrom, float yFrom, float xDest, float yDest) {
        g2d.drawLine(Math.round(xFrom * SCALING), Math.round(yFrom * SCALING),
                Math.round(xDest * SCALING), Math.round(yDest * SCALING));
    }

    private void setColor(Color color) {
        g2d.setColor(color);
    }

    @Override
    public void paint(Graphics g) {
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(2.0f));
        draw();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing Area");
        frame.add(getThisClassInstance());
        frame.setSize(21 * SCALING, 22 * SCALING);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}