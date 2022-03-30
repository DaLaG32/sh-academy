package cz.cvut.sh.eshop.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.With;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.lang.Nullable;

import java.util.UUID;


@With
@Value
@AllArgsConstructor(onConstructor_ = {@JsonCreator(mode = JsonCreator.Mode.PROPERTIES), @ConstructorBinding})
public class Item {

    @Nullable
    UUID id;
    String name;
    long count;
    Object option1;
    Object option2;
    Object picture;
}
