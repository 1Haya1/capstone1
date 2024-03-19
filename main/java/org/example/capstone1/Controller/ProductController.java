package org.example.capstone1.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.capstone1.Api.ApiResponse;
import org.example.capstone1.Model.Product;
import org.example.capstone1.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get")
    public ResponseEntity getAllProducts(){
        List<Product> products=productService.getAllProducts();
        return ResponseEntity.status(200).body(products);
    }


@PostMapping("/add")
public ResponseEntity addProduct(@RequestBody  Product product, Errors errors){
    if (errors.hasErrors()){
        String message = errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    productService.addProduct(product);
    return ResponseEntity.status(200).body("added");
}

    @PutMapping("/update/{Id}")
    public ResponseEntity  updateProduct(@PathVariable Integer Id, @RequestBody @Valid Product product, Errors errors) {

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdate = productService.updateProduct(Id , product);
        if (isUpdate){
            return ResponseEntity.status(200).body("updated");
        }

        return ResponseEntity.status(400).body("not found");
    }


    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteStudent(@PathVariable Integer Id ){


        if (productService.deleteProduct(Id) == null){
            return ResponseEntity.status(400).body(new ApiResponse("Invalid Id"));
        }

        return ResponseEntity.status(200).body(new ApiResponse("deleted"));

    }









    //Extra
    @PostMapping("/addR/{productId}/rating")
    public ResponseEntity addRating(@PathVariable Integer productId, @RequestBody Integer rating) {
        productService.addRatingForProduct(productId, rating);
        return ResponseEntity.ok("Rating added.");
    }

    @GetMapping("/getR/{productId}/ratings")
    public ResponseEntity<List<Integer>> getAllRatings(@PathVariable Integer productId) {
        List<Integer> ratings = productService.getAllRatingsForProduct(productId);
        return ResponseEntity.ok(ratings);
    }

  @GetMapping("/filtr/{catId}")
    public ResponseEntity filtr(@PathVariable String catId) {
        List<Product>list= productService.filter(catId);
        return ResponseEntity.status(200).body(list);
    }









}



















