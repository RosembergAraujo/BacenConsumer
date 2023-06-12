package com.ibm.bacenconsumer.Services.TaxasJurosMensalPorMesService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.bacenconsumer.Repositories.ITaxasJurosMensalPorMesRepository;

@Service
public class DeleteTaxasJurosMensalPorMesService {
    private final ITaxasJurosMensalPorMesRepository _taxasJurosMensalPorMesRepository;

    public DeleteTaxasJurosMensalPorMesService(ITaxasJurosMensalPorMesRepository taxasJurosMensalPorMesRepository) {
        _taxasJurosMensalPorMesRepository = taxasJurosMensalPorMesRepository;
    }

    public ResponseEntity<Object> delete(Long id) {
        var taxaJurosMensalPorMesResult = _taxasJurosMensalPorMesRepository.findById(id);
        if (taxaJurosMensalPorMesResult.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Object() {
                public final Object message = "TaxasJurosMensalPorMes not found";
            });
        _taxasJurosMensalPorMesRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new Object() {
            public final Object message = "";
        });
    }
}
