/**
 * 
 */
package seg.jUCMNav.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Figure that represent a belief in GRL
 * 
 * @author Jean-Fran�ois Roy
 *
 */
public class BeliefFigure extends GrlNodeFigure {
 
    // default sizes
    protected static int DEFAULT_HEIGHT = 50;
    protected static int DEFAULT_WIDTH = 100;
   
    /**
     * Override this method if your figure is not of the default size.
     * 
     * @return Returns the default dimension.
     * @see seg.jUCMNav.figures.util.JUCMNavFigure
     */
    public static Dimension getDefaultDimension() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
    
    /**
     * Constructor of the belief figure
     * the line style is in dash
     */
    public BeliefFigure() {
        super();
        setLineWidth(2);
        setLineStyle(Graphics.LINE_SOLID);
    }

    /* (non-Javadoc)
     * @see seg.jUCMNav.figures.GrlNodeFigure#outlineShape(org.eclipse.draw2d.Graphics)
     */
    protected void outlineShape(Graphics graphics) {
        Rectangle r = getBounds().getCopy();
        PointList points = new PointList();
        r.x += lineWidth / 2;
        r.y += lineWidth / 2;
        r.width -= lineWidth;
        r.height -= lineWidth;
        graphics.drawOval(r);
    }

    /* (non-Javadoc)
     * @see seg.jUCMNav.figures.GrlNodeFigure#fillShape(org.eclipse.draw2d.Graphics)
     */
    protected void fillShape(Graphics graphics) {
        Rectangle r = getBounds().getCopy();
        PointList points = new PointList();
        r.x += lineWidth / 2;
        r.y += lineWidth / 2;
        r.width -= lineWidth;
        r.height -= lineWidth;
        graphics.fillOval(r);

    }
}