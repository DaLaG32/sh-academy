package cz.cvut.sh.eshop.service;

import cz.cvut.sh.eshop.domain.Item;
import cz.cvut.sh.eshop.dto.PreviewItem;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ItemService {
    List<Item> getItems();

    Item createNew(Item newItem);

    Optional<Item> find(UUID id);
}
