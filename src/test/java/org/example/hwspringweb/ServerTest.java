package org.example.hwspringweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ServerTest {
    @Autowired
    MockMvc mockMvc;
    @Test
    void shouldReturnDefaultMessage() throws Exception {
        mockMvc.perform(get("/test_url")
        ).andDo(print()
        ).andExpect(status().isOk()
        ).andExpect(content().string(
                containsString("Test Response String")));
    }

    private RequestBuilder get(String s) {
    }


}
