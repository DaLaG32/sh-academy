package cz.cvut.sh.eshop.service;

import cz.cvut.sh.eshop.domain.Item;
import cz.cvut.sh.eshop.domain.ItemType;
import cz.cvut.sh.eshop.entity.ItemId;
import cz.cvut.sh.eshop.mapper.ItemMapper;
import cz.cvut.sh.eshop.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DefaultItemService implements ItemService {

    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    @Override
    public List<Item> getItems(final ItemType itemType) {
        return this.itemRepository.findAllByType(itemType)
                .stream()
                .map(this.itemMapper::map)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Item createNew(final Item newItem) {
        final var toSave = this.itemMapper.map(newItem.withId(new ItemId(UUID.randomUUID())));
        final var saved = this.itemRepository.save(toSave);
        return this.itemMapper.map(saved);
    }

    @Override
    public Optional<Item> find(final ItemId id) {
        return this.itemRepository.findById(id)
                .map(this.itemMapper::map);
    }
}
