package com.retotecnico.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class AppTests {

    private Long id_appoinment;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "es-CO", timezone = "America/Bogota")
    private Date date;
    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a", locale = "es-CO", timezone = "UTC")
    private Date hour;
    private String test_name;

    public AppTests(){

    }

    public AppTests(Long id_appoinment, Date date, Date hour, String test_name) {
        this.id_appoinment = id_appoinment;
        this.date = date;
        this.hour = hour;
        this.test_name = test_name;
    }
}
