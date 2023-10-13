package service;

import dto.CategoryDto;
import model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    /*Admin*/
    Category save(Category category);

    Category update(Category category);

    List<Category> findAllByActivatedTrue();

    List<Category> findALl();

    Optional<Category> findById(Long id);

    void deleteById(Long id);

    void enableById(Long id);

    List<CategoryDto> getCategoriesAndSize();
}
