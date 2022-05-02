package cz.cvut.sh.eshop.controller;

import cz.cvut.sh.eshop.domain.Item;
import cz.cvut.sh.eshop.domain.ItemType;
import cz.cvut.sh.eshop.entity.ItemId;
import cz.cvut.sh.eshop.mapper.ItemMapper;
import cz.cvut.sh.eshop.mapper.ItemMapperImpl;
import cz.cvut.sh.eshop.service.ItemService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WithMockUser(roles = {"SHIRT"})
@WebMvcTest(value = ShirtItemController.class)
class ShirtItemControllerTest {
    @TestConfiguration
    static class AdditionalConfig {
        @Bean
        public ItemMapper itemMapper() {
            return new ItemMapperImpl();
        }
    }

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ItemService itemService;

    @Test
    void name() throws Exception {
        final Item blueShirt = new Item(new ItemId(UUID.randomUUID()), "blueShirt", 5, ItemType.SHIRT, "blue", "nice blue shirt");

//        Mockito.when(this.itemService.getItems(ItemType.SHIRT))
//                .thenReturn(List.of(blueShirt));

        this.mvc.perform(get("/shirts").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is(blueShirt.getName())));
    }
}
