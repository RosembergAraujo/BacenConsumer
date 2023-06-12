package com.ibm.bacenconsumer.Controllers;

import static com.ibm.bacenconsumer.Utils.DataCreator.INVALID_TOP_PARAM;
import static com.ibm.bacenconsumer.Utils.DataCreator.VALID_TOP_PARAM;
import static com.ibm.bacenconsumer.Utils.DataCreator.getValidlistOfTaxasJurosMensalPorMes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.ibm.bacenconsumer.Errors.BadParameterException;
import com.ibm.bacenconsumer.Models.DTO.RequestBacenApiResponseDTO;
import com.ibm.bacenconsumer.Services.IRequestBacenApiService;
import com.ibm.bacenconsumer.Services.RefreshOnboardingDatabaseService;

//@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Onboarding Controller Test")
@RunWith(MockitoJUnitRunner.Silent.class)
@WebMvcTest(OnboardingController.class)
class OnboardingControllerTest {
	@InjectMocks
	private OnboardingController _onboardingController;
	@MockBean
	private IRequestBacenApiService _requestBacenApiService;
	@MockBean
	private RefreshOnboardingDatabaseService _refreshOnboardingDatabaseService;
	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Should throw BadParameterException when $top is not a number")
	void triggerOnboardingShouldThrowBadParameterExceptionWhenTopIsNotANumber() throws Exception {
		when(_requestBacenApiService.getTaxasJurosMensalPorMes(INVALID_TOP_PARAM))
				.thenThrow(new BadParameterException("$top query parameter must be a number"));

		mockMvc.perform(get(String.format("/triggerOnboarding?$top=%s", INVALID_TOP_PARAM)))
				.andExpect(status().isBadRequest())
				.andExpect(response -> assertTrue(response.getResolvedException() instanceof BadParameterException))
				.andExpect(response -> assertEquals("$top query parameter must be a number",
						Objects.requireNonNull(response.getResolvedException()).getMessage()));
	}

	@Test
	@DisplayName("Should not throw BadParameterException when $top is a number")
	void triggerOnboardingShouldNotThrowBadParameterExceptionTopIsANumber() throws Exception {
		var requestBacenApiResponseDTO = new RequestBacenApiResponseDTO();
		requestBacenApiResponseDTO.setValue(getValidlistOfTaxasJurosMensalPorMes());

		when(_requestBacenApiService.getTaxasJurosMensalPorMes(VALID_TOP_PARAM)).thenReturn(requestBacenApiResponseDTO);
		when(_refreshOnboardingDatabaseService.refreshDatabase(getValidlistOfTaxasJurosMensalPorMes()))
				.thenReturn(getValidlistOfTaxasJurosMensalPorMes());

		mockMvc.perform(get(String.format("/triggerOnboarding?$top=%s", VALID_TOP_PARAM)))
				.andExpect(status().isOk());
	}
}
