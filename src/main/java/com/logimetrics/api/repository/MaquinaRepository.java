package com.logimetrics.api.repository;

import com.logimetrics.api.model.Maquina;
import com.logimetrics.api.model.StatusMaquina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MaquinaRepository extends JpaRepository<Maquina, Long> {
    // O Spring Data JPA entende que "findByStatus" deve filtrar pela coluna status
    List<Maquina> findByStatus(StatusMaquina status);
}