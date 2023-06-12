package com.ibm.bacenconsumer.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ibm.bacenconsumer.Errors.BadParameterException;
import com.ibm.bacenconsumer.Models.TaxasJurosMensalPorMes;
import com.ibm.bacenconsumer.Repositories.ITaxasJurosMensalPorMesRepository;

@Service
public class RefreshOnboardingDatabaseService {
    private final ITaxasJurosMensalPorMesRepository _taxasJurosMensalPorMesRepository;

    public RefreshOnboardingDatabaseService(
            ITaxasJurosMensalPorMesRepository taxasJurosMensalPorMesRepository) {
        _taxasJurosMensalPorMesRepository = taxasJurosMensalPorMesRepository;
    }

    public List<TaxasJurosMensalPorMes> refreshDatabase(
            List<TaxasJurosMensalPorMes> taxasJurosMensalPorMesList) {
        _taxasJurosMensalPorMesRepository.deleteAll();
        return _taxasJurosMensalPorMesRepository.saveAll(taxasJurosMensalPorMesList);
    }

    public void checkValidTopParam(String topParam) {
        if (!topParam.chars().allMatch(Character::isDigit))
            throw new BadParameterException("$top query parameter must be a number");
    }
}
