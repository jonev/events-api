package statistics.eventsapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import statistics.eventsapi.service.EventService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService service;

    @Test
    void getEvent() throws Exception {
        doNothing().when(service).save(any());
        this.mockMvc.perform(post("/events/").contentType(MediaType.APPLICATION_JSON)
                .content("{\"eventType\":\"eventType\",\"appId\":\"appId\"}"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}