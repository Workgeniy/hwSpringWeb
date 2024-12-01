package org.example.hwspringweb;

import jdk.dynalink.linker.support.Guards;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class PageControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private UserDtoRepository userDtoRepository;

    @Test
    void createNewCustomer() throws Exception {
        this.mockMvc
                .perform(post("/postRegistr")
                        .param("firstName", "Alex")
                        .param("lastName", "Tom")
                        .param("password", "123")
                        .param("email", "a@a.a")
                ).andExpect(status().isOk());

        assertThat(userDtoRepository.findOneByEmail("a@a.a")).isNotNull();

    }


    @Test
    void shouldReturnDefaultMessage() throws Exception {
        mockMvc.perform(get("/test_url")
        ).andDo(print()
        ).andExpect(status().isOk()
        ).andExpect(content().string(containsString("Test Response String")));
    }


}