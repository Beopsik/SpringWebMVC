package com.example.demospringwebmvcapplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FileControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void fileUploadTest() throws Exception{
        MockMultipartFile file = new MockMultipartFile("file", "kakaotalk.txt", "text/plain", "hello file".getBytes());
        this.mockMvc.perform(multipart("/file").file(file))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
    }


}