package com.retotecnico.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "apoinments")
public class AppoinmentsEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_apoinments")
  private long idAppoinments;

  @NotNull
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "es-CO", timezone = "America/Bogota")
  private Date date;

  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a", locale = "es-CO", timezone = "UTC")
  private Date hours;

  @NotNull
  @Column(name = "id_tests")
  private long idTests;

  @NotNull
  @Column(name = "id_affiliates")
  private long idAffiliates;

  public AppoinmentsEntity() {
  }

  public AppoinmentsEntity(long idAppoinments) {
    this.idAppoinments = idAppoinments;
  }

  public AppoinmentsEntity(Date date, Date hours, long id_tests, long id_affiliates) {
    this.date = date;
    this.hours = hours;
    this.idTests = id_tests;
    this.idAffiliates = id_affiliates;
  }

  public AppoinmentsEntity(long idAppoinments, Date date, Date hours, long id_tests, long id_affiliates) {
    this.idAppoinments = idAppoinments;
    this.date = date;
    this.hours = hours;
    this.idTests = id_tests;
    this.idAffiliates = id_affiliates;
  }

  public long getIdAppoinments() {
    return idAppoinments;
  }

  public void setIdAppoinments(long idAppoinments) {
    this.idAppoinments = idAppoinments;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Date getHours() {
    return hours;
  }

  public void setHours(Date hours) {
    this.hours = hours;
  }

  public long getId_tests() {
    return idTests;
  }

  public void setId_tests(long id_tests) {
    this.idTests = id_tests;
  }

  public long getId_affiliates() {
    return idAffiliates;
  }

  public void setId_affiliates(long id_affiliates) {
    this.idAffiliates = id_affiliates;
  }

  @Override
  public String toString() {
    return "AppoinmentsEntity{" + "idAppoinments=" + idAppoinments + ", date=" + date + ", hours=" + hours + ", id_tests=" + idTests + ", id_affiliates=" + idAffiliates + '}';
  }
}
