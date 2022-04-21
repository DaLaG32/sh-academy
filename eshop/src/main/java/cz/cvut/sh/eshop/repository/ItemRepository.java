package cz.cvut.sh.eshop.repository;

import cz.cvut.sh.eshop.domain.ItemType;
import cz.cvut.sh.eshop.entity.ItemEntity;
import cz.cvut.sh.eshop.entity.ItemId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity, ItemId> {
    List<ItemEntity> findAllByType(ItemType type);
}
