/*
 * Copyright contributors to the Galasa project
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package dev.galasa.eclipse.ui.run.storedartifacts;

import java.util.ResourceBundle;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IFindReplaceTarget;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.texteditor.FindReplaceAction;
import org.eclipse.ui.texteditor.IAbstractTextEditorHelpContextIds;

import dev.galasa.framework.spi.IRunResult;
import dev.galasa.framework.spi.ResultArchiveStoreException;
import dev.galasa.framework.spi.teststructure.TestStructure;

public class ArtifactEditor extends EditorPart {

    public final static String  ID       = "dev.galasa.eclipse.ui.run.storedartifacts.ArtifactEditor";

    private ArtifactEditorInput editorInput;

    private boolean             disposed = false;

    private TextViewer          textViewer;

    private Document            doc;

    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {

        setSite(site);
        setInput(input);

        if (!(input instanceof ArtifactEditorInput)) {
            throw new PartInitException("Invalid input to ArtifactEditor (" + input.getClass().getName() + ")");
        }

        this.editorInput = (ArtifactEditorInput) input;
        IRunResult runResult = this.editorInput.getRunResult();
        TestStructure testStructure;
        try {
            testStructure = runResult.getTestStructure();
        } catch (ResultArchiveStoreException e) {
            throw new PartInitException("Error loading test structure for run " + this.editorInput.getName(), e);
        }

        setTitle("Run " + testStructure.getRunName() + " - " + this.editorInput.getPath().getFileName().toString());

        new FetchStoredArtifactJob(this, editorInput.getPath()).schedule();
    }

    @Override
    public void createPartControl(Composite parent) {
        parent.setLayout(new GridLayout(1, true));

        Composite lvComposite = new Composite(parent, SWT.NONE);
        lvComposite.setLayout(new FillLayout());

        textViewer = new TextViewer(lvComposite, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);

        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        gd.heightHint = 0;
        gd.widthHint = 0;

        lvComposite.setLayoutData(gd);
        
        activateActions();

        textViewer.setEditable(false);
        doc = new Document();
        textViewer.setDocument(doc);
        doc.set("Loading, please wait...");

        textViewer.getTextWidget().setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));
    }
    
    
    public void activateActions() { 

        ResourceBundle x = ResourceBundle.getBundle("org.eclipse.ui.texteditor.ConstructedEditorMessages");
        FindReplaceAction fAction = new FindReplaceAction(x, "Editor.FindReplace.", this); //$NON-NLS-1$
        fAction.setHelpContextId(IAbstractTextEditorHelpContextIds.FIND_ACTION);
        fAction.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_FIND_AND_REPLACE);
        getEditorSite().getActionBars().setGlobalActionHandler(ActionFactory.FIND.getId(), fAction);
        fAction.setEnabled(true);
    }


    @Override
    public void doSave(IProgressMonitor arg0) {

    }

    @Override
    public void doSaveAs() {
    }

    @Override
    public boolean isDirty() {
        return false;
    }

    @Override
    public boolean isSaveAsAllowed() {
        return false;
    }

    @Override
    public void setFocus() {
        textViewer.getControl().setFocus();

    }

    @Override
    public void dispose() {
        disposed = true;
        super.dispose();
    }

    public boolean isDisposed() {
        return disposed;
    }

    public void setText(String text) {
        if (disposed) {
            return;
        }

        // *** This method has to run on the UI thread, so switch if required
        if (Display.getCurrent() == null) {
            Display.getDefault().asyncExec(new Runnable() {
                public void run() {
                    setText(text);
                }
            });
            return;
        }

        // *** Now running on the UI thread

        this.doc.set(text);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public <T> T getAdapter(Class<T> adapter) {
        if (IFindReplaceTarget.class.equals(adapter)) {
            if (textViewer != null) {
                return (T) textViewer.getFindReplaceTarget();
            }
        }
    	return super.getAdapter(adapter);
    }

}
