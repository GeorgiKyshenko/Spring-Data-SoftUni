package BookShop.services;

import BookShop.entities.Category;

import java.util.Set;

public interface CategoryService {

    Set<Category> getRandomCategories();
}
