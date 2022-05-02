package cz.cvut.sh.eshop.controller;

import cz.cvut.sh.eshop.domain.Item;
import cz.cvut.sh.eshop.domain.ItemType;
import cz.cvut.sh.eshop.dto.PreviewItem;
import cz.cvut.sh.eshop.entity.ItemId;
import cz.cvut.sh.eshop.mapper.ItemMapperImpl;
import cz.cvut.sh.eshop.service.ItemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class ShirtItemControllerTestJunitOnly {

    private ShirtItemController underTest;

    @Mock
    private ItemService itemService;

    @BeforeEach
    void setUp() {
        this.underTest = new ShirtItemController(this.itemService, new ItemMapperImpl());
    }

    @Test
    void name() {
        final ItemId id = new ItemId(UUID.randomUUID());
        final Item blueShirt = new Item(id, "blueShirt", 5, ItemType.SHIRT, "blue", "nice blue shirt");

        Mockito.when(this.itemService.getItems(ItemType.SHIRT))
                .thenReturn(List.of(blueShirt));

        final var items = this.underTest.getItems();

        Assertions.assertEquals(List.of(new PreviewItem(id, "blueShirt")), items.getBody());
    }
}
