package skypro.com.springhomework.Service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import skypro.com.springhomework.Data.ShoppingCart;
import skypro.com.springhomework.Service.ShoppingCartService;

import java.util.Collection;
import java.util.Set;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private static final Logger log = LoggerFactory.getLogger(ShoppingCartServiceImpl.class);

    private final ShoppingCart shoppingCart;

    public ShoppingCartServiceImpl(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void putItems(Collection<Integer> itemIDs) {
        for (Integer itemsID : itemIDs) {
            shoppingCart.addItem(itemsID);
        }
        log.info("The following items have been added to shopping cart: {}", itemIDs);
    }

    @Override
    public Set<Integer> getItemIDs() {
        return shoppingCart.getItems();
    }
}
