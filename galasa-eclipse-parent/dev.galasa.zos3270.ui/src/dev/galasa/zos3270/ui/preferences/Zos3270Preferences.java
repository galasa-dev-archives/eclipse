/*
 * Copyright contributors to the Galasa project
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package dev.galasa.zos3270.ui.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import dev.galasa.zos3270.ui.Zos3270Activator;

public class Zos3270Preferences extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    private BooleanFieldEditor liveTerminals;
    private BooleanFieldEditor logConsole;
    private ColorFieldEditor backgroundColour;
    private ColorFieldEditor normalColour;
    private ColorFieldEditor intenseColour;

    private ColorFieldEditor defaultColour;
    private ColorFieldEditor blueColour;
    private ColorFieldEditor redColour;
    private ColorFieldEditor pinkColour;
    private ColorFieldEditor greenColour;
    private ColorFieldEditor turquoiseColour;
    private ColorFieldEditor yellowColour;
    private ColorFieldEditor neutralColour;

    
    public Zos3270Preferences() {
        super(GRID);

        IPreferenceStore store = Zos3270Activator.getDefault().getPreferenceStore();

        setPreferenceStore(store);
        setDescription("Galasa z/OS 3270 Preferences");

        store.addPropertyChangeListener(this);
    }

    @Override
    public void init(IWorkbench arg0) {
    }

    @Override
    protected void createFieldEditors() {
        liveTerminals = new BooleanFieldEditor(PreferenceConstants.P_LIVE_TERMINALS, "Use live terminal views", getFieldEditorParent());
        logConsole = new BooleanFieldEditor(PreferenceConstants.P_LOG_CONSOLE, "Log terminal images to console", getFieldEditorParent());
        backgroundColour = new ColorFieldEditor(PreferenceConstants.P_BACKGROUND_COLOUR, "Background Colour", getFieldEditorParent());
        normalColour = new ColorFieldEditor(PreferenceConstants.P_NORMAL_COLOUR, "Normal Text Colour", getFieldEditorParent());
        intenseColour = new ColorFieldEditor(PreferenceConstants.P_INTENSE_COLOUR, "Intense Text Colour", getFieldEditorParent());

        defaultColour = new ColorFieldEditor(PreferenceConstants.P_DEFAULT_COLOUR, "Default Colour", getFieldEditorParent());
        blueColour = new ColorFieldEditor(PreferenceConstants.P_BLUE_COLOUR, "Blue Colour", getFieldEditorParent());
        redColour = new ColorFieldEditor(PreferenceConstants.P_RED_COLOUR, "Red Colour", getFieldEditorParent());
        pinkColour = new ColorFieldEditor(PreferenceConstants.P_PINK_COLOUR, "Pink Colour", getFieldEditorParent());
        greenColour = new ColorFieldEditor(PreferenceConstants.P_GREEN_COLOUR, "Green Colour", getFieldEditorParent());
        turquoiseColour = new ColorFieldEditor(PreferenceConstants.P_TURQUOISE_COLOUR, "Turquoise Colour", getFieldEditorParent());
        yellowColour = new ColorFieldEditor(PreferenceConstants.P_YELLOW_COLOUR, "Yellow Colour", getFieldEditorParent());
        neutralColour = new ColorFieldEditor(PreferenceConstants.P_NEUTRAL_COLOUR, "Neutral Colour", getFieldEditorParent());

        
        addField(liveTerminals);
        addField(logConsole);
        addField(backgroundColour);
        addField(normalColour);
        addField(intenseColour);
        addField(defaultColour);
        addField(blueColour);
        addField(redColour);
        addField(pinkColour);
        addField(greenColour);
        addField(turquoiseColour);
        addField(yellowColour);
        addField(neutralColour);
    }

}
