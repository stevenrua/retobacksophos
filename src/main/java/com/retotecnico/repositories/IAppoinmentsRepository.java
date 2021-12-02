package com.retotecnico.repositories;

import com.retotecnico.entities.AppoinmentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface IAppoinmentsRepository extends JpaRepository<AppoinmentsEntity, Long> {

    @Query(value = "SELECT * FROM reto.apoinments ap WHERE ap.date = ?1", nativeQuery = true)
    public List<AppoinmentsEntity> findBydate(String date);

    public List<AppoinmentsEntity> findAllByidAffiliates(Long id);
}
