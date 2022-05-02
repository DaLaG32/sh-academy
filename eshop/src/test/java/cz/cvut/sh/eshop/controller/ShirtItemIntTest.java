package cz.cvut.sh.eshop.controller;

import cz.cvut.sh.eshop.dto.CreateItemDto;
import cz.cvut.sh.eshop.dto.DetailItem;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ShirtItemIntTest {

    @LocalServerPort
    private int port;

    @Test
    void name() throws Exception {
        final var createItemDto = new CreateItemDto("blueShirt", 5L, "blue", "some details");
        final var expected = new DetailItem(null, "blueShirt", 5L, "blue", "some details");

        final var template = new TestRestTemplate("shirt_manager", "password");

        final var request = RequestEntity.post("http://localhost:" + this.port + "/shirts")
                .body(createItemDto);

        final var actual = template.exchange(request, DetailItem.class);

        log.debug("{}", actual);

        Assertions.assertEquals(HttpStatus.CREATED, actual.getStatusCode());
        Assertions.assertNotNull(actual.getBody());
        Assertions.assertEquals(expected.getName(), actual.getBody().getName());
    }
}
