package org.example.capstone1.Service;

import lombok.RequiredArgsConstructor;

import org.example.capstone1.Model.MerchantStock;
import org.example.capstone1.Model.Product;
import org.example.capstone1.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
@RequiredArgsConstructor
public class UserService {

    private final MerchantStockService merchantStockService;
    private final MerchantService merchantService;
    private final ProductService productService;
    private final UserService userService;


    private final List<User> users = new ArrayList<>();



    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public User getUserById(Integer id) {
        for (User user : users) {
            if (user.getId()==(id)) {
                return user;
            }
        }
        return null;
    }

    public User addUser(User user) {
        users.add(user);
        return user;
    }

    public Boolean updateUser(Integer Id , User user){

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == Id){
                users.set(i , user);
                return true ;
            }

        }
        return false ;
    }



    public Boolean deleteUser(Integer Id){

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == Id){
                users.remove(i);
                return true ;
            }
        }
        return null ;
    }




    //12
    public String buyProduct(Integer userId, Integer productId, Integer merchantId) {
        User user = userService.getUserById(userId);
        Product product = productService.getProductById(productId);
        MerchantStock merchantStock = merchantStockService.getMerchantStock1(null,merchantId);

        if (user != null && product != null && merchantStock != null) {
            if (user.getBalance() >= product.getPrice() && merchantStock.getStock() > 0) {
                user.setBalance(user.getBalance() - product.getPrice());
                merchantStock.setStock(merchantStock.getStock() - 1);

                return "Product purchased.";
            } else {
                return "product out of stock.";
            }
        } else {
            return "Invalid user, product, or merchant.";
        }
    }


    //extra
    // إضافة المبلغ إلى رصيد المستخدم
    public void addBalance(int userId, double amount) {
        User user = getUserById(userId);
        if (user != null) {
            double currentBalance = user.getBalance();
            user.setBalance(currentBalance + amount);
        }
    }

    // استرداد المبلغ المدفوع إلى حساب المستخدم
    public void refundBalance(int userId, double amount) {
        User user = getUserById(userId);
        if (user != null) {
            double currentBalance = user.getBalance();
            // التأكد من أن الرصيد لا يقل عن المبلغ المراد استرداده
                user.setBalance(currentBalance + amount);
            
        }}


}




