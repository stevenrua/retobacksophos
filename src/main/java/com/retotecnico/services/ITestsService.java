package com.retotecnico.services;

import com.retotecnico.entities.TestsEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ITestsService {

    public ResponseEntity<List<TestsEntity>> getList();

    public ResponseEntity<Optional<Object>> getById(Long id);

    public ResponseEntity<Optional<Object>> post(TestsEntity newTest);

    public ResponseEntity<TestsEntity> put(TestsEntity updateTest);

    public ResponseEntity<TestsEntity> delete(Long id);
}
