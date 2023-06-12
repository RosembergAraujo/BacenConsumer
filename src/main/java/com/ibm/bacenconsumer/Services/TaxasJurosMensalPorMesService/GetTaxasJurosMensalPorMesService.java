package com.ibm.bacenconsumer.Services.TaxasJurosMensalPorMesService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.bacenconsumer.Models.TaxasJurosMensalPorMes;
import com.ibm.bacenconsumer.Repositories.ITaxasJurosMensalPorMesRepository;

@Service
public class GetTaxasJurosMensalPorMesService {
    private final ITaxasJurosMensalPorMesRepository _taxasJurosMensalPorMesRepository;

    public GetTaxasJurosMensalPorMesService(ITaxasJurosMensalPorMesRepository taxasJurosMensalPorMesRepository) {
        _taxasJurosMensalPorMesRepository = taxasJurosMensalPorMesRepository;
    }

    public ResponseEntity<Object> getById(Long id) {
        var taxaJurosMensalPorMesResult = _taxasJurosMensalPorMesRepository.findById(id);
        if (taxaJurosMensalPorMesResult.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Object() {
                public final Object message = "TaxasJurosMensalPorMes not found";
            });
        return ResponseEntity.status(HttpStatus.OK).body(new Object() {
            public final Object taxaJurosMensalPorMes = taxaJurosMensalPorMesResult;
        });
    }

    public ResponseEntity<Object> getByAnoMes(String anoMes) {
        var taxasJurosMensalPorMesResult = _taxasJurosMensalPorMesRepository.findAllByAnoMes(anoMes);
        if (taxasJurosMensalPorMesResult.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Object() {
                public final Object message = "TaxasJurosMensalPorMes not found";
            });
        return ResponseEntity.status(HttpStatus.OK).body(new Object() {
            public final Object taxasJurosMensalPorMes = taxasJurosMensalPorMesResult;
        });
    }

    public ResponseEntity<Object> get() {
        var taxasJurosMensalPorMesResult = _taxasJurosMensalPorMesRepository.findAll();
        return ResponseEntity.status(
                taxasJurosMensalPorMesResult.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK).body(new Object() {
                    public final Object taxasJurosMensalPorMes = taxasJurosMensalPorMesResult;
                });
    }

    public ResponseEntity<Object> getPageable(Pageable pageable) {
        Page<TaxasJurosMensalPorMes> taxasJurosMensalPorMesResult = _taxasJurosMensalPorMesRepository.findAll(pageable);
        return ResponseEntity.status(
                taxasJurosMensalPorMesResult.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK).body(new Object() {
                    public final Object taxasJurosMensalPorMesPageable = taxasJurosMensalPorMesResult;
                });
    }
}
