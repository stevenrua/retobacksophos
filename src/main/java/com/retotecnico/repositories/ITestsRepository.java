package com.retotecnico.repositories;

import com.retotecnico.entities.TestsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestsRepository extends JpaRepository<TestsEntity, Long> {

}
