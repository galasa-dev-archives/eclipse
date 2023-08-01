/*
 * Copyright contributors to the Galasa project
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package dev.galasa.eclipse.ui;

public interface IPropertyListener {

    void propertyUpdate(PropertyUpdate propertyUpdate);

    void propertyUpdateComplete();

}
