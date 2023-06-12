package com.ibm.bacenconsumer.Services.TaxasJurosMensalPorMesService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.bacenconsumer.Models.TaxasJurosMensalPorMes;
import com.ibm.bacenconsumer.Models.DTO.UpdateTaxasJurosMensalPorMesDTO;
import com.ibm.bacenconsumer.Repositories.ITaxasJurosMensalPorMesRepository;

@Service
public class UpdateTaxasJurosMensalPorMesService {
    private final ITaxasJurosMensalPorMesRepository _taxasJurosMensalPorMesRepository;

    public UpdateTaxasJurosMensalPorMesService(ITaxasJurosMensalPorMesRepository taxasJurosMensalPorMesRepository) {
        _taxasJurosMensalPorMesRepository = taxasJurosMensalPorMesRepository;
    }

    public ResponseEntity<Object> update(Long id, UpdateTaxasJurosMensalPorMesDTO updateTaxasJurosMensalPorMesDTO) {
        var lookingForTaxaJurosMensalPorMes = _taxasJurosMensalPorMesRepository.findById(id);
        if (lookingForTaxaJurosMensalPorMes.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Object() {
                public final Object message = "TaxasJurosMensalPorMes not found";
            });
        var taxaJurosMensalPorMes = TaxasJurosMensalPorMes.builder()
                .id(id)
                .mes(updateTaxasJurosMensalPorMesDTO.getMes())
                .modalidade(updateTaxasJurosMensalPorMesDTO.getModalidade())
                .posicao(updateTaxasJurosMensalPorMesDTO.getPosicao())
                .instituicaoFinanceira(updateTaxasJurosMensalPorMesDTO.getInstituicaoFinanceira())
                .taxaJurosAoMes(updateTaxasJurosMensalPorMesDTO.getTaxaJurosAoMes())
                .taxaJurosAoAno(updateTaxasJurosMensalPorMesDTO.getTaxaJurosAoAno())
                .cnpj8(updateTaxasJurosMensalPorMesDTO.getCnpj8())
                .anoMes(updateTaxasJurosMensalPorMesDTO.getAnoMes())
                .build();
        var taxaJurosMensalPorMesResult = _taxasJurosMensalPorMesRepository.save(taxaJurosMensalPorMes);
        return ResponseEntity.status(HttpStatus.OK).body(new Object() {
            public final Object message = "TaxasJurosMensalPorMes updated successfully";
            public final Object taxaJurosMensalPorMes = taxaJurosMensalPorMesResult;
        });
    }
}
