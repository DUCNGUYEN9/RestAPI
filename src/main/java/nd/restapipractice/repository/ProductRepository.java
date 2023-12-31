package nd.restapipractice.repository;

import nd.restapipractice.model.Categories;
import nd.restapipractice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    @Query("select p from Product p join Categories c on p.catalog.id = c.id where p.name like %?1% or c.name like %?1%")
    List<Product> findByName(String name);
}
