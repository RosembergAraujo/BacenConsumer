package com.ibm.bacenconsumer.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.bacenconsumer.Models.TaxasJurosMensalPorMes;

public interface ITaxasJurosMensalPorMesRepository extends JpaRepository<TaxasJurosMensalPorMes, Long> {
    Optional<List<TaxasJurosMensalPorMes>> findAllByAnoMes(String anoMes);
}
