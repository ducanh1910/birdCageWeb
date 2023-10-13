package repository;

import dto.CategoryDto;
import model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "update Category set name = ?1 where id = ?2")
    Category update(String name, Long id);

    @Query(value = "select * from categories where is_activated = true", nativeQuery = true)
    List<Category> findAllByActivatedTrue();

    @Query(value = "select new dto.CategoryDto(c.id,c.name, count (p.category.id)) " +
            "from Category c left join Product p on c.id = p.category.id " +
            "where c.isActivated = true and c.isDeleted = false " +
            "group by c.id ")
    List<CategoryDto> getCategoriesAndSize();
}
