package cz.cvut.sh.eshop.dto.serialize;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import cz.cvut.sh.eshop.entity.ItemId;

import java.io.IOException;

public class ItemIdDeserializer extends StdDeserializer<ItemId> {
    private static final long serialVersionUID = 8893969312969504964L;

    protected ItemIdDeserializer() {
        super(ItemId.class);
    }

    @Override
    public ItemId deserialize(final JsonParser p,
                              final DeserializationContext ctxt) throws IOException, JacksonException {
        return new ItemId(p.getValueAsString());
    }
}
