/*
 * Copyright contributors to the Galasa project
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package dev.galasa.eclipse.ui.run.storedartifacts;

import org.eclipse.ui.IWorkbenchPartSite;

public interface IArtifact {

    boolean hasChildren();

    IArtifact[] getChildren();

    IArtifact getChild(String childName);

    String getName();

    void doubleClick(IWorkbenchPartSite iWorkbenchPartSite);
}
