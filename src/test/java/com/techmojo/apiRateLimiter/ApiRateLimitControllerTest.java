package com.techmojo.apiRateLimiter;

import com.techmojo.apiRateLimiter.ApiRateLimitApplication;
import com.techmojo.apiRateLimiter.repository.IRequestLogRepository;
import com.techmojo.apiRateLimiter.services.IApiRateLimitService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ApiRateLimitApplication.class)
@AutoConfigureMockMvc
@ComponentScan(basePackages = {"com.techmojo.apiRateLimiter"})
@TestPropertySource(locations = "classpath:application-test.properties")
public class ApiRateLimitControllerTest {

    @Value("${timeDuration}")
    private Integer timeDuration;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IRequestLogRepository iRequestLogRepository;

    @Test
    public void shouldReturnSuccess_WhenRateLimitThreshold_Not_Reached() throws Exception {
        Mockito.when(iRequestLogRepository.getLastHourRequestCount(anyString(),anyLong(), anyLong() )).thenReturn(3);
        ResultActions resultActions = mvc.perform(get("/api/rateLimit/1"))
                .andExpect(status().isOk());
        MvcResult response = resultActions.andReturn();
        String responseString = response.getResponse().getContentAsString();
        Assert.assertEquals("Successful", responseString);
    }

    @Test
    public void shouldReturnFailure_WhenRateLimitThreshold_Reached() throws Exception {
        Mockito.when(iRequestLogRepository.getLastHourRequestCount(anyString(),anyLong(), anyLong() )).thenReturn(5);
        ResultActions resultActions = mvc.perform(get("/api/rateLimit/1"))
                .andExpect(status().isOk());
        MvcResult response = resultActions.andReturn();
        String responseString = response.getResponse().getContentAsString();
        Assert.assertEquals("Api rate limit threshold reached try after some time", responseString);
    }
}