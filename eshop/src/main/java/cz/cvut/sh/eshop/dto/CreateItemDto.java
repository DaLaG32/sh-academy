package cz.cvut.sh.eshop.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.boot.context.properties.ConstructorBinding;

@Value
@AllArgsConstructor(onConstructor_ = {@JsonCreator(mode = JsonCreator.Mode.PROPERTIES), @ConstructorBinding})
public class CreateItemDto {

    String name;

    Long count;

    String color;

    String details;
}
