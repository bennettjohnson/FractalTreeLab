import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.geom.Point2D;
/**
 * Draws a Fractal Tree in a new JFrame
 * 
 * @author (Bennett Johnson)
 * @version (v0.1a)
 */
public class FractalTree extends JFrame {
    //Private variables
    Color color;
    
    int boundsX1 = 100;
    int boundsY1 = 100;
    int boundsX2 = 800;
    int boundsY2 = 600;
    
    int initX = 400;
    int initY = 500;
    int depth = 15;
    double angle = -90;
    
    boolean isResizable = false;
    
    /**
     * Constructor for objects of classFractalTree
     */
    public FractalTree() {
        super("Fractal Tree");
        setBounds(this.boundsX1, this.boundsY1, this.boundsX2, this.boundsY2);
        setResizable(this.isResizable);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    /**
     * Draws fractal tree with parameters set by user.
     * 
     * @param   g       Graphics object from content pane
     * @param   x1      Initial X coordinate value
     * @param   y1      Initial Y coordinate value
     * @param   angle   Initial angle
     * @param   depth   Level Of Detail for Tree
     */
    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        if (depth == 0) return;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 4.0);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 4.0);
        
        this.color = new Color(0, 255 - (int)Math.abs(angle / 2), (int)(Math.abs(angle)/1.5));
        g.setColor(this.color);
        
        g.drawLine(x1, y1, x2, y2);
        drawTree(g, x2, y2, angle - 20, depth - 1);
        drawTree(g, x2, y2, angle + 10, depth - 1);
    }
    /**
     * Paint method that paints the Fractal tree with a specific color
     * 
     * @param   g   Graphics object from content pane
     */
    @Override
    public void paint(Graphics g) {
        drawTree(g, this.initX, this.initY, this.angle, this.depth);
    }
    /**
     * Main method that runs FratcalTree
     */
    public static void main(String[] args) {
        new FractalTree().setVisible(true);
    }
}