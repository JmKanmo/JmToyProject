package com.jmshop.jmshop_admin.service.impl;

import com.jmshop.jmshop_admin.dto.domain.Category;
import com.jmshop.jmshop_admin.repository.CategoryRepository;
import com.jmshop.jmshop_admin.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Long saveCategory(Category category) {
        return categoryRepository.save(category).getId();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Category> findCategories() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Category> findCategoryById(Long id) {
        return Optional.ofNullable(categoryRepository.findCategoryById(id));
    }
}
