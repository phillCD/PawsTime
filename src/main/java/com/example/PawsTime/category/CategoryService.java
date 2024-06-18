package com.example.PawsTime.category;

import com.example.PawsTime.exceptions.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category createCategory(CategoryRepresentation.createCategory create) {
        return categoryRepository.save(new Category(
                create.getName()
        ));
    }

    public Category update(Long id, CategoryRepresentation.updateCategory entity) {
        var dbEntity = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category"));
        modelMapper.map(entity, dbEntity);

        return categoryRepository.save(dbEntity);
    }

    public Category delete(Long id) {
        var dbEntity = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category"));
        categoryRepository.delete(dbEntity);
        return dbEntity;
    }
}
