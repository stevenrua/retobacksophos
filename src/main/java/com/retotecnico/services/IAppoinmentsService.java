package com.retotecnico.services;

import com.retotecnico.entities.AppoinmentsEntity;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface IAppoinmentsService {

  public ResponseEntity<List<AppoinmentsEntity>> getList();

  public ResponseEntity<AppoinmentsEntity> getById(Long id);

  public ResponseEntity<AppoinmentsEntity> post(AppoinmentsEntity newAppoinments);

  public ResponseEntity<AppoinmentsEntity> put(AppoinmentsEntity updateAppoinments);

  public ResponseEntity delete(Long id);
}
