package com.fiap.challenge_api.repository;

import com.fiap.challenge_api.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotoRepository extends JpaRepository<Moto, Long> {

    List<Moto> findByPlacaStartsWithIgnoreCase(String placa);
    List<Moto> findByStatusIgnoreCase(String status);


}
