package nd.restapipractice.controller;

import jakarta.websocket.server.PathParam;
import nd.restapipractice.dto.request.CategoriesRequest;
import nd.restapipractice.dto.response.CategoriesResponse;
import nd.restapipractice.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;
    @GetMapping
    public ResponseEntity<List<CategoriesResponse>> getAll(){
        List<CategoriesResponse> categoriesResponseList =categoriesService.findAll();
        return new ResponseEntity<>(categoriesResponseList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoriesResponse> getById(@PathVariable int id){
        CategoriesResponse categoriesResponse = categoriesService.findById(id);
        return new ResponseEntity<>(categoriesResponse,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CategoriesResponse> create( @RequestBody CategoriesRequest categoriesRequest){
        CategoriesResponse categoriesResponse = categoriesService.save(categoriesRequest);
        return new ResponseEntity<>(categoriesResponse,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoriesResponse> update(@RequestBody CategoriesRequest categoriesRequest,@PathVariable  int id){
        CategoriesResponse categoriesResponse = categoriesService.update(categoriesRequest,id);
        return new ResponseEntity<>(categoriesResponse,HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CategoriesResponse> delete(@PathVariable int id){
        CategoriesResponse categoriesResponse = categoriesService.delete(id);
        return new ResponseEntity<>(categoriesResponse,HttpStatus.OK);
    }
    @GetMapping("/searchName")
    public ResponseEntity<List<CategoriesResponse>> searchName(@PathParam("searchName") String name){
        List<CategoriesResponse> categoriesResponseList =categoriesService.findByName(name);
        return new ResponseEntity<>(categoriesResponseList, HttpStatus.OK);
    }

}
