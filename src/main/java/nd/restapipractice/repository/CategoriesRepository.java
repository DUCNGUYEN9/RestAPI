package nd.restapipractice.repository;

import nd.restapipractice.dto.response.CategoriesResponse;
import nd.restapipractice.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories,Integer> {
    @Query("select c from Categories c where c.name like %?1%")
    List<Categories> findByName(String name);
}
