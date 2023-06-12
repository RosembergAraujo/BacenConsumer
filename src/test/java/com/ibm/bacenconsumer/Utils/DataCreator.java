package com.ibm.bacenconsumer.Utils;

import java.math.BigDecimal;
import java.util.List;

import com.ibm.bacenconsumer.Models.TaxasJurosMensalPorMes;

public class DataCreator {
        public static final String INVALID_TOP_PARAM = "1A";
        public static final String VALID_TOP_PARAM = "1";

        public static List<TaxasJurosMensalPorMes> getValidlistOfTaxasJurosMensalPorMes() {
                return List.of(
                                TaxasJurosMensalPorMes.builder()
                                                .id(0L)
                                                .mes("Jan-2023")
                                                .modalidade("FINANCIAMENTO IMOBILIÁRIO COM TAXAS REGULADAS - PRÉ-FIXADO")
                                                .posicao(2)
                                                .instituicaoFinanceira("BCO DO BRASIL S.A.")
                                                .taxaJurosAoMes(BigDecimal.ZERO)
                                                .taxaJurosAoAno(BigDecimal.ZERO)
                                                .cnpj8("00000000")
                                                .anoMes("2023-02")
                                                .build(),
                                TaxasJurosMensalPorMes.builder()
                                                .id(1L)
                                                .mes("Jan-2023")
                                                .modalidade("FINANCIAMENTO IMOBILIÁRIO COM TAXAS REGULADAS - PRÉ-FIXADO")
                                                .posicao(2)
                                                .instituicaoFinanceira("BCO DO BRASIL S.A.")
                                                .taxaJurosAoMes(BigDecimal.ZERO)
                                                .taxaJurosAoAno(BigDecimal.ZERO)
                                                .cnpj8("00000000")
                                                .anoMes("2023-02")
                                                .build(),
                                TaxasJurosMensalPorMes.builder()
                                                .id(2L)
                                                .mes("Jan-2023")
                                                .modalidade("FINANCIAMENTO IMOBILIÁRIO COM TAXAS REGULADAS - PRÉ-FIXADO")
                                                .posicao(2)
                                                .instituicaoFinanceira("BCO DO BRASIL S.A.")
                                                .taxaJurosAoMes(BigDecimal.ZERO)
                                                .taxaJurosAoAno(BigDecimal.ZERO)
                                                .cnpj8("00000000")
                                                .anoMes("2023-01")
                                                .build(),
                                TaxasJurosMensalPorMes.builder()
                                                .id(3L)
                                                .mes("Jan-2023")
                                                .modalidade("FINANCIAMENTO IMOBILIÁRIO COM TAXAS REGULADAS - PRÉ-FIXADO")
                                                .posicao(2)
                                                .instituicaoFinanceira("BCO DO BRASIL S.A.")
                                                .taxaJurosAoMes(BigDecimal.ZERO)
                                                .taxaJurosAoAno(BigDecimal.ZERO)
                                                .cnpj8("00000000")
                                                .anoMes("2023-01")
                                                .build());
        }
}
