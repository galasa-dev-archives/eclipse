/*
 * Copyright contributors to the Galasa project
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package dev.galasa.eclipse.ui.runs;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import dev.galasa.eclipse.Activator;
import dev.galasa.framework.spi.IFramework;

public class ResetRunJob extends Job {
	
	private final Run run;
	
	public ResetRunJob(Run run) {
		super("Reset run " + run.getRunName());
		
		this.run = run;
	}

	@Override
	protected IStatus run(IProgressMonitor arg0) {
		
		try {
			IFramework framework = Activator.getInstance().getFramework();
			
			if (!framework.isInitialised()) {
				return new Status(Status.CANCEL, Activator.PLUGIN_ID, getName() + " - framework not initialised");
			}
		
			framework.getFrameworkRuns().reset(this.run.getRunName());
		
		} catch(Exception e) {
			return new Status(Status.ERROR, Activator.PLUGIN_ID, getName() + " failed", e);
		}
		
		return new Status(Status.OK, Activator.PLUGIN_ID, getName() + " job ended ok");
	}

}
