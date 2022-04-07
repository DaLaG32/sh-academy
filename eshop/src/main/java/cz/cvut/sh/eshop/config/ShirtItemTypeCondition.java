package cz.cvut.sh.eshop.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

@Slf4j
public class ShirtItemTypeCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        if(Objects.equals(context.getEnvironment().getProperty("store.type"), "shirt-store")){
            log.info("ShirtItemService initialized on condition store.type == 'shirt-store'");
            return true;
        }
        return false;
    }
}
