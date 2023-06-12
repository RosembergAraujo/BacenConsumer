package com.ibm.bacenconsumer.Controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@DisplayName("Home Controller Test")
@RunWith(MockitoJUnitRunner.Silent.class)
@AutoConfigureMockMvc
@SpringBootTest
class HomeControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("It Should Return Index.html")
    void welcome() throws Exception {
        var modelAndView = new HomeController().welcome();
        assertEquals("index.html", modelAndView.getViewName());
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
}
