package service;

import dto.CategoryDto;
import model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAllByActivatedTrue();

    List<Category> findALl();

    List<CategoryDto> getCategoriesAndSize();
}
