package cz.cvut.sh.eshop.dto.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import cz.cvut.sh.eshop.entity.ItemId;

import java.io.IOException;

public class ItemIdSerializer extends StdSerializer<ItemId> {
    private static final long serialVersionUID = 5574441985273200978L;

    protected ItemIdSerializer() {
        super(ItemId.class);
    }

    @Override
    public void serialize(final ItemId itemId, final JsonGenerator jsonGenerator,
                          final SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(itemId.asString());
    }
}
