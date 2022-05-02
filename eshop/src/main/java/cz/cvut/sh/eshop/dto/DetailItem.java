package cz.cvut.sh.eshop.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import cz.cvut.sh.eshop.dto.serialize.ItemIdDeserializer;
import cz.cvut.sh.eshop.dto.serialize.ItemIdSerializer;
import cz.cvut.sh.eshop.entity.ItemId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;


@With
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailItem {

    @JsonSerialize(using = ItemIdSerializer.class)
    @JsonDeserialize(using = ItemIdDeserializer.class)
    ItemId id;
    String name;
    long count;
    String color;
    String details;
}
