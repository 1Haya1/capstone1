package org.example.capstone1.Service;


import lombok.RequiredArgsConstructor;
import org.example.capstone1.Model.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MerchantService {

    private final List<Merchant> merchants = new ArrayList<>();

    public List<Merchant> getAllMerchants() {
        return new ArrayList<>(merchants);
    }


    public Merchant addMerchant(Merchant merchant) {
        merchants.add(merchant);
        return merchant;
    }

    public Boolean updateMerchant(Integer Id , Merchant merchant){

        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getId() == Id){
                merchants.set(i , merchant);
                return true ;
            }

        }
        return false ;
    }

    public Boolean deleteMerchant(Integer Id){

        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getId() == Id){
                merchants.remove(i);
                return true ;
            }
        }
        return null ;
    }













}