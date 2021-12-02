package com.retotecnico.controllers;

import com.retotecnico.entities.AffiliatesEntity;
import com.retotecnico.repositories.IAffiliatesRepository;
import com.retotecnico.services.AffiliatesServiceImpl;
import java.util.*;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

class AffiliatesControllerTest {

    @Autowired
    private final IAffiliatesRepository affiliatesRepositoryMock = Mockito.mock(IAffiliatesRepository.class);

    @Autowired
    private final AffiliatesServiceImpl affiliatesService = new AffiliatesServiceImpl(affiliatesRepositoryMock);

    @Autowired
    private final AffiliatesController affiliateController = new AffiliatesController(affiliatesService);

    @Test
    void testGetListAffiliates() {
        List<AffiliatesEntity> affiliatesList = new ArrayList<>();
        affiliatesList.add(new AffiliatesEntity(1, "Steve", 28, "srua10@gmail.com"));
        affiliatesList.add(new AffiliatesEntity(2, "Shara", 25, "shara@gmail.com"));
        affiliatesList.add(new AffiliatesEntity(3, "Celeste", 5, "celeste@gmail.com"));
        affiliatesList.add(new AffiliatesEntity(4, "Amanda", 50, "Amanda@gmail.com"));

        Mockito.when(affiliatesRepositoryMock.findAll()).thenReturn(affiliatesList);

        ResponseEntity<List<AffiliatesEntity>> serviceResponse;
        serviceResponse = affiliateController.getListAffiliates();

        List<AffiliatesEntity> expectedAffiliateList = new ArrayList<>();
        expectedAffiliateList.add(new AffiliatesEntity(1, "Steve", 28, "srua10@gmail.com"));
        expectedAffiliateList.add(new AffiliatesEntity(2, "Shara", 25, "shara@gmail.com"));
        expectedAffiliateList.add(new AffiliatesEntity(3, "Celeste", 5, "celeste@gmail.com"));
        expectedAffiliateList.add(new AffiliatesEntity(4, "Amanda", 50, "Amanda@gmail.com"));

        Assertions.assertEquals(HttpStatus.OK, serviceResponse.getStatusCode());
        Assertions.assertEquals(expectedAffiliateList, serviceResponse.getBody());
    }

    @Test
    void testGetListAffiliatesVoid() {
        List<AffiliatesEntity> affiliatesList = new ArrayList<>();

        Mockito.when(affiliatesRepositoryMock.findAll()).thenReturn(affiliatesList);

        ResponseEntity<List<AffiliatesEntity>> serviceResponse;
        serviceResponse = affiliateController.getListAffiliates();

        List<AffiliatesEntity> expectedAffiliateList = new ArrayList<>();

        Assertions.assertEquals(HttpStatus.NO_CONTENT, serviceResponse.getStatusCode());
        Assertions.assertEquals(expectedAffiliateList, serviceResponse.getBody());
    }

    @Test
    void testGetAffiliateById() {
        AffiliatesEntity affiliate = new AffiliatesEntity(3, "Celeste", 5, "celeste@gmail.com");
        Optional<AffiliatesEntity> oAffiliate = Optional.of(affiliate);
        Mockito.when(affiliatesRepositoryMock.findById(3L)).thenReturn(oAffiliate);

        ResponseEntity<Optional<AffiliatesEntity>> serviceResponse;
        serviceResponse = affiliateController.getAffiliateById(3L);

        AffiliatesEntity expectedAffiliate = new AffiliatesEntity(3, "Celeste", 5, "celeste@gmail.com");
        Optional<AffiliatesEntity> oExpectedAffiliate = Optional.of(expectedAffiliate);

        Assertions.assertEquals(HttpStatus.OK, serviceResponse.getStatusCode());
        Assertions.assertEquals(oExpectedAffiliate, serviceResponse.getBody());

    }

    @Test
    @SuppressWarnings("AssertEqualsBetweenInconvertibleTypes")
    void testGetAffiliateByIdNotFound() {
        AffiliatesEntity affiliate = new AffiliatesEntity(3, "Celeste", 5, "celeste@gmail.com");
        Optional<AffiliatesEntity> oAffiliate = Optional.of(affiliate);

        Mockito.when(affiliatesRepositoryMock.findById(3L)).thenReturn(oAffiliate);

        ResponseEntity<Optional<AffiliatesEntity>> serviceResponse;
        serviceResponse = affiliateController.getAffiliateById(5L);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, serviceResponse.getStatusCode());
        Assertions.assertEquals(Optional.empty(), serviceResponse.getBody());

    }

    @Test
    void testNewAffiliate() {
        AffiliatesEntity affiliate = new AffiliatesEntity("Celeste", 5, "celeste@gmail.com");

        Mockito.when(affiliatesRepositoryMock.save(affiliate)).thenReturn(affiliate);

        ResponseEntity<AffiliatesEntity> serviceResponse;
        serviceResponse = affiliateController.newAffiliate(affiliate);

        AffiliatesEntity expectedAffiliate = new AffiliatesEntity("Celeste", 5, "celeste@gmail.com");

        Assertions.assertEquals(HttpStatus.CREATED, serviceResponse.getStatusCode());
        Assertions.assertEquals(expectedAffiliate, serviceResponse.getBody());
    }

    @Test
    void testNewAffiliateNotFound() {
        AffiliatesEntity affiliate = new AffiliatesEntity("Shara", 25, "shara@gmail.com");

        Mockito.when(affiliatesRepositoryMock.findByEmail(affiliate.getEmail())).thenReturn(affiliate);

        ResponseEntity<AffiliatesEntity> serviceResponse;
        serviceResponse = affiliateController.newAffiliate(affiliate);

        AffiliatesEntity expectedAffiliate = new AffiliatesEntity("Shara", 25, "shara@gmail.com");

        Assertions.assertEquals(HttpStatus.NOT_FOUND, serviceResponse.getStatusCode());
        Assertions.assertEquals(expectedAffiliate, serviceResponse.getBody());
    }

    @Test
    void testUpdateAffiliate() {
        AffiliatesEntity updateAffiliate = new AffiliatesEntity(1, "Shara", 25, "shara@gmail.com");
        Optional<AffiliatesEntity> oUpdateAffiliate = Optional.of(updateAffiliate);
        
        Mockito.when(affiliatesRepositoryMock.findById(updateAffiliate.getIdAffiliate())).thenReturn(oUpdateAffiliate);
        Mockito.when(affiliatesRepositoryMock.save(updateAffiliate)).thenReturn(updateAffiliate);

        ResponseEntity<AffiliatesEntity> serviceResponse;
        serviceResponse = affiliateController.updateAffiliate(updateAffiliate);

        AffiliatesEntity expectedAffiliate = new AffiliatesEntity(1, "Shara", 25, "shara@gmail.com");

        Assertions.assertEquals(HttpStatus.CREATED, serviceResponse.getStatusCode());
        Assertions.assertEquals(expectedAffiliate, serviceResponse.getBody());
    }

    @Test
    void testUpdateAffiliateNotFound() {
        AffiliatesEntity updateAffiliate = new AffiliatesEntity(17, "Shara", 25, "shara@gmail.com");        
        
        Mockito.when(affiliatesRepositoryMock.findById(updateAffiliate.getIdAffiliate())).thenReturn(Optional.empty());

        ResponseEntity<AffiliatesEntity> serviceResponse;
        serviceResponse = affiliateController.updateAffiliate(updateAffiliate);
        
        AffiliatesEntity expectedAffiliate = new AffiliatesEntity();
                
        Assertions.assertEquals(HttpStatus.NOT_FOUND, serviceResponse.getStatusCode());
        Assertions.assertEquals(expectedAffiliate, serviceResponse.getBody());
    }

    @Test
    void testDeleteAffiliate() {
        AffiliatesEntity deleteAffiliate = new AffiliatesEntity(1, "Shara", 25, "shara@gmail.com");
        Optional<AffiliatesEntity> oDeleteAffiliate = Optional.of(deleteAffiliate);

        Mockito.when(affiliatesRepositoryMock.findById(deleteAffiliate.getIdAffiliate())).thenReturn(oDeleteAffiliate);

        ResponseEntity serviceResponse;
        serviceResponse = affiliateController.deleteAffiliate(deleteAffiliate.getIdAffiliate());
        
        AffiliatesEntity expectedAffiliate = new AffiliatesEntity();
        
        Assertions.assertEquals(HttpStatus.OK, serviceResponse.getStatusCode());
        Assertions.assertEquals(expectedAffiliate, serviceResponse.getBody());
    }

    @Test
    void testDeleteAffiliateNotFound() {
        AffiliatesEntity deleteAffiliate = new AffiliatesEntity(1, "Shara", 25, "shara@gmail.com");

        Mockito.when(affiliatesRepositoryMock.findById(deleteAffiliate.getIdAffiliate())).thenReturn(Optional.empty());

        ResponseEntity serviceResponse;
        serviceResponse = affiliateController.deleteAffiliate(deleteAffiliate.getIdAffiliate());
        
        AffiliatesEntity expectedAffiliate = new AffiliatesEntity();

        Assertions.assertEquals(HttpStatus.NO_CONTENT, serviceResponse.getStatusCode());
        Assertions.assertEquals(expectedAffiliate, serviceResponse.getBody());
    }

}
