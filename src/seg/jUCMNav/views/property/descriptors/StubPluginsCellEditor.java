package seg.jUCMNav.views.property.descriptors;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import seg.jUCMNav.views.StubBindingsDialog;
import ucm.map.Stub;

/**
 * Created 2005-06-05
 * 
 * @author Etienne Tremblay
 */
public class StubPluginsCellEditor extends DialogCellEditor {
	
	private Stub stub;
	
	private Label defaultLabel;

	private CommandStack cmdStack;

	/**
	 * @param parent
	 */
	public StubPluginsCellEditor(Composite parent, CommandStack cmdStack) {
		super(parent);
		this.cmdStack = cmdStack;
	}

	/**
	 * @param parent
	 * @param style
	 */
	public StubPluginsCellEditor(Composite parent, int style) {
		super(parent, style);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.DialogCellEditor#openDialogBox(org.eclipse.swt.widgets.Control)
	 */
	protected Object openDialogBox(Control cellEditorWindow) {
		Shell shell = new Shell();
		StubBindingsDialog d = new StubBindingsDialog(shell, cmdStack);
		d.open(getStub());
		return null;
	}
	
	protected Stub getStub() {
		return stub;
	}

	public void setStub(Stub stub) {
		this.stub = stub;
	}

	protected Control createContents(Composite cell) {
		defaultLabel = new Label(cell, SWT.LEFT);
		defaultLabel.setFont(cell.getFont());
		defaultLabel.setBackground(cell.getBackground());
		return defaultLabel;
	}
	
	protected void updateContents(Object value) {
		defaultLabel.setText("");
	}

	protected Label getDefaultLabel() {
		return defaultLabel;
	}
}
