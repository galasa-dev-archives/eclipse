/*
 * Copyright contributors to the Galasa project
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package dev.galasa.eclipse.launcher;

import java.util.Properties;

import org.eclipse.debug.core.ILaunchConfiguration;

public interface ILauncherOverridesExtension {

    void appendOverrides(ILaunchConfiguration configuration, Properties generatedOverrides);

}
