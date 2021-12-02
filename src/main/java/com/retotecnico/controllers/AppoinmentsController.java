package com.retotecnico.controllers;

import com.retotecnico.entities.AppoinmentsEntity;
import com.retotecnico.services.IAppoinmentsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/appoinmentscontroller/api")
public class AppoinmentsController {
  
  @Autowired
  private final IAppoinmentsService appoinmentsService;
  
  public AppoinmentsController(IAppoinmentsService appoinmentsService) {
    this.appoinmentsService = appoinmentsService;
  }
  
  @GetMapping("/getlist")
    public ResponseEntity<List<AppoinmentsEntity>> getListAppoinments() {
        return appoinmentsService.getList();
    }
    
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<AppoinmentsEntity> getAppoinmentsById(@PathVariable(value = "id") Long id) {
        return appoinmentsService.getById(id);
    }
    
    @PostMapping("/post")
    public ResponseEntity<AppoinmentsEntity> newAppoinments(@RequestBody AppoinmentsEntity newAppoinment) {
        return appoinmentsService.post(newAppoinment);
    }

    @PutMapping("/put")
    public ResponseEntity<AppoinmentsEntity> updateAppoinments(@RequestBody AppoinmentsEntity updateAppoinment) {
        return appoinmentsService.put(updateAppoinment);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAppoinments(@PathVariable(value = "id") Long id) {
        return appoinmentsService.delete(id);
    }
}
