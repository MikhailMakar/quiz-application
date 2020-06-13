package com.quiz.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quiz.model.Question;
import com.quiz.service.QuestionService;
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
@WebMvcTest(controllers = QuestionController.class)
public class QuestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionService questionService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void createQuestionTest() throws Exception {
        String questionCreateJson = mapper.writeValueAsString(Question.builder().build());

        mockMvc.perform(post("/questions")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(questionCreateJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void getAllQuestionsTest() throws Exception {
        mockMvc.perform(get("/questions/all"))
                .andExpect(status().isOk());
    }
}
