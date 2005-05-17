/*
 * Created on 2005-03-04
 *
 */
package seg.jUCMNav.editpolicies.feedback;

import org.eclipse.gef.Request;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;

import seg.jUCMNav.editparts.NodeConnectionEditPart;
import seg.jUCMNav.figures.SplineConnection;

/**
 * Created 2005-03-04
 * 
 * On mouse hover of node connection, it becomes thicker so that we can click on it more easily.
 * 
 * @author jkealey
 */
public class NodeConnectionFeedbackEditPolicy extends GraphicalEditPolicy {

    /**
     *  
     */
    public NodeConnectionFeedbackEditPolicy() {
        super();
    }

    private SplineConnection getFigure() {
        return (SplineConnection) ((NodeConnectionEditPart) this.getHost()).getFigure();
    }

    public void eraseTargetFeedback(Request request) {
        getFigure().setLineWidth(3);
    }

    public void showTargetFeedback(Request request) {
        getFigure().setLineWidth(6);
    }
}