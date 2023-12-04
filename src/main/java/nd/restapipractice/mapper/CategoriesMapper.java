package nd.restapipractice.mapper;

import nd.restapipractice.dto.request.CategoriesRequest;
import nd.restapipractice.dto.response.CategoriesResponse;
import nd.restapipractice.model.Categories;
import org.springframework.stereotype.Component;

@Component
public class CategoriesMapper implements GenericMapper<Categories, CategoriesRequest, CategoriesResponse>{
    @Override
    public Categories toEntity(CategoriesRequest categoriesRequest) {
        return Categories.builder().id(categoriesRequest.getId())
                .name(categoriesRequest.getName())
                .priority(categoriesRequest.getPriority())
                .description(categoriesRequest.getDescription())
                .status(categoriesRequest.isStatus()).build();
    }


    @Override
    public CategoriesResponse toResponse(Categories categories) {
        return CategoriesResponse.builder().id(categories.getId())
                .name(categories.getName())
                .description(categories.getDescription())
                .priority(categories.getPriority())
                .status(categories.isStatus()).build();
    }
}
