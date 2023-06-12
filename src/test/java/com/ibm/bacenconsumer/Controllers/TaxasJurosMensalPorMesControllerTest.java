package com.ibm.bacenconsumer.Controllers;

import static com.ibm.bacenconsumer.Utils.DataCreator.getValidlistOfTaxasJurosMensalPorMes;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.bacenconsumer.Models.TaxasJurosMensalPorMes;
import com.ibm.bacenconsumer.Models.DTO.CreateTaxasJurosMensalPorMesDTO;
import com.ibm.bacenconsumer.Models.DTO.UpdateTaxasJurosMensalPorMesDTO;
import com.ibm.bacenconsumer.Services.TaxasJurosMensalPorMesService.CreateTaxasJurosMensalPorMesService;
import com.ibm.bacenconsumer.Services.TaxasJurosMensalPorMesService.DeleteTaxasJurosMensalPorMesService;
import com.ibm.bacenconsumer.Services.TaxasJurosMensalPorMesService.GetTaxasJurosMensalPorMesService;
import com.ibm.bacenconsumer.Services.TaxasJurosMensalPorMesService.UpdateTaxasJurosMensalPorMesService;

@DisplayName("Onboarding Controller Test")
@WebMvcTest(TaxasJurosMensalPorMesController.class)
@RunWith(MockitoJUnitRunner.Silent.class)
@AutoConfigureMockMvc
class TaxasJurosMensalPorMesControllerTest {
        @InjectMocks
        private TaxasJurosMensalPorMesController taxasJurosMensalPorMesController;
        @MockBean
        private CreateTaxasJurosMensalPorMesService _createTaxasJurosMensalPorMesService;
        @MockBean
        public GetTaxasJurosMensalPorMesService _getTaxasJurosMensalPorMesService;
        @MockBean
        public DeleteTaxasJurosMensalPorMesService _deleteTaxasJurosMensalPorMesService;
        @MockBean
        public UpdateTaxasJurosMensalPorMesService _updateTaxasJurosMensalPorMesService;
        @Autowired
        private ObjectMapper objectMapper;
        @Autowired
        private MockMvc mockMvc;
        private final TaxasJurosMensalPorMes firstValidElementList = getValidlistOfTaxasJurosMensalPorMes().get(0);
        private final String firstAnoMesOfValidList = firstValidElementList.getAnoMes();
        private final List<TaxasJurosMensalPorMes> listOfAnoMesThatIsEqualToFirstOne = getValidlistOfTaxasJurosMensalPorMes()
                        .stream().filter(
                                        taxasJurosMensalPorMes -> taxasJurosMensalPorMes.getAnoMes().equals(
                                                        firstAnoMesOfValidList))
                        .collect(Collectors.toList());
        private final Integer amountOfAnoMesThatIsEqualToFirstOne = listOfAnoMesThatIsEqualToFirstOne.size();

    @DisplayName("GET /taxasJurosMensalPorMes route")
    @Test
    void shouldReturnStatusOkWhenGetRequestIsCalled() throws Exception {
        when(_getTaxasJurosMensalPorMesService.get())
                .thenReturn(
                        ResponseEntity.status(HttpStatus.OK).body(new Object() {
                            public final Object taxasJurosMensalPorMes =
                                    getValidlistOfTaxasJurosMensalPorMes();
                        })
                );
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/taxasJurosMensalPorMes");
        mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.taxasJurosMensalPorMes").exists())
                .andExpect(jsonPath("$.taxasJurosMensalPorMes").isArray())
                .andExpect(jsonPath("$.taxasJurosMensalPorMes", hasSize(
                        getValidlistOfTaxasJurosMensalPorMes().size()
                )));
    }

    @DisplayName("GET /taxasJurosMensalPorMes route with a Id")
    @Test
    void shouldReturnStatusOkWhenGetRequestIsCalledWithAId() throws Exception {
        when(_getTaxasJurosMensalPorMesService.getById(any()))
                .thenReturn(
                        ResponseEntity.status(HttpStatus.OK).body(new Object() {
                            public final Object taxaJurosMensalPorMes =
                                    firstValidElementList;
                        })
                );
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/taxasJurosMensalPorMes/1");
        mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.taxaJurosMensalPorMes").exists())
                .andExpect(jsonPath("$.taxaJurosMensalPorMes.Mes", is(
                        firstValidElementList.getMes()
                )));
    }

    @DisplayName("GET /taxasJurosMensalPorMes/getByAnoMes route")
    @Test
    void shouldReturnStatusOkWhenGetRequestByAnoMesIsCalled() throws Exception {
        when(_getTaxasJurosMensalPorMesService.getByAnoMes(firstAnoMesOfValidList))
                .thenReturn(
                        ResponseEntity.status(HttpStatus.OK).body(new Object() {
                            public final Object taxasJurosMensalPorMes =
                                    listOfAnoMesThatIsEqualToFirstOne;
                        })
                );
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/taxasJurosMensalPorMes/getByAnoMes")
                        .param("anoMes", firstAnoMesOfValidList);
        mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.taxasJurosMensalPorMes").exists())
                .andExpect(jsonPath("$.taxasJurosMensalPorMes").isArray())
                .andExpect(jsonPath("$.taxasJurosMensalPorMes", hasSize(
                        amountOfAnoMesThatIsEqualToFirstOne
                )))
                .andExpect(jsonPath("$.taxasJurosMensalPorMes[0].Mes", is(
                        listOfAnoMesThatIsEqualToFirstOne.get(0).getMes()
                )));
    }

    @DisplayName("GET /taxasJurosMensalPorMes/getPageable route")
    @Test
    void shouldReturnStatusOkWhenGetRequestIsCalledWithPageable() throws Exception {
        when(_getTaxasJurosMensalPorMesService.getPageable(any()))
                .thenReturn(
                        ResponseEntity.status(HttpStatus.OK).body(new Object() {
                            public final Object taxasJurosMensalPorMesPageable =
                                    new PageImpl<TaxasJurosMensalPorMes>(getValidlistOfTaxasJurosMensalPorMes());
                        })
                );
        var pageableSize = String.valueOf(
                getValidlistOfTaxasJurosMensalPorMes().size() - 1);
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/taxasJurosMensalPorMes/getPageable")
                .param("size", pageableSize);
        mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.taxasJurosMensalPorMesPageable").exists())
                .andExpect(jsonPath("$.taxasJurosMensalPorMesPageable.content").exists())
                .andExpect(jsonPath("$.taxasJurosMensalPorMesPageable.content").isArray())
                .andExpect(jsonPath("$.taxasJurosMensalPorMesPageable.content", hasSize(
                        Integer.parseInt(pageableSize) + 1
                )))
                .andExpect(jsonPath("$.taxasJurosMensalPorMesPageable.content[0].Mes", is(
                        firstValidElementList.getMes()
                )));
    }

    @DisplayName("POST /taxasJurosMensalPorMes route")
    @Test
    void shouldReturnStatus201WhenPostRequestIsCalled() throws Exception {
        when(_createTaxasJurosMensalPorMesService.create(any(CreateTaxasJurosMensalPorMesDTO.class)))
                .thenReturn(
                        ResponseEntity.status(HttpStatus.CREATED).body(new Object() {
                            public final Object taxaJurosMensalPorMes =
                                    firstValidElementList;
                        })
                );
        var newTaxaDeJurosAsJson = new ObjectMapper().writeValueAsString(
                firstValidElementList
        );
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/taxasJurosMensalPorMes")
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8").content(newTaxaDeJurosAsJson);
        mockMvc.perform(builder)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.taxaJurosMensalPorMes.Modalidade", is(
                        firstValidElementList.getModalidade()
                )));
    }

    @DisplayName("PUT /taxasJurosMensalPorMes route")
    @Test
    void shouldReturnOkWhenPutRequestIsCalled() throws Exception {
        when(_updateTaxasJurosMensalPorMesService.update(
                any(),
                any(UpdateTaxasJurosMensalPorMesDTO.class)
        ))
                .thenReturn(
                        ResponseEntity.status(HttpStatus.OK).body(new Object() {
                            public final Object message = "TaxasJurosMensalPorMes updated successfully";
                            public final Object taxaJurosMensalPorMes = firstValidElementList;
                        })
                );
        firstValidElementList.setModalidade("newModalidade");
        var newTaxaDeJurosAsJson = new ObjectMapper().writeValueAsString(
                firstValidElementList
        );
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put(
                String.format("/taxasJurosMensalPorMes/%s", firstValidElementList.getId()))
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8").content(newTaxaDeJurosAsJson);
        mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.taxaJurosMensalPorMes.Modalidade", is(
                        "newModalidade"
                )));
    }

    @DisplayName("DELETE /taxasJurosMensalPorMes route")
    @Test
    void shouldReturnNoContentWhenDeleteRequestIsCalled() throws Exception {
        when(_deleteTaxasJurosMensalPorMesService.delete(any()))
                .thenReturn(
                        ResponseEntity.status(HttpStatus.NO_CONTENT).body(new Object() {
                            public final Object message = "";
                        })
                );
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.delete(
                        String.format("/taxasJurosMensalPorMes/%s", firstValidElementList.getId()))
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(builder)
                .andExpect(status().isNoContent());
    }
}
