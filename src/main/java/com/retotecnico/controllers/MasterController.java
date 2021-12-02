package com.retotecnico.controllers;

import com.retotecnico.entities.MasterEntity;
import com.retotecnico.services.IMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/mastercontroller/api")
public class MasterController {

    @Autowired
    public final IMasterService masterService;

    public MasterController(IMasterService masterService) {
        this.masterService = masterService;
    }

    @GetMapping("/getbydate/{date}")
    public ResponseEntity<List<MasterEntity>> getByDate(@PathVariable(value = "date") String date) {
        return masterService.getbydate(date);
    }

    @GetMapping("/getbyidaffiliate/{idAffiliate}")
    public ResponseEntity<List<MasterEntity>> getByIdAffiliate(@PathVariable(value = "idAffiliate") Long id) {
        return masterService.getbyaffiliates(id);
    }

}
