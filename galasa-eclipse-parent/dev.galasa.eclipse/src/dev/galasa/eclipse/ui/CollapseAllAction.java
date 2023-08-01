/*
 * Copyright contributors to the Galasa project
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package dev.galasa.eclipse.ui;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class CollapseAllAction extends Action {

    private final ICollapseAllListener listener;

    public CollapseAllAction(ICollapseAllListener listener) {
        super("Collapse All",
                PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_COLLAPSEALL));
        this.listener = listener;
    }

    @Override
    public void run() {
        listener.collapseAll();
    }

}
