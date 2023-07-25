/*
 * Copyright contributors to the Galasa project
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package dev.galasa.eclipse.ui.run.storedartifacts;

public interface IStoredArtifactsFilter {

    void filter(String runId, IArtifact rootArtifact);

}
