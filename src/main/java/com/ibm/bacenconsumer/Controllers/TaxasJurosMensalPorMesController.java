package com.ibm.bacenconsumer.Controllers;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bacenconsumer.Models.DTO.CreateTaxasJurosMensalPorMesDTO;
import com.ibm.bacenconsumer.Models.DTO.UpdateTaxasJurosMensalPorMesDTO;
import com.ibm.bacenconsumer.Services.TaxasJurosMensalPorMesService.CreateTaxasJurosMensalPorMesService;
import com.ibm.bacenconsumer.Services.TaxasJurosMensalPorMesService.DeleteTaxasJurosMensalPorMesService;
import com.ibm.bacenconsumer.Services.TaxasJurosMensalPorMesService.GetTaxasJurosMensalPorMesService;
import com.ibm.bacenconsumer.Services.TaxasJurosMensalPorMesService.UpdateTaxasJurosMensalPorMesService;

@RestController
@RequestMapping("/taxasJurosMensalPorMes")
public class TaxasJurosMensalPorMesController {
    private final CreateTaxasJurosMensalPorMesService _createTaxasJurosMensalPorMesService;
    public final GetTaxasJurosMensalPorMesService _getTaxasJurosMensalPorMesService;
    public final DeleteTaxasJurosMensalPorMesService _deleteTaxasJurosMensalPorMesService;
    public final UpdateTaxasJurosMensalPorMesService _updateTaxasJurosMensalPorMesService;

    public TaxasJurosMensalPorMesController(
            CreateTaxasJurosMensalPorMesService createTaxasJurosMensalPorMesService,
            GetTaxasJurosMensalPorMesService getTaxasJurosMensalPorMesService,
            DeleteTaxasJurosMensalPorMesService deleteTaxasJurosMensalPorMesService,
            UpdateTaxasJurosMensalPorMesService updateTaxasJurosMensalPorMesService) {
        _createTaxasJurosMensalPorMesService = createTaxasJurosMensalPorMesService;
        _getTaxasJurosMensalPorMesService = getTaxasJurosMensalPorMesService;
        _deleteTaxasJurosMensalPorMesService = deleteTaxasJurosMensalPorMesService;
        _updateTaxasJurosMensalPorMesService = updateTaxasJurosMensalPorMesService;
    }

    @PostMapping()
    public ResponseEntity<Object> post(@RequestBody CreateTaxasJurosMensalPorMesDTO createTaxasJurosMensalPorMesDTO) {
        return _createTaxasJurosMensalPorMesService.create(createTaxasJurosMensalPorMesDTO);
    }

    @GetMapping("/{paramId}")
    public ResponseEntity<Object> getById(@PathVariable Long paramId) {
        return _getTaxasJurosMensalPorMesService.getById(paramId);
    }

    @GetMapping("/getByAnoMes")
    public ResponseEntity<Object> getByAnoMes(@RequestParam(name = "anoMes") String anoMes) {
        return _getTaxasJurosMensalPorMesService.getByAnoMes(anoMes);
    }

    @GetMapping("/getPageable")
    public ResponseEntity<Object> getPageable(Pageable pageable) {
        return _getTaxasJurosMensalPorMesService.getPageable(pageable);
    }

    @GetMapping()
    public ResponseEntity<Object> get() {
        return _getTaxasJurosMensalPorMesService.get();
    }

    @DeleteMapping("/{paramId}")
    public ResponseEntity<Object> delete(@PathVariable Long paramId) {
        return _deleteTaxasJurosMensalPorMesService.delete(paramId);
    }

    @PutMapping("/{paramId}")
    public ResponseEntity<Object> put(@PathVariable Long paramId,
            @RequestBody UpdateTaxasJurosMensalPorMesDTO updateTaxasJurosMensalPorMesDTO) {
        return _updateTaxasJurosMensalPorMesService.update(paramId, updateTaxasJurosMensalPorMesDTO);
    }
}
