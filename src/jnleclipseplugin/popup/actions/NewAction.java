package jnleclipseplugin.popup.actions;

import jnleclipseplugin.ui.JILui;

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class NewAction implements IObjectActionDelegate
{
    private static final String RAWXMLTOJIL = "Raw XML To JIL";
    private static final String RAWXMLTOMXML = "Raw XML To Massaged XML";
    private static final String MXMLTOJIL = "Massaged XML to JIL";
    private static final String DBTOJIL = "Database to JIL";
    
	private Shell shell;
	
	private String filePath;

	/**
	 * Constructor for Action1.
	 */
	public NewAction()
	{
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart)
	{
		shell = targetPart.getSite().getShell();

	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action)
	{
		/*
		 * MessageDialog.openInformation( shell, "JNLEclipse Plug-in",
		 * action.getText());
		 */
		
		JILui ui = new JILui(shell,action.getId());
		
		ui.open();

	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection)
	{
		IStructuredSelection isselection = (IStructuredSelection) selection;
		Object obj = isselection.getFirstElement();
		if (obj instanceof File)
		{
			filePath = ((File) obj).getFullPath().toOSString();

		}

	}

}
