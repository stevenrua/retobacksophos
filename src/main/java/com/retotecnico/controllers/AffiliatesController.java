package com.retotecnico.controllers;

import com.retotecnico.entities.AffiliatesEntity;
import com.retotecnico.services.IAffiliatesService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/affiliatescontroller/api")
public class AffiliatesController {

    @Autowired
    private final IAffiliatesService affiliateService;

    public AffiliatesController(IAffiliatesService affiliateService) {
        this.affiliateService = affiliateService;
    }

        
    @GetMapping("/getlist")
    public ResponseEntity<List<AffiliatesEntity>> getListAffiliates() {
        System.out.println("Entra perras");
        return affiliateService.getList();
    }
    
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Optional<AffiliatesEntity>> getAffiliateById(@PathVariable(value = "id") Long id) {
        return affiliateService.getById(id);
    }
    
    @GetMapping("/getbyemail/{email}")
    public ResponseEntity<AffiliatesEntity> getAffiliateByEmail(@PathVariable(value = "email") String email) {
        return affiliateService.getEmail(email);
    }
    
    @PostMapping("/post")
    public ResponseEntity<AffiliatesEntity> newAffiliate(@RequestBody AffiliatesEntity affiliatenew) {
        return affiliateService.post(affiliatenew);
    }

    @PutMapping("/put")
    public ResponseEntity<AffiliatesEntity> updateAffiliate(@RequestBody AffiliatesEntity updateAffiliate) {
        return affiliateService.put(updateAffiliate);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AffiliatesEntity> deleteAffiliate(@PathVariable(value = "id") Long id) {
        return affiliateService.delete(id);
    }
}
