package service;

import dto.ProductDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    List<ProductDto> products();

    List<ProductDto> allProduct();

    ProductDto getById(Long id);

    List<ProductDto> randomProduct();

    Page<ProductDto> searchProducts(int pageNo, String keyword);

    Page<ProductDto> getAllProducts(int pageNo);

    Page<ProductDto> getAllProductsForCustomer(int pageNo);

    List<ProductDto> findAllByCategory(String category);

    List<ProductDto> filterHighProducts();

    List<ProductDto> filterLowerProducts();

    List<ProductDto> listViewProducts();

    List<ProductDto> findByCategoryId(Long id);

    List<ProductDto> searchProducts(String keyword);

}
