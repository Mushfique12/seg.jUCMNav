/**
 * 
 */
package seg.jUCMNav.model.commands.delete;

import java.util.Iterator;

import org.eclipse.gef.commands.CompoundCommand;

import seg.jUCMNav.model.commands.delete.internal.RemoveScenarioCommand;
import ucm.scenario.ScenarioDef;
import ucm.scenario.ScenarioEndPoint;
import ucm.scenario.ScenarioStartPoint;
import urncore.Condition;

/**
 * This command delete a scenario. It generate command to delete 
 * all initializations, pre-conditions, post-conditions, relations with parent scenarios and delete the scenario after.
 * 
 * @author jkealey
 *
 */
public class DeleteScenarioCommand extends CompoundCommand {

	private ScenarioDef scenario;
    public DeleteScenarioCommand(ScenarioDef scenario) {
        setLabel("Delete Scenario");  
        

        for (Iterator iter = scenario.getIncludedScenarios().iterator(); iter.hasNext();) {
			ScenarioDef child = (ScenarioDef) iter.next();
			add(new DeleteIncludedScenarioCommand(scenario, child));
		}
        for (Iterator iter = scenario.getParentScenarios().iterator(); iter.hasNext();) {
			ScenarioDef parent = (ScenarioDef) iter.next();
			add(new DeleteIncludedScenarioCommand(parent, scenario));
		}   
        
        for (Iterator iter = scenario.getPreconditions().iterator(); iter.hasNext();) {
			Condition condition = (Condition) iter.next();
			add(new DeleteScenarioConditionCommand(condition));
		}
        
        for (Iterator iter = scenario.getPostconditions().iterator(); iter.hasNext();) {
			Condition condition = (Condition) iter.next();
			add(new DeleteScenarioConditionCommand(condition));
		}
        
        for (Iterator iter = scenario.getStartPoints() .iterator(); iter.hasNext();) {
        	ScenarioStartPoint pt = (ScenarioStartPoint) iter.next();
			add(new DeleteScenarioPathNodeCommand(pt));
		}   

        for (Iterator iter = scenario.getEndPoints() .iterator(); iter.hasNext();) {
        	ScenarioEndPoint pt = (ScenarioEndPoint) iter.next();
			add(new DeleteScenarioPathNodeCommand(pt));
		}
        
        // TODO: delete initializations. 
        
        add(new RemoveScenarioCommand(scenario));
        this.scenario = scenario;
        
        
    }


}
