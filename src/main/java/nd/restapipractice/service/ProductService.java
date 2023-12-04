package nd.restapipractice.service;

import nd.restapipractice.dto.request.CategoriesRequest;
import nd.restapipractice.dto.request.ProductRequest;
import nd.restapipractice.dto.response.CategoriesResponse;
import nd.restapipractice.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> findAll();
    ProductResponse findById(String id);
    List<ProductResponse> findByName(String name);
    ProductResponse save(ProductRequest product);
    ProductResponse update(ProductRequest product, String id);
    ProductResponse delete(String id);
}
