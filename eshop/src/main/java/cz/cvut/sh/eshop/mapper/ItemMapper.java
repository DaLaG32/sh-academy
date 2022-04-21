package cz.cvut.sh.eshop.mapper;

import cz.cvut.sh.eshop.domain.Item;
import cz.cvut.sh.eshop.dto.CreateItemDto;
import cz.cvut.sh.eshop.dto.DetailItem;
import cz.cvut.sh.eshop.dto.PreviewItem;
import cz.cvut.sh.eshop.entity.ItemEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ItemMapper {

    Item map(ItemEntity itemEntity);

    ItemEntity map(Item item);

    PreviewItem toPreview(Item item);

    DetailItem toDetail(Item item);

    Item map(CreateItemDto newItem);
}
