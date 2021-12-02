package com.retotecnico.services;

import com.retotecnico.entities.*;
import com.retotecnico.repositories.IAffiliatesRepository;
import com.retotecnico.repositories.IAppoinmentsRepository;
import com.retotecnico.repositories.ITestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

@Service
public class MasterServiceImpl implements IMasterService {

    @Autowired
    private final IAffiliatesRepository affiliatesRepo;
    @Autowired
    private final ITestsRepository testsRepo;
    @Autowired
    private final IAppoinmentsRepository appoinmentsRepo;

    public MasterServiceImpl(IAffiliatesRepository affiliatesRepo, ITestsRepository testsRepo, IAppoinmentsRepository appoinmentsRepo) {
        this.affiliatesRepo = affiliatesRepo;
        this.testsRepo = testsRepo;
        this.appoinmentsRepo = appoinmentsRepo;
    }

    @Override
    public ResponseEntity<List<MasterEntity>> getbydate(String date) {

        List<AppoinmentsEntity> listAppoiments = appoinmentsRepo.findBydate(date);
        if (!listAppoiments.isEmpty()) {

            return ResponseEntity.ok(createdListMaster(listAppoiments));
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @Override
    public ResponseEntity<List<MasterEntity>> getbyaffiliates(Long id_affiliate) {

        List<AppoinmentsEntity> listAppoiments = appoinmentsRepo.findAllByidAffiliates(id_affiliate);

        if (!listAppoiments.isEmpty()) {

            return ResponseEntity.ok(createdListMaster(listAppoiments));
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    private List<MasterEntity> createdListMaster(List<AppoinmentsEntity> listAppoiments) {
        List<MasterEntity> listMaster = new ArrayList<>();
        Optional<AffiliatesEntity> affiliate;
        Optional<TestsEntity> tests;
        List<AppTests> appTests = new ArrayList<>();
        List<AffiliatesEntity> listAffiliate = new ArrayList<>();
        
        for (AppoinmentsEntity appoiment : listAppoiments) {
            affiliate = affiliatesRepo.findById(appoiment.getId_affiliates());
            tests = testsRepo.findById(appoiment.getId_tests());
            if (listAffiliate.contains(affiliate.get())) {                
                int getIndex = listAffiliate.indexOf(affiliate.get());
                appTests = listMaster.get(getIndex).getListAppTests();
                appTests.add(new AppTests(appoiment.getIdAppoinments(), appoiment.getDate(),
                        appoiment.getHours(), tests.get().getName()));
                listMaster.get(getIndex).setListAppTests(appTests);
            }
            if (!listAffiliate.contains(affiliate.get())) {
                appTests = new ArrayList<>();
                appTests.add(new AppTests(appoiment.getIdAppoinments(), appoiment.getDate(),
                        appoiment.getHours(), tests.get().getName()));
                listMaster.add(new MasterEntity(affiliate.get(), appTests));
                listAffiliate.add(affiliate.get());
            }
        }
        return listMaster;
    }
}
