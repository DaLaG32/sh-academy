package cz.cvut.sh.eshop.controller;

import cz.cvut.sh.eshop.domain.ItemType;
import cz.cvut.sh.eshop.dto.CreateItemDto;
import cz.cvut.sh.eshop.dto.DetailItem;
import cz.cvut.sh.eshop.dto.PreviewItem;
import cz.cvut.sh.eshop.entity.ItemId;
import cz.cvut.sh.eshop.mapper.ItemMapper;
import cz.cvut.sh.eshop.service.ItemService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/shirts")
@AllArgsConstructor
public class ShirtItemController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @GetMapping
    public ResponseEntity<List<PreviewItem>> getItems() {
        return ResponseEntity.ok(this.itemService.getItems(ItemType.SHIRT)
                .stream()
                .map(this.itemMapper::toPreview)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<DetailItem> createItem(@RequestBody final CreateItemDto createItemDto) {
        final var newItem = this.itemMapper.map(createItemDto)
                .withType(ItemType.SHIRT);
        final var saved = this.itemService.createNew(newItem);
        return ResponseEntity.ok(this.itemMapper.toDetail(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailItem> getItem(@PathVariable final ItemId id) {
        return this.itemService.find(id)
                .filter(item -> item.getType().isShirt())
                .map(this.itemMapper::toDetail)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
