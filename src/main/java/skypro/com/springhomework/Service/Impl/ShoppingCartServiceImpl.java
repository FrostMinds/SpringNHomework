package skypro.com.springhomework.Service.Impl;

import skypro.com.springhomework.Data.ShoppingCart;
import skypro.com.springhomework.Service.ShoppingCartService;

import java.util.List;
import java.util.Set;

public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCart shoppingCart;

    public ShoppingCartServiceImpl(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void putItems(List<Integer> itemIDs) {
        for (Integer itemsID : itemIDs) {
            shoppingCart.addItem(itemsID);
        }
    }

    @Override
    public Set<Integer> getItemIDs() {
        return shoppingCart.getItems();
    }
}
