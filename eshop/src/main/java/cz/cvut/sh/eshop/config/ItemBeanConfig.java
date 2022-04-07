package cz.cvut.sh.eshop.config;

import cz.cvut.sh.eshop.service.ChairItemService;
import cz.cvut.sh.eshop.service.ItemService;
import cz.cvut.sh.eshop.service.ShirtItemService;
import cz.cvut.sh.eshop.service.TableItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ItemBeanConfig {

    @Bean
    @ConditionalOnMissingBean(ItemService.class)
    public ItemService shirtItemService(){
        return new ShirtItemService();
    }

    @Bean
    @ConditionalOnProperty(name = "store.type", havingValue = "table-store")
    public ItemService tableItemService(){
        return new TableItemService();
    }

    @Bean
    @ConditionalOnExpression("'${store.type}'=='chair-store'")
    public ItemService chairItemService(){
        return new ChairItemService();
    }

}
