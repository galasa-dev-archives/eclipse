/*
 * Copyright contributors to the Galasa project
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package dev.galasa.eclipse.ui.results;

import java.util.Objects;

public abstract class Branch {

    private final ResultsView view;

    public Branch(ResultsView view) {
        Objects.requireNonNull(view);
        this.view = view;
    }

    protected ResultsView getView() {
        return this.view;
    }

    public void load() {
    }

}
