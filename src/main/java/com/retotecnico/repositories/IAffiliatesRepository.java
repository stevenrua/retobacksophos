package com.retotecnico.repositories;

import com.retotecnico.entities.AffiliatesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAffiliatesRepository extends JpaRepository<AffiliatesEntity, Long> {
    
    public AffiliatesEntity findByEmail(String email);
    
}
