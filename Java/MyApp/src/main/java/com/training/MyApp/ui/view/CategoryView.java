package com.training.MyApp.ui.view;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.vaadin.template.AbstractCrudView;
import com.training.MyApp.domain.Category;
import com.training.MyApp.ui.view.form.CategoryForm;

public class CategoryView extends AbstractCrudView<Category> {

	private static final long serialVersionUID = 1L;

	@Inject
	public CategoryView(CategoryForm crudForm) {
		super(crudForm);
	}

	@Override
	public void initializeComponents() {
		super.initializeComponents();
		setCaption("Category");

		addComponent(getCrudForm());
		addComponent(getListTable());
	}

	public void setDeleteButtonEnabled(boolean enabled) {
		getCrudForm().getButtonDelete().setEnabled(enabled);
	}

	@Override
	public String getWarningMessage() {
		return "Tem certeza que deseja sair?";
	}

}
