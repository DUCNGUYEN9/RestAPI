package nd.restapipractice.service;

import nd.restapipractice.dto.request.CategoriesRequest;
import nd.restapipractice.dto.response.CategoriesResponse;

import java.util.List;

public interface CategoriesService {
    List<CategoriesResponse> findAll();
    CategoriesResponse findById(int id);
    List<CategoriesResponse> findByName(String name);
    CategoriesResponse save(CategoriesRequest catalog);
    CategoriesResponse update(CategoriesRequest catalog, int id);
    CategoriesResponse delete(int id);
}
