package com.ibm.bacenconsumer.Models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaxasJurosMensalPorMes {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty("id")
    @Id
    private Long id;
    @Column(name = "mes")
    @JsonProperty("Mes")
    private String mes;
    @Column(name = "modalidade")
    @JsonProperty("Modalidade")
    private String modalidade;
    @Column(name = "posicao")
    @JsonProperty("Posicao")
    private Integer posicao;
    @Column(name = "instituicao_financeira")
    @JsonProperty("InstituicaoFinanceira")
    private String instituicaoFinanceira;
    @Column(name = "taxa_juros_ao_mes")
    @JsonProperty("TaxaJurosAoMes")
    private BigDecimal taxaJurosAoMes;
    @Column(name = "taxa_juros_ao_ano")
    @JsonProperty("TaxaJurosAoAno")
    private BigDecimal taxaJurosAoAno;
    @Column(name = "cnpj8")
    @JsonProperty("cnpj8")
    private String cnpj8;
    @Column(name = "ano_mes")
    @JsonProperty("anoMes")
    private String anoMes;
}
