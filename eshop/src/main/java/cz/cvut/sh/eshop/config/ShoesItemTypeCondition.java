package cz.cvut.sh.eshop.config;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

@Slf4j
public class ShoesItemTypeCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        if(Objects.equals(context.getEnvironment().getProperty("store.type"), "shoe-store")){
            log.info("ShoeItemService initialized on condition store.type == 'shoe-store'");
            return true;
        }
        return false;
    }
}
