package nd.restapipractice.serviceImp;

import nd.restapipractice.dto.request.ProductRequest;
import nd.restapipractice.dto.response.ProductResponse;
import nd.restapipractice.mapper.ProductMapper;
import nd.restapipractice.model.Categories;
import nd.restapipractice.model.Product;
import nd.restapipractice.repository.CategoriesRepository;
import nd.restapipractice.repository.ProductRepository;
import nd.restapipractice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream()
                .map(product -> productMapper.toResponse(product)).collect(Collectors.toList());
    }

    @Override
    public ProductResponse findById(String id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return productMapper.toResponse(product.get());
        }
        return null;
    }

    @Override
    public List<ProductResponse> findByName(String name) {
        return productRepository.findByName(name).stream()
                .map(product -> productMapper.toResponse(product)).collect(Collectors.toList());
    }

//    @Override
//    public ProductResponse save(ProductRequest product) {
//        Product productNew = productRepository.save(productMapper.toEntity(product));
//        Categories categories = categoriesRepository.findById(product.getCatalog()).get();
//        if(productNew.getCatalog().getId() == categories.getId()){
//        return new ProductResponse(productNew.getId(), productNew.getName(), productNew.getPrice(), productNew.getCreated(),
//                productNew.getQuantity(), productNew.isStatus(), productNew.getCatalog().getId(), categories.getName());
//        }
//        return null;
//    }

    @Override
    public ProductResponse save(ProductRequest product) {
        return productMapper.toResponse(productRepository.save(productMapper.toEntity(product)));
    }

    @Override
    public ProductResponse update(ProductRequest productRequest, String id) {
        Optional<Product> products = productRepository.findById(id);
        if (products.isPresent()) {
            Product productUpdate = products.get();
            productUpdate.setName(productRequest.getName());
            productUpdate.setPrice(productRequest.getPrice());
            productUpdate.setStatus(productRequest.isStatus());
            productUpdate.setCatalog(new Categories(productRequest.getCatalog()));
            return productMapper.toResponse(productRepository.save(productUpdate));
        }
        return null;
    }

    @Override
    public ProductResponse delete(String id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product productUpdate = product.get();
            productUpdate.setStatus(false);
            return productMapper.toResponse(productRepository.save(productUpdate));
        }
        return null;
    }
}
