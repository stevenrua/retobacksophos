package com.retotecnico.entities;

import lombok.Data;
import java.util.List;

@Data
public class MasterEntity {

    private AffiliatesEntity affiliate;
    private List<AppTests> listAppTests;

    public MasterEntity(){

    }

    
    public MasterEntity(AffiliatesEntity affiliate, List<AppTests> listAppTests) {
        this.affiliate = affiliate;
        this.listAppTests = listAppTests;
    }
    
    public void setListAppTests(List<AppTests> listAppTests){
        this.listAppTests = listAppTests;
    }
    
}
