package com.ibm.bacenconsumer.Models.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.bacenconsumer.Annotations.Generated;
import com.ibm.bacenconsumer.Models.TaxasJurosMensalPorMes;

import lombok.Data;

@Data
@Generated
public class RequestBacenApiResponseDTO {
    @JsonProperty("@odata.context")
    private String context;
    @JsonProperty("value")
    private List<TaxasJurosMensalPorMes> value;
}
