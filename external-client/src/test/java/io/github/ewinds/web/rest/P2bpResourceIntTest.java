package io.github.ewinds.web.rest;

import io.github.ewinds.ExternalApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the P2bp REST controller.
 *
 * @see P2bpResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExternalApp.class)
public class P2bpResourceIntTest {

    private MockMvc restMockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        P2bpResource p2bpResource = new P2bpResource();
        restMockMvc = MockMvcBuilders
            .standaloneSetup(p2bpResource)
            .build();
    }

    /**
    * Test defaultAction
    */
    @Test
    public void testDefaultAction() throws Exception {
        restMockMvc.perform(get("/api/p-2-bp/default-action"))
            .andExpect(status().isOk());
    }

}
