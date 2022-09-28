/*
 * Copyright contributors to the Galasa project
 */
package dev.galasa.zos3270.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import dev.galasa.zos3270.ui.Zos3270Activator;

public class Zos3270PreferencesInitialiser  extends AbstractPreferenceInitializer {

    @Override
    public void initializeDefaultPreferences() {
        
        IPreferenceStore store = Zos3270Activator.getDefault().getPreferenceStore();
        
        store.setDefault(PreferenceConstants.P_BACKGROUND_COLOUR, "0, 0, 0");
        store.setDefault(PreferenceConstants.P_NORMAL_COLOUR, "0, 204, 0");
        store.setDefault(PreferenceConstants.P_INTENSE_COLOUR, "255, 255, 255");
        
        store.setDefault(PreferenceConstants.P_DEFAULT_COLOUR, "36, 216, 48");
        store.setDefault(PreferenceConstants.P_BLUE_COLOUR, "0, 0, 204");
        store.setDefault(PreferenceConstants.P_RED_COLOUR, "240, 24, 24");
        store.setDefault(PreferenceConstants.P_PINK_COLOUR, "255, 0, 255");
        store.setDefault(PreferenceConstants.P_GREEN_COLOUR, "36, 216, 48");
        store.setDefault(PreferenceConstants.P_TURQUOISE_COLOUR, "88, 240, 240");
        store.setDefault(PreferenceConstants.P_YELLOW_COLOUR, "255, 255, 0");
        store.setDefault(PreferenceConstants.P_NEUTRAL_COLOUR, "255, 255, 255");
        
        store.setDefault(PreferenceConstants.P_LOG_CONSOLE, true);
        store.setDefault(PreferenceConstants.P_LIVE_TERMINALS, true);
    }

}
