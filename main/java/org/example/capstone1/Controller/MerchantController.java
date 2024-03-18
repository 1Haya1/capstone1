package org.example.capstone1.Controller;


import lombok.RequiredArgsConstructor;
import org.example.capstone1.Model.Merchant;
import org.example.capstone1.Service.MerchantService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/merchant")
public class MerchantController {

    private final MerchantService merchantService;

    @GetMapping("/get")
    public ResponseEntity<List<Merchant>> getAllMerchants(){
        List<Merchant>merchants=merchantService.getAllMerchants();
        return ResponseEntity.ok(merchants);
    }


    @PostMapping("/add")
    public ResponseEntity addMerchant(@RequestBody Merchant merchant) {
        Merchant createdMerchant = merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body(createdMerchant);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@PathVariable Integer id, @RequestBody Merchant updatedMerchant) {
        boolean merchantUpdated = merchantService.updateMerchant(id, updatedMerchant);
        if (merchantUpdated) {
            return ResponseEntity.ok("updated");
        } else {
            return ResponseEntity.status(400).body("not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable Integer id) {
        boolean deleted = merchantService.deleteMerchant(id);
        if (deleted) {
            return ResponseEntity.ok("deleted");
        } else {
            return ResponseEntity.status(400).body("not found");
        }
    }







}
