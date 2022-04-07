package cz.cvut.sh.eshop.service;

import cz.cvut.sh.eshop.domain.Item;

import java.util.*;

public class ChairItemService implements ItemService {

    private static final List<Item> ITEMS = new ArrayList<>(List.of(new Item(UUID.randomUUID(), "Big chair", 123L, "","","" ),
            new Item(UUID.randomUUID(), "Sofa", 56L,"","",""),
            new Item(UUID.randomUUID(), "Wood chair", 9L, "","","")));

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
                .filter(item -> Objects.equals(item.getId(), id))
                .findFirst();
    }
}
