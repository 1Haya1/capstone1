package org.example.capstone1.Service;

import lombok.RequiredArgsConstructor;
import org.example.capstone1.Model.Merchant;
import org.example.capstone1.Model.MerchantStock;
import org.example.capstone1.Model.Product;
import org.example.capstone1.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {



    private final List<Product> products = new ArrayList<>();

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public Product getProductById(Integer productId) {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Boolean updateProduct(Integer Id , Product product){

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == Id){
                products.set(i , product);
                return true ;
            }

        }
        return false ;
    }



    public Boolean deleteProduct(Integer Id){

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == Id){
                products.remove(i);
                return true ;
            }
        }
        return null ;
    }




    //EXtra
    public void addRatingForProduct(Integer productId, Integer rating) {
        Product p = getProductById(productId);// الحصول على المنتج بالاي دي
        if (p != null) {// يتحقق اذا المنتج موجود ويضيفه بقائمه التقييمات
            p.getRatings().add(rating);
        }
    }
    public List<Integer> getAllRatingsForProduct(Integer productId) {
        return getProductById(productId).getRatings();
    }

      public ArrayList<Product> filter(String cat){
        ArrayList <Product>list=new ArrayList<>();
        for (Product p:products){
            if(p.getCategoryId().equalsIgnoreCase(cat))
                list.add(p);
        }
    return list;}


}




