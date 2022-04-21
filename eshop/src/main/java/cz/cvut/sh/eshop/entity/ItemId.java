package cz.cvut.sh.eshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ItemId implements Serializable {

    private static final long serialVersionUID = -4690466374049028939L;

    private UUID value;

    public ItemId(final String plainValue) {
        this.value = UUID.fromString(plainValue);
    }

    public String asString() {
        return this.value.toString();
    }
}
