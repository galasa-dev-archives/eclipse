/*
 * Copyright contributors to the Galasa project
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package dev.galasa.eclipse.ui.runs;

import java.util.Iterator;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class DeleteRunAction implements IObjectActionDelegate {

	private IStructuredSelection selection;

	public void run(IAction action) {
		
		if (selection == null) {
			return;
		}
		
		Iterator<?> iterator = selection.iterator();
		while(iterator.hasNext()) {
			Object oSelected = iterator.next();
			if (oSelected instanceof Run) {
				Run selected = (Run)oSelected;
				new DeleteRunJob(selected).schedule();
			}
		}
		
		return;
	}

	public void selectionChanged(IAction action, ISelection selection) {
		
		if (selection instanceof IStructuredSelection) {
			this.selection = (IStructuredSelection) selection;
		} else {
			selection = null;
		}
		
		return;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}


}
