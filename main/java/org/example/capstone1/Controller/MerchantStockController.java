package org.example.capstone1.Controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.capstone1.Model.MerchantStock;
import org.example.capstone1.Service.MerchantStockService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/merchantStock")
public class MerchantStockController {

    private final MerchantStockService merchantStockService;


    @GetMapping("/get")
    public ResponseEntity<List<MerchantStock>> getAllMerchantStocks() {
        List<MerchantStock> merchantStocks = merchantStockService.getAllMerchantStocks();
        return ResponseEntity.ok(merchantStocks);
    }


    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@RequestBody MerchantStock merchantStock) {
        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(200).body(merchantStock);
    }

    @PutMapping("/update/{Id}")
    public ResponseEntity updateMerchantStock(@PathVariable Integer Id , @RequestBody @Valid MerchantStock merchantStock , Errors errors ){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdate = merchantStockService.updateMerchantStock(Id , merchantStock);
        if (isUpdate){
            return ResponseEntity.status(200).body("updated");
        }

        return ResponseEntity.status(400).body("Invalid Id");
    }


    @DeleteMapping("/delete/{Id}")
    public ResponseEntity deleteMerchantStock(@PathVariable Integer Id ){

        if (merchantStockService.deleteMerchantStock(Id) == null){
            return ResponseEntity.status(400).body("Invalid Id");
        }

        return ResponseEntity.status(200).body("deleted");

    }


    //11
    @PutMapping("/addStock/{productId}/{merchantId}/{stock}")
    public ResponseEntity addStock(@PathVariable Integer productId, @PathVariable Integer merchantId, @PathVariable Integer stock) {
        merchantStockService.addStock(productId, merchantId, stock);
        return ResponseEntity.ok("Stock added");
    }






}






