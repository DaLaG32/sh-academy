package cz.cvut.sh.reactiveworld;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


public class ObjectA {

    @Autowired
    private ObjectB b;

    @Autowired
    public ObjectA(ObjectB b){
        this.b = b;
        b.setC(new ObjectC(""));
    }

    public static class ObjectB {

        private static final ObjectB OBJECT_B = new ObjectB();

        private ObjectC c;

        @Autowired
        public void setC(ObjectC c) {
            this.c = c;
        }

        public static ObjectB instance() {
            return OBJECT_B;
        }
    }
    public static class ObjectC {

        private final String name;

        private ObjectC(String name){
            this.name = name;
        }
    }
}
