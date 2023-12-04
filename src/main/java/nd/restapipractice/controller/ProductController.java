package nd.restapipractice.controller;

import jakarta.websocket.server.PathParam;
import nd.restapipractice.dto.request.CategoriesRequest;
import nd.restapipractice.dto.request.ProductRequest;
import nd.restapipractice.dto.response.CategoriesResponse;
import nd.restapipractice.dto.response.ProductResponse;
import nd.restapipractice.service.CategoriesService;
import nd.restapipractice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll(){
        List<ProductResponse> productResponseList =productService.findAll();
        return new ResponseEntity<>(productResponseList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable String id){
        ProductResponse productResponse = productService.findById(id);
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ProductResponse> create( @RequestBody ProductRequest productRequest){
        ProductResponse productResponse = productService.save(productRequest);
        return new ResponseEntity<>(productResponse,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@RequestBody ProductRequest productRequest,@PathVariable  String id){
        ProductResponse productResponse = productService.update(productRequest,id);
        return new ResponseEntity<>(productResponse,HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponse> delete(@PathVariable String id){
        ProductResponse productResponse = productService.delete(id);
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }
    @GetMapping("/searchName")
    public ResponseEntity<List<ProductResponse>> searchName(@PathParam("searchName") String name){
        List<ProductResponse> productResponseList =productService.findByName(name);
        return new ResponseEntity<>(productResponseList, HttpStatus.OK);
    }

}
