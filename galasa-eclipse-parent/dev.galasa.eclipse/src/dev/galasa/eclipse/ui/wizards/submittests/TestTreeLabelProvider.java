/*
 * Copyright contributors to the Galasa project
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package dev.galasa.eclipse.ui.wizards.submittests;

import org.eclipse.jface.viewers.LabelProvider;

/**
 * Provides the labels for the Notification tree nodes
 * 
 * @author Michael Baylis
 *
 */
public class TestTreeLabelProvider extends LabelProvider {

    @Override
    public String getText(Object element) {
//		if (element instanceof TestCatalog) {
//			return "Test Catalog"; 
//		}
//		if (element instanceof TestCollection) {
//			TestCollection tc = (TestCollection) element;
//			return tc.label;
//		}
//		if (element instanceof TestClass) {
//			TestClass tc = (TestClass) element;
//			if (tc.summary != null) {
//				return tc.shortName + " - " + tc.summary;
//			}
//			
//			return tc.shortName; 
//		}

        return super.getText(element);
    }

}
