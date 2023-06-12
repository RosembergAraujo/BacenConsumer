package com.ibm.bacenconsumer.Services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.bacenconsumer.Annotations.Generated;
import com.ibm.bacenconsumer.Models.DTO.RequestBacenApiResponseDTO;

@Service
@FeignClient(name = "bacen", url = "${BACEN_API_URL}")
@Generated
public interface IRequestBacenApiService {
    @GetMapping(value = "?$format=json")
    RequestBacenApiResponseDTO getTaxasJurosMensalPorMes(
            @RequestParam(value = "$top") String top);
}
