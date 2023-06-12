package com.ibm.bacenconsumer.Services;

import static com.ibm.bacenconsumer.Utils.DataCreator.INVALID_TOP_PARAM;
import static com.ibm.bacenconsumer.Utils.DataCreator.VALID_TOP_PARAM;
import static com.ibm.bacenconsumer.Utils.DataCreator.getValidlistOfTaxasJurosMensalPorMes;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.ibm.bacenconsumer.Errors.BadParameterException;
import com.ibm.bacenconsumer.Repositories.ITaxasJurosMensalPorMesRepository;

@DisplayName("Refresh Onboarding Database Service Test")
@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
class RefreshOnboardingDatabaseServiceTest {
    @InjectMocks
    private RefreshOnboardingDatabaseService _refreshOnboardingDatabaseService;
    @Mock
    private ITaxasJurosMensalPorMesRepository _taxasJurosMensalPorMesRepository;

    @Test
    @DisplayName("Should return a list of TaxasJurosMensalPorMes when refreshDatabase is called")
    void refreshDatabaseShouldReturnAListOfTaxasJurosMensalPorMes() {
        doNothing().when(_taxasJurosMensalPorMesRepository).deleteAll();
        when(_taxasJurosMensalPorMesRepository.saveAll(getValidlistOfTaxasJurosMensalPorMes()))
                .thenReturn(getValidlistOfTaxasJurosMensalPorMes());
        var returnSize = _refreshOnboardingDatabaseService.refreshDatabase(getValidlistOfTaxasJurosMensalPorMes())
                .size();
        assertEquals(getValidlistOfTaxasJurosMensalPorMes().size(), returnSize);
    }

    @Test
    @DisplayName("Should throw BadParameterException when $top is not a number")
    void checkValidTopParamShouldThrowBadParameterExceptionWhenTopIsNotANumber() {
        assertThrows(BadParameterException.class,
                () -> _refreshOnboardingDatabaseService.checkValidTopParam(INVALID_TOP_PARAM));
    }

    @Test
    @DisplayName("Should not throw BadParameterException when $top is a number")
    void checkValidTopParamShouldNotThrowBadParameterExceptionWhenTopIsANumber() {
        assertDoesNotThrow(
                () -> _refreshOnboardingDatabaseService.checkValidTopParam(VALID_TOP_PARAM));
    }
}
