package org.example.capstone1.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.capstone1.Model.User;
import org.example.capstone1.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }



    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("added");
    }


    @PutMapping("/update/{Id}")
    public ResponseEntity updateUser(@PathVariable Integer Id , @RequestBody @Valid User user , Errors errors ){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdate = userService.updateUser(Id , user);
        if (isUpdate){
            return ResponseEntity.status(200).body("updated");
        }
        return ResponseEntity.status(400).body("not found");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        boolean userDeleted = userService.deleteUser(id);
        if (userDeleted) {
            return ResponseEntity.status(200).body("deleted");
        } else {
            return ResponseEntity.status(400).body("not found");
        }
    }





    //12
    @PostMapping("/buy/{userId}/{productId}/{merchantId}")
    public ResponseEntity buyProduct(@PathVariable Integer userId, @PathVariable Integer productId, @PathVariable Integer merchantId) {
        userService.buyProduct(userId, productId, merchantId);
        return ResponseEntity.ok("Product purchased");
    }


//extra
@PostMapping("/user/addBalance")
public ResponseEntity addBalance(@RequestParam Integer userId, @RequestBody double amount) {
    userService.addBalance(userId, amount);
    return ResponseEntity.ok("Balance added.");
}

    @PostMapping("/user/refundBalance")
    public ResponseEntity refundBalance(@RequestParam Integer userId, @RequestBody double amount) {
        userService.refundBalance(userId, amount);
        return ResponseEntity.ok("Balance refunded.");
    }
}








