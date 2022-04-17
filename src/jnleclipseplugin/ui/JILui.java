package jnleclipseplugin.ui;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class JILui extends Dialog
{

	private static final int RESET_ID = IDialogConstants.NO_TO_ALL_ID + 1;

	private Text environmentField;

	private Text databaseField;
	
	
	private String actionId;

	public JILui(Shell shell, String actionId)
	{
		super(shell);
		super.setBlockOnOpen(true);
		this.actionId = actionId;
		// TODO Auto-generated constructor stub
	}

	protected Control createDialogArea(Composite parent)
	{
		parent.getShell().setText("JIL Tools");
		Composite comp = (Composite) super.createDialogArea(parent);
		
		GridLayout layout = (GridLayout) comp.getLayout();
		layout.numColumns = 2;

		Label envLabel = new Label(comp, SWT.RIGHT);
		envLabel.setText("Environment{D1,D2..M1..P1}: ");

		environmentField = new Text(comp, SWT.SINGLE);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		environmentField.setLayoutData(data);

		Label databaseLabel = new Label(comp, SWT.RIGHT);
		databaseLabel.setText("Database{M=Model,P=Production}: ");

		databaseField = new Text(comp, SWT.SINGLE);
		data = new GridData(GridData.FILL_HORIZONTAL);
		databaseField.setLayoutData(data);
		
		new Button(comp,SWT.CHECK).setText("Include Delte Jobs");
		

		return comp;
	}

	protected void createButtonsForButtonBar(Composite parent)
	{
		super.createButtonsForButtonBar(parent);
		createButton(parent, RESET_ID, "Reset All", false);
	}

	protected void buttonPressed(int buttonId)
	{
		if (buttonId == RESET_ID)
		{
			databaseField.setText("");
			environmentField.setText("");
		} else if(buttonId == IDialogConstants.OK_ID)
		{
			this.close();
			MessageConsole myConsole = findConsole("Console");
			   MessageConsoleStream out = myConsole.newMessageStream();
			   out.setColor(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
			   out.println("Hello from Generic console sample action");

		}
		else
		{
			this.close();
		}
	}
	
	private MessageConsole findConsole(String name) {
	      ConsolePlugin plugin = ConsolePlugin.getDefault();
	      IConsoleManager conMan = plugin.getConsoleManager();
	      IConsole[] existing = conMan.getConsoles();
	      for (int i = 0; i < existing.length; i++)
	         if (name.equals(existing[i].getName()))
	            return (MessageConsole) existing[i];
	      //no console found, so create a new one
	      MessageConsole myConsole = new MessageConsole(name, null);
	      conMan.addConsoles(new IConsole[]{myConsole});
	      return myConsole;
	   }


}
