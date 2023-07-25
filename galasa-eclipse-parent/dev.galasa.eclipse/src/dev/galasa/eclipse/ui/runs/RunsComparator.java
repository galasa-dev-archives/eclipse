/*
 * Copyright contributors to the Galasa project
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package dev.galasa.eclipse.ui.runs;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

public class RunsComparator extends ViewerComparator {

    @Override
    public int compare(Viewer viewer, Object e1, Object e2) {

        if (e1 instanceof Run && e2 instanceof Run) {
            return ((Run) e2).getQueued().compareTo(((Run) e1).getQueued());
        }

        return 0;
    }

    @Override
    public int category(Object element) {
        return 0;
    }

    @Override
    public boolean isSorterProperty(Object element, String property) {
        return false;
    }

}
