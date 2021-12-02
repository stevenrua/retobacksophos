package com.retotecnico.services;

import com.retotecnico.entities.TestsEntity;
import com.retotecnico.repositories.ITestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestsServiceImpl implements ITestsService {

    @Autowired
    private ITestsRepository testsRepository;

    @Override
    public ResponseEntity<List<TestsEntity>> getList() {
        List<TestsEntity> listTests = testsRepository.findAll();

        if (listTests.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(listTests);

        return ResponseEntity.status(HttpStatus.OK).body(listTests);

    }

    @Override
    public ResponseEntity<Optional<Object>> getById(Long id) {
        Optional<TestsEntity> test = testsRepository.findById(id);
        return test.<ResponseEntity<Optional<Object>>>map(testsEntity -> ResponseEntity.ok(Optional.of(testsEntity))).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty()));
    }

    @Override
    public ResponseEntity<Optional<Object>> post(TestsEntity newTest) {
        ResponseEntity<Optional<Object>> test;
        try {
            test = ResponseEntity.status(HttpStatus.CREATED).body(Optional.of(testsRepository.save(newTest)));
        } catch (Exception e) {
            test = ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
        }
        return test;
    }

    @Override
    public ResponseEntity<TestsEntity> put(TestsEntity updateTest) {
        Optional<TestsEntity> updaTest = testsRepository.findById(updateTest.getIdtest());
        if (updaTest.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(testsRepository.save(updateTest));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new TestsEntity());

    }

    @Override
    public ResponseEntity<TestsEntity> delete(Long id) {
        Optional<TestsEntity> deleteTest = testsRepository.findById(id);

        if (deleteTest.isPresent()) {
            testsRepository.delete(new TestsEntity(id));
            return ResponseEntity.status(HttpStatus.OK).body(new TestsEntity());
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new TestsEntity());
    }
}
