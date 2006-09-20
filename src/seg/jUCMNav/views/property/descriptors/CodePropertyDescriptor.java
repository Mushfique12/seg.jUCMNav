package seg.jUCMNav.views.property.descriptors;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.PropertyDescriptor;

import seg.jUCMNav.Messages;
import urncore.Condition;
import urncore.Responsibility;

/**
 * A property descriptor that opens the CodeCellEditor.
 * 
 * @author jkealey
 * @see seg.jUCMNav.views.property.descriptors.CodeCellEditor
 */
public class CodePropertyDescriptor extends PropertyDescriptor {
	
	// one of these is passed. 
    private Responsibility resp;
    private Condition cond;

    /**
     * Property descriptor for a responsibility. 
     * 
     * @param id the PropertyID
     * @param resp the responsibility
     */
    public CodePropertyDescriptor(Object id, Responsibility resp) {
        super(id, Messages.getString("CodePropertyDescriptor.code")); //$NON-NLS-1$
        this.resp = resp;
        setLabelProvider(new LabelProvider() {
            public String getText(Object element) {
                return Messages.getString("CodePropertyDescriptor.ClickToEdit");  //$NON-NLS-1$
            }
        });
    }

    /**
     * Property descriptor for a condition
     * 
     * @param id the PropertyID
     * @param condition the condition
     */
    public CodePropertyDescriptor(Object id, Condition condition) {
        super(id, Messages.getString("CodePropertyDescriptor.expression")); //$NON-NLS-1$
        this.cond = condition;
        setLabelProvider(new LabelProvider() {
            public String getText(Object element) {
                return Messages.getString("CodePropertyDescriptor.ClickToEdit");  //$NON-NLS-1$
            }
        });
    }
    
    /**
     * Creates the cell editor. 
     */
    public CellEditor createPropertyEditor(Composite parent) {
    	CodeCellEditor editor = new CodeCellEditor(parent);
    	if (resp!=null)
    		editor.setResponsibility(resp);
    	else
    		editor.setCondition(cond);
        return editor;
    }
}