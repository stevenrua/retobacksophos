package com.retotecnico.controllers;

import com.retotecnico.entities.TestsEntity;
import com.retotecnico.services.ITestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/testscontroller/api")
public class TestsController {

    @Autowired
    private ITestsService testsService;

    @GetMapping("/getlist")
    public ResponseEntity<List<TestsEntity>> getListTest() {
        return testsService.getList();
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Optional<Object>> getTestById(@PathVariable(value = "id") Long id) {
        return testsService.getById(id);
    }

    @PostMapping("/post")
    public ResponseEntity<Optional<Object>> newTest(@RequestBody TestsEntity testnew) {
        return testsService.post(testnew);
    }

    @PutMapping("/put")
    public ResponseEntity<TestsEntity> updateTest(@RequestBody TestsEntity updatetest) {
        return testsService.put(updatetest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TestsEntity> deleteTest(@PathVariable(value = "id") Long id) {
        return testsService.delete(id);
    }

}
