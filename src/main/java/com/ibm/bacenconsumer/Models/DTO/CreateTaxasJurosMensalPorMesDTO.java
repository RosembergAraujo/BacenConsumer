package com.ibm.bacenconsumer.Models.DTO;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.bacenconsumer.Annotations.Generated;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Generated
public class CreateTaxasJurosMensalPorMesDTO {
    @JsonProperty("Mes")
    private String mes;
    @JsonProperty("Modalidade")
    private String modalidade;
    @JsonProperty("Posicao")
    private Integer posicao;
    @JsonProperty("InstituicaoFinanceira")
    private String instituicaoFinanceira;
    @JsonProperty("TaxaJurosAoMes")
    private BigDecimal taxaJurosAoMes;
    @JsonProperty("TaxaJurosAoAno")
    private BigDecimal taxaJurosAoAno;
    @JsonProperty("cnpj8")
    private String cnpj8;
    @JsonProperty("anoMes")
    private String anoMes;
}
