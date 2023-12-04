package nd.restapipractice.serviceImp;

import nd.restapipractice.dto.request.CategoriesRequest;
import nd.restapipractice.dto.response.CategoriesResponse;
import nd.restapipractice.mapper.CategoriesMapper;
import nd.restapipractice.model.Categories;
import nd.restapipractice.repository.CategoriesRepository;
import nd.restapipractice.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriesServiceImp implements CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private CategoriesMapper categoriesMapper;

    @Override
    public List<CategoriesResponse> findAll() {
        return categoriesRepository.findAll().stream()
                .map(categories -> categoriesMapper.toResponse(categories)).collect(Collectors.toList());
    }

    @Override
    public CategoriesResponse findById(int id) {
        Optional<Categories> categories = categoriesRepository.findById(id);
        if(categories.isPresent()){
            return categoriesMapper.toResponse(categories.get());
        }
        return null;
    }

    @Override
    public List<CategoriesResponse> findByName(String name) {
        return categoriesRepository.findByName(name).stream()
                .map(categories -> categoriesMapper.toResponse(categories)).collect(Collectors.toList());
    }

    @Override
    public CategoriesResponse save(CategoriesRequest catalog) {
        return categoriesMapper.toResponse(categoriesRepository.save(categoriesMapper.toEntity(catalog)));
    }

    @Override
    public CategoriesResponse update(CategoriesRequest catalog, int id) {
        Optional<Categories> categories = categoriesRepository.findById(id);
        if(categories.isPresent()){
            Categories categoriesUpdate = categories.get();
            categoriesUpdate.setName(catalog.getName());
            categoriesUpdate.setDescription((catalog.getDescription()));
            categoriesUpdate.setPriority(catalog.getPriority());
            categoriesUpdate.setStatus(catalog.isStatus());
            return categoriesMapper.toResponse(categoriesRepository.save(categoriesUpdate));
        }
        return null;
    }

    @Override
    public CategoriesResponse delete(int id) {
        Optional<Categories> categories = categoriesRepository.findById(id);
        if(categories.isPresent()){
            Categories categoriesUpdate = categories.get();
            categoriesUpdate.setStatus(false);
            return categoriesMapper.toResponse(categoriesRepository.save(categoriesUpdate));
        }
        return null;
    }
}
