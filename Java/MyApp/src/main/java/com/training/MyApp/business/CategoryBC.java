package com.training.MyApp.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import com.training.MyApp.domain.Category;
import com.training.MyApp.persistence.CategoryDAO;

@BusinessController
public class CategoryBC extends DelegateCrud<Category, Long, CategoryDAO> {

	private static final long serialVersionUID = 1L;

}
