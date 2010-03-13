package com.eclipserunner.views.actions;

import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jface.action.Action;

import com.eclipserunner.RunnerPluginPrererenceConstants;
import com.eclipserunner.model.IRunnerModel;
import com.eclipserunner.views.IRunnerView;

@SuppressWarnings("restriction")
public class ToggleDefaultCategoryAction extends Action {

	private final IRunnerView runnerView;
	private final IRunnerModel runnerModel;

	public ToggleDefaultCategoryAction(IRunnerView runnerView, IRunnerModel runnerModel) {
		this.runnerView = runnerView;
		this.runnerModel = runnerModel;

		boolean checked = JavaPlugin.getDefault().getPreferenceStore().getBoolean(RunnerPluginPrererenceConstants.DEFAULT_CATEGORY_VISIBLE);
		valueChanged(checked, false);
	}

	@Override
	public void run() {
		valueChanged(isChecked(), true);

		runnerModel.setDefaultCategoryVisible(isChecked());
		runnerView.refresh();
	}

	private void valueChanged(final boolean checked, boolean storeProperty) {
		setChecked(checked);
		if (storeProperty) {
			JavaPlugin.getDefault().getPreferenceStore().setValue(RunnerPluginPrererenceConstants.DEFAULT_CATEGORY_VISIBLE, checked);
		}
	}

}
