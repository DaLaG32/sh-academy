package cz.cvut.sh.eshop.service;

import cz.cvut.sh.eshop.domain.Item;
import cz.cvut.sh.eshop.domain.ItemType;
import cz.cvut.sh.eshop.entity.ItemId;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> getItems(ItemType itemType);

    Item createNew(Item newItem);

    Optional<Item> find(ItemId id);
}
