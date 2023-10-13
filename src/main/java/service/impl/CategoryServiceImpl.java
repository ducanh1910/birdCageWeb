package service.impl;

import dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import model.Category;
import org.springframework.stereotype.Service;
import repository.CategoryRepository;
import service.CategoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;


    @Override
    public List<Category> findAllByActivatedTrue() {
        return categoryRepository.findAllByActivatedTrue();
    }

    @Override
    public List<Category> findALl() {
        return categoryRepository.findAll();
    }


    @Override
    public List<CategoryDto> getCategoriesAndSize() {
        List<CategoryDto> categories = categoryRepository.getCategoriesAndSize();
        return categories;
    }
}
