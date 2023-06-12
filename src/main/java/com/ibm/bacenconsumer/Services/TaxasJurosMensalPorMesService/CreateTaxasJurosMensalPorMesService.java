package com.ibm.bacenconsumer.Services.TaxasJurosMensalPorMesService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.bacenconsumer.Models.TaxasJurosMensalPorMes;
import com.ibm.bacenconsumer.Models.DTO.CreateTaxasJurosMensalPorMesDTO;
import com.ibm.bacenconsumer.Repositories.ITaxasJurosMensalPorMesRepository;

@Service
public class CreateTaxasJurosMensalPorMesService {
    private final ITaxasJurosMensalPorMesRepository _taxasJurosMensalPorMesRepository;

    public CreateTaxasJurosMensalPorMesService(ITaxasJurosMensalPorMesRepository taxasJurosMensalPorMesRepository) {
        _taxasJurosMensalPorMesRepository = taxasJurosMensalPorMesRepository;
    }

    public ResponseEntity<Object> create(CreateTaxasJurosMensalPorMesDTO createTaxasJurosMensalPorMesDTO) {
        var taxasJurosMensalPorMes = TaxasJurosMensalPorMes.builder()
                .mes(createTaxasJurosMensalPorMesDTO.getMes())
                .modalidade(createTaxasJurosMensalPorMesDTO.getModalidade())
                .posicao(createTaxasJurosMensalPorMesDTO.getPosicao())
                .instituicaoFinanceira(createTaxasJurosMensalPorMesDTO.getInstituicaoFinanceira())
                .taxaJurosAoMes(createTaxasJurosMensalPorMesDTO.getTaxaJurosAoMes())
                .taxaJurosAoAno(createTaxasJurosMensalPorMesDTO.getTaxaJurosAoAno())
                .cnpj8(createTaxasJurosMensalPorMesDTO.getCnpj8())
                .anoMes(createTaxasJurosMensalPorMesDTO.getAnoMes())
                .build();
        var taxasJurosMensalPorMesResult = _taxasJurosMensalPorMesRepository.save(taxasJurosMensalPorMes);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Object() {
            public final Object message = "TaxasJurosMensalPorMes created successfully";
            public final Object taxasJurosMensalPorMes = taxasJurosMensalPorMesResult;
        });
    }
}
