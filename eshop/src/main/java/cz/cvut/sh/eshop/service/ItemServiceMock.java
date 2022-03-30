package cz.cvut.sh.eshop.service;

import cz.cvut.sh.eshop.domain.Item;
import cz.cvut.sh.eshop.dto.PreviewItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemServiceMock implements ItemService {

    private static final List<Item> ITEMS = new ArrayList<>(List.of(new Item(UUID.randomUUID(), "Blue shirt", 123L, "","","" ),
            new Item(UUID.randomUUID(), "Black jeans", 56L,"","",""),
            new Item(UUID.randomUUID(), "Green hood", 9L, "","","")));

    @Override
    public List<Item> getItems() {
        return ITEMS;
    }

    @Override
    public Item createNew(Item newItem) {
        var toSave = newItem.withId(UUID.randomUUID());
        ITEMS.add(toSave);
        return toSave;
    }

    @Override
    public Optional<Item> find(UUID id) {
        return ITEMS.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }
}
