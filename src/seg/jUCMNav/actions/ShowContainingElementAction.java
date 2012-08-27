package seg.jUCMNav.actions;

import java.util.List;

import grl.ActorRef;
import grl.IntentionalElementRef;

import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IWorkbenchPart;

import seg.jUCMNav.JUCMNavPlugin;
import seg.jUCMNav.actions.hyperlinks.HyperlinkUtils;
import seg.jUCMNav.model.commands.create.ShowContainingElementCommand;
import seg.jUCMNav.model.commands.create.ShowLinkedElementCommand;
import urn.URNspec;
import urncore.URNmodelElement;

/**
 * Action for showing containing element(s)
 * 
 * @author rouzbahan
 *
 */
public class ShowContainingElementAction extends URNSelectionAction
{
    public static final String SHOWCONTAININGELEMENT = "seg.jUCMNav.ShowContainingElementAction"; //$NON-NLS-1$
  
    private URNmodelElement element;
    private ActorRef elementRef;
    private URNspec urnspec;
    
    public ShowContainingElementAction(IWorkbenchPart part)
    {
        super(part);
      
        setId(SHOWCONTAININGELEMENT);
        setImageDescriptor(JUCMNavPlugin.getImageDescriptor("icons/ShowLinkedElement.gif")); //$NON-NLS-1$
    }
    
    /**
     * True if we have selected a valid URNmodelElement.
     */
    protected boolean calculateEnabled() 
    {
        List objects = getSelectedObjects();

        if (objects.size() != 1)
            return false;

        SelectionHelper sel = new SelectionHelper(objects);
        urnspec = sel.getUrnspec();
        
        //System.out.println("\nsel.getSelectionType is : " + sel.getSelectionType());
        
        //element = HyperlinkUtils.findURNmodelElement(sel);
        
        //System.out.println("\nsel.getSelectionType is : " + sel.getSelectionType());
        ///System.out.println("\nelement type is : " + element);
        
        if (sel.getSelectionType() == SelectionHelper.ACTOR)
        //if (element != null)
        {
            //elementRef = sel.getActorref();
            element = sel.getActor();
            elementRef = (ActorRef) HyperlinkUtils.findURNmodelElement(sel);
            System.out.println("\nelement type is : " + element);
            System.out.println("elementRef type is : " + elementRef);
            System.out.println("It is Enabled");
                return true;
        } 
        else
        {
            System.out.println("It is not Enabled");
                return false;
        }
    }
    
    /**
     * Trying to Add linked element to environment.
     * 
     */
    protected Command getCommand() 
    {
        return new ShowContainingElementCommand(urnspec, element, elementRef);            
    }
}
