package com.example.PawsTime.category;

import com.example.PawsTime.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryRepresentation.categoryResponse>> getAllCategories(){
        List<CategoryRepresentation.categoryResponse> categories = service.getAllCategories().stream()
                .map(CategoryRepresentation.categoryResponse::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(categories);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryRepresentation.categoryResponse> getCategoryById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(CategoryRepresentation.categoryResponse.from(service.getCategoryById(id)));
        } catch (NotFoundException e){
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<CategoryRepresentation.categoryResponse> createCategory(@RequestBody CategoryRepresentation.createCategory category){
        try{
            return ResponseEntity.ok().body(CategoryRepresentation.categoryResponse.from(service.createCategory(category)));
        } catch (NotFoundException e){
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("{id}")
    public ResponseEntity<CategoryRepresentation.categoryResponse> updateCategory(@PathVariable Long id, @RequestBody CategoryRepresentation.updateCategory category){
        try{
            return ResponseEntity.ok().body(CategoryRepresentation.categoryResponse.from(service.update(id, category)));
        } catch (NotFoundException e){
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CategoryRepresentation.categoryResponse> deleteCategory(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
