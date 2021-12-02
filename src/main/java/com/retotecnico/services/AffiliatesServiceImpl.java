package com.retotecnico.services;

import com.retotecnico.entities.AffiliatesEntity;
import com.retotecnico.repositories.IAffiliatesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AffiliatesServiceImpl implements IAffiliatesService{

    @Autowired
    private final IAffiliatesRepository affiliateRepository;

    public AffiliatesServiceImpl(IAffiliatesRepository affiliateRepository) {
        this.affiliateRepository = affiliateRepository;
    }
    
        
    @Override
    public ResponseEntity<List<AffiliatesEntity>> getList() {
                       
        List<AffiliatesEntity> listAffialies = affiliateRepository.findAll();
        
        if(listAffialies.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(listAffialies);
        
        return ResponseEntity.status(HttpStatus.OK).body(listAffialies);
        
    }

    @Override
    public ResponseEntity<Optional<AffiliatesEntity>> getById(Long id) {
        Optional<AffiliatesEntity> affiliate = affiliateRepository.findById(id);
        
        if(affiliate.isPresent())
            return ResponseEntity.ok(affiliate);
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(affiliate);
    }
    
    @Override
    public ResponseEntity<AffiliatesEntity> getEmail(String email) {
        AffiliatesEntity affiliateByEmail = affiliateRepository.findByEmail(email);
        if(affiliateByEmail != null)
            return ResponseEntity.ok(affiliateByEmail);
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @Override
    public ResponseEntity<AffiliatesEntity> post(AffiliatesEntity newAffiliate) {
        AffiliatesEntity affiliate = affiliateRepository.findByEmail(newAffiliate.getEmail());
        if(affiliate != null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(affiliate);
        
        AffiliatesEntity nAffiliate = affiliateRepository.save(newAffiliate);
        return ResponseEntity.status(HttpStatus.CREATED).body(nAffiliate);         
              
    }

    @Override
    public ResponseEntity<AffiliatesEntity> put(AffiliatesEntity updateAffiliate) {
        Optional<AffiliatesEntity> updaAffiliate = affiliateRepository.findById(updateAffiliate.getIdAffiliate());
        
        if(updaAffiliate.isPresent())
            return ResponseEntity.status(HttpStatus.CREATED).body(affiliateRepository.save(updateAffiliate));
                           
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AffiliatesEntity());
    }

    @Override
    public ResponseEntity<AffiliatesEntity> delete(Long id) {
        Optional<AffiliatesEntity> deleteAffiliate = affiliateRepository.findById(id);
        
        if(deleteAffiliate.isPresent()){
            affiliateRepository.delete(deleteAffiliate.get());
            return ResponseEntity.status(HttpStatus.OK).body(new AffiliatesEntity());
        }           
        
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new AffiliatesEntity());
    }

    
    
}
