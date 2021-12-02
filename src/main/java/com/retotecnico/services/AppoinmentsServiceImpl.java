package com.retotecnico.services;

import com.retotecnico.entities.AppoinmentsEntity;
import com.retotecnico.repositories.IAppoinmentsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AppoinmentsServiceImpl implements IAppoinmentsService {

  @Autowired
  private final IAppoinmentsRepository appoinmentsRepository;

  public AppoinmentsServiceImpl(IAppoinmentsRepository appoinmentsRepository) {
    this.appoinmentsRepository = appoinmentsRepository;
  }

  @Override
  public ResponseEntity<List<AppoinmentsEntity>> getList() {
    List<AppoinmentsEntity> listarAppoinments = (List<AppoinmentsEntity>) appoinmentsRepository.findAll();
    if (listarAppoinments.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
    return ResponseEntity.ok(listarAppoinments);
  }

  @Override
  public ResponseEntity<AppoinmentsEntity> getById(Long id) {
    Optional<AppoinmentsEntity> appoinmentsEntity = appoinmentsRepository.findById(id);
    if (appoinmentsEntity.isPresent()) {
      return ResponseEntity.ok(appoinmentsEntity.get());
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }

  @Override
  public ResponseEntity<AppoinmentsEntity> post(AppoinmentsEntity newAppoinments) {
    AppoinmentsEntity appoinmentsEntity = appoinmentsRepository.save(newAppoinments);
    if (appoinmentsEntity == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(appoinmentsEntity);
  }

  @Override
  public ResponseEntity<AppoinmentsEntity> put(AppoinmentsEntity updateAppoinments) {
    Optional<AppoinmentsEntity> appoinmentsEntity = appoinmentsRepository.findById(updateAppoinments.getIdAppoinments());
    if (appoinmentsEntity.isPresent()) {
      return ResponseEntity.status(HttpStatus.CREATED).body(appoinmentsRepository.save(updateAppoinments));
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }

  @Override
  public ResponseEntity delete(Long id) {
    Optional<AppoinmentsEntity> appoinmentsEntity = appoinmentsRepository.findById(id);
    if (appoinmentsEntity.isPresent()) {
      appoinmentsRepository.delete(appoinmentsEntity.get());
      return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
  }
}
