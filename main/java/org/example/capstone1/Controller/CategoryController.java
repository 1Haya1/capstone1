package org.example.capstone1.Controller;

import lombok.RequiredArgsConstructor;
import org.example.capstone1.Model.Category;
import org.example.capstone1.Service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {


    private final CategoryService categoryService;



    @GetMapping("/get")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }


    @GetMapping("/get/{id}")
    public ResponseEntity getCategoryById(@PathVariable Integer id) {
        Category category = categoryService.getCategoryById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.status(400).body("not found");
        }
    }

    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.addCategory(category);
        return ResponseEntity.status(200).body(createdCategory);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable Integer id, @RequestBody Category category) {
        Category existingCategory = categoryService.getCategoryById(id);
        if (existingCategory != null) {
            Category updatedCategory = categoryService.updateCategory(id, category);
            return ResponseEntity.ok(updatedCategory);
        } else {
            return ResponseEntity.status(400).body("not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id) {
        boolean categoryDeleted = categoryService.deleteCategory(id);
        if (categoryDeleted) {
            return ResponseEntity.status(200).body("deleted");
        } else {
            return ResponseEntity.status(400).body("not found");
        }
    }



}
