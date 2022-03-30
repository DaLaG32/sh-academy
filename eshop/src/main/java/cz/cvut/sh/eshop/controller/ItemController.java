package cz.cvut.sh.eshop.controller;

import cz.cvut.sh.eshop.domain.Item;
import cz.cvut.sh.eshop.dto.DetailItem;
import cz.cvut.sh.eshop.dto.PreviewItem;
import cz.cvut.sh.eshop.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService service;

    public ItemController(final ItemService itemServiceDbConnect) {
        this.service = itemServiceDbConnect;
    }

    @GetMapping
    public ResponseEntity<List<PreviewItem>> getItems(){
        return ResponseEntity.ok(service.getItems()
                .stream()
                .map(this::map)
                .collect(Collectors.toList()));
    }

    private PreviewItem map(Item item) {
        return new PreviewItem(item.getId(), item.getName());
    }

    private DetailItem mapDetail(Item item) {
        return new DetailItem(item.getId(), item.getName(), item.getCount(), item.getOption1(),
                item.getOption2(), item.getPicture());
    }

    @PostMapping
    public ResponseEntity<Item> createItem(Item newItem){
        return ResponseEntity.ok(service.createNew(newItem));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailItem> getItem(@PathVariable UUID id){
        return service.find(id)
                .map(this::mapDetail)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
