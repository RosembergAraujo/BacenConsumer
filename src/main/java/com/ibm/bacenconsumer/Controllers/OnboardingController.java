package com.ibm.bacenconsumer.Controllers;

import static com.ibm.bacenconsumer.Constants.Constants.DEFAULT_TOP_VALUE_REFRESH_ONBOARDING;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bacenconsumer.Models.TaxasJurosMensalPorMes;
import com.ibm.bacenconsumer.Services.IRequestBacenApiService;
import com.ibm.bacenconsumer.Services.RefreshOnboardingDatabaseService;

@RestController
@RequestMapping("/triggerOnboarding")
public class OnboardingController {
	private final IRequestBacenApiService _requestBacenApiService;
	private final RefreshOnboardingDatabaseService _refreshOnboardingDatabaseService;

	public OnboardingController(IRequestBacenApiService requestBacenApiService,
			RefreshOnboardingDatabaseService refreshOnboardingDatabaseService) {
		_requestBacenApiService = requestBacenApiService;
		_refreshOnboardingDatabaseService = refreshOnboardingDatabaseService;
	}

	@GetMapping()
	public List<TaxasJurosMensalPorMes> triggerOnboarding(
			@RequestParam(value = "$top", required = false) Optional<String> top) {
		top.ifPresent(_refreshOnboardingDatabaseService::checkValidTopParam);
		List<TaxasJurosMensalPorMes> listOfTaxaDeJuros = _requestBacenApiService
				.getTaxasJurosMensalPorMes(
						top.orElse(DEFAULT_TOP_VALUE_REFRESH_ONBOARDING))
				.getValue();
		return _refreshOnboardingDatabaseService.refreshDatabase(
				listOfTaxaDeJuros);
	}
}
