package nd.restapipractice.mapper;

import nd.restapipractice.dto.request.ProductRequest;
import nd.restapipractice.dto.response.ProductResponse;
import nd.restapipractice.model.Categories;
import nd.restapipractice.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements GenericMapper<Product,ProductRequest, ProductResponse> {

    @Override
    public Product toEntity(ProductRequest productRequest) {
        return Product.builder().id(productRequest.getId())
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .created(productRequest.getCreated())
                .quantity(productRequest.getQuantity())
                .status(productRequest.isStatus())
                .catalog(new Categories(productRequest.getCatalog())).build();
    }

    @Override
    public ProductResponse toResponse(Product product) {
        return ProductResponse.builder().id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .created(product.getCreated())
                .quantity(product.getQuantity())
                .status(product.isStatus())
                .catalog(product.getCatalog().getId())
                .build();
    }
}
