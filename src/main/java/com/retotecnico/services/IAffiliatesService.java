package com.retotecnico.services;

import com.retotecnico.entities.AffiliatesEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

public interface IAffiliatesService {
    public ResponseEntity<List<AffiliatesEntity>> getList();
    
    public ResponseEntity<Optional<AffiliatesEntity>> getById(Long id);
    
    public ResponseEntity<AffiliatesEntity> getEmail(String email);
    
    public ResponseEntity<AffiliatesEntity> post(AffiliatesEntity newAffiliate);
    
    public ResponseEntity<AffiliatesEntity> put(AffiliatesEntity updateAffiliate);
    
    public ResponseEntity<AffiliatesEntity> delete(Long id);
    
    
}
