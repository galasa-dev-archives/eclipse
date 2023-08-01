/*
 * Copyright contributors to the Galasa project
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package dev.galasa.eclipse.launcher.tabs;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.widgets.Composite;

public interface IConfigurationGroups {

    void createControl(IConfigurationTab tab, Composite parent);

    void setDefaults(ILaunchConfigurationWorkingCopy config);

    void initializeFrom(ILaunchConfiguration config);

    void performApply(ILaunchConfigurationWorkingCopy configuration);

    boolean validatePage();
}
