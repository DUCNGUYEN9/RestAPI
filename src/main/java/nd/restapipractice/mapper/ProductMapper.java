package nd.restapipractice.mapper;

import nd.restapipractice.dto.request.ProductRequest;
import nd.restapipractice.dto.response.ProductResponse;
import nd.restapipractice.model.Categories;
import nd.restapipractice.model.Product;
import nd.restapipractice.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements GenericMapper<Product,ProductRequest, ProductResponse> {
    @Autowired
    CategoriesRepository categoriesRepository;

    @Override
    public Product toEntity(ProductRequest productRequest) {
        return Product.builder().id(productRequest.getId())
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .created(productRequest.getCreated())
                .quantity(productRequest.getQuantity())
                .status(true)
                .catalog(new Categories(productRequest.getCatalog())).build();
    }

    @Override
    public ProductResponse toResponse(Product product) {
        Categories categories = categoriesRepository.findById(product.getCatalog().getId()).get();
        if(product.getCatalog().getId() == categories.getId()){

        return ProductResponse.builder().id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .created(product.getCreated())
                .quantity(product.getQuantity())
                .status(product.isStatus())
                .catalog(product.getCatalog().getId())
                .catalogName(categories.getName())
                .build();
        }
        return null;
    }
}
