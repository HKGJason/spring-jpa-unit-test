package com.oocl.web.sampleWebApp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static junit.framework.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SingleEntityRepository singleEntityRepository;

    @Test
    public void testReturnStatus() throws Exception{
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/message")).andReturn();

        final MockHttpServletResponse response = result.getResponse();

        assertEquals(200, response.getStatus());
    }
    @Test
    public void testReturnMessage() throws Exception{
        MvcResult result = this.mockMvc.perform(get("/message")).andReturn();

        final String json = result.getResponse().getContentAsString();
        final ObjectMapper mapper = new ObjectMapper();
        final MessageResponse messageResponse = mapper.readValue(json, MessageResponse.class);

        assertEquals("Hi", messageResponse.getMsg());
    }

    @Test
    public void should_get_entity_name_message() throws Exception{
        SingleEntity entity = new SingleEntity();
        entity.setId(2L);
        entity.setName("testRepo");
        singleEntityRepository.save(entity);
        singleEntityRepository.flush();
        MvcResult result = this.mockMvc.perform(get("/singleentity")).andReturn();

        final String json = result.getResponse().getContentAsString();
        final ObjectMapper mapper = new ObjectMapper();
        final MessageResponse messageResponse = mapper.readValue(json, MessageResponse.class);

        assertEquals("testRepo", messageResponse.getMsg());

    }

}
