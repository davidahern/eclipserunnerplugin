package com.eclipserunner.model;

import java.util.Collection;

public interface IRunnerModel {

	void addLaunchNode(ILaunchNode launchNode);
	void removeLaunchNode(ILaunchNode launchNode);

	void addCategoryNode(ICategoryNode categoryNode);
	void removeCategoryNode(ICategoryNode categoryNode);

	Collection<ICategoryNode> getCategoryNodes();

	void addModelChangeListener(IModelChangeListener modelChangeListener);
	void removeModelChangeListener(IModelChangeListener modelChangeListener);

	ICategoryNode getDefaultCategoryNode();

}
