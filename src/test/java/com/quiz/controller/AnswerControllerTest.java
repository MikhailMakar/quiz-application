package com.quiz.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quiz.model.Answer;
import com.quiz.service.AnswerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AnswerController.class)
public class AnswerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnswerService answerService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void createAnswerTest() throws Exception {
        String answerCreateJson = mapper.writeValueAsString(Answer.builder().build());

        mockMvc.perform(post("/answers")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(answerCreateJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void getAllAnswersTest() throws Exception {
        mockMvc.perform(get("/answers/all"))
                .andExpect(status().isOk());
    }
}
