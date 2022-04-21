package cz.cvut.sh.eshop.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import cz.cvut.sh.eshop.dto.serialize.ItemIdSerializer;
import cz.cvut.sh.eshop.entity.ItemId;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.With;
import org.springframework.boot.context.properties.ConstructorBinding;


@With
@Value
@AllArgsConstructor(onConstructor_ = {@JsonCreator(mode = JsonCreator.Mode.PROPERTIES), @ConstructorBinding})
public class PreviewItem {

    @JsonSerialize(using = ItemIdSerializer.class)
    ItemId id;
    String name;
}
