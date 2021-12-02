package com.retotecnico.services;

import com.retotecnico.entities.MasterEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IMasterService {

    public ResponseEntity<List<MasterEntity>> getbydate(String date);

    public ResponseEntity<List<MasterEntity>> getbyaffiliates(Long id_affiliate);

}
