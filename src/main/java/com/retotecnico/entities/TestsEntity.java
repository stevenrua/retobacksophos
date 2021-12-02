package com.retotecnico.entities;

import com.sun.istack.NotNull;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tests")
public class TestsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tests")
    private Long idtest;

    @Column(length = 45)
    @NotNull
    private String name;

    @Column(length = 200)
    @NotNull
    private String description;

    public TestsEntity() {
    }

    public TestsEntity(Long idtest) {
        this.idtest = idtest;
    }

    public TestsEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public TestsEntity(Long idtest, String name, String description) {
        this.idtest = idtest;
        this.name = name;
        this.description = description;
    }

    public Long getIdtest() {
        return idtest;
    }

    public void setIdtest(Long idtest) {
        this.idtest = idtest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "tests{" +
                "idtest=" + idtest +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
