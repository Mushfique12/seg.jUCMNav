/*
 * Created on Jun 10, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package seg.jUCMNav.views.stub;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListDialog;

import seg.jUCMNav.editors.UCMNavMultiPageEditor;
import ucm.map.Map;
import ucm.map.PluginBinding;

/**
 * @author TremblaE
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class PluginListDialog extends ListDialog {

	private List input;
	private UCMNavMultiPageEditor editor;


	/**
	 * @param parent
	 * @param editor
	 */
	public PluginListDialog(Shell parent, UCMNavMultiPageEditor editor) {
		super(parent);
		setShellStyle(SWT.TOOL | SWT.BORDER);
		this.setContentProvider(new PluginContentProvider());
    	this.setLabelProvider(new MapLabelProvider());
    	this.editor = editor;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.ListDialog#setInput(java.lang.Object)
	 */
	public void setInput(Object input) {
		this.input = (List)input;
		super.setInput(input);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createDialogArea(Composite container) {
		container.setBackground(new Color(null, 255, 255, 255));
		setWidthInChars(30);
		if(input != null)
			setHeightInChars(input.size());
		else
			setHeightInChars(10);
		Control toReturn = super.createDialogArea(container);
		toReturn.setBackground(new Color(null, 255, 255, 255));
		getTableViewer().getControl().setBackground(new Color(null, 235, 235, 235));
		return toReturn;
	}
	
	protected Control createButtonBar(Composite parent) {
		return parent;
	}
	
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	protected void okPressed() {
		IStructuredSelection selection = (IStructuredSelection) getTableViewer().getSelection();
		Map map = ((PluginBinding)selection.toList().get(0)).getPlugin();
        if (map != null)
            editor.setActivePage(map);
        
		super.okPressed();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
	 */
	protected void createButtonsForButtonBar(Composite parent) {
		parent.setVisible(false);
//		super.createButtonsForButtonBar(parent);
//		parent.setBackground(new Color(null, 255, 255, 255));
//		parent.getParent().setBackground(new Color(null, 255, 255, 255));
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.SelectionDialog#createMessageArea(org.eclipse.swt.widgets.Composite)
	 */
	protected Label createMessageArea(Composite composite) {
		Label toReturn = super.createMessageArea(composite);
		toReturn.setBackground(new Color(null, 255, 255, 255));
		return toReturn;
	}
}
