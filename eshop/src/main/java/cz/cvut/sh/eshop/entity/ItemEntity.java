package cz.cvut.sh.eshop.entity;

import cz.cvut.sh.eshop.domain.ItemType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Data
@Entity
@javax.persistence.Table(name = "ITEM")
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity implements Serializable {

    private static final long serialVersionUID = 2323048760291911994L;

    @EmbeddedId
    private ItemId id;

    private String name;

    private long count;

    @Enumerated(EnumType.STRING)
    private ItemType type;

    private String color;

    private String details;
}
