package cz.cvut.sh.eshop.domain;

public enum ItemType {
    TABLE, SHIRT;

    public boolean isTable() {
        return this == TABLE;
    }

    public boolean isShirt() {
        return this == SHIRT;
    }
}
