package cz.cvut.sh.eshop.service;

import cz.cvut.sh.eshop.domain.Item;
import cz.cvut.sh.eshop.domain.ItemType;
import cz.cvut.sh.eshop.entity.ItemId;
import cz.cvut.sh.eshop.mapper.ItemMapper;
import cz.cvut.sh.eshop.repository.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class DefaultItemServiceTest {
    private final static UUID RANDOM_UUID = UUID.randomUUID();

    private DefaultItemService underTest;

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private ItemMapper itemMapper;

    @BeforeEach
    void setUp() {
        this.underTest = new DefaultItemService(this.itemRepository, this.itemMapper);
    }

    @Test
    @DisplayName("Description of test")
    void testMethodName() {
        // init testing data
        final var toSave = new Item(null, "table", 5, ItemType.TABLE, "brown", "Brown table");
        final var expected = new Item(new ItemId(RANDOM_UUID), "table", 5, ItemType.TABLE, "brown", "Brown table");
        // mock dependencies

        // perform operation
        final var actual = this.underTest.createNew(toSave);

        // verify results
        Assertions.assertEquals(expected, actual);
    }
}
