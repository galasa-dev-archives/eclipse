/*
 * Copyright contributors to the Galasa project
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package dev.galasa.eclipse.ui.results;

import dev.galasa.framework.spi.IResultArchiveStoreDirectoryService;

public class BranchTestClassFolder extends BranchFolder {

    protected BranchTestClassFolder(ResultsView view, IResultArchiveStoreDirectoryService dirService) {
        super(view, dirService, Icon.none, 4);
    }

    @Override
    public String toString() {
        return "Runs by test class";
    }

    @Override
    public void dispose() {
    }

    @Override
    public void refresh() {
    }

}
