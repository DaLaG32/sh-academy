package cz.cvut.sh.eshop.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import cz.cvut.sh.eshop.entity.ItemId;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.With;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.lang.Nullable;


@With
@Value
@AllArgsConstructor(onConstructor_ = {@ConstructorBinding, @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)})
public class Item {

    @Nullable
    ItemId id;
    String name;
    long count;
    ItemType type;
    String color;
    String details;
}
