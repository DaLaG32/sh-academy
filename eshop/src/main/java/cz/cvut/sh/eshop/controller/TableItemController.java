package cz.cvut.sh.eshop.controller;

import cz.cvut.sh.eshop.domain.ItemType;
import cz.cvut.sh.eshop.dto.CreateItemDto;
import cz.cvut.sh.eshop.dto.DetailItem;
import cz.cvut.sh.eshop.dto.PreviewItem;
import cz.cvut.sh.eshop.entity.ItemId;
import cz.cvut.sh.eshop.mapper.ItemMapper;
import cz.cvut.sh.eshop.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tables")
@PreAuthorize("hasRole('ROLE_TABLE')")
@AllArgsConstructor
public class TableItemController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @GetMapping
    public ResponseEntity<List<PreviewItem>> getItems() {
        return ResponseEntity.ok(this.itemService.getItems(ItemType.TABLE)
                .stream()
                .map(this.itemMapper::toPreview)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<DetailItem> createItem(@RequestBody final CreateItemDto createItemDto) {
        final var newItem = this.itemMapper.map(createItemDto)
                .withType(ItemType.TABLE);
        final var saved = this.itemService.createNew(newItem);
        return ResponseEntity.ok(this.itemMapper.toDetail(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailItem> getItem(@PathVariable final ItemId id) {
        return this.itemService.find(id)
                .filter(item -> item.getType().isTable())
                .map(this.itemMapper::toDetail)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
