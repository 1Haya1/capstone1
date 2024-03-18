package org.example.capstone1.Service;

import lombok.RequiredArgsConstructor;
import org.example.capstone1.Model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryService {


    private final List<Category> categories = new ArrayList<>();

    public List<Category> getAllCategories() {
        return categories;
    }

    public Category getCategoryById(Integer id) {
        for (Category category : categories) {
            if (category.getId().equals(id)) {
                return category;
            }
        }
        return null;
    }

    public Category addCategory(Category category) {
        categories.add(category);
        return category;
    }

    public Category updateCategory(Integer id, Category updatedCategory) {
        for (Category category : categories) {
            if (category.getId()==(id)) {
                category.setName(updatedCategory.getName());
                return category;
            }
        }
        return null;
    }

    public boolean deleteCategory(Integer id) {
        for (Category category : categories) {
            if (category.getId().equals(id)) {
                categories.remove(category);
                return true;
            }
        }
        return false;
    }
}

