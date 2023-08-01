/*
 * Copyright contributors to the Galasa project
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package dev.galasa.eclipse.ui;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class ExpandAllAction extends Action {

    private final IExpandAllListener listener;

    public ExpandAllAction(IExpandAllListener listener) {
        super("Collapse All",
                PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_ADD));
        this.listener = listener;
    }

    @Override
    public void run() {
        listener.expandAll();
    }

}
