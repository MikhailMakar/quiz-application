package com.quiz.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quiz.model.Quiz;
import com.quiz.service.QuizService;
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
@WebMvcTest(controllers = QuizController.class)
public class QuizControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuizService quizService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void createQuizTest() throws Exception {
        String quizCreateJson = mapper.writeValueAsString(Quiz.builder().build());

        mockMvc.perform(post("/quizzes")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(quizCreateJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void getAllQuizzesTest() throws Exception {
        mockMvc.perform(get("/quizzes/all"))
                .andExpect(status().isOk());
    }
}
