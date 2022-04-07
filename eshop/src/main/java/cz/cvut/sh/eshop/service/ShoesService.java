package cz.cvut.sh.eshop.service;

import cz.cvut.sh.eshop.config.ShirtItemTypeCondition;
import cz.cvut.sh.eshop.config.ShoesItemTypeCondition;
import cz.cvut.sh.eshop.domain.Item;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Conditional(ShoesItemTypeCondition.class)
public class ShoesService implements ItemService {

    private static final List<Item> ITEMS = new ArrayList<>(List.of(new Item(UUID.randomUUID(), "Nike Air", 123L, "","","" ),
            new Item(UUID.randomUUID(), "New Balance", 56L,"","",""),
            new Item(UUID.randomUUID(), "Salamander", 9L, "","","")));

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
