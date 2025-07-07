package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService; // 👈 We mock the service

    @Test
    public void testGetUserById() throws Exception {
        // Arrange
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setName("Abi");

        when(userService.getUserById(1L)).thenReturn(mockUser);

        // Act & Assert
        mockMvc.perform(get("/users/1"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Abi"));
    }
}
