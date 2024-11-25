package org.example.hwspringweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HwSpringWebApplicationTests {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    PageController pageController;
    @Test
    void contextLoads() throws Exception {
        assertThat(pageController).isNotNull();
    }

    @Test
    void buy_something() throws Exception {
        Wallet w = new Wallet("Ticket to the Moon", 2000.);
        mockMvc.perform(post("/kupi")
                //).andExpect(view().name("customers")
        ).andExpect(model().attributeExists("puprose")
        ).andExpect(model().attributeExists("quantity")
        ).andExpect(status().isOk());

//        List<Wallet> ws = service.find
    }


}
