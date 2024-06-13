package com.example.PawsTime.category;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categories")
@AllArgsConstructor
@ComponentScan
public class CategoryController {

    private CategoryService service;

    @GetMapping("teste")
    public String teste(){
        return "teste";
    }

    @GetMapping
    public ResponseEntity<CategoryRepresentation.categoryResponse> getAllCategories(){
        return ResponseEntity.ok((CategoryRepresentation.categoryResponse) service.getAllCategories().stream().map(CategoryRepresentation.categoryResponse::fromCategory).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryRepresentation.categoryResponse> getCategoryById(Long id){
        try{
            return ResponseEntity.ok(CategoryRepresentation.categoryResponse.fromCategory(service.getCategoryById(id)));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("cu")
    public ResponseEntity<CategoryRepresentation.categoryResponse> createCategory(@RequestBody CategoryRepresentation.createCategory category){
        try{
            return ResponseEntity.ok().body(CategoryRepresentation.categoryResponse.fromCategory(service.createCategory(category)));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("{id}")
    public ResponseEntity<CategoryRepresentation.categoryResponse> updateCategory(@PathVariable Long id, @RequestBody CategoryRepresentation.updateCategory category){
        try{
            return ResponseEntity.ok().body(CategoryRepresentation.categoryResponse.fromCategory(service.update(id, category)));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CategoryRepresentation.categoryResponse> deleteCategory(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
