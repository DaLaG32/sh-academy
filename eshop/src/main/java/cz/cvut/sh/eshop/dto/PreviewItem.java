package cz.cvut.sh.eshop.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.With;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@With
@Value
@AllArgsConstructor(onConstructor_ = {@JsonCreator(mode = JsonCreator.Mode.PROPERTIES), @ConstructorBinding})
public class PreviewItem {

    @Nullable
    UUID id;
    String name;
}
