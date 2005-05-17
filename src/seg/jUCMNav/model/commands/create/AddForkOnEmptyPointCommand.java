package seg.jUCMNav.model.commands.create;

import org.eclipse.gef.commands.Command;

import seg.jUCMNav.model.ModelCreationFactory;
import seg.jUCMNav.model.commands.JUCMNavCommand;
import seg.jUCMNav.model.util.ParentFinder;
import ucm.map.EmptyPoint;
import ucm.map.EndPoint;
import ucm.map.Map;
import ucm.map.NodeConnection;
import ucm.map.PathGraph;
import ucm.map.PathNode;
import urn.URNspec;

/**
 * @author jpdaigle
 *  
 */
public class AddForkOnEmptyPointCommand extends Command implements JUCMNavCommand {
    // Where to create the Fork
    PathGraph _pg;

    EmptyPoint _originEp;

    // New items
    PathNode _newFork;

    EmptyPoint _newEmptyPoint;

    EndPoint _newEndPoint;

    NodeConnection _newLink1, _newLink2, _ncPred, _ncTarg;

    NodeConnection _originNc;

    PathNode _prevNode, _nextNode;

    int _posX, _posY;

    /**
     *  
     */
    public AddForkOnEmptyPointCommand() {
        super();
        this.setLabel("Add Fork");
    }

    public AddForkOnEmptyPointCommand(PathNode newFork, PathGraph pg, EmptyPoint ep) {
        _newFork = newFork;
        _pg = pg;
        _originEp = ep;
        this.setLabel("Add Fork");
    }

    /**
     * @param label
     */
    public AddForkOnEmptyPointCommand(String label) {
        super(label);
        // TODO Auto-generated constructor stub
    }

    public boolean canExecute() {
        return super.canExecute();
    }

    public void execute() {
        if (_originEp != null && _pg != null) {
            int x, y;
            x = _originEp.getX();
            y = _originEp.getY();

            assert (_originEp.getPred().size() > 0);
            assert (_originEp.getSucc().size() > 0);

            // Fork -- EmptyPoint -- EndPoint
            _newFork.setX(x);
            _newFork.setY(y);

            _newEmptyPoint = (EmptyPoint) ModelCreationFactory.getNewObject((URNspec) _pg.eContainer().eContainer()
                    .eContainer(), EmptyPoint.class);
            _newEmptyPoint.setX(x + 25);
            _newEmptyPoint.setY(y - 25);

            _newLink1 = (NodeConnection) ModelCreationFactory.getNewObject((URNspec) _pg.eContainer().eContainer()
                    .eContainer(), NodeConnection.class);

            _newEndPoint = (EndPoint) ModelCreationFactory.getNewObject((URNspec) _pg.eContainer().eContainer()
                    .eContainer(), EndPoint.class);
            _newEndPoint.setX(x + 75);
            _newEndPoint.setY(y - 30);

            _newLink2 = (NodeConnection) ModelCreationFactory.getNewObject((URNspec) _pg.eContainer().eContainer()
                    .eContainer(), NodeConnection.class);

            // TODO Add an empty point *ON* the connection going towards the
            // EndPoint

            redo();
        }
    }

    public void redo() {
        // Path modifications
        _ncPred = (NodeConnection) _originEp.getPred().get(0);
        _ncTarg = (NodeConnection) _originEp.getSucc().get(0);
        _ncPred.setTarget(_newFork);
        _ncTarg.setSource(_newFork);
        _newLink1.setSource(_newFork);
        _newLink1.setTarget(_newEmptyPoint);
        _newLink2.setSource(_newEmptyPoint);
        _newLink2.setTarget(_newEndPoint);

        // Add to model
        _pg.getNodeConnections().add(_newLink1);
        _pg.getNodeConnections().add(_newLink2);
        _pg.getPathNodes().add(_newFork);
        _pg.getPathNodes().add(_newEmptyPoint);
        _pg.getPathNodes().add(_newEndPoint);

        // Delete old node
        _pg.getPathNodes().remove(_originEp);
        _originEp.setCompRef(null);
        //_originEp = null;

        // bind to parent
        _newFork.setCompRef(ParentFinder.findParent((Map) _pg.eContainer(), _newFork.getX(), _newFork.getY()));
        _newEmptyPoint.setCompRef(ParentFinder.findParent((Map) _pg.eContainer(), _newEmptyPoint.getX(), _newEmptyPoint
                .getY()));
        _newEndPoint.setCompRef(ParentFinder.findParent((Map) _pg.eContainer(), _newEndPoint.getX(), _newEndPoint
                .getY()));
    }

    public void undo() {
        // Path modifications
        _ncPred.setTarget(_originEp);
        _ncTarg.setSource(_originEp);

        _newLink1.setSource(null);
        _newLink1.setTarget(null);
        _newLink2.setSource(null);
        _newLink2.setTarget(null);

        // Remove from model
        _pg.getNodeConnections().remove(_newLink1);
        _pg.getNodeConnections().remove(_newLink2);
        _pg.getPathNodes().remove(_newFork);
        _pg.getPathNodes().remove(_newEmptyPoint);
        _pg.getPathNodes().remove(_newEndPoint);

        // Re-add old node
        _pg.getPathNodes().add(_originEp);
        _originEp.setCompRef(ParentFinder.findParent((Map) _pg.eContainer(), _originEp.getX(), _originEp.getY()));

        // unbind from parent
        _newFork.setCompRef(null);
        _newEmptyPoint.setCompRef(null);
        _newEndPoint.setCompRef(null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see seg.jUCMNav.model.commands.JUCMNavCommand#testPreConditions()
     */
    public void testPreConditions() {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see seg.jUCMNav.model.commands.JUCMNavCommand#testPostConditions()
     */
    public void testPostConditions() {
        // TODO Auto-generated method stub

    }

}