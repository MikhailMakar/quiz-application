package com.quiz.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quiz.model.User;
import com.quiz.service.UserService;
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
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void createUserTest() throws Exception {
        String userCreateJson = mapper.writeValueAsString(User.builder().build());

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(userCreateJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void getAllUsersTest() throws Exception {
        mockMvc.perform(get("/users/all"))
                .andExpect(status().isOk());
    }
}
