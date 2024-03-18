package org.example.capstone1.Service;

import lombok.RequiredArgsConstructor;
import org.example.capstone1.Model.MerchantStock;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantStockService {


    private final List<MerchantStock> merchantStocks = new ArrayList<>();

    public List<MerchantStock> getAllMerchantStocks() {
        return new ArrayList<>(merchantStocks);
    }


    public void addMerchantStock(MerchantStock merchantStock) {
        merchantStocks.add(merchantStock);
    }

    public Boolean updateMerchantStock(Integer Id , MerchantStock merchantStock){

        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId() == Id){
                merchantStocks.set(i , merchantStock);
                return true ;
            }

        }
        return false ;
    }



    public Boolean deleteMerchantStock(Integer Id){

        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId() == Id){
                merchantStocks.remove(i);
                return true ;
            }
        }
        return null ;
    }



    //11
    public void addStock(Integer productId, Integer merchantId, Integer stock) {
        //    البحث عن مخزون التاجر
        MerchantStock SMerchantStock = getMerchantStock1(productId, merchantId);
        if (SMerchantStock != null) {
            // إذا كان هناك مخزون موجود، قم بزيادة كمية
            SMerchantStock.setStock(SMerchantStock.getStock() + stock);
        } else {
            // إذا لم يكن هناك مخزون، قم بإنشاء مخزون جديد
            merchantStocks.add(new MerchantStock(null,productId,merchantId,stock));
        }
    }
    // يرجع مخزون التاجر بالايدي
    public MerchantStock getMerchantStock1(Integer productId, Integer merchantId) {
        for (MerchantStock merchantStock : merchantStocks) {
            if (merchantStock.getProductId().equals(productId) && merchantStock.getMerchantId().equals(merchantId)) {
                return merchantStock;
            }
        }
        return null;
    }

}













